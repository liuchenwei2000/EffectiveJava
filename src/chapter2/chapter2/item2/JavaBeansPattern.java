/**
 * 
 */
package chapter2.item2;

/**
 * JavBeans ģʽʾ��
 * <p>
 * �� JavaBeans ģʽ�£�����һ���޲ι���������������Ȼ����� setter ����������ÿ����Ҫ�Ĳ�����
 * ����ȱ���ǣ��ڹ�������� JavaBean ���ܴ��ڲ�һ�µ�״̬��������ֹ�����Ϊ���ɱ�Ŀ��ܣ�ɥʧ��ԭ�����̰߳�ȫ�ԡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��7��31��
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
	 * JavBeans ģʽ
	 */
	private static class Book {
		// ǰ�����Ǳ�������
		private String name;
		private String author;
		private String isbn;
		// �������ǿ�ѡ����
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