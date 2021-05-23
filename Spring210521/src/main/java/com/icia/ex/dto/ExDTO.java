package com.icia.ex.dto;


public class ExDTO {
//	dto필드는 반드시 input의 name과 똑같아야 한다.대소문자도 정확히 똑같아야 한다.
//	만약 변수이름을 다르게 할 경우에는 내가 집어넣은 값이 제대로 들어가지 않고 null로 값이 출력된다.
//	dto필드명, input name, DB컬럼명은 모두 동이해야 한다.
//	필드 선언 후 getter/setter, toString선언
	private String col1;
	private String col2;
	private String col3;
	
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	public String getCol2() {
		return col2;
	}
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	public String getCol3() {
		return col3;
	}
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	
	@Override
	public String toString() {
		return "ExDTO [col1=" + col1 + ", col2=" + col2 + ", col3=" + col3 + "]";
	}
	
	
}
