/**
 * 
 */
package chapter6.item4;

/**
 * 字符串拼接演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-27
 */
public class StringAppendDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testN(5000);
		testN(10000);
		testN(20000);
	}
	
	private static void testN(int n) {
		long start = System.currentTimeMillis();
		appendString(n);
		long end = System.currentTimeMillis();
		System.out.println("String " + n + " 次拼接：" + (end - start) + " ms");

		start = System.currentTimeMillis();
		appendStringBuffer(n);
		end = System.currentTimeMillis();
		System.out.println("StringBuffer " + n + " 次拼接：" + (end - start) + " ms");

		start = System.currentTimeMillis();
		appendStringBuilder(n);
		end = System.currentTimeMillis();
		System.out.println("StringBuilder " + n  + " 次拼接：" + (end - start) + " ms");
	}

	private static void appendString(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s = s + i;
		}
	}

	private static void appendStringBuffer(int n) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < n; i++) {
			s.append(i);
		}
	}

	private static void appendStringBuilder(int n) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < n; i++) {
			s.append(i);
		}
	}
}