/**
 * 
 */
package chapter4.item5;

/**
 * ģ����ؼ̳�(Simulated Multiple Inheritance)��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-11
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
 * ����һ���ӿ�
 */
interface Flyable {

	public void fly();
}

/**
 * ����һ���Ǽ�ʵ����
 */
abstract class AbstractFlyable implements Flyable {

	// ����һЩ�����Եķ���
}

class Animal {
}

/**
 * Human���Ѿ��̳���Animal�������޷��ټ̳�AbstractFlyable�ˡ�
 * ������ģ����ؼ̳еķ�ʽ���౾��ʵ��Flyable��
 */
class Human extends Animal implements Flyable {

	/**
	 * �ӿڷ�����ʵ��ί�и��ڲ�����
	 *
	 * @see chapter4.item16.Flyable#fly()
	 */
	public void fly() {
		new AirPlane().fly();
	}

	/**
	 * ����ڲ���̳���AbstractFlyable����������Ľӿ�ʵ�֡�
	 */
	private static class AirPlane extends AbstractFlyable {

		@Override
		public void fly() {
			System.out.println("I can fly.");
		}
	}
}