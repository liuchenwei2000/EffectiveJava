/**
 * 
 */
package chapter8.item5;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * ���л�����ģʽʾ��
 * <p>
 * ���л�����ģʽ�Ĺ��ܱȱ����Կ�������ǿ����Ϊ���������л�ʵ��������ԭʼ���л�ʵ����ͬ���ࡣ
 * ��ͬʱҲ��ʧ��һЩ���ܡ�
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
	
	private final Date start;
	private final Date end;
	
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
	 * ��Χ�༰������඼����ʵ�� Serializable �ӿڡ�
	 * <p>
	 * ��һ����Ϊ�����л��������һ��˽�еľ�̬Ƕ���࣬��ȷ�ر�ʾ��Χ��ʵ�����߼�״̬��
	 * ���Ƕ���౻�������л�����Serialization Proxy������Ӧ����һ�������Ĺ���������������;�������Χ�ࡣ
	 * ���������ֻ�����Ĳ����и������ݣ�����Ҫ�κ�һ���Լ����߱����Կ�����
	 */
	private static class SerializationProxy implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3041222550075990191L;
		
		private final Date start;
		private final Date end;
		
		public SerializationProxy(Period period) {
			this.start = period.start;
			this.end = period.end;
		}
		
		/**
		 * ���Ĳ����� SerializationProxy �����ṩһ�� readResolve ������������һ���߼����൱����Χ���ʵ����
		 * ��������ĳ��֣��������л�ϵͳ�ڷ����л�ʱ�����л�����ת�����Χ���ʵ����
		 * <p>
		 * ��� readResolve �����������ù��� API ��������Χ���ʵ���������Ǹ�ģʽ���������ڡ�
		 * ����������������л����������Ա���֮�����������Ϊ�����л�ʵ���������봴�������κ�ʵ��һ���Ĺ���������̬�������������ġ�
		 * �����Ͳ��ص���ȷ���������л���ʵ��һ��Ҫ�������Լ����������Ϊ�������Ĺ���������̬��������������ЩԼ��������
		 * ��������ʵ��������ά������ЩԼ���������Ϳ���ȷ�����л�Ҳ��ά����ЩԼ��������
		 */
		private Object readResolve(){
			return new Period(start, end);
		}
	}
	
	/**
	 * �ڶ������������ writeReplace ������ӵ���Χ���С�
	 * ��������Ĵ��ڵ������л�ϵͳ����һ�� SerializationProxy ʵ����������Χ���ʵ����
	 * writeReplace ���������л�֮ǰ������Χ���ʵ��ת������������л��������ʵ����
	 */
	private Object writeReplace() {
		return new SerializationProxy(this);
	}
	
	/**
	 * ����������������� writeReplace ����֮�����л�ϵͳ��Զ���������Χ������л�ʵ����
	 * ���ǹ������п���α�죬��ͼΥ�������Լ��������Ϊ�˷������ֹ�����ֻҪ����Χ������� readObject �������ɡ�
	 */ 
	private void readObject(ObjectInputStream ois) throws InvalidObjectException{
		throw new InvalidObjectException("Proxy required");
	}
}
