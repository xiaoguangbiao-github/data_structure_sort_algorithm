package xiaoguangbiao.data_structure.bean;

/**
 * @Description: 循环单链表节点
 * @author: scott
 * @date: 2022年03月19日 14:59
 */
public class LoopNode {

    int data; //节点内容
    LoopNode next = this; //下一个节点

    public LoopNode(int data){
        this.data = data;
    }

    /**
     * 在当前节点后面插入一个节点node
     * @param node
     */
    public void after(LoopNode node){
        LoopNode nextNdoe = this.next; //取出下一个节点
        this.next = node; //把新节点，作为下一个节点
        node.next = nextNdoe; //把原下一个节点，作为现在下下一个节点
    }

    /**
     * 删除指定节点node
     * @param node
     */
    public LoopNode removeNode(LoopNode node){
        LoopNode currentNode = this;
        if(this.data == node.getData()){
            //当前节点就是要删除的节点
            return this.next;
        }

        while (true){
            LoopNode nextNode = currentNode.next;
            if(nextNode == null){
                //currentNode已经是最后一个节点了，跳出循环
                throw new RuntimeException("未找到可以删除的节点");
            }else if(nextNode.getData() == node.getData()){
                //nextNode节点就是我们要找的删除节点，删除nextNode节点
                currentNode.next = nextNode.next;
                return this;
            }else{
                currentNode = nextNode;
            }
        }
    }

    /**
     * 删除下一个节点
     */
    public void removeNext(){
        if(this.next == null){
            //没有下一个节点
            throw new RuntimeException("没有下一个节点");
        }
        //将下下一个节点给到下一个节点
        this.next = this.next.next;
    }

    /**
     * 获取下一个节点
     * @return
     */
    public LoopNode next(){
        return this.next;
    }

    public int getData(){
        return this.data;
    }
}
