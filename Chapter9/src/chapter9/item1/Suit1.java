/**
 * 
 */
package chapter9.item1;

/**
 * 扑克牌花色枚举
 * <p>
 * 2，使用类型安全枚举模式实现。
 * <p>
 * 因为客户没有办法创建这个类的对象，也无法扩展这个类，
 * 所以，除了这些公有的静态 final 域声明的 Suit 对象之外，不会再有别的对象存在。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-14
 */
public class Suit1 {

	public static final Suit1 CLUBS = new Suit1("clubs");// 黑桃
	public static final Suit1 DIAMONDS = new Suit1("diamonds");// 方块
	public static final Suit1 HEARTS = new Suit1("hearts");// 红桃
	public static final Suit1 SPADES = new Suit1("spades");// 梅花

	private final String name;

	private Suit1(String name) {
		this.name = name;
	}

	/**
	 * 因为类型安全枚举类是完全意义上的类，所以可以覆盖 toString方法，从而允许其值被转换为可打印的字符串。
	 * 注意，只有 toString 方法用到了字符串名字，equals比较操作并没有用到它， 因为从Object继承的equals实现只执行引用比较。
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
