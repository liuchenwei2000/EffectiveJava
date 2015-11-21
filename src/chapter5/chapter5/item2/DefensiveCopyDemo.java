/**
 * 
 */
package chapter5.item2;

import java.util.Date;

/**
 * 防御性拷贝(defensive copy)演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-17
 */
public class DefensiveCopyDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// test Period1
		Date start = new Date();
		Date end = new Date();
		Period1 period1 = new Period1(start, end);
		System.out.println(period1);
		end.setYear(2000);
		System.out.println(period1);
		period1.getEndDate().setYear(1990);
		System.out.println(period1);
		// test Period2
		start = new Date();
		end = new Date();
		Period2 period2 = new Period2(start, end);
		System.out.println(period2);
		end.setYear(2000);
		System.out.println(period2);
		period2.getEndDate().setYear(1990);
		System.out.println(period2);
	}
}

/**
 * 时间段类（不安全的）
 * <p>
 * 这个类的约束条件是：周期的起始时间不能在结束时间之后。
 */
class Period1 {

	private final Date startDate;
	private final Date endDate;

	public Period1(Date startDate, Date endDate) {
		// 虽然这里有约束条件的检查，但是外界传入的对象仍然是可变的。
		if (startDate.compareTo(endDate) > 0) {
			throw new IllegalArgumentException(startDate + " after " + endDate);
		}
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * 下面这两个访问方法提供了内部信息的对象引用，使得外界可以改变其状态。
	 */
	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	@Override
	public String toString() {
		return "Period [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}

/**
 * 时间段类（安全的）
 * <p>
 * 这个类的约束条件是：周期的起始时间不能在结束时间之后。
 */
class Period2 {

	private final Date startDate;
	private final Date endDate;

	public Period2(Date startDate, Date endDate) {
		// 对于构造函数的每个可变参数进行防御性拷贝(defensive copy)是必要的，并且使用拷贝之后的对象作为实例的组件，而不使用原始的对象。
		this.startDate = new Date(startDate.getTime());
		this.endDate = new Date(endDate.getTime());
		if (this.startDate.compareTo(this.endDate) > 0) {
			throw new IllegalArgumentException(this.startDate + " after " + this.endDate);
		}
	}

	/**
	 * 对于这两个访问方法，只要返回可变内部域的防御性拷贝即可。
	 */
	public Date getStartDate() {
		return (Date) startDate.clone();
	}

	public Date getEndDate() {
		return (Date) endDate.clone();
	}

	@Override
	public String toString() {
		return "Period [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
