package com.kitri.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionAttributeListener {
	private int loginCnt;
    public MySessionListener() {
        
    }

    public void attributeAdded(HttpSessionBindingEvent e)  { 
        String attrName = e.getName();
        
        if("loginInfo".equals(attrName)) {    		
        	loginCnt++;
        	System.out.println(e.getValue() + "님이 로그인했습니다" );
        	System.out.println("로그인된 총인원:" + loginCnt);
        }        
        
    }
    public void attributeRemoved(HttpSessionBindingEvent e)  { 
    	String attrName = e.getName();
    	if("loginInfo".equals(attrName)) {
    		loginCnt--;
    		System.out.println(e.getValue() + "님이 로그아웃했습니다" );
    		System.out.println("로그인된 총인원:" + loginCnt);
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
        
    }
	
}
