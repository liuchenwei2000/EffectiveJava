/**
 * 
 */
package chapter5.item3;

/**
 * 重载(overload)和覆盖(overridden)演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-19
 */
public class OverloadOverriddenDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A[] as = new A[] { new A(), new A1(), new A2() };
		// 重载演示，结果如下：
//	    sayHello(A a)
//		sayHello(A a)
//		sayHello(A a)
		for (A a : as) {
			sayHello(a);
		}
		// 覆盖演示，结果如下：
//		A.sayHello()
//		A1.sayHello()
//		A2.sayHello()
		for (A a : as) {
			a.sayHello();
		}
	}

	/**
	 * 下面三个方法用来演示重载 
	 * <p>
	 * 对象的运行时类型对于哪个重载版本将被执行没有任何影响，选择工作是在编译时进行的，完全基于参数的编译时类型。
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
	 * 这个方法用来演示覆盖
	 * <p>
	 * 当调用一个被覆盖的方法时，对象的编译时类型不会影响哪个方法将被执行。
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