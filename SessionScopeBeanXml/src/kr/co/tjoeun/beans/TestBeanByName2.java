package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@Component(value="testBeanByName2")
@SessionScope
public class TestBeanByName2 {
	private String data7;
	private String data8;
}
