package xiaoguangbiao.data_structure.bean;

import java.util.Arrays;

/**
 * @Description: 自定义面向对象的数据
 * @author: scott
 * @date: 2022年03月19日 11:33
 */
public class ObjectArray {
    private Object[] elements;

    public ObjectArray(){
        elements = new Object[0];
    }

    /**
     * 对象数组尾部添加
     * @param element
     */
    public void add(Object element){
        //创建一个新数组
        Object[] newElements = new Object[elements.length + 1];

        //把原数组数据遍历到新数组
        for (int i=0; i<elements.length; i++){
            newElements[i] = elements[i];
        }

        //把添加的元素放入新数组中
        newElements[elements.length] = element;

        //指向新数组
        elements=newElements;
    }

    /**
     * 对象数组中间插入
     * @param j
     * @param element
     */
    public void insert(int j,Object element){
        //创建一个新数据
        Object[] newElements = new Object[elements.length + 1];

        //把原数组数据遍历到新数组
        for (int i=0; i<newElements.length; i++){
            if(i < j){
               newElements[i] = elements[i];
            }else if(i == j){
                //就是插入到这个位置
                newElements[i] = element;
            }else{
                newElements[i] = elements[i-1];
            }
        }

        //指向新数组
        elements=newElements;
    }

    /**
     * 对象数组尾部删除
     */
    public void delete(){
        //创建一个新数据
        Object[] newElements = new Object[elements.length - 1];

        //把原数组数据遍历到新数组
        for (int i=0; i<newElements.length; i++){
            newElements[i] = elements[i];
        }

        //指向新数组
        elements=newElements;
    }


    /**
     * 对象数组中间删除
     * @param j
     */
    public void delete(int j){

        if(j < 0 || j>= elements.length){
            throw new RuntimeException("数组下标越界");
        }

        //创建一个新数据
        Object[] newElements = new Object[elements.length - 1];

        //把原数组数据遍历到新数组
        for (int i=0; i<elements.length; i++){
            if(i < j){
                newElements[i] = elements[i];
            }else if(i == j){
                //就是删除这个位置的元素
            }else{
                newElements[i-1] = elements[i];
            }
        }

        //指向新数组
        elements=newElements;
    }

    /**
     * 查询目标元素在对象数组中的下标
     * @param target
     * @return
     */
    public int selectIndexByTarget(Object target){
        for (int i=0; i<elements.length; i++){
            if(elements[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public Object get(int i){
        return elements[i];
    }

    public String getAll(){
        return Arrays.toString(elements);
    }

    public int getSize(){
        return elements.length;
    }






}
