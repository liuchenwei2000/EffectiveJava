/**
 * 
 */
package chapter2.item7;

/**
 * 显式终止方法(Explicit Termination Method)演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2010-12-25
 */
public class ExplicitTerminationMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassWithExplicitTerminationMethod object = new ClassWithExplicitTerminationMethod();
		/*
		 * 显式的终止方法通常与 try-finally 结构结合起来使用，以确保及时终止。
		 * 在finally子句内部调用显式的终止方法可以保证：
		 * 即使在对象被使用的时候有异常被抛出，该终止方法也会被执行。
		 */
		try {
			// do something using object
		} finally {
			object.terminate();
		}
	}
}

class ClassWithExplicitTerminationMethod {
	
	/**
	 * 显式的终止方法
	 */
	public void terminate(){
		// do termination
	}
}
