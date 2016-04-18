package com.sist.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	private WebApplicationContext webApplicationContext;
	
	private List<String> list=new ArrayList<>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		String path=config.getInitParameter("contextConfigLocation");
		
		webApplicationContext=new WebApplicationContext(path);
		list=webApplicationContext.getFileName();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String uriCmd=request.getRequestURI();
			uriCmd=uriCmd.substring(request.getContextPath().length()+1);
			
			for(String strCls:list){
				Class clsName=Class.forName(strCls);
				
				if(clsName.isAnnotationPresent(Controller.class)==false)
					continue;
				
				
				Object object=clsName.newInstance();
				Method[] methods=clsName.getDeclaredMethods();
				for(Method method:methods){
					RequestMapping requestMapping=method.getAnnotation(RequestMapping.class);
					if(requestMapping.value().equals(uriCmd)){
						String jsp=(String)method.invoke(object, request);
						
						RequestDispatcher rd=request.getRequestDispatcher(jsp);
						rd.forward(request, response);
						return;
					}
				}
				
			}
			
		}catch(Exception ex){
			System.out.println("service()" +ex.getMessage());
		}
	}
	
	
}



























































