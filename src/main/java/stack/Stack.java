package stack;

import java.util.EmptyStackException;

/**
 * 栈
 */
public class Stack {

    /** 定义栈的指针 */
    private int size = 0;

    /** 栈的数据结构 */
    private Object[] elements;


    public Stack(int initialCapcity) {
        elements = new Object[initialCapcity];
    }

    /**
     * 入栈
     * @param e
     */
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        /** 释放空间 */
        elements[size] = null;
        return result;
    }

    /**
     * 判断当前栈是否存满
     */
    public void ensureCapacity() {
        if (elements.length == size) {
            Object[] oldElements = elements;
            elements = new Object[2*elements.length + 1];
            System.arraycopy(oldElements, 0, elements, 0, size);
        }
    }
}
