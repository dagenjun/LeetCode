package hss.basic.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class MyLinkedListStack<T> {
    private LinkedList<T> stack = new LinkedList<>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.getFirst();
    }

    public T pop() {
        T t = peek();
        if (t != null) {
            stack.removeFirst();
        }
        return t;
    }

    public void push(T t) {
        stack.addFirst(t);
    }

    @Override
    public String toString() {
        return "MyLinkedListStack{" +
                "stack=" + stack +
                '}';
    }

    public static void main(String[] args) {
        MyLinkedListStack<String> myLinkedListStack = new MyLinkedListStack<>();
        myLinkedListStack.push("hss");
        myLinkedListStack.push("xc");
        System.out.println(myLinkedListStack);
        System.out.println(myLinkedListStack.pop());

    }

}
