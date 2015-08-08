/**
 * 
 */
package chapter8.item5;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 序列化代理模式示例
 * <p>
 * 序列化代理模式的功能比保护性拷贝更加强大，因为它允许反序列化实例有着与原始序列化实例不同的类。
 * 但同时也损失了一些性能。
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
	 * 外围类及其代理类都必须实现 Serializable 接口。
	 * <p>
	 * 第一步，为可序列化的类添加一个私有的静态嵌套类，精确地表示外围类实例的逻辑状态。
	 * 这个嵌套类被称作序列化代理（Serialization Proxy），它应该有一个单独的构造器，其参数类型就是其外围类。
	 * 这个构造器只从它的参数中复制数据，不需要任何一致性检查或者保护性拷贝。
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
		 * 第四步，在 SerializationProxy 类中提供一个 readResolve 方法，它返回一个逻辑上相当的外围类的实例。
		 * 这个方法的出现，导致序列化系统在反序列化时将序列化代理转变回外围类的实例。
		 * <p>
		 * 这个 readResolve 方法仅仅利用公有 API 创建了外围类的实例，这正是该模式的魅力所在。
		 * 它极大地消除了序列化机制中语言本身之外的特征，因为反序列化实例是利用与创建其他任何实例一样的构造器（静态工厂）而创建的。
		 * 这样就不必单独确保被反序列化的实例一定要遵守类的约束条件，因为如果该类的构造器（静态工厂）建立了这些约束条件，
		 * 并且它的实例方法在维持着这些约束条件，就可以确信序列化也会维持这些约束条件。
		 */
		private Object readResolve(){
			return new Period(start, end);
		}
	}
	
	/**
	 * 第二步，将下面的 writeReplace 方法添加到外围类中。
	 * 这个方法的存在导致序列化系统产生一个 SerializationProxy 实例，代替外围类的实例。
	 * writeReplace 方法在序列化之前，将外围类的实例转变成了它的序列化代理类的实例。
	 */
	private Object writeReplace() {
		return new SerializationProxy(this);
	}
	
	/**
	 * 第三步，有了上面的 writeReplace 方法之后，序列化系统永远不会产生外围类的序列化实例。
	 * 但是攻击者有可能伪造，企图违反该类的约束条件，为了防范这种攻击，只要在外围类中添加 readObject 方法即可。
	 */ 
	private void readObject(ObjectInputStream ois) throws InvalidObjectException{
		throw new InvalidObjectException("Proxy required");
	}
}
