import lombok.Data;

/**
 * @Author: frode
 * @Date:2018/8/6 19:30
 * @Description:
 */
@Data
 class Node{

    String nodeValue;
    Node pre;
    Node next;
    public Node(){}

}

public class LinkedList {
/**
 *@描述
 *@创建人  frode
 *@创建时间  2018/8/6 19:43
 *@修改人和其它信息 链表的简单实现
 */

    public static void printLinkedList(Node node){
            for (Node x=node;x!=null;x=x.next){
                System.out.println(x.nodeValue);
            }

    }

    public static void changeValue(Node node){
        for (Node x=node;x!=null;x=x.next){
            x.nodeValue="888";
        }
    }
    public static void main(String[] args) {
        Node first = new Node();
        first.nodeValue = "1";
        Node second = new Node();
        second.nodeValue="2";
        Node third = new Node();
        third.nodeValue="3";

        first.next=second;
        second.pre=first;
        second.next=third;

        printLinkedList(first);
        changeValue(first);
        printLinkedList(first);//Node当入参可以直接改值

    }



}
