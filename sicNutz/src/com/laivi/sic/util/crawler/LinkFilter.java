/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laivi.sic.util.crawler;

/**
 * 
 * @author Administrator
 */
public interface LinkFilter {
	public boolean accept(String url) ;
}