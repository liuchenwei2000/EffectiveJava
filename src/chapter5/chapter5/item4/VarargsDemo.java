/**
 * 
 */
package chapter5.item4;

import java.util.Arrays;

/**
 * 可变参数示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年8月3日
 */
public class VarargsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	/**
	 * 当方法需要0个或多个同类型参数时。
	 */
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args) {
			sum += arg;
		}
		return sum;
	}
	
	/**
	 * 当方法需要1个或多个同类型参数时，使用下面的方式更好。
	 */
	static int max(int firstArg, int... args) {
		int max = firstArg;
		for (int arg : args) {
			if (arg > max) {
				max = arg;
			}
		}
		return max;
	}
	
	/**
	 * 在重视性能的情况下，使用可变参数机制要特别小心，对它的每次调用都会导致一次数组分配和初始化。
	 * 假设确定对某方法的调用有95%的可能性是三个参数或更少，那就应该声明该方法的五个重载，如下：
	 */
	static void foo() {
	}

	static void foo(int a) {
	}

	static void foo(int a, int b) {
	}

	static void foo(int a, int b, int c) {
	}

	static void foo(int a, int b, int c, int... args) {
	}
}