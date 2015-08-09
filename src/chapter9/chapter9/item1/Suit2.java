/**
 * 
 */
package chapter9.item1;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * �˿��ƻ�ɫö��2
 * <p>
 * 3����ǿ���ܵ����Ͱ�ȫö�١�
 * <p>
 * �κη��������Ա���ӵ����Ͱ�ȫö�����У�Ҳ����ʵ���κνӿ�(����ʵ����Serializable)��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-14
 */
public class Suit2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final Suit2 CLUBS = new Suit2("clubs");// ����
	public static final Suit2 DIAMONDS = new Suit2("diamonds");// ����
	public static final Suit2 HEARTS = new Suit2("hearts");// ����
	public static final Suit2 SPADES = new Suit2("spades");// ÷��

	// ˽�е�����ö�ٶ�������
	private static final Suit2[] VALUES = { CLUBS, DIAMONDS, HEARTS, SPADES };

	// �����ṩ�Ĺ��еķǿɱ������ö�ٶ����б�
	public static final List<Suit2> VALUES_LIST = Collections.unmodifiableList(Arrays.asList(VALUES));
	
	private final String name;

	private Suit2(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	/**
	 * ʵ����Serializable �ӿڻ���Ҫ�ṩ���µ�����������÷����ᱻ���л�ϵͳ�Զ����á�
	 * ���������ڷ����л���ʱ������ظ��ĳ�������֤ÿ��ö�ٳ���ֻ��һ��������Ϊ���Ĵ���
	 */
	private Object readResolve() throws ObjectStreamException {
		for (Suit2 suit2 : VALUES) {
			if (suit2.name.equals(name)) {
				return suit2;
			}
		}
		return null;
	}
}