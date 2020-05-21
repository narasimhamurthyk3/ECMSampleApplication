/**
 * 
 */
package com.ecm.rest.controller;
/**
 * @author prate
 * This is a controller class for registering a student and to handle POST request
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecm.beans.*;

@Controller
public class StudentRegisterController {
	
	@RequestMapping(method = RequestMethod.POST, value="/register/student")
	@ResponseBody
	StudentRegistrationReply registerStudent(@RequestBody StudentRegistration studentregd) {
		
		StudentRegistrationReply stdregreply = new StudentRegistrationReply();
		stdregreply.setName(studentregd.getName());
		stdregreply.setAge(studentregd.getAge());
		stdregreply.setRegistrationNumber("12345678");
		stdregreply.setRegistrationStatus("Successful");
		return stdregreply;
		
	}

}
