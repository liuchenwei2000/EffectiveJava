/**
 * 
 */
package chapter8.item3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 保护性地编写 readObject 方法示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年8月8日
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
	 * 对于每个可序列化的不可变类，如果包含了私有的可变组件，那在它的 readObject 方法中，必须要对这些组件进行保护性拷贝。
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
