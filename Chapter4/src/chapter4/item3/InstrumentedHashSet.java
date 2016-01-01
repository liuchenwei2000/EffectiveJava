/**
 * 
 */
package chapter4.item3;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 具有计数功能的Set
 * <p>
 * 用于记录集合中总共曾加入过多少元素，和 size 是不同的。
 * <p>
 * 本类是使用继承实现的，有很多问题。
 *
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-2
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2122336346668650222L;
	
	private int counter = 0;// 计数器
	
	/** 下面是继承自超类的所有构造方法 */
	
	public InstrumentedHashSet() {
		super();
	}

	public InstrumentedHashSet(Collection<? extends E> c) {
		super(c);
	}

	public InstrumentedHashSet(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public InstrumentedHashSet(int initialCapacity) {
		super(initialCapacity);
	}

	/** 为了实现计数功能而覆盖下面的两个超类方法 */
	
	@Override
	public boolean add(E e) {
		this.counter++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		this.counter += c.size();
		return super.addAll(c);
	}

	/**
	 * 计数器
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InstrumentedHashSet<String> set = new InstrumentedHashSet<String>();
		set.addAll(Arrays.asList(new String[] { "a", "b", "c" }));
		System.out.println(set.getCounter());// 6
		/*
		 * 这个结果和预期的3不一样，原因在于超类的addAll方法实际上又调用了add方法。 
		 * 这样导致了计数错误。而HashSet的文档中并没有说明这样的实现细节。
		 * 为了修正这个错误，采用下面的两种方式：
		 * 
		 * 1，去掉子类覆盖的addAll方法，这样计数功能就正常工作了。
		 * 但是它的正确性依赖于这样的事实：HashSet的addAll方法是在add方法上实现的。
		 * 这是实现细节，而不是承诺，不能保证在所有的Java平台都保持不变，不会随着版本的不同而不发生变化。
		 * 
		 * 2，完全重写addAll方法。
		 */
	}
}
