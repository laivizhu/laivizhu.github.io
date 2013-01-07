/**
 * 
 */
package com.janlu.util;

import javax.swing.JOptionPane;

import com.janlu.contents.Constants.AlgorithmConstants;

/**
 * @author janlu
 *
 */
public class OutPrintUtil {
	
	public static void outMessage(Object message){
		JOptionPane.showMessageDialog(null,message==null?AlgorithmConstants.EMPTY:message.toString());
	}
	
}
