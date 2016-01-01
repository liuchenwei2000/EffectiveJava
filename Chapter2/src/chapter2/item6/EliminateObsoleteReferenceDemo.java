/**
 * 
 */
package chapter2.item6;

import java.util.EmptyStackException;

/**
 * 消除过期引用(Obsolete Reference)演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2010-12-21
 */
public class EliminateObsoleteReferenceDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack s = new Stack(0);
		for (int i = 0; i < 10; i++) {
			s.push(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(s.pop1());
		}
	}
}

/**
 * 这是一个自定义的栈
 */
class Stack {
	
	private Object[] elements;
	private int size = 0;

	public Stack(int initialCapacity) {
		this.elements = new Object[initialCapacity];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	/**
	 * 这个方法会有内存泄漏
	 */
	public Object pop1() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		/*
		 * 这里仅仅将对象弹出栈，但是并未清除栈内部对该对象的过期引用，即elements[size]仍然指向该对象
		 * 如果像EliminateObsoleteReferenceDemo.main()的方式使用栈，就会有内存泄漏
		 */
		return  elements[--size];
	}
	
	/**
	 * 这个方法不会有内存泄漏
	 */
	public Object pop2() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		/*
		 * 这里不仅仅将对象弹出栈，并且清除了栈内部对该对象的引用，即将 elements[size] 设为 null
		 */
		elements[size] = null;
		return result;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			Object[] oldElements = elements;
			elements = new Object[2 * elements.length + 1];
			System.arraycopy(oldElements, 0, elements, 0, size);
		}
	}
}
