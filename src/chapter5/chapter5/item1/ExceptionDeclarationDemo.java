/**
 * 
 */
package chapter5.item1;

/**
 * ���������쳣��ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-15
 */
public class ExceptionDeclarationDemo {

	/**
	 * ����log(x)��ֵ
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