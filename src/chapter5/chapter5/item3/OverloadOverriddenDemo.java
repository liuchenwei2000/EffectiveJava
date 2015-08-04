/**
 * 
 */
package chapter5.item3;

/**
 * ����(overload)�͸���(overridden)��ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-19
 */
public class OverloadOverriddenDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A[] as = new A[] { new A(), new A1(), new A2() };
		// ������ʾ��������£�
//	    sayHello(A a)
//		sayHello(A a)
//		sayHello(A a)
		for (A a : as) {
			sayHello(a);
		}
		// ������ʾ��������£�
//		A.sayHello()
//		A1.sayHello()
//		A2.sayHello()
		for (A a : as) {
			a.sayHello();
		}
	}

	/**
	 * ������������������ʾ���� 
	 * <p>
	 * ���������ʱ���Ͷ����ĸ����ذ汾����ִ��û���κ�Ӱ�죬ѡ�������ڱ���ʱ���еģ���ȫ���ڲ����ı���ʱ���͡�
	 */
	static void sayHello(A a) {
		System.out.println("sayHello(A a)");
	}

	static void sayHello(A1 a) {
		System.out.println("sayHello(A1 a)");
	}

	static void sayHello(A2 a) {
		System.out.println("sayHello(A2 a)");
	}
}

class A {

	/**
	 * �������������ʾ����
	 * <p>
	 * ������һ�������ǵķ���ʱ������ı���ʱ���Ͳ���Ӱ���ĸ���������ִ�С�
	 */
	public void sayHello() {
		System.out.println("A.sayHello()");
	}
}

class A1 extends A {

	public void sayHello() {
		System.out.println("A1.sayHello()");
	}
}

class A2 extends A {

	public void sayHello() {
		System.out.println("A2.sayHello()");
	}
}