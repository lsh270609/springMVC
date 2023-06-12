package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Data;

@Data
@Component
@RequestScope
public class TestBean3 {
	private String data5;
	private String data6;
}
