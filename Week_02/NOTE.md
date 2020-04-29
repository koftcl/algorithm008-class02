# 哈希表
1. 计算哈希值
2. 哈希碰撞
    1. 使用链表解决哈希碰撞

## java 中的数据结构
1. set
    1. TreeSet 使用二叉搜索树实现 O(logN)
    2. HashSet
2. map
    1. HashMap
    2. Hashtable
    3. ConcurrentHashMap

# 题目讲解
## 做题步骤
1. clarification
2. possible solutions --> optimal (time & space)
3. code
4. test cases

## leetcode242
1. 暴力破解 O(nlogn)
2. 哈希表 O(n)cS

# 树和图
1. 二叉树
    1. 子树
        1. 左子树
        2. 右子树
2. 链表 -> 跳表 升维
3. 树和图
    1. 差别，是否有环
4. 应用
    1. 递归求解斐波那契数列
5. 状态树、决策树
6. 遍历二叉树
    1. 前序 Pre-order 根-左-右
    2. 中序 In-order 左-根-右
    3. 后序 Post-order 左-右-根
7. 二叉树特性
    1. 左 > 根 > 右
    2. 中序遍历： 升序排列
8. 时间复杂度
    1. 查询 O(logn)
    2. 插入 O(logn)
    3. 遍历 O(n)
    4. 删除 O(logn)
    
# 堆 Heap
1. 作用： 可以迅速找到一堆数中的最大或者最小值
2. 分类
    1. 大顶堆 = 大根堆
        1. find-max O(1)
        2. delete-max O(logN)
        3. insert(create) O(logN) or O(1)
    2. 小顶堆 = 小根堆
    3. 二叉堆、斐波那契堆
3. 不同实现比较 [https://en.wikipedia.org/wiki/Heap_\(data_structure\)](https://en.wikipedia.org/wiki/Heap_%28data_structure%29)
4. 二叉堆
    1. 完全二叉树来实现
        1. 是一颗完全树
        2. 树种任意节点的值总是 >= 其子节点的值
    2. 使用数组实现
        1. 索引左儿子 2\*i+1
        2. 索引右儿子 2\*i+2
        3. 发索引父节点floor(i-1)/2
    3. 插入
        1. 新元素一律插入堆的尾部
        2. 一次向上调整整个堆的结构（一直到根即可） HeapifyUp
    4. 删除堆顶操作 Delete Max O(logN)
        1. 将堆尾元素替换到顶部（即堆顶被替代删除掉）
        2. 一次从根部乡下调整整个堆的结构（一直到堆尾即可） HeapifyDown

# 自学堆排序
1. url： [https://www.geeksforgeeks.org/heap-sort/](https://www.geeksforgeeks.org/heap-sort/)
2. 在数组中执行排序操作
    1. 步骤
        1. 数组中建堆，堆化
        2. 堆顶元素放到堆外的数组中
        3. 堆化
3. 时间复杂度： O(NlogN)

```
// Java program for implementation of Heap Sort
public class HeapSort
{
    public void sort(int arr[])
    {
        int n = arr.length;
  
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
  
        // One by one extract an element from heap
        for (int i=n-1; i>0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
  
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
  
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2
  
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
  
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
  
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
  
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
  
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
  
    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
  
        HeapSort ob = new HeapSort();
        ob.sort(arr);
  
        System.out.println("Sorted array is");
        printArray(arr);
    }
}
```

# 图
1. 定义 Graph(V, E)
    1. 点 Vertices
        1. 度 - 入度 和 出度 （有向才分出入度）
        2. 点与点之间： 连通与否
    2. 边 Edge
        1. 有向和无向（单行线）
        2. 权重（边长）
2. 数据结构
    1. 邻接矩阵
    2. 邻接表
3. 分类
    1. 向 和 权
        1. 有向有权图
        2. 有向无权图
        3. 无向有权图
        4. 无向无权图
4. 图的遍历
    1. dfs
    2. bfs
    3. 注，需要加visited集合避免环路
5. 相关知识
    1. 拓扑排序
        1. [https://zhuanlan.zhihu.com/p/34871092](https://zhuanlan.zhihu.com/p/34871092)
    2. 最短路径
        1. [https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158](https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158)
    3. 最小生成树
        1. [https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051](https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051)