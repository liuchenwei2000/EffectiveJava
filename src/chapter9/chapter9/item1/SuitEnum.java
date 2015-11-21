/**
 * 
 */
package chapter9.item1;

/**
 * 扑克牌花色枚举
 * <p>
 * 4，使用Java原生enum类型实现。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-14
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
		// 枚举类有个静态的 values 方法，按照声明顺序返回它的值数组。
		for (SuitEnum s : SuitEnum.values()) {
			// 枚举类的 toString 可以将枚举转换成可打印的字符串，如果不适合可以通过覆盖进行修改
			System.out.println(s);
		}
	}
}
