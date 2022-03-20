package xiaoguangbiao.data_structure.bean;

/**
 * @Description: 循环双链表
 * @author: scott
 * @date: 2022年03月20日 14:22
 */
public class DoubleNode {
    private DoubleNode pre = this;  //上一个节点
    private int data;
    private DoubleNode next = this;  //下一个节点

    public DoubleNode(int data){
        this.data = data;
    }

    /**
     * 在后面追加一个节点
     */
    public void after(DoubleNode node){
        DoubleNode nextNode = this.next;  //取出原下一个节点
        this.next = node; //让当前节点的下一个节点，指向新节点
        node.pre = this; //让新节点的上一个节点，指向当前

        node.next = nextNode; //让新节点的下一个节点，指向原下一个节点
        nextNode.pre = node; //让原下一个节点的上一个节点，指向新节点
    }

    /**
     * 获取上一个节点
     * @return
     */
    public DoubleNode getNext(){
        return this.next;
    }

    /**
     * 获取下一个
     * @return
     */
    public DoubleNode getPre(){
        return this.pre;
    }

    public int getData(){
        return this.data;
    }
}
