/**
 * 
 */
package chapter4.item6;

/**
 * 常量接口演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-9
 */
public class ConstantInterfaceDemo {
}

/**
 * 数学常量接口
 */
interface MathConstant {

	public static final double PI = 3.14159;
}

/**
 * 使用数学常量的类实现了这个接口以便于直接使用其中的常量
 */
class MathClass1 implements MathConstant {

	public void doSomething() {
		System.out.println(PI);
	}
}

/**
 * 数学常量类
 */
class MathConstants {

	public static final double PI = 3.14159;

	private MathConstants() {
		// no instance and no subclass
	}
}

/**
 * 使用数学常量的类直接使用MathConstants中的常量
 */
class MathClass2 {

	public void doSomething() {
		System.out.println(MathConstants.PI);
	}
}