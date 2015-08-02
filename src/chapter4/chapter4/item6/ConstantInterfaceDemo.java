/**
 * 
 */
package chapter4.item6;

/**
 * �����ӿ���ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-9
 */
public class ConstantInterfaceDemo {
}

/**
 * ��ѧ�����ӿ�
 */
interface MathConstant {

	public static final double PI = 3.14159;
}

/**
 * ʹ����ѧ��������ʵ��������ӿ��Ա���ֱ��ʹ�����еĳ���
 */
class MathClass1 implements MathConstant {

	public void doSomething() {
		System.out.println(PI);
	}
}

/**
 * ��ѧ������
 */
class MathConstants {

	public static final double PI = 3.14159;

	private MathConstants() {
		// no instance and no subclass
	}
}

/**
 * ʹ����ѧ��������ֱ��ʹ��MathConstants�еĳ���
 */
class MathClass2 {

	public void doSomething() {
		System.out.println(MathConstants.PI);
	}
}