package genericCheckpointing.util;

import genericCheckpointing.util.MyLogger;

public class MyAllTypesSecond extends SerializableObject{
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	private MyLogger myLogger;
	private double myOtherDoubleT;

	public MyAllTypesSecond(){

	}

	public MyAllTypesSecond(double myDoubleTIn, float myFloatTIn, short myShortTIn, char myCharTIn, double myOtherDoubleTIn){
		myLogger.writeMessage("Inside MyAllTypesSecond constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		myDoubleT = myDoubleTIn;
		myFloatT = myFloatTIn;
		myShortT = myShortTIn;
		myCharT = myCharTIn;
		myDoubleT = myDoubleTIn;
	}

	public double getmyDoubleT(){
		return myDoubleT;
	}

	public void setmyDoubleT(double value){
		myDoubleT = value;
	}

	public float getmyFloatT(){
		return myFloatT;
	}

	public void setmyFloatT(float value){
		myFloatT = value;
	}

	public short getmyShortT(){
		return myShortT;
	}

	public void setmyShortT(short value){
		myShortT = value;
	}

	public char getmyCharT(){
		return myCharT;
	}

	public void setmyCharT(char value){
		myCharT = value;
	}

	public double getmyOtherDoubleT(){
		return myDoubleT;
	}

	public void setmyOtherDoubleT(double value){
		myDoubleT = value;
	}
}
