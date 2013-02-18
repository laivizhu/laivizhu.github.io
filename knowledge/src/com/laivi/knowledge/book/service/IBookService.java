package com.laivi.knowledge.book.service;

import java.io.File;

import net.sf.json.JSONArray;

import com.laivi.knowledge.basic.model.exception.ErrorFileException;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 18, 2013
 */
public interface IBookService{
	JSONArray upload(File[] books,String[] booksFileName,String path,long userId)throws ErrorFileException;
}
