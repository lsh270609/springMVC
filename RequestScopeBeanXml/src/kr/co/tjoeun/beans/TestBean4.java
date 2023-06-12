package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Data;

@Data
@Component(value="testBean4")	// byName 방식
@RequestScope
public class TestBean4 {
	private String data7;
	private String data8;
}
