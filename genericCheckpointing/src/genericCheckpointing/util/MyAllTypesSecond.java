package genericCheckpointing.util;

import genericCheckpointing.util.MyLogger;

public class MyAllTypesSecond extends SerializableObject{
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	private MyLogger myLogger;
	private double myOtherDoubleT;

	public MyAllTypesSecond(double myDoubleTIn, float myFloatTIn, short myShortTIn, char myCharTIn, double myOtherDoubleTIn){
		myLogger.writeMessage("Inside MyAllTypesSecond constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		myDoubleT = myDoubleTIn;
		myFloatT = myFloatTIn;
		myShortT = myShortTIn;
		myCharT = myCharTIn;
		myDoubleT = myDoubleTIn;
	}

	public double getMyDoubleT(){
		return myDoubleT;
	}

	public void setMyDoubleT(double value){
		myDoubleT = value;
	}

	public float getMyFloatT(){
		return myFloatT;
	}

	public void setMyFloatT(float value){
		myFloatT = value;
	}

	public short getMyShortT(){
		return myShortT;
	}

	public void setMyShortT(short value){
		myShortT = value;
	}

	public char getMyCharT(){
		return myCharT;
	}

	public void setMyCharT(char value){
		myCharT = value;
	}

	public double getMyOtherDoubleT(){
		return myDoubleT;
	}

	public void setMyOtherDoubleT(double value){
		myDoubleT = value;
	}
}
