package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.Data;

@Data
@Component(value="testBeanByName2")
@SessionAttributes
public class TestBeanByName2 {
	private String data7;
	private String data8;
}
