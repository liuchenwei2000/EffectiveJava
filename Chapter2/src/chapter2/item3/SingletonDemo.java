/**
 * 
 */
package chapter2.item3;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * singleton演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2010-12-18
 */
public class SingletonDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Client端如何使用singleton类
		System.out.println(Singleton1.INSTANCE);
		System.out.println(Singleton2.getInstance());
	}
}

/**
 * 公有静态域实现单例
 */
class Singleton1 {

	// 声明一个公有静态成员
	public static final Singleton1 INSTANCE = new Singleton1();

	/**
	 * 私有的构造函数，保证了Singleton1实例的全局唯一性，只有一个实例(INSTANCE)存在
	 */
	private Singleton1() {
		// do something
	}
}

/**
 * 公有静态方法实现单例
 */
class Singleton2 implements Serializable {

	private static final long serialVersionUID = -2892082535158192922L;
	
	// 声明一个私有静态成员
	private static final Singleton2 INSTANCE = new Singleton2();

	/**
	 * 私有的构造函数，保证了Singleton2实例的全局唯一性，只有一个实例(INSTANCE)存在
	 */
	private Singleton2() {
		// do something
		// 可以通过反射机制调用私有构造器创建实例，为了防范这种攻击，可以修改构造器
		// 在它被要求创建第二个实例的时候抛出异常。
		if(INSTANCE != null) {
			throw new RuntimeException("非法访问");
		}
	}

	/**
	 * 通过静态方法返回同一个Singleton2实例
	 */
	public static Singleton2 getInstance() {
		return INSTANCE;
	}
	
	/**
	 * 如果singleton类是可序列化的，为了维护并保证单例性，必须声明所有实例域都是 transient 的，并实现本方法。
	 */
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;// 返回真正的singleton实例，而不是反序列化回来的实例
	}
}

/**
 * 枚举类型实现单例，提供原生的序列化机制，防止多次实例化、防止反射攻击。
 */
enum Singleton3 {
	
	INSTANCE;
	
	public void doSomething(){
		// do something
	}
}
