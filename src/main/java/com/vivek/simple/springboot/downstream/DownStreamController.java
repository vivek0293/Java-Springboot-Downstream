package com.vivek.simple.springboot.downstream;

import java.io.*;
import java.net.*;
 
import jakarta.servlet.http.HttpServletRequest;
 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DownStreamController {
	// Static Variables
    public static String unresolvedHttpUrl = "http://example.com/index.html";
    
    private static final Logger logger = LoggerFactory.getLogger(DownStreamController.class);
         
    @RequestMapping("/downstream/hello")
    @ResponseBody
    public String index(HttpServletRequest request) throws Exception {
        System.out.println("Protocol: " +request.getScheme());
        System.out.println("Host: " +request.getServerName());
        System.out.println("Port: " +request.getServerPort());
        System.out.println("URI: " +request.getRequestURI());
        logger.error("Throwing an error");
        // Make a HTTP call to www.example.com
        callHTTP();
        // Call a Custom Function
        greet();
        return "Greetings from DownStream!!!";
    }
         
    public static void callHTTP() throws Exception {
        URL url = new URL(unresolvedHttpUrl);
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        System.out.println("=====Response from simple-http.com=====");
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
         
    public void greet() throws InterruptedException {
        System.out.println("=====Sleeping for 2 secs in greet()=====");
        Thread.sleep(2000);
        System.out.println("=====Hello from greet() function=====");
    }
}
