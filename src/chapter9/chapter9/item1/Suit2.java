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
 * 扑克牌花色枚举2
 * <p>
 * 3，增强功能的类型安全枚举。
 * <p>
 * 任何方法都可以被添加到类型安全枚举类中，也可以实现任何接口(本例实现了Serializable)。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-14
 */
public class Suit2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final Suit2 CLUBS = new Suit2("clubs");// 黑桃
	public static final Suit2 DIAMONDS = new Suit2("diamonds");// 方块
	public static final Suit2 HEARTS = new Suit2("hearts");// 红桃
	public static final Suit2 SPADES = new Suit2("spades");// 梅花

	// 私有的所有枚举对象数组
	private static final Suit2[] VALUES = { CLUBS, DIAMONDS, HEARTS, SPADES };

	// 对外提供的公有的非可变的所有枚举对象列表
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
	 * 实现了Serializable 接口还需要提供如下的这个方法，该方法会被序列化系统自动调用。
	 * 它避免了在反序列化的时候产生重复的常量，保证每个枚举常量只有一个对象作为它的代表。
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