package com.sample.testing.powermock.staticmethod;

public class TestStaticMethodCall {
	private boolean isConnected = false;
	private String msg = null;
	public String getStaticMethodCall(String message) {
		if(!isConnected) {
			msg = Utility.staticMethod(message);
			System.out.println("inside the condition");
			setConnected(true);
		}
		
		return msg;
	}
	
	private void setConnected(boolean connectionStatus) {
		this.isConnected = connectionStatus;
	}
	
	public boolean isConnected() {
		return this.isConnected;
	}

}
