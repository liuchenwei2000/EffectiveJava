/**
 * 
 */
package chapter4.item4;

import java.util.Date;

/**
 * �⵽�ƻ��Ĺ�������ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-10
 */
public class BrokenConstructorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Ԥ��Ӧ�ý����ڴ�ӡ�������Σ�ʵ���ϵ�һ�δ�ӡ��������null
		new SubClass().method();
	}
}

class SuperClass {

	/**
	 * ������췽�������˿ɱ���д��(overridable)��������ɴ���
	 */
	public SuperClass() {
		method();
	}

	public void method() {
	}
}

class SubClass extends SuperClass {

	private final Date date;

	public SubClass() {
		// ���������ŵ�����super();
		this.date = new Date();
	}

	public void method() {
		System.out.println(date);
	}
}