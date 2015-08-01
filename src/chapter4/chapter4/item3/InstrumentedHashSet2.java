/**
 * 
 */
package chapter4.item3;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 具有计数功能的Set
 * <p>
 * 本类是使用复合实现的，除了获得了健壮性之外，也带来了灵活性。
 * <p>
 * 本类是一个包装类(wrapper class)，是 Decorator 模式的应用。
 *
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-2
 */
public class InstrumentedHashSet2<E> implements Set<E> {

	private final Set<E> set;
	
	private int counter = 0;// 计数器
	
	/**
	 * 从本质上讲，这个类把一个Set转变成另外一个Set，同时还增加了计数的功能。
	 * InstrumentedHashSet是基于继承的，只能为一个具体的类而工作，
	 * 对于超类所支持的每一个构造函数都要求有一个单独的构造函数。
	 * 而本类可以用为任何一个Set服务，并且只有一个构造函数。
	 */
	public InstrumentedHashSet2(Set<E> set) {
		super();
		this.set = set;
	}

	/**
	 * 计数器
	 */
	public int getCounter() {
		return counter;
	}

	/** 为了实现计数功能而对下面的两个方法略微调整 */
	
	public boolean add(E e) {
		this.counter++;
		return set.add(e);
	}
	public boolean addAll(Collection<? extends E> c) {
		this.counter += c.size();
		return set.addAll(c);
	}
	
	/** 下面是Set必须实现的其他方法，全部转发给包装的set对象 */
	
	public int size() {
		return set.size();
	}

	public boolean isEmpty() {
		return set.isEmpty();
	}

	public boolean contains(Object o) {
		return set.contains(o);
	}

	public Iterator<E> iterator() {
		return set.iterator();
	}

	public Object[] toArray() {
		return set.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return set.toArray(a);
	}

	public boolean remove(Object o) {
		return set.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return set.retainAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return set.removeAll(c);
	}

	public void clear() {
		set.clear();
	}

	public boolean equals(Object o) {
		return set.equals(o);
	}

	public int hashCode() {
		return set.hashCode();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InstrumentedHashSet2<String> iset = new InstrumentedHashSet2<String>(new HashSet<String>());// 可以包装HashSet
		iset.addAll(Arrays.asList(new String[] { "a", "b", "c" }));
		System.out.println(iset.getCounter());// 3
		iset = new InstrumentedHashSet2<String>(new TreeSet<String>());// 可以包装TreeSet
		iset.addAll(Arrays.asList(new String[] { "a", "b", "c" }));
		System.out.println(iset.getCounter());// 3
	}
}