/**
 * 
 */
package chapter5.item5;

import java.util.Arrays;

/**
 * �����㳤�ȵ����������null��ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-15
 */
public class NullArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = getArray1();
		// ����null��Ҫ��ͻ��������ж���Ĵ���������null����ֵ��ÿ���õ��÷���������Ҫ�������۵Ĵ���ʽ��
		// ���⣬����null�ķ�ʽҲ���Ƿ�������ķ���������Ӹ��ӡ�
		if (array == null || Arrays.asList(array).contains(1)) {
			System.out.println("1");
		}
		// �����㳤���������һЩ���������ܲ������⡣
		array = getArray2();
		if (Arrays.asList(array).contains(1)) {
			System.out.println("1");
		}
	}

	/**
	 * �᷵��null�ķ���
	 */
	private static int[] getArray1() {
		return null;
	}
	
	/**
	 * �᷵���㳤�ȵ�����ķ���
	 */
	private static int[] getArray2() {
		return new int[0];
	}
}