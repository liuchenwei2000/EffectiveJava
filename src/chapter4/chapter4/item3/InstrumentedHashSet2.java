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
 * ���м������ܵ�Set
 * <p>
 * ������ʹ�ø���ʵ�ֵģ����˻���˽�׳��֮�⣬Ҳ����������ԡ�
 * <p>
 * ������һ����װ��(wrapper class)���� Decorator ģʽ��Ӧ�á�
 *
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-2
 */
public class InstrumentedHashSet2<E> implements Set<E> {

	private final Set<E> set;
	
	private int counter = 0;// ������
	
	/**
	 * �ӱ����Ͻ���������һ��Setת�������һ��Set��ͬʱ�������˼����Ĺ��ܡ�
	 * InstrumentedHashSet�ǻ��ڼ̳еģ�ֻ��Ϊһ����������������
	 * ���ڳ�����֧�ֵ�ÿһ�����캯����Ҫ����һ�������Ĺ��캯����
	 * �����������Ϊ�κ�һ��Set���񣬲���ֻ��һ�����캯����
	 */
	public InstrumentedHashSet2(Set<E> set) {
		super();
		this.set = set;
	}

	/**
	 * ������
	 */
	public int getCounter() {
		return counter;
	}

	/** Ϊ��ʵ�ּ������ܶ������������������΢���� */
	
	public boolean add(E e) {
		this.counter++;
		return set.add(e);
	}
	public boolean addAll(Collection<? extends E> c) {
		this.counter += c.size();
		return set.addAll(c);
	}
	
	/** ������Set����ʵ�ֵ�����������ȫ��ת������װ��set���� */
	
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
		InstrumentedHashSet2<String> iset = new InstrumentedHashSet2<String>(new HashSet<String>());// ���԰�װHashSet
		iset.addAll(Arrays.asList(new String[] { "a", "b", "c" }));
		System.out.println(iset.getCounter());// 3
		iset = new InstrumentedHashSet2<String>(new TreeSet<String>());// ���԰�װTreeSet
		iset.addAll(Arrays.asList(new String[] { "a", "b", "c" }));
		System.out.println(iset.getCounter());// 3
	}
}