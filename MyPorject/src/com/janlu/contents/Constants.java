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
			String HeapOutError="����������";
			String ArrayOutError="����Խ�����������";
		}
		
		interface Message{
			String NotFoundMessage="û�ҵ�";
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
