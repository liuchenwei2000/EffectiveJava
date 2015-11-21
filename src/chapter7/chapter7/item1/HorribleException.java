/**
 * 
 */
package chapter7.item1;

/**
 * 异常用于正常的控制流示例
 * <p>
 * 本例是反面教材，不要这么做。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年8月5日
 */
public class HorribleException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int i = 0;
			while (true) {
				System.out.println(args[i++]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// ...
		}
	}
}
