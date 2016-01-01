/**
 * 
 */
package chapter2.item2;

/**
 * 重叠构造器模式示例
 * <p>
 * 重叠构造器模式可行，但是当有许多参数的时候，客户端代码会很难编写，并且仍然较难以阅读。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年7月31日
 */
public class TelescopingConstructorPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Book book1 = new Book("Effective Java", "Joshua Bloch", "978-7-111-25583-3");
		Book book2 = new Book("Effective Java", "Joshua Bloch", "978-7-111-25583-3", 2);
		Book book3 = new Book("Effective Java", "Joshua Bloch", "978-7-111-25583-3", 2, 52.00);
		Book book4 = new Book("Effective Java", "Joshua Bloch", "978-7-111-25583-3", 2, 52.00, 297);
	}

	/**
	 * 重叠构造器模式
	 */
	private static class Book {
		// 前三个是必需属性
		private final String name;
		private final String author;
		private final String isbn;
		// 后三个是可选属性
		private final int edition;
		private final double price;
		private final int pages;

		/**
		 * 除了提供一个只有必需属性的构造器外，还要提供多个包括可选属性的构造器。
		 */
		public Book(String name, String author, String isbn) {
			this(name, author, isbn, 1, 0, 0);
		}

		public Book(String name, String author, String isbn, int edition) {
			this(name, author, isbn, edition, 0, 0);
		}

		public Book(String name, String author, String isbn, int edition, double price) {
			this(name, author, isbn, edition, price, 0);
		}

		public Book(String name, String author, String isbn, int edition, double price, int pages) {
			this.name = name;
			this.author = author;
			this.isbn = isbn;
			this.edition = edition;
			this.price = price;
			this.pages = pages;
		}
	}
}
