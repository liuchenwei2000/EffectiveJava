/**
 * 
 */
package chapter5.item5;

import java.util.Arrays;

/**
 * 返回零长度的数组或者集合，而不是null
 * <p>
 * 对于一个返回null而不是零长度数组或者集合的方法，几乎每次用到该方法时都需要进行非空检查。
 * 所以对于这种场景，最好返回零长度数组或者不可变的空集合（Collections.emptyList等）。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-15
 */
public class NullArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = getArray1();
		if (array == null || Arrays.asList(array).contains(1)) {
			System.out.println("1");
		}
		// 返回零长度数组更好一些，并且性能不是问题。
		array = getArray2();
		if (Arrays.asList(array).contains(1)) {
			System.out.println("1");
		}
	}

	/**
	 * 会返回null的方法
	 */
	private static int[] getArray1() {
		return null;
	}
	
	/**
	 * 会返回零长度的数组的方法
	 */
	private static int[] getArray2() {
		return new int[0];
	}
}
