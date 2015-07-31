/**
 * 
 */
package chapter2.item2;

/**
 * �ص�������ģʽʾ��
 * <p>
 * �ص�������ģʽ���У����ǵ������������ʱ�򣬿ͻ��˴������ѱ�д��������Ȼ�������Ķ���
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��7��31��
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
	 * �ص�������ģʽ
	 */
	private static class Book {
		// ǰ�����Ǳ�������
		private final String name;
		private final String author;
		private final String isbn;
		// �������ǿ�ѡ����
		private final int edition;
		private final double price;
		private final int pages;

		/**
		 * �����ṩһ��ֻ�б������ԵĹ������⣬��Ҫ�ṩ���������ѡ���ԵĹ�������
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