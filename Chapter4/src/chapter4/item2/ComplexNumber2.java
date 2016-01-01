/**
 * 
 */
package chapter4.item2;

/**
 * 复数类2
 * <p>
 * 用来表示数学上的复数：a + b*i
 * <p>
 * 该类使用公有的静态工厂来代替公有的构造函数以避免其内方法被子类改写。
 * 这种方式最灵活，因为它允许使用多个包级私有的实现类。
 * 对于包外面的客户而言，不可变类实际上是final的，因为要继承它是不可能的。
 * 这种做法也使得可以在后续的版本中改进这个类的性能，比如增强静态工厂的对象缓存能力。
 *
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-1
 */
public class ComplexNumber2 {

	private final double realPart;// 实部
	private final double imaginaryPart;// 虚部
	
	/**
	 * 构造函数私有
	 */
	private ComplexNumber2(double realPart, double imaginaryPart) {
		super();
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	/**
	 * 这是一个静态工厂。
	 */
	public static ComplexNumber2 valueOf(double realPart,double imaginaryPart){
		return new ComplexNumber2(realPart, imaginaryPart);
	}
	
	/**
	 * 如果需要使用极坐标来创建复数对象，采用构造函数来实现这样的功能，可能会使得这个类很零乱。
	 * 因为这样的构造函数会和已有的构造函数具有同样的原型特征。但是通过静态工厂却很容易做到。
	 */
	public static ComplexNumber2 valueOfPolar(double r, double theta) {
		return new ComplexNumber2(r * Math.cos(theta), r * Math.sin(theta));
	}

	/** 下面是两个域的访问方法，没有提供修改方法。 */
	
	public double getRealPart() {
		return realPart;
	}
	
	public double getImaginaryPart() {
		return imaginaryPart;
	}
}
