/**
 * 
 */
package chapter9.item1;

/**
 * �˿��ƻ�ɫö��
 * <p>
 * 2��ʹ�����Ͱ�ȫö��ģʽʵ�֡�
 * <p>
 * ��Ϊ�ͻ�û�а취���������Ķ���Ҳ�޷���չ����࣬
 * ���ԣ�������Щ���еľ�̬ final �������� Suit ����֮�⣬�������б�Ķ�����ڡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-14
 */
public class Suit1 {

	public static final Suit1 CLUBS = new Suit1("clubs");// ����
	public static final Suit1 DIAMONDS = new Suit1("diamonds");// ����
	public static final Suit1 HEARTS = new Suit1("hearts");// ����
	public static final Suit1 SPADES = new Suit1("spades");// ÷��

	private final String name;

	private Suit1(String name) {
		this.name = name;
	}

	/**
	 * ��Ϊ���Ͱ�ȫö��������ȫ�����ϵ��࣬���Կ��Ը��� toString�������Ӷ�������ֵ��ת��Ϊ�ɴ�ӡ���ַ�����
	 * ע�⣬ֻ�� toString �����õ����ַ������֣�equals�Ƚϲ�����û���õ����� ��Ϊ��Object�̳е�equalsʵ��ִֻ�����ñȽϡ�
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
}