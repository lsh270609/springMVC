package kr.co.tjoeun.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/saveCookie")
	public String getSaveCookie(HttpServletResponse response) {

		try {
			//한글인 경우 저장할 문자열을 encoding 해줘야함
			String str1 = URLEncoder.encode("더조은", "UTF-8");
			String str2 = URLEncoder.encode("아카데미", "UTF-8");
			
			Cookie ck1 = new Cookie("data1", str1);
			Cookie ck2 = new Cookie("data2", str2);
			
			ck1.setMaxAge(60 * 60 * 24 * 365);
			ck2.setMaxAge(60 * 60 * 24 * 365);
			
			response.addCookie(ck1);
			response.addCookie(ck2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "saveCookie";
	}
	
	@GetMapping("/loadCookie")
	public String getLoadCookie(HttpServletRequest request) {
		Cookie[] ckArr = request.getCookies();
		for (Cookie c : ckArr) {
			try {
				String str1 = URLDecoder.decode(c.getValue(), "UTF-8");
				if(c.getName().equals("data1")) {
					System.out.println("data1 : "+str1);
				} else if (c.getName().equals("data2")) {
					System.out.println("data2 : "+str1);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return "loadCookie";
	}
	
	@GetMapping("/loadCookie2")
	public String getLoadCookie2(@CookieValue("data1") String cookie1,
								 @CookieValue("data2") String cookie2) {
		System.out.println("data1 : "+cookie1);
		System.out.println("data2 : "+cookie2);
		return "loadCookie2";
	}
}
