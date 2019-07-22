package com.kitri.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {

	private int loginCnt;
	
    public MySessionAttributeListener() {
    	
    }

    public void attributeAdded(HttpSessionBindingEvent e)  {
    	String attrName = e.getName();
    	if("loginInfo".equals(attrName)){
    		loginCnt ++;
    		System.out.println(e.getValue() + "님이 로그인하셨습니다!");
    		System.out.println("로그인 된 사용자 : " + loginCnt + "명");
    	}
    }

    public void attributeRemoved(HttpSessionBindingEvent e)  {
    	String attrName = e.getName();
    	if("loginInfo".equals(attrName)) {
    		loginCnt --;
    		System.out.println(e.getValue() + "님이 로그아웃하셨습니다!");
    		System.out.println("로그인 된 사용자 : " + loginCnt + "명");
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 

    }
	
}
