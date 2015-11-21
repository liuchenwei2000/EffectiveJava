/**
 * 
 */
package chapter2.item2;

/**
 * Builder 模式示例
 * <p>
 * Builder 模式既能保证重叠构造器的安全性，也能保证 JavaBeans 模式的可读性。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年7月31日
 */
public class BuilderPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Book book = new BookBuilder("Effective Java", "Joshua Bloch", "978-7-111-25583-3").setEdition(2).setPrice(52.00)
				.setPages(297).build();
	}
	
	private static class BookBuilder {
		
		private String name;
		private String author;
		private String isbn;
		
		private int edition;
		private double price;
		private int pages;
		
		public BookBuilder(String name, String author, String isbn) {
			super();
			this.name = name;
			this.author = author;
			this.isbn = isbn;
		}

		public BookBuilder setPages(int pages) {
			this.pages = pages;
			return this;
		}

		public BookBuilder setEdition(int edition) {
			this.edition = edition;
			return this;
		}

		public BookBuilder setPrice(double price) {
			this.price = price;
			return this;
		}
		
		public Book build(){
			return new Book(this);
		}
	}

	private static class Book {
		
		// 前三个是必需属性
		private final String name;
		private final String author;
		private final String isbn;
		// 后三个是可选属性
		private final int edition;
		private final double price;
		private final int pages;

		public Book(BookBuilder bookBuilder) {
			this.name = bookBuilder.name;
			this.author = bookBuilder.author;
			this.isbn = bookBuilder.isbn;
			this.edition = bookBuilder.edition;
			this.price = bookBuilder.price;
			this.pages = bookBuilder.pages;
		}
	}
}
