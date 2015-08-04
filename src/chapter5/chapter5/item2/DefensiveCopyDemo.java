/**
 * 
 */
package chapter5.item2;

import java.util.Date;

/**
 * �����Կ���(defensive copy)��ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-17
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
 * ʱ����ࣨ����ȫ�ģ�
 * <p>
 * ������Լ�������ǣ����ڵ���ʼʱ�䲻���ڽ���ʱ��֮��
 */
class Period1 {

	private final Date startDate;
	private final Date endDate;

	public Period1(Date startDate, Date endDate) {
		// ��Ȼ������Լ�������ļ�飬������紫��Ķ�����Ȼ�ǿɱ�ġ�
		if (startDate.compareTo(endDate) > 0) {
			throw new IllegalArgumentException(startDate + " after " + endDate);
		}
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * �������������ʷ����ṩ���ڲ���Ϣ�Ķ������ã�ʹ�������Ըı���״̬��
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
 * ʱ����ࣨ��ȫ�ģ�
 * <p>
 * ������Լ�������ǣ����ڵ���ʼʱ�䲻���ڽ���ʱ��֮��
 */
class Period2 {

	private final Date startDate;
	private final Date endDate;

	public Period2(Date startDate, Date endDate) {
		// ���ڹ��캯����ÿ���ɱ�������з����Կ���(defensive copy)�Ǳ�Ҫ�ģ�����ʹ�ÿ���֮��Ķ�����Ϊʵ�������������ʹ��ԭʼ�Ķ���
		this.startDate = new Date(startDate.getTime());
		this.endDate = new Date(endDate.getTime());
		if (this.startDate.compareTo(this.endDate) > 0) {
			throw new IllegalArgumentException(this.startDate + " after " + this.endDate);
		}
	}

	/**
	 * �������������ʷ�����ֻҪ���ؿɱ��ڲ���ķ����Կ������ɡ�
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