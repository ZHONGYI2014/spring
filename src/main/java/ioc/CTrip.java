package ioc;

import tree.Node;

public class CTrip {



    public static void main(String[] args) {
        Node<Integer> head = new Node<>();
        Node<Integer> n1 = new Node<>();
        n1.setData(1);
        Node<Integer> n2 = new Node<>();
        n2.setData(2);
        Node<Integer> n3 = new Node<>();
        n3.setData(3);
        Node<Integer> n4 = new Node<>();
        n4.setData(4);
        Node<Integer> n5 = new Node<>();
        n5.setData(5);
        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);


        revertSingleNodeList(head);
        Node<Integer> node = head.getNext();
        while (null != node) {
            if (null != node.getData()) {
                System.out.print(node.getData() + " ");
            }
            node = node.getNext();
        }
    }

    /**
     * 冒泡排序
     * 复杂度 n(n-1)
     * 每一次比较最大的数沉在最底（这个底向上移）
     * @param array
     */
    public static int[] maopaoSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            //记录当前的最大数的下标
            int index = i;
            int tmp = 0;
            for (int j = i+1; j < array.length; j++) {
                if (array[index] < array[j]) index = j;
            }
            tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
        return array;
    }

    /**
     * 快速排序
     * 1.找一个参照数 key （默认选第一个就好）
     * 2.从后往前找, 找比 key 小的数, 找到之后替换 a[i] = a[j], 替换之后i++
     * 3.现在要找比key大的数, 想一下, 为什么第二步 i++ , 其实是因为替换到左边的这个数字比key 小,
     * 而现在我们要找比key大的数, 所以不用比较啦
     * 4.重复第三步和第四步, 递归循环遍历
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static void quicklySort(int[] a, int low, int high) {
        int i = low;
        int j = high;
        // 参照
        int key = a[low];
        int tmp = 0;
        if (i > j) {
            return;
        }
        //找比key小的数
        while (low < high) {
            while (key < a[high]) {
                high--;
            }
            tmp = a[low];
            a[low] = a[high];
            a[high] = key;
            low++;

            while (key > a[low]) {
                low++;
            }
            tmp = a[low];
            a[low] = a[high];
            a[high] = key;
            high--;
        }
        quicklySort(a, i, low);
        quicklySort(a, low, j);
    }

    /**
     * 单链表倒置
     */
    public static void revertSingleNodeList(Node<Integer> node) {
        if (null == node) {
            return;
        }

        Node<Integer> head = node;

        Node<Integer> currentNode = node.getNext();

        Node<Integer> priorNode = null;

        Node<Integer> nextNode = null;

        while (null != currentNode) {
            nextNode = currentNode.getNext();
            currentNode.setNext(priorNode);
            priorNode = currentNode;
            currentNode = nextNode;
        }
        head.setNext(priorNode);
    }
}
