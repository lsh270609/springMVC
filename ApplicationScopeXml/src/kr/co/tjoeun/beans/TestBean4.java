package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import lombok.Data;

// byName
@Data
@Component(value="applicationBean4")
@ApplicationScope
public class TestBean4 {
	private String data7;
	private String data8;
}
