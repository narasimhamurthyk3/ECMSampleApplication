/**
 * 
 */
package com.ecm.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecm.beans.Welcome;

@Controller
public class WelcomeController {

	private static final String welcomemsg = "Welcome Mr. %s!";
	
	private static final String applicationName = "Welcome to %s!";

    @GetMapping("/welcome/user")
    @ResponseBody
    public Welcome welcomeUser(@RequestParam(name="name", required=false, defaultValue="Java Fan") String name) {
        return new Welcome(String.format(welcomemsg, name));
    }
    
    @GetMapping("/welcome")
    @ResponseBody
    public Welcome welcomeApp(@RequestParam(name="name", required=false, defaultValue="Application V1") String name) {
        return new Welcome(String.format(applicationName, name));
    }

}
