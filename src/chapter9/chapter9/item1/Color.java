/**
 * 
 */
package chapter9.item1;

/**
 * ö��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��8��9��
 */
public enum Color {

	RED, GREEN, YELLOW;

	public static void main(String[] args) {
		// ö�����и���̬�� values ��������������˳�򷵻�����ֵ���顣
		for (Color c : Color.values()) {
			// ö����� toString ���Խ�ö��ת���ɿɴ�ӡ���ַ�����������ʺϿ���ͨ�����ǽ����޸�
			System.out.println(c);
		}
	}
}
