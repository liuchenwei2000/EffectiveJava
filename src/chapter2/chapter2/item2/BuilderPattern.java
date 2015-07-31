/**
 * 
 */
package chapter2.item2;

/**
 * Builder ģʽʾ��
 * <p>
 * Builder ģʽ���ܱ�֤�ص��������İ�ȫ�ԣ�Ҳ�ܱ�֤ JavaBeans ģʽ�Ŀɶ��ԡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��7��31��
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
		
		// ǰ�����Ǳ�������
		private final String name;
		private final String author;
		private final String isbn;
		// �������ǿ�ѡ����
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