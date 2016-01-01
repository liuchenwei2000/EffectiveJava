/**
 * 
 */
package chapter4.item5;

/**
 * 模拟多重继承(Simulated Multiple Inheritance)演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-11
 */
public class SimulatedMultipleInheritanceDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fly(new Human());
	}
	
	private static void fly(Flyable flyable) {
		flyable.fly();
	}
}

/**
 * 这是一个接口
 */
interface Flyable {

	public void fly();
}

/**
 * 这是一个骨架实现类
 */
abstract class AbstractFlyable implements Flyable {

	// 其他一些辅助性的方法
}

class Animal {
}

/**
 * Human类已经继承了Animal，所以无法再继承AbstractFlyable了。
 * 采用了模拟多重继承的方式，类本身实现Flyable。
 */
class Human extends Animal implements Flyable {

	/**
	 * 接口方法的实现委托给内部对象
	 *
	 * @see chapter4.item16.Flyable#fly()
	 */
	public void fly() {
		new AirPlane().fly();
	}

	/**
	 * 这个内部类继承了AbstractFlyable，完成真正的接口实现。
	 */
	private static class AirPlane extends AbstractFlyable {

		@Override
		public void fly() {
			System.out.println("I can fly.");
		}
	}
}
