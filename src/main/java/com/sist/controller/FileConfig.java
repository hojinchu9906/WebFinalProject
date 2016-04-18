package com.sist.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileConfig {
	public static List<String> getFileName(String package0){
		List<String> list=new ArrayList<>();
		
		try{
			String path="C:\\Users\\sist\\Documents\\GitStudyDownload\\spring-tool-suite-3.7.3.RELEASE-e4.5.2-win32-x86_64_\\workspace\\WebFinalProject\\src\\main\\java";
			path=path+package0.replace('.', '\\');		// com\\sist\\board
			
			File dir=new File(path);
			File[] files=dir.listFiles();
			for(File file:files){
				if(file.getName().equals("."))
					continue;
				if(file.isFile()){
					String name=file.getName();
					System.out.println(name);
					
					String extension=name.substring(name.lastIndexOf('.'));
					if(extension.equals("java")){
						String fullFileName=package0 +"."+ name.substring(0,name.lastIndexOf('.'));
						System.out.println(fullFileName);
						
						list.add(fullFileName);
					}
				}
			}
						
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
}


























