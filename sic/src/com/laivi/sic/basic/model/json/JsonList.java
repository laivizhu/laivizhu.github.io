/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.basic.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laivi
 * Desc:
 */
@SuppressWarnings("serial")
public final class JsonList implements Serializable {
	private List<String> list = new ArrayList<String>();
	
	public void add(String item) {
        list.add(item);
    }
}
