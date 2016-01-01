/**
 * 
 */
package chapter3.item2;

import java.util.Arrays;

/**
 * 缓存 hash code 演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2011-2-18
 */
public class CachedHashCodeDemo {
}

/**
 * 如果一个类是不可变的，并且计算散列码的代价比较大，就应该考虑把散列码缓存在对象内部，而不是每次请求的时候都重新计算散列码。
 * 如果这种类型的大多数对象都会被用作散列的键，就应该在创建实例的时候计算散列码。
 * 否则，可以选择“延迟初始化”散列码，一直到hashCode被第一次被调用的时候才初始化。
 */
class Immutable {
	
	private volatile int hashCode = 0; 

	private int[] array = new int[10000];

	public int hashCode() {
		if (hashCode == 0) {
			final int prime = 31;
			int result = 1;
			hashCode = prime * result + Arrays.hashCode(array);
		}
		return hashCode;
	}
}
