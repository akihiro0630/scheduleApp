package model;

public class CheckResult {
	private boolean flag;
	private String message;

	public CheckResult(boolean flag, String message){
		this.flag = flag;
		this.message = message;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
