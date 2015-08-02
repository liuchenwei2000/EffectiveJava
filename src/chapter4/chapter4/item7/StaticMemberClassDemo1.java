/**
 * 
 */
package chapter4.item7;

/**
 * ��̬��Ա��ĵ�һ���÷�(���и�����)��ʾ
 * <p>
 * ��Ϊ���еĸ����࣬�����������ⲿ��һ��ʹ��ʱ�������塣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2011-3-12
 */
public class StaticMemberClassDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// �ͻ��˳������ͨ�����µķ�ʽ������Щ�������
		double result = new Calculator().calculate(1, Calculator.Operation.PLUS, 2);
		System.out.println(result);
	}
}

/**
 * ������������һ���ⲿ��
 */
class Calculator {

	/**
	 * �����������������
	 */
	public double calculate(double x, Operation op, double y) {
		return op.eval(x, y);
	}

	/**
	 * �������������һ�����еľ�̬�ڲ���
	 */
	public static abstract class Operation {

		private final String name;

		Operation(String name) {
			this.name = name;
		}

		/**
		 * ����������
		 */
		abstract double eval(double x, double y);

		public String toString() {
			return name;
		}

		/**
		 * �ӷ�
		 */
		public static final Operation PLUS = new Operation("+") {

			@Override
			double eval(double x, double y) {
				return x + y;
			}
		};

		/**
		 * ����
		 */
		public static final Operation MINUS = new Operation("-") {

			@Override
			double eval(double x, double y) {
				return x - y;
			}
		};

		/**
		 * �˷�
		 */
		public static final Operation TIMES = new Operation("*") {

			@Override
			double eval(double x, double y) {
				return x * y;
			}
		};

		/**
		 * ����
		 */
		public static final Operation DIVIDE = new Operation("/") {

			@Override
			double eval(double x, double y) {
				return x / y;
			}
		};
	}
}