package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import lombok.Data;

// byName
@Data
@Component
@ApplicationScope
public class TestBean3 {
	private String data5;
	private String data6;
}
