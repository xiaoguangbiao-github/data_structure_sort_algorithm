package xiaoguangbiao.data_structure.bean;

import java.util.Arrays;

/**
 * @Description: 自定义队列
 * @author: scott
 * @date: 2022年03月19日 14:44
 */
public class MyQueue {
    private int elements[];

    public MyQueue(){
        elements = new int[0];
    }

    /**
     * 向队列中压入元素
     * @param eliment
     */
    public void push(int eliment){
        //创建一个新数组
        int[] newElements = new int[elements.length + 1];

        //把原数组数据遍历到新数组
        for (int i=0; i<elements.length; i++){
            newElements[i] = elements[i];
        }

        //把添加的元素放入新数组中
        newElements[elements.length] = eliment;

        //指向新数组
        elements=newElements;
    }

    /**
     * 从队列中取出元素
     * @return
     */
    public int get(){
        if(isEmpt()){
            throw new RuntimeException("队列已为空！");
        }

        int element;
        //创建一个新数组
        int[] newElements = new int[elements.length - 1];

        //把原数组数据遍历到新数组，提出已经取出的最后一个元素
        for (int i=0; i<newElements.length; i++){
            newElements[i] = elements[i + 1];
        }

        element = elements[0]; //取出队列元素，用于返回
        elements = newElements; //指向新数组

        return element;
    }


    /**
     * 查看队列是否为空
     * @return
     */
    public boolean isEmpt(){
        return elements.length == 0;
    }

    public String getAll(){
        return Arrays.toString(elements);
    }

    public int getSize(){
        return elements.length;
    }

}
