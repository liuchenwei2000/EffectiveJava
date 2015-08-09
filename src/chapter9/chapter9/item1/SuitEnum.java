/**
 * 
 */
package chapter9.item1;

/**
 * �˿��ƻ�ɫö��
 * <p>
 * 4��ʹ��Javaԭ��enum����ʵ�֡�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-14
 */
public enum SuitEnum {
	
	CLUBS("clubs"), DIAMONDS("diamonds"), HEARTS("hearts"), SPADES("spades");

	private final String name;

	private SuitEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ö�����и���̬�� values ��������������˳�򷵻�����ֵ���顣
		for (SuitEnum s : SuitEnum.values()) {
			// ö����� toString ���Խ�ö��ת���ɿɴ�ӡ���ַ�����������ʺϿ���ͨ�����ǽ����޸�
			System.out.println(s);
		}
	}
}