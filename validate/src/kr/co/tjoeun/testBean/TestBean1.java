package kr.co.tjoeun.testBean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TestBean1 {
	
	@Size(min=2, max=10)
	private String data1;
	
	@Max(value = 100)
	private int data2;
	
	
}

