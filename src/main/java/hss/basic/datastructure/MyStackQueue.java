package hss.basic.datastructure;

import java.util.Stack;

public class MyStackQueue<T> {
    private Stack<T> stackA = new Stack<>();
    private Stack<T> stackB = new Stack<>();

    public void offer(T t) {
        stackA.push(t);
    }

    public T poll() {
        T t = null;
        if (stackB.isEmpty()) {
            while(stackA.size()>0){
                stackB.push(stackA.pop());
            }
        }
        t=stackB.pop();
        return t;
    }


    public static void main(String[] args) {
        MyStackQueue<String> StringMyStackQueue = new MyStackQueue<>();
        StringMyStackQueue.offer("hss");
        StringMyStackQueue.offer("xc");
        StringMyStackQueue.offer("xqm");
        System.out.println(StringMyStackQueue.poll());
        System.out.println(StringMyStackQueue);
    }
}
