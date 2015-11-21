/**
 * 
 */
package chapter3.item2;

import java.util.HashMap;

/**
 * 标准HashCode方法实现
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-2-17
 */
public class HashCodeDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Class1因为没有改写hashCode方法，导致HashMap行为异常
		 */
		HashMap<Class1,String> map1 = new HashMap<Class1,String>();
		map1.put(new Class1(1), "class1");
		System.out.println(map1.get(new Class1(1)));
		/*
		 * Class2改写了hashCode方法，所以HashMap表现正常
		 */
		HashMap<Class2,String> map2 = new HashMap<Class2,String>();
		map2.put(new Class2(2), "class2");
		System.out.println(map2.get(new Class2(2)));
	}
}

/**
 * 这个类在改写equals方法之后没有改写hashCode方法
 */
class Class1 {
	
	private int number;

	public Class1(int number) {
		super();
		this.number = number;
	}

	public boolean equals(Object obj) {
		if (this == obj)// 1
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Class1))// 2
			return false;
		Class1 other = (Class1) obj;// 3
		return other.number == this.number;// 4
	}
}

/**
 * 这个类在改写equals方法之后同时改写了hashCode方法
 */
class Class2 {

	private int number;

	public Class2(int number) {
		super();
		this.number = number;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)// 1
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Class2))// 2
			return false;
		Class2 other = (Class2) obj;// 3
		return other.number == this.number;// 4
	}
}
