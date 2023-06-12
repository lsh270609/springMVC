package kr.co.tjoeun.model;

import javax.servlet.http.HttpServletRequest;

public class Test2Service {
	public int sum(HttpServletRequest request) {
		int res = 0;
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		res = i + j;
		return res;
	}
}
