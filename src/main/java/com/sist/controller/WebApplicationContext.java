package com.sist.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApplicationContext {

	List<String> list=new ArrayList<String>();
	
	//»ý¼ºÀÚ
	public WebApplicationContext(String path){
		try{
			SAXParserFactory spf=
					SAXParserFactory.newInstance();
			SAXParser sp=
					spf.newSAXParser();
			
			HandlerMapping hm=new HandlerMapping();
			
			sp.parse(new File(path), hm);
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public List<String> getFileName(){
		List<String> packageList=new ArrayList<>();
		
		for(String package0: list){
			List<String> fileList=FileConfig.getFileName(package0);
			
			for(String str:fileList){
				packageList.add(str);
			}
		}
		
		return packageList;
	}
}

















































