/**
 * 
 */
package chapter9.item1;

/**
 * 枚举示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年8月9日
 */
public enum Color {

	RED, GREEN, YELLOW;

	public static void main(String[] args) {
		// 枚举类有个静态的 values 方法，按照声明顺序返回它的值数组。
		for (Color c : Color.values()) {
			// 枚举类的 toString 可以将枚举转换成可打印的字符串，如果不适合可以通过覆盖进行修改
			System.out.println(c);
		}
	}
}
