/**
 * 
 */
package chapter8.item4;

import java.io.Serializable;

/**
 * readResolve ������ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��8��8��
 */
public class Singleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8708650646144710173L;

	public static final Singleton INSTANCE = new Singleton();

	private Singleton() {
		// do nothing
	}

	/**
	 * ����һ�����ڱ������л��Ķ�����������ඨ����һ�� readResolve ������
	 * ���Ҿ߱���ȷ����������ô�ڷ����л�֮�󣬣������л����½������ϵ� readResolve �����ͻᱻ���á�
	 * Ȼ�󣬸÷������صĶ������ý�������ȡ���������л����½��Ķ���
	 * ��������Եľ�������÷��У�ָ���½���������ò���Ҫ�ڱ����������������Ϊ�������յĶ���
	 * ͬʱ��������������л���ʽ������Ҫ�����κ�ʵ�ʵ����ݣ����е�ʵ����Ӧ�ñ�����Ϊ transient �ġ�
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}
