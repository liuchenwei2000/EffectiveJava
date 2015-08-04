/**
 * 
 */
package chapter5.item4;

import java.util.Arrays;

/**
 * �ɱ����ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��8��3��
 */
public class VarargsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	/**
	 * ��������Ҫ0������ͬ���Ͳ���ʱ��
	 */
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args) {
			sum += arg;
		}
		return sum;
	}
	
	/**
	 * ��������Ҫ1������ͬ���Ͳ���ʱ��ʹ������ķ�ʽ���á�
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
	 * ���������ܵ�����£�ʹ�ÿɱ��������Ҫ�ر�С�ģ�������ÿ�ε��ö��ᵼ��һ���������ͳ�ʼ����
	 * ����ȷ����ĳ�����ĵ�����95%�Ŀ�������������������٣��Ǿ�Ӧ�������÷�����������أ����£�
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