/**
 * 
 */
package chapter4.item2;

/**
 * 复数类
 * <p>
 * 用来表示数学上的复数：a + b*i
 * <p>
 * 这是一个不可变类，可以参见JDK的BigInteger类。
 *
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-1
 */
public class ComplexNumber {
	
	/** 下面是客户端常用的实例，鼓励客户端重用这些已有的实例。 */
	
	public static final ComplexNumber ZERO = new ComplexNumber(0, 0);
	public static final ComplexNumber ONE = new ComplexNumber(1, 0);
	public static final ComplexNumber I = new ComplexNumber(0, 1);

	private final double realPart;// 实部
	private final double imaginaryPart;// 虚部
	
	public ComplexNumber(double realPart, double imaginaryPart) {
		super();
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	/** 下面是两个域的访问方法，没有提供修改方法。 */
	
	public double getRealPart() {
		return realPart;
	}
	
	public double getImaginaryPart() {
		return imaginaryPart;
	}
	
	/** 下面是两个运算方法。 */
	
	/**
	 * 这些运算方法是创建并返回一个新的ComplexNumber实例，而不是修改当前这个实例。
	 * 大多数重要的不可变类都使用了这种模式。
	 */
	public ComplexNumber add(ComplexNumber c) {
		double resultRealPart = c.getRealPart() + this.getRealPart();
		double resultImaginaryPart = c.getImaginaryPart()
				+ this.getImaginaryPart();
		return new ComplexNumber(resultRealPart, resultImaginaryPart);
	}
	
	public ComplexNumber sub(ComplexNumber c) {
		double resultRealPart = c.getRealPart() - this.getRealPart();
		double resultImaginaryPart = c.getImaginaryPart()
				- this.getImaginaryPart();
		return new ComplexNumber(resultRealPart, resultImaginaryPart);
	}
	
	/** 诸如equals、hashCode、toString等方法略掉 */
}
