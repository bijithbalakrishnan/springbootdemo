package com.howtodoinjava.demo.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.howtodoinjava.demo.model.Employee;

@RestController
public class EmployeeController {

	//private static final Logger log = Logger.getLogger(EmployeeController.class.getName());

	private static final Logger LOG = Logger.getLogger(EmployeeController.class.getName());
	
	@Autowired

	RestTemplate restTemplate;
	
	@Bean
	
	
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

	@RequestMapping("/")
	public List<Employee> getEmployees() {
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee(1, "lokesh", "gupta", "howtodoinjava@gmail.com"));
		return employeesList;
	}

	@RequestMapping("/elkdemo")

	public String helloWorld() {

		String response = "Hello" + new Date();

		LOG.info("/elkdemo - &gt; " + response);

		return response;

	}

	@RequestMapping("/exception")

	public String exception() {

		String rsp = "";

		try {
			int i = 1 / 0;
		} catch (Exception e) {

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString(); // stack trace as a string
			LOG.error("Exception As String :: - &gt; " + sStackTrace);

			rsp = sStackTrace;

		}

		return rsp;

	}
	
	@RequestMapping(value = "/elk")
    public String helloWorld1() {
		
		String response="";
		

 
        return response;
    }

}
