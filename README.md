
# 离线KNN检索工具

在离线大数据平台上进行K近邻检索，通过MapReduce进行分布式执行，可以达到在千万级索引上批量亿级查询的规模，真正地应用于工业级场景。

# 用途

+ DeepI2I计算物品向量，离线构建i2i
+ 深度向量召回的离线大规模测评
+ 基于content-based的i2i数据

# 原理

![原理图](https://app.yinxiang.com/FileSharing.action?hash=1/b2256898e3582fd1a00a48dda8ec172a-367230)

通过MapReduce，将索引和查询的数据都进行分片，减少数据量到单机运行时间可接受的规模，调用faiss进行K进行查询，然后再对多个partition进行topk归并。

在Reducer上单机knn检索采用了faiss库，faiss通过java-jni调用。

# start

网络环境不好的话，`docker build`多试几次，最后一句执行成功不报错说明faiss-jni得到了编译和调用成功了

```
git clone git@github.com:qqhard/knn_tool.git 
cd knn_tool
git submodule init && git submodule update

docker build -t knn-tool .
docker run -it knn-tool java -cp knn-tool-mr/target/knn-tool-mr-0.0.1.jar com.gameofdimension.faiss.tutorial.OneFlat
```

执行之后，target目录下就得到了knn-tool-mr-0.0.1.jar，这是可以直接拿到hadoop上用的

```
mkdir target
docker run -v `pwd`/target:/tmp/knn-tool-mr/target -it knn-tool cp /opt/jni-faiss/knn-tool-mr/target/knn-tool-mr-0.0.1.jar /tmp/knn-tool-mr/target/
ls target
```

`src/main/java/com/gameofdimension/faiss/swig/`下的代码和`/cpu/src/main/resources/_swigfaiss.so`的资源文件是为了方便使用IDE编码，从docker里拉出来的，然后其实在mac环境上，也可以用maven打包了，一样可以执行


准备向量文件，格式为

```
key,0.1:0.2:0.3
```

执行mr任务，参数依次为query向量，索引向量，查询结果，选项

```
hadoop jar knn-tool-mr-0.0.1.jar com.knn.KnnDriver /tmp/querys.txt /tmp/indexs.txt /tmp/out.txt index_num=8,search_num=8,dim=64,topk=10,dis_type=l2
```

同组内查询，格式为
```
group,key,0.1:0.2:0.3
```

执行

```
hadoop jar knn-tool-mr-0.0.1.jar com.knn.KnnInGroupDriver /tmp/querys_in_group.txt /tmp/indexs_in_group.txt /tmp/out.txt index_num=8,search_num=8,dim=64,topk=10,dis_type=l2
```

# 参数

|参数|说明|
|---|---|
|index_num|索引分片数，根据索引数量设置，保证切分后，单机索引大小满足精度与用时|
|search_num|查询分片数|
|dim|向量维度|
|topk|查询数量|
|dis_type|距离类型，仅支持l2和ip，分别为欧式距离和内积距离，余弦距离参考faiss的文档|

# 感谢

通过swig进行java-jni编译参考了 https://github.com/gameofdimension/jni-faiss

搭建hadoop-hive环境所用的库 https://github.com/big-data-europe/docker-hive