/**
 * 
 */
package chapter4.item2;

/**
 * ������
 * <p>
 * ������ʾ��ѧ�ϵĸ�����a + b*i
 * <p>
 * ����һ�����ɱ��࣬���Բμ�JDK��BigInteger�ࡣ
 *
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-1
 */
public class ComplexNumber {
	
	/** �����ǿͻ��˳��õ�ʵ���������ͻ���������Щ���е�ʵ���� */
	
	public static final ComplexNumber ZERO = new ComplexNumber(0, 0);
	public static final ComplexNumber ONE = new ComplexNumber(1, 0);
	public static final ComplexNumber I = new ComplexNumber(0, 1);

	private final double realPart;// ʵ��
	private final double imaginaryPart;// �鲿
	
	public ComplexNumber(double realPart, double imaginaryPart) {
		super();
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	/** ������������ķ��ʷ�����û���ṩ�޸ķ����� */
	
	public double getRealPart() {
		return realPart;
	}
	
	public double getImaginaryPart() {
		return imaginaryPart;
	}
	
	/** �������������㷽���� */
	
	/**
	 * ��Щ���㷽���Ǵ���������һ���µ�ComplexNumberʵ�����������޸ĵ�ǰ���ʵ����
	 * �������Ҫ�Ĳ��ɱ��඼ʹ��������ģʽ��
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
	
	/** ����equals��hashCode��toString�ȷ����Ե� */
}