/**
 * 
 */
package chapter7.item1;

/**
 * �쳣���������Ŀ�����ʾ��
 * <p>
 * �����Ƿ���̲ģ���Ҫ��ô����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��8��5��
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
