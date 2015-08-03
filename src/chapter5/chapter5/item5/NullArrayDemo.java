/**
 * 
 */
package chapter5.item5;

import java.util.Arrays;

/**
 * 返回零长度的数组而不是null演示
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
		// 返回null会要求客户方必须有额外的代码来处理null返回值，每次用到该方法都会需要这种曲折的处理方式。
		// 另外，返回null的方式也会是返回数组的方法本身更加复杂。
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