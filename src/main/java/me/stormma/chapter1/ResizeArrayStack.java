package me.stormma.chapter1;

/**
 * This {@code ResizeArrayStack} class is implement with array.
 * And <em>The size of the array is growing dynamically.</em>
 *
 * @author stormma
 * @date 2017/10/18
 */
public class ResizeArrayStack<Data> {

    private Data[] stack;

    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ResizeArrayStack() {
         stack = (Data[]) new Object[DEFAULT_CAPACITY];
         size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Data data) {
        // stack is overflow
        if (size == stack.length) {
            // resize
            resize(2 * stack.length);
        }
        stack[size++] = data;
    }

    public Data pop() {
        Data data = stack[--size];
        if (size >= 0 && size < stack.length / 4) {
            resize(stack.length / 2);
        }
        return data;
    }

    public void resize(int maxSize) {
        Data[] temp = (Data[]) new Object[maxSize];
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public Data peek() {
        return stack[size - 1];
    }
}
