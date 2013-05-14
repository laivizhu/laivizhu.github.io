package com.laivi.sic.test;


import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Before;
import org.junit.Test;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class MethodTest {
	
	@Before
	public void init(){
		
	}
	
	@Test
	public void testJson(){
	}
	
	@Test
	public void testStringReplace(){
		String id="userId";
		System.out.println("after replace:"+id.replaceAll("Id","").length());
	}
	
	@Test
	public void testIKAnalysic() throws IOException{
		String text="从基于java语言开发的轻量级你的我的中文分词工具包 china laivi of a ok"; 
		Analyzer anal=new IKAnalyzer(true);
		StringReader reader=new StringReader(text);
		//分词  
        TokenStream ts=anal.tokenStream("", reader);  
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);  
        //遍历分词数据  
        while(ts.incrementToken()){  
        	/*if(term.toString().equals("的")){
        		continue;
        	}*/
            System.out.print(term.toString()+"|");  
        }  
        reader.close();  
        System.out.println();  
	}
	
	@Test
	public void testLucene() throws IOException{
		String text="从基于java语言开发的轻量级你的我的中文分词工具包 china laivi of a ok";  
        StringReader sr=new StringReader(text);  
        IKSegmenter ik=new IKSegmenter(sr, true);  
        Lexeme lex=null;  
        while((lex=ik.next())!=null){  
            System.out.print(lex.getLexemeText()+"|");  
        } 
	}
	
	
	
}
