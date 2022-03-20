package xiaoguangbiao.data_structure;

import xiaoguangbiao.data_structure.bean.*;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月19日 11:14
 */
public class TestDataStructure {
    public static void main(String[] args) {
        /* 1、数组，例如：int[]、String[]等 */
        // 1.1、长度是不可变的，如何解决长度不可变？可以创建一个符合大小的新数据，让原数组地址引用指向新数组。
        newArrayToOldArray();
        // 1.2、查找算法：顺序查找、二分法查找
        selectAlgorithm();
        // 1.3、数据里面只能放基本数据类型，如何存放对象类型呢？我们自定义一个面向对象的数据
        testObjectArray();

        System.out.println("---------------------------------");

        /* 2、栈，先入后出、后入先出 */
        testStack();

        System.out.println("---------------------------------");

        /* 3、队列，先入先出、后入后出 */
        testQueue();

        System.out.println("---------------------------------");

        /* 4、单链表 */
        testLink();

        System.out.println("---------------------------------");

        /* 5、循环单链表 */
        testLoopLink();

        System.out.println("---------------------------------");

        /* 6、循环双链表 */
        testDoubleLink();

    }

    /**
     *  1.1、长度是不可变的，如何解决长度不可变？可以创建一个符合大小的新数据，让原数组地址引用指向新数组。
     */
    private static void newArrayToOldArray(){
        //目标数据
        int[] oldArr = new int[]{1,2,3};
        System.out.println("----newArrayToOldArray--原数组元素：" + Arrays.toString(oldArr));

        //现在要添加一个元素4，怎么做呢？
        int add=4;
        int[] newArr = new int[4];
        for (int i=0; i<newArr.length; i++) {
            if(i < oldArr.length){
                newArr[i] = oldArr[i];
            }else{
                newArr[i] = add;
            }
        }

        System.out.println("----newArrayToOldArray--新数组元素：" + Arrays.toString(newArr));
    }

    /**
     *  1.2、查找算法：线性查找、二分法查找
     */
    private static void selectAlgorithm(){
        /* （1）线性查找: 要求从arr数组中找到目标元素的下标 */
        int target =3;
        int[] arr = new int[]{0,3,2,2,4,5};

        int index = 0;  //声明index用来存储目标元素的下标
        for (int i=0; i<arr.length; i++){
            if(arr[i] == target){
                index = i;
                break;
            }
        }
        System.out.println("----selectAlgorithm--线性查找index：" + index);


        /* （2）二分法查找: 要求从有序的arr数组中找到目标元素的下标 */
        int target2 =4;
        int[] arr2 = new int[]{0,1,2,3,4,5};

        int index2 = 0;  //声明index用来存储目标元素的下标
        int begin_index = 0;  //开始下标
        int end_index =arr2.length-1;  //结束下标
        int mid_index=(begin_index + end_index)/2;  //中间的下标
        while (true){
            if(arr2[mid_index] == target2){
                index2 = mid_index;
                break;
            }else if(arr2[mid_index] > target2){
                //把结束位置调整到中间位置的前一个位置
                end_index = mid_index - 1;
            }else if(arr2[mid_index] < target2){
                //把开始位置调整到中间位置的后一个位置
                begin_index = mid_index + 1;
            }
            mid_index=(begin_index + end_index)/2;  //新中间的下标
        }
        System.out.println("----selectAlgorithm--二分法查找index2：" + index2);
    }

    /**
     *  1.3、数据里面只能放基本数据类型，如何存放对象类型呢？我们自定义一个面向对象的数据
     */
    private static void testObjectArray(){
        ObjectArray arr = new ObjectArray();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        System.out.println("----testObjectArray--对象数组尾部添加：" + arr.getAll());

        arr.insert(1,3);
        arr.insert(2,4);
        System.out.println("----testObjectArray--对象数组中间插入：" + arr.getAll());

        arr.delete();
        System.out.println("----testObjectArray--对象数组尾部删除：" + arr.getAll());

        arr.delete(1);
        System.out.println("----testObjectArray--对象数组中间删除：" + arr.getAll());

        System.out.println("----testObjectArray--查询目标元素在对象数组中的下标：" + arr.selectIndexByTarget(1));
    }

    /**
     * 2、栈，先入后出、后入先出
     */
    private static void testStack(){
        MyStack stack = new MyStack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        System.out.println("----testStack--向栈中压入元素后：" + stack.getAll());

        System.out.println("----testStack--查看栈顶层元素：" + stack.lookTop());

        stack.get();
        System.out.println("----testStack--从栈中取出顶层元素后：" + stack.getAll());

        System.out.println("----testStack--查看栈是否为空：" + stack.isEmpt());
    }

    /**
     * 3、队列，先入先出、后入后出
     */
    private static void testQueue(){
        MyQueue queue = new MyQueue();
        queue.push(0);
        queue.push(1);
        queue.push(2);
        System.out.println("----testQueue--向队列中压入元素后：" + queue.getAll());

        queue.get();
        System.out.println("----testQueue--从队列中取出元素后：" + queue.getAll());
        queue.get();
        queue.get();
        System.out.println("----testQueue--查看队列是否为空：" + queue.isEmpt());
//        queue.get();
//        System.out.println("----testQueue--查看队列是否为空：" + queue.isEmpt());
    }

    /**
     *  4、单链表
     */
    private static void testLink(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.append(n2).append(n3).append(n4).append(n5); //追加节点node

        n1.show();  //显示出n1所有节点信息

        n2.removeNext();  //删除n2的下一个节点（删除n3）
        n1.show();  //显示出n1所有节点信息

        n4.after(new Node(6));  //在node4后面插入一个节点
        n1.show();  //显示出n1所有节点信息

        n1.removeNode(new Node(6)).show();  //删除n1中的node6节点

        n1.removeNode(new Node(1)).show();  //删除n1中的node1节点
    }

    /**
     *  5、循环单链表
     */
    private static void testLoopLink(){
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);

        n1.after(n2);  //追加节点n2
        n2.after(n3);  //追加节点n3
        System.out.println("----testQueue--显示n1下一个节点的值：" + n1.next().getData());
        System.out.println("----testQueue--显示n2下一个节点的值：" + n2.next().getData());
    }

    /**
     *  6、循环双链表
     */
    private static void testDoubleLink(){
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        n1.after(n2);  //追加节点n2
        n2.after(n3);  //追加节点n3
        System.out.println("----testDoubleLink--显示n2上1个节点的值：" + n2.getPre().getData());
        System.out.println("----testDoubleLink--显示n2节点的值：" + n2.getData());
        System.out.println("----testDoubleLink--显示n2下1个节点的值：" + n2.getNext().getData());
    }
}
