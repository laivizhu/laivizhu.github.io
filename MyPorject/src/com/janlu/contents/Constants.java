/**
 * 
 */
package com.janlu.contents;

/**
 * @author janlu
 *
 */
public interface Constants {

	interface AlgorithmConstants {
		String EMPTY = "";
		interface Error{
			String HeapOutError="超过堆容量";
			String ArrayOutError="数组越界或容量不够";
		}
		
		interface Message{
			String NotFoundMessage="没找到";
		}
		
		interface Value{
			int ArrayTotalSize=100000;
			final String One="1";
			final String Zero="0";
		}
		
		interface Symbol{
			String Comma=",";
		}
	}
}
