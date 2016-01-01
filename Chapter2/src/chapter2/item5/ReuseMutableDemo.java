/**
 * 
 */
package chapter2.item5;

import java.util.Calendar;
import java.util.Date;

/**
 * 重用可变对象演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2010-12-21
 */
public class ReuseMutableDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UnreuseMutable urm = new UnreuseMutable(new Date());
		System.out.println(urm.is21Century() ? "21Century" : "not 21Century");
		ReuseMutable rm = new ReuseMutable(new Date());
		System.out.println(rm.is21Century() ? "21Century" : "not 21Century");
	}
}

/**
 * 没重用可变对象
 */
class UnreuseMutable {

	private Date date;

	public UnreuseMutable(Date date) {
		this.date = date;
	}

	/**
	 * 每次调用这个方法都会重新创建一个Calendar对象，Calendar对象是一个可变对象。
	 */
	public boolean is21Century() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
		return date.compareTo(calendar.getTime()) >= 0;
	}
}

/**
 * 重用可变对象
 */
class ReuseMutable {

	// 将Calendar对象提升为静态域
	private static Calendar calendar = Calendar.getInstance();

	// 在类加载的时候进行初始化，因为它的值一旦被计算出来就不会再改变了
	static {
		calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
	}

	private Date date;

	public ReuseMutable(Date date) {
		this.date = date;
	}

	/**
	 * 每次调用这个方法都会重用可变对象calendar
	 */
	public boolean is21Century() {
		return date.compareTo(calendar.getTime()) >= 0;
	}
}
