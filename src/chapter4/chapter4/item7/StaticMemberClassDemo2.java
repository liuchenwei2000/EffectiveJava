/**
 * 
 */
package chapter4.item7;

import java.util.ArrayList;
import java.util.List;

/**
 * ��̬��Ա��ĵڶ����÷���˽������ࣩ��ʾ
 * <p>
 * ����������Χ�����������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-12
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
 * �Զ����Map
 */
class MyMap {

	// Pair��ΪMyMap��һ�����ʹ��
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
	 * ��ֵ�ԣ�����һ��˽�еľ�̬�ڲ���
	 * <p>
	 * ��Ϊһ��Pair����������ݲ�����Ҫ������Χ��Map�����Կ���ʹ��̬�ġ�
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