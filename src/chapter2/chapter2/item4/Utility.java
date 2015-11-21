/**
 * 
 */
package chapter2.item4;

/**
 * 不可实例化的工具类演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2010-12-18
 */
public class Utility {

	/**
	 * 显式构造函数是私有的，所以在该类的外部是不能调用的。
	 * 如果该构造函数不会被类自身从内部调用，就能保证该类永远不会被实例化。
	 */
	private Utility() {
		// do nothing and no instance
		// 下面的代码不是必须的，可以避免不小心在类的内部调用构造器。
		throw new AssertionError();
	}
}
