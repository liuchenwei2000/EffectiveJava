/**
 * 
 */
package chapter8.item4;

import java.io.Serializable;

/**
 * readResolve 特性演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年8月8日
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
	 * 对于一个正在被反序列化的对象，如果它的类定义了一个 readResolve 方法，
	 * 并且具备正确的声明，那么在反序列化之后，（反序列化）新建对象上的 readResolve 方法就会被调用。
	 * 然后，该方法返回的对象引用将被用来取代（反序列化）新建的对象。
	 * 在这个特性的绝大多数用法中，指向新建对象的引用不需要在被保留，因此立即成为垃圾回收的对象。
	 * 同时，单例对象的序列化形式并不需要包含任何实际的数据，所有的实例域都应该被声明为 transient 的。
	 */
	private Object readResolve() {
		return INSTANCE;
	}
}
