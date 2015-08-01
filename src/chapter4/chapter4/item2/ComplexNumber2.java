/**
 * 
 */
package chapter4.item2;

/**
 * ������2
 * <p>
 * ������ʾ��ѧ�ϵĸ�����a + b*i
 * <p>
 * ����ʹ�ù��еľ�̬���������湫�еĹ��캯���Ա������ڷ����������д��
 * ���ַ�ʽ������Ϊ������ʹ�ö������˽�е�ʵ���ࡣ
 * ���ڰ�����Ŀͻ����ԣ����ɱ���ʵ������final�ģ���ΪҪ�̳����ǲ����ܵġ�
 * ��������Ҳʹ�ÿ����ں����İ汾�иĽ����������ܣ�������ǿ��̬�����Ķ��󻺴�������
 *
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-1
 */
public class ComplexNumber2 {

	private final double realPart;// ʵ��
	private final double imaginaryPart;// �鲿
	
	/**
	 * ���캯��˽��
	 */
	private ComplexNumber2(double realPart, double imaginaryPart) {
		super();
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	/**
	 * ����һ����̬������
	 */
	public static ComplexNumber2 valueOf(double realPart,double imaginaryPart){
		return new ComplexNumber2(realPart, imaginaryPart);
	}
	
	/**
	 * �����Ҫʹ�ü������������������󣬲��ù��캯����ʵ�������Ĺ��ܣ����ܻ�ʹ�����������ҡ�
	 * ��Ϊ�����Ĺ��캯��������еĹ��캯������ͬ����ԭ������������ͨ����̬����ȴ������������
	 */
	public static ComplexNumber2 valueOfPolar(double r, double theta) {
		return new ComplexNumber2(r * Math.cos(theta), r * Math.sin(theta));
	}

	/** ������������ķ��ʷ�����û���ṩ�޸ķ����� */
	
	public double getRealPart() {
		return realPart;
	}
	
	public double getImaginaryPart() {
		return imaginaryPart;
	}
}