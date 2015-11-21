/**
 * 
 */
package chapter5.item1;

/**
 * 方法声明异常演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-15
 */
public class ExceptionDeclarationDemo {

	/**
	 * 返回log(x)的值
	 * 
	 * @param x
	 *            which must be positive.
	 * @return log(x)
	 * @throws IllegalArgumentException
	 *             if x<=0
	 */
	public double log(double x) {
		if (x <= 0) {
			throw new IllegalArgumentException(x + " not positive.");
		}
		return Math.log(x);
	}
}
