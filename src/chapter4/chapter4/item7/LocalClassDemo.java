/**
 * 
 */
package chapter4.item7;

/**
 * 局部类的用法演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-13
 */
public class LocalClassDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 这是一个局部类
		class DefaultFlyable implements Flyable {

			private String name;

			public DefaultFlyable(String name) {
				super();
				this.name = name;
			}

			@Override
			public void fly() {
				System.out.println(name + " can fly.");
			}

		}
		// 在方法中多次使用了该类
		fly(new DefaultFlyable("bird"));
		fly(new DefaultFlyable("airplane"));
	}

	private static void fly(Flyable flyable) {
		flyable.fly();
	}

}

interface Flyable {

	public void fly();
}