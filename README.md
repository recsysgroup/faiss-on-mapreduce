
# 离线KNN检索工具

在离线大数据平台上进行K近邻检索，通过MapReduce进行分布式执行，可以达到在千万级索引上批量亿级查询的规模，真正地应用于工业级场景。

# 用途

+ DeepI2I计算物品向量，离线构建i2i
+ 深度向量召回的离线大规模测评
+ 基于content-based的i2i数据

# 原理

![原理图](https://github.com/qqhard/knn_tool/blob/master/image1.png?raw=true)

通过MapReduce，将索引和查询的数据都进行分片，减少数据量到单机运行时间可接受的规模，调用faiss进行K进行查询，然后再对多个partition进行topk归并。


## cpu

- git clone https://github.com/gameofdimension/jni-faiss.git && cd jni-faiss && git submodule update --init

- docker build -t jni-faiss .

- docker run -it jni-faiss java -cp cpu-demo/target/cpu-demo-0.0.1.jar com.gameofdimension.faiss.tutorial.OneFlat
