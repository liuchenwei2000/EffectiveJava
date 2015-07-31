/**
 * 
 */
package chapter2.item3;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * singleton��ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2010-12-18
 */
public class SingletonDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Client�����ʹ��singleton��
		System.out.println(Singleton1.INSTANCE);
		System.out.println(Singleton2.getInstance());
	}
}

/**
 * ���о�̬��ʵ�ֵ���
 */
class Singleton1 {

	// ����һ�����о�̬��Ա
	public static final Singleton1 INSTANCE = new Singleton1();

	/**
	 * ˽�еĹ��캯������֤��Singleton1ʵ����ȫ��Ψһ�ԣ�ֻ��һ��ʵ��(INSTANCE)����
	 */
	private Singleton1() {
		// do something
	}
}

/**
 * ���о�̬����ʵ�ֵ���
 */
class Singleton2 implements Serializable {

	private static final long serialVersionUID = -2892082535158192922L;
	
	// ����һ��˽�о�̬��Ա
	private static final Singleton2 INSTANCE = new Singleton2();

	/**
	 * ˽�еĹ��캯������֤��Singleton2ʵ����ȫ��Ψһ�ԣ�ֻ��һ��ʵ��(INSTANCE)����
	 */
	private Singleton2() {
		// do something
		// ����ͨ��������Ƶ���˽�й���������ʵ����Ϊ�˷������ֹ����������޸Ĺ�����
		// ������Ҫ�󴴽��ڶ���ʵ����ʱ���׳��쳣��
		if(INSTANCE != null) {
			throw new RuntimeException("�Ƿ�����");
		}
	}

	/**
	 * ͨ����̬��������ͬһ��Singleton2ʵ��
	 */
	public static Singleton2 getInstance() {
		return INSTANCE;
	}
	
	/**
	 * ���singleton���ǿ����л��ģ�Ϊ��ά������֤�����ԣ�������������ʵ������ transient �ģ���ʵ�ֱ�������
	 */
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;// ����������singletonʵ���������Ƿ����л�������ʵ��
	}
}

/**
 * ö������ʵ�ֵ������ṩԭ�������л����ƣ���ֹ���ʵ��������ֹ���乥����
 */
enum Singleton3 {
	
	INSTANCE;
	
	public void doSomething(){
		// do something
	}
}