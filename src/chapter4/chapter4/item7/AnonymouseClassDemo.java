/**
 * 
 */
package chapter4.item7;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ������ĵ����÷���ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-13
 */
public class AnonymouseClassDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1������һ����������(function object)
		Integer[] array = { 3, 2, 4, 1 };
		Arrays.sort(array, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		// 2������һ�����̶���(process object)
		new Thread(new Runnable() {

			@Override
			public void run() {
				createDefault();
			}
		}).start();
	}

	interface Flyable {

		public void fly();
	}

	// 3��Ϊĳ�־��з������͵�(��void��)�������ض���
	private static Flyable createDefault() {
		return new Flyable() {

			@Override
			public void fly() {
				System.out.println("I can fly.");
			}
		};
	}
}