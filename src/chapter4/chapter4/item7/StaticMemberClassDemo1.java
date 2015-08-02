/**
 * 
 */
package chapter4.item7;

/**
 * 静态成员类的第一个用法(公有辅助类)演示
 * <p>
 * 作为公有的辅助类，仅当与它的外部类一起使用时才有意义。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-3-12
 */
public class StaticMemberClassDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 客户端程序可以通过如下的方式访问这些运算操作
		double result = new Calculator().calculate(1, Calculator.Operation.PLUS, 2);
		System.out.println(result);
	}
}

/**
 * 计算器，这是一个外部类
 */
class Calculator {

	/**
	 * 根据运算操作计算结果
	 */
	public double calculate(double x, Operation op, double y) {
		return op.eval(x, y);
	}

	/**
	 * 运算操作，这是一个公有的静态内部类
	 */
	public static abstract class Operation {

		private final String name;

		Operation(String name) {
			this.name = name;
		}

		/**
		 * 返回运算结果
		 */
		abstract double eval(double x, double y);

		public String toString() {
			return name;
		}

		/**
		 * 加法
		 */
		public static final Operation PLUS = new Operation("+") {

			@Override
			double eval(double x, double y) {
				return x + y;
			}
		};

		/**
		 * 减法
		 */
		public static final Operation MINUS = new Operation("-") {

			@Override
			double eval(double x, double y) {
				return x - y;
			}
		};

		/**
		 * 乘法
		 */
		public static final Operation TIMES = new Operation("*") {

			@Override
			double eval(double x, double y) {
				return x * y;
			}
		};

		/**
		 * 除法
		 */
		public static final Operation DIVIDE = new Operation("/") {

			@Override
			double eval(double x, double y) {
				return x / y;
			}
		};
	}
}