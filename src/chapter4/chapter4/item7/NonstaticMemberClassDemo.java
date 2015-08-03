/**
 * 
 */
package chapter4.item7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * �Ǿ�̬��Ա����÷����������ࣩ��ʾ
 * <p>
 * ����һ��Adapter���������ⲿ���һ��ʵ����������һ������ص����ʵ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-12
 */
public class NonstaticMemberClassDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringList stringList = new StringList();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		// �ͻ��˳������ͨ�����µķ�ʽ��StringListʵ����Ϊһ��Iteratorʵ��ʹ�á�
		print(stringList.iterator());
	}

	private static void print(Iterator<String> it) {
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

/**
 * �ַ����б�����һ���ⲿ�ࡣ
 */
class StringList {

	private List<String> list = new ArrayList<String>();

	/**
	 * ���һ���ַ���
	 */
	public void add(String s) {
		list.add(s);
	}

	/**
	 * ɾ��ָ�����ַ���
	 */
	public void remove(String s) {
		list.remove(s);
	}

	/**
	 * �����Լ��ĵ�����
	 */
	public Iterator<String> iterator() {
		return new StringListIterator();
	}

	/**
	 * �ַ����б�ĵ�����������һ���Ǿ�̬��Ա�ࡣ
	 */
	private class StringListIterator implements Iterator<String> {

		private Iterator<String> it = list.iterator();
		
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public String next() {
			return it.next();
		}

		@Override
		public void remove() {
			it.remove();
		}
	}
}
