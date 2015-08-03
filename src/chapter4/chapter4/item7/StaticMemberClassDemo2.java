/**
 * 
 */
package chapter4.item7;

import java.util.ArrayList;
import java.util.List;

/**
 * 静态成员类的第二个用法（私有组件类）演示
 * <p>
 * 用来代表外围类对象的组件。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-12
 */
public class StaticMemberClassDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyMap map = new MyMap();
		map.put("1", "A");
		System.out.println(map.get("1"));
		map.put("1", "B");
		map.put("2", "B");
		System.out.println(map.get("1"));
		System.out.println(map.get("2"));
		System.out.println(map.get("3"));
	}
}

/**
 * 自定义的Map
 */
class MyMap {

	// Pair作为MyMap的一个组件使用
	private List<Pair> pairs = new ArrayList<Pair>();

	public void put(Object key, Object value) {
		Pair pair = getPairByKey(key);
		if (pair == null) {
			pairs.add(new Pair(key, value));
		} else {
			pair.setValue(value);
		}
	}

	public Object get(Object key) {
		Pair pair = getPairByKey(key);
		return pair == null ? null : pair.getValue();
	}

	private Pair getPairByKey(Object key) {
		for (Pair pair : pairs) {
			if (pair.getKey().equals(key)) {
				return pair;
			}
		}
		return null;
	}

	/**
	 * 键值对，这是一个私有的静态内部类
	 * <p>
	 * 因为一个Pair对象访问数据并不需要访问外围的Map，所以可以使静态的。
	 */
	private static class Pair {

		private Object key;
		private Object value;

		Pair(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		Object getValue() {
			return value;
		}

		void setValue(Object value) {
			this.value = value;
		}

		Object getKey() {
			return key;
		}
	}
}