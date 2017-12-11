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

	public int getMyInt(){
		return myInt;
	}

	public void setMyInt(int value){
		myInt = value;
	}

	public long getMyLong(){
		return myLong;
	}

	public void setMyLong(long value){
		myLong = value;
	}

	public String getMyString(){
		return myString;
	}

	public void setMyString(String value){
		myString = value;
	}

	public boolean getMyBool(){
		return myBool;
	}

	public void setMyBool(boolean value){
		myBool = value;
	}

	public int getMyOtherInt(){
		return myOtherInt;
	}

	public void setMyOtherInt(int value){
		myOtherInt = value;
	}
}