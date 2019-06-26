package com.plzdaeng.util;

public class SiteConstance {
 public static final String ENCODE = "UTF-8";

// DB info
 public static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
 public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
 public static final String DB_USERNAME = "plz";
 public static final String DB_PASSWORD = "plz";
 
 //Image Path 
 public static final String IMG_PATH = "C:\\fileupload";
 
 //chatServer URL
 //작동 안할땐 port 번호 확인할것
 //public static final String CHAT_SERVER_URL = "ws://192.168.14.53:80/plzdaengs/chatserver";
 public static final String CHAT_SERVER_URL = "ws://localhost:8080/chattest/chatserver";
}
