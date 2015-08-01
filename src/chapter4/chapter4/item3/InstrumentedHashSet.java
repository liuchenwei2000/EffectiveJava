/**
 * 
 */
package chapter4.item3;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * ���м������ܵ�Set
 * <p>
 * ���ڼ�¼�������ܹ������������Ԫ�أ��� size �ǲ�ͬ�ġ�
 * <p>
 * ������ʹ�ü̳�ʵ�ֵģ��кܶ����⡣
 *
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-2
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2122336346668650222L;
	
	private int counter = 0;// ������
	
	/** �����Ǽ̳��Գ�������й��췽�� */
	
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

	/** Ϊ��ʵ�ּ������ܶ�����������������෽�� */
	
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
	 * ������
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
		 * ��������Ԥ�ڵ�3��һ����ԭ�����ڳ����addAll����ʵ�����ֵ�����add������ 
		 * ���������˼������󡣶�HashSet���ĵ��в�û��˵��������ʵ��ϸ�ڡ�
		 * Ϊ������������󣬲�����������ַ�ʽ��
		 * 
		 * 1��ȥ�����า�ǵ�addAll�����������������ܾ����������ˡ�
		 * ����������ȷ����������������ʵ��HashSet��addAll��������add������ʵ�ֵġ�
		 * ����ʵ��ϸ�ڣ������ǳ�ŵ�����ܱ�֤�����е�Javaƽ̨�����ֲ��䣬�������Ű汾�Ĳ�ͬ���������仯��
		 * 
		 * 2����ȫ��дaddAll������
		 */
	}
}