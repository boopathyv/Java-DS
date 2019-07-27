package com.in28minutes.springboot.studentservices;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentServicesApplication {

//	@Autowired
//	StudentServiceImpl studentService;
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/cool")
    String cool() {
        return "Hello Cool!";
    }
	
	@RequestMapping("/callservice")
    String callService(HttpServletRequest req,HttpServletResponse res) {
//        return studentService.getData();
		return res.encodeUrl("Hai Baby");
//		try {
//			res.sendRedirect("http://localhost:8080/cool");
//		} catch (IOException e) {
//			e.printStackTrace();
//		};
    }
	
	public static void main(String[] args) {
		SpringApplication.run(StudentServicesApplication.class, args);
	}

}