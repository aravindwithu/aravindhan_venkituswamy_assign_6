package genericCheckpointing.util;

import genericCheckpointing.util.MyLogger;

public class MyAllTypesFirst extends SerializableObject{
	
	private int myInt;
	private long myLong;
	private String myString;
	private boolean myBool;
	private int myOtherInt;
	private MyLogger myLogger;

	public MyAllTypesFirst(){
		myLogger.writeMessage("Inside MyAllTypesFirst constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	};

	public MyAllTypesFirst(int myIntIn, long myLongIn, String myStringIn, boolean myBoolIn, int myOtherIntIn){
		myLogger.writeMessage("Inside MyAllTypesFirst constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		myInt = myIntIn;
		myLong = myLongIn;
		myString = myStringIn;
		myBool = myBoolIn;
		myOtherInt = myOtherIntIn;
	}

	public int getmyInt(){
		return myInt;
	}

	public void setmyInt(int value){
		myInt = value;
	}

	public long getmyLong(){
		return myLong;
	}

	public void setmyLong(long value){
		myLong = value;
	}

	public String getmyString(){
		return myString;
	}

	public void setmyString(String value){
		myString = value;
	}

	public boolean getmyBool(){
		return myBool;
	}

	public void setmyBool(boolean value){
		myBool = value;
	}

	public int getmyOtherInt(){
		return myOtherInt;
	}

	public void setmyOtherInt(int value){
		myOtherInt = value;
	}
}