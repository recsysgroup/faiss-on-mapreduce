package com.knn;

import java.util.PriorityQueue;

import static com.knn.KnnMergeTopk.TopkReducer.ascComparator;
import static com.knn.KnnMergeTopk.TopkReducer.descComparator;

public class Test {
    public static void main(String[] args){
        KnnMergeTopk.TopkReducer.Node node1 = new KnnMergeTopk.TopkReducer.Node("1:0.1");
        KnnMergeTopk.TopkReducer.Node node2 = new KnnMergeTopk.TopkReducer.Node("2:0.2");

        System.out.println(descComparator.compare(node1, node2));

        PriorityQueue<KnnMergeTopk.TopkReducer.Node> queue = new PriorityQueue<>(2, ascComparator);
        queue.add(node1);
        queue.add(node2);
        System.out.println(queue.element());
    }
}
