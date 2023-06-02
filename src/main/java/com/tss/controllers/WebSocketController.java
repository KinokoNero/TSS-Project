package com.tss.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {
    
    @RequestMapping("/websocket")
    public String showWebSocket(Model model) {        
        return "websocket.html";
    }
    
}
