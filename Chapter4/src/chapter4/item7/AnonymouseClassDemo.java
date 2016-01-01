/**
 * 
 */
package chapter4.item7;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 匿名类的典型用法演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-13
 */
public class AnonymouseClassDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1，创建一个函数对象(function object)
		Integer[] array = { 3, 2, 4, 1 };
		Arrays.sort(array, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		// 2，创建一个过程对象(process object)
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

	// 3，为某种具有返回类型的(非void的)方法返回对象
	private static Flyable createDefault() {
		return new Flyable() {

			@Override
			public void fly() {
				System.out.println("I can fly.");
			}
		};
	}
}
