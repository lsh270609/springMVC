package kr.co.tjoeun.beans;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TestBean1 {
	@AssertTrue
	private boolean data1;
	
	@AssertFalse
	private boolean data2;
	
	@Max(100)
	@Min(10)
	private String data3;
	
	@DecimalMax(value="100", inclusive=false)
	@DecimalMin(value="10", inclusive=false)
	private String data4;
	
	@Null
	private String data5;
	
	@NotNull
	private String data6;
	
	@Digits(integer = 3, fraction = 3)
	private String data7;
	
	@Size(min=2, max=10)
	private String data8;
	
	@Pattern(regexp = "[a-zA-z]*")
	private String data9;
	
	public TestBean1(){
		this.data1 = true;
		this.data2 = false;
		this.data3 = "30";
		this.data4 = "50";
		this.data5 = null;
		this.data6 = "check2";
		this.data7 = "123.345";
		this.data8 = "data8";
		this.data9 = "datadata";
	}
}
