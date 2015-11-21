/**
 * 
 */
package chapter2.item2;

/**
 * JavBeans 模式示例
 * <p>
 * 在 JavaBeans 模式下，调用一个无参构造器来创建对象，然后调用 setter 方法来设置每个必要的参数。
 * 它的缺点是，在构造过程中 JavaBean 可能处于不一致的状态，并且阻止了类成为不可变的可能，丧失了原生的线程安全性。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年7月31日
 */
public class JavaBeansPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Book book = new Book();
		book.setName("Effective Java");
		book.setAuthor("Joshua Bloch");
		book.setIsbn("978-7-111-25583-3");
		book.setEdition(2);
		book.setPrice(52.00);
		book.setPages(297);
	}

	/**
	 * JavBeans 模式
	 */
	private static class Book {
		// 前三个是必需属性
		private String name;
		private String author;
		private String isbn;
		// 后三个是可选属性
		private int edition;
		private double price;
		private int pages;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public int getEdition() {
			return edition;
		}

		public void setEdition(int edition) {
			this.edition = edition;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getPages() {
			return pages;
		}

		public void setPages(int pages) {
			this.pages = pages;
		}
	}
}
