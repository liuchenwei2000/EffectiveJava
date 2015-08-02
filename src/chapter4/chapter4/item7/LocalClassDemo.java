/**
 * 
 */
package chapter4.item7;

/**
 * �ֲ�����÷���ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-13
 */
public class LocalClassDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����һ���ֲ���
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
		// �ڷ����ж��ʹ���˸���
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