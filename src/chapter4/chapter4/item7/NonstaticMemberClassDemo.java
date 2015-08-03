/**
 * 
 */
package chapter4.item7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 非静态成员类的用法（适配器类）演示
 * <p>
 * 定义一个Adapter，它允许外部类的一个实例被看做另一个不相关的类的实例。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-12
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
		// 客户端程序可以通过如下的方式将StringList实例作为一个Iterator实例使用。
		print(stringList.iterator());
	}

	private static void print(Iterator<String> it) {
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

/**
 * 字符串列表，这是一个外部类。
 */
class StringList {

	private List<String> list = new ArrayList<String>();

	/**
	 * 添加一个字符串
	 */
	public void add(String s) {
		list.add(s);
	}

	/**
	 * 删除指定的字符串
	 */
	public void remove(String s) {
		list.remove(s);
	}

	/**
	 * 返回自己的迭代器
	 */
	public Iterator<String> iterator() {
		return new StringListIterator();
	}

	/**
	 * 字符串列表的迭代器，这是一个非静态成员类。
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
