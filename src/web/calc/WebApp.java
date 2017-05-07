package web.calc;

import android.content.Context;

public class WebApp {
	WebCalcActivity webCalc;
	double first,second;
	String op;
	
	
	public WebApp(Context ctx) {
		webCalc=(WebCalcActivity)ctx;
		first=0;
		second=0;
		op="";
	}
	
	public void addNum(String val) {
		if(op=="") {
			first=Double.valueOf(val);
		}
		else {
			second=Double.valueOf(val);
		}
	}
	
	public void addOperator(String val) {
		op=val;
	}
	
	public String getResult() {
		if(op.equals("+")) {
			first=first+second;
			return String.valueOf(first);
		}
		if(op.equals("-")) {
			first=first-second;
			return String.valueOf(first);
		}
		if(op.equals("*")) {
			first=first*second;
			return String.valueOf(first);
		}
		if(op.equals("/")) {
			first=first/second;
			return String.valueOf(first);
		}
		second=0;
		op="";
		return "";
	}
}
