package com.kitri.chattest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class ChatController {

	@RequestMapping("/chat.kitri")
	public String chatStart() {
		return "chat";
	}
}
