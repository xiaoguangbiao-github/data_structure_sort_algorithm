package xiaoguangbiao.data_structure.bean;

import java.util.Arrays;

/**
 * @Description: 自定义栈
 * @author: scott
 * @date: 2022年03月19日 13:57
 */
public class MyStack {
    private int[] elements;

    public MyStack(){
        elements = new int[0];
    }

    /**
     * 向栈中压入元素
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
     * 从栈中取出顶层元素
     * @return
     */
    public int get(){
        if(isEmpt()){
            throw new RuntimeException("栈已为空！");
        }

        int top;
        //创建一个新数组
        int[] newElements = new int[elements.length - 1];

        //把原数组数据遍历到新数组，提出已经取出的最后一个元素
        for (int i=0; i<newElements.length; i++){
            newElements[i] = elements[i];
        }

        top = elements[elements.length -1]; //取出栈顶元素，用于返回
        elements = newElements; //指向新数组

        return top;
    }


    /**
     * 查看栈顶层元素
     * @return
     */
    public int lookTop(){
        if(elements.length == 0){
            return -1;
        }
        return elements[elements.length-1];
    }

    /**
     * 查看栈是否为空
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
