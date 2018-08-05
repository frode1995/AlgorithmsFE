import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @Author: frode
 * @Date:2018/8/5 8:27
 * @Description: 下压堆栈（链表实现）
 */
public class Stack<Item> implements Iterable<Item> {//实现迭代接口
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
    }


    public boolean isEmpty() {
        return first == null;
    }


    public int size() {
        return n;
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }


    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    /**
     * Unit tests the {@code Stack} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Scanner sc = new Scanner(System.in);
        String item = sc.nextLine();
        do {
            if (!item.equals("-")&&!item.equals("end")){
                stack.push(item);
            }
            item = sc.nextLine();
        }while (!item.equals("end"));//输入end停止扫描 sc.hasNext()&&

        System.out.println("栈的大小是"+stack.size());
        System.out.println("栈中元素依次出栈为");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());//这里的item是泛型
        }

    }
}
