package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.Data;

@Data
@Component
@SessionAttributes
public class TestBeanByType2 {
	private String data5;
	private String data6;
}
