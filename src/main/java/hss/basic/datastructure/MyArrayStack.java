package hss.basic.datastructure;

import java.util.Arrays;

public class MyArrayStack<T> {
    private Object[] stack;
    private int size;

    MyArrayStack() {
        stack = new Object[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (size > 0) {
            return (T) stack[size - 1];
        }
        return null;
    }

    public T pop() {
        T t = peek();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return t;
    }

    public void push(T t) {
        expandCapacity(size + 1);
        stack[size] = t;
        size++;

    }

    private void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = len * 3 / 2 + 1;
            stack=Arrays.copyOf(stack, size);
        }
    }

    @Override
    public String toString() {
        return "MyArrayStack{" +
                "stack=" + Arrays.toString(stack) +
                '}';
    }

    public static void main(String[] args) {
        MyArrayStack<String> stringMyArrayStack = new MyArrayStack<>();
        System.out.println(stringMyArrayStack.pop());
        stringMyArrayStack.push("hss");
        stringMyArrayStack.push("xc");
        System.out.println(stringMyArrayStack);
        System.out.println(stringMyArrayStack.pop());
        System.out.println(stringMyArrayStack);
    }

}
