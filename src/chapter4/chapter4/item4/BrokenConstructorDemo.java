/**
 * 
 */
package chapter4.item4;

import java.util.Date;

/**
 * 遭到破坏的构造器演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-10
 */
public class BrokenConstructorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 预期应该将日期打印出来两次，实际上第一次打印出来的是null
		new SubClass().method();
	}
}

class SuperClass {

	/**
	 * 这个构造方法调用了可被改写的(overridable)方法，造成错误
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
		// 这里隐含着调用了super();
		this.date = new Date();
	}

	public void method() {
		System.out.println(date);
	}
}