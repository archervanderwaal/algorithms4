## Algorithms4
> 生命不息，奋斗不止。

Algorithms4是关于算法第四版(传说中的红宝书)的代码练习项目，这本书估计是我看过最好的数据结构算法的书籍了。
书上的数据结构实现方式都很经典，所以就算是自己写不出来，也要跟着实现一遍。相信我，看完这本书，你会觉得神清气爽。
我想我要首先申明一点，这本书前面有一部分都是讲的基础知识，但是我觉得你如果是java初学者的话，指望这些内容来入门，我劝你
打消这个念头。我想你应该做的是先去学学java基础，然后再来用java这个工具学习数据结构和算法。所以，这个项目都是实现数据结构和
算法的，书上的基础语法的练习不包含在里面。

### [第一章 基础](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter1)
第一章的关于数据结构和算法的实现都很简单，其中队列和栈既可以使用链表的方式来实现，也可以使用数组来实现，如果是数组的话，
有个动态扩容的方法要实现，这一块可以参考`java`中的`ArrayList.java`的扩容机制，`java`扩容机制不止在`ArrayList.java`里面有
，`HashMap.java`等等里面都有很经典的实现方式(所谓经典，就是扩散因子的选择)。

- [三数和问题](https://github.com/StormMaybin/algorithms4/blob/master/src/main/java/me/stormma/chapter1/ThreeSumFast.java)
- [二分查找](https://github.com/StormMaybin/algorithms4/blob/master/src/main/java/me/stormma/chapter1/BinarySearch.java)
- [链表实现栈](https://github.com/StormMaybin/algorithms4/blob/master/src/main/java/me/stormma/chapter1/Stack.java)
- [动态数组实现栈](https://github.com/StormMaybin/algorithms4/blob/master/src/main/java/me/stormma/chapter1/ResizeArrayStack.java)
- [链表实现队列](https://github.com/StormMaybin/algorithms4/blob/master/src/main/java/me/stormma/chapter1/Queue.java)
- [quick-find](https://github.com/StormMaybin/algorithms4/blob/master/src/main/java/me/stormma/chapter1/uf/QuickFind.java)
- [quick-union](https://github.com/StormMaybin/algorithms4/blob/master/src/main/java/me/stormma/chapter1/uf/QuickUnion.java)
- [加权quick-union](https://github.com/StormMaybin/algorithms4/blob/master/src/main/java/me/stormma/chapter1/uf/WeightedQuickUnion.java)
- [路径压缩quick-union](https://github.com/StormMaybin/algorithms4/blob/master/src/main/java/me/stormma/chapter1/uf/PathCompressionWeightedQuickUnion.java)
- [并查集博文](http://blog.csdn.net/strommaybin/article/details/52523149)
### [第二章 排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2)
- [常用排序方式博文总结]()
- [选择排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/sort/SelectSort.java)
- [冒泡排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/sort/BubbleSort.java)
- [插入排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/sort/InsertSort.java)
- [自顶而下归并排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/sort/MergeSortTD.java)
- [自下而上归并排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/sort/MergeSortBU.java)
- [希尔排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/sort/ShellSort.java)
- [快速排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/sort/QuickSort.java)
- [三向切分快速排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/sort/QuickSort3Way.java)
- [堆排序](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/sort/HeapSort.java)
- [荷兰国旗问题](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/SortColors.java)
- [优先队列](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter2/PriorityQueue.java)

### [第三章 树](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter3)
- [最小顶堆实现](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter3/MinHeapArray.java)
- [哈夫曼树](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter3/HuffmanTree.java)
### [第四章 图](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter4)
#### 4.1无向图
- [图的表示](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter4/section4_1/Graph.java)
- [DFS](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter4/section4_1/DepthFirstSearch.java)
- [BFS](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter4/section4_1/BreadFirstSearch.java)
- [连通分量](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter4/section4_1/CC.java)
- [五环图](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter4/section4_1/Cycle.java)
- [双色问题](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter4/section4_1/TwoColor.java)
#### 4.2有向图
- [有向图实现](https://github.com/StormMaybin/algorithms4/tree/master/src/main/java/me/stormma/chapter4/section4_2/Digraph.java)
- [有向图的可达性]