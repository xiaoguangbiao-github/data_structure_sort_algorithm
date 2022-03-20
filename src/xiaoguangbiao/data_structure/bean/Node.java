package xiaoguangbiao.data_structure.bean;

/**
 * @Description: 单链表节点
 * @author: scott
 * @date: 2022年03月19日 14:59
 */
public class Node{

    int data; //节点内容
    Node next; //下一个节点

    public Node(int data){
        this.data = data;
    }

    /**
     * 在当前节点后面追加节点node
     * @param node
     * @return
     */
    public Node append(Node node){
        Node currentNode = this;
        while (true){
            Node nextNode = currentNode.next;
            if(nextNode==null){
                //currentNode已经是最后一个节点了，跳出循环
                break;
            }
            currentNode = nextNode;
        }
        currentNode.next = node;
        //返回this，调用时就可以链式追加
        return this;
    }

    /**
     * 在当前节点后面插入一个节点node
     * @param node
     */
    public void after(Node node){
        Node nextNdoe = this.next; //取出下一个节点
        this.next = node; //把新节点，作为下一个节点
        node.next = nextNdoe; //把原下一个节点，作为现在下下一个节点
    }

    /**
     * 删除指定节点node
     * @param node
     */
    public Node removeNode(Node node){
        Node currentNode = this;
        if(this.data == node.getData()){
            //当前节点就是要删除的节点
            return this.next;
        }

        while (true){
            Node nextNode = currentNode.next;
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
     * 显示所有节点内容
     */
    public void show(){
        Node currentNode = this;
        while (true){
            System.out.print(currentNode.getData() + "  ");
            //取出下一个节点
            currentNode = currentNode.next;
            if(currentNode==null){
                System.out.println("  "); //分行，无实际意义
                break;
            }
        }
    }

    /**
     * 当前node是否是最后一个节点
     * @return
     */
    public boolean isLast(){
        return this.next == null;
    }

    /**
     * 获取下一个节点
     * @return
     */
    public Node next(){
        return this.next;
    }

    public int getData(){
        return this.data;
    }
}
