/**
 * 
 */
package chapter8.item3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * �����Եر�д readObject ����ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��8��8��
 */
public final class Period implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7291865000486090758L;
	
	private Date start;
	private Date end;
	
	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if(this.start.compareTo(this.end) >0){
			throw new IllegalArgumentException(start + " after " + end);
		}
	}

	public Date getStart() {
		return new Date(start.getTime());
	}

	public Date getEnd() {
		return new Date(end.getTime());
	}
	
	/**
	 * ����ÿ�������л��Ĳ��ɱ��࣬���������˽�еĿɱ�������������� readObject �����У�����Ҫ����Щ������б����Կ�����
	 */
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();

		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException(start + " after " + end);
		}
	}
}
