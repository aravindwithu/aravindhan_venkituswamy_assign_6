package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	private double myOtherDoubleT;

	// constructor
	public MyAllTypesSecond(){

	}

	// constructor with values to intialize
	public MyAllTypesSecond(double myDoubleTIn, float myFloatTIn, short myShortTIn, char myCharTIn, double myOtherDoubleTIn){
		myDoubleT = myDoubleTIn;
		myFloatT = myFloatTIn;
		myShortT = myShortTIn;
		myCharT = myCharTIn;
		myDoubleT = myDoubleTIn;
	}

	// getter setter methods
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

	@Override
	public boolean equals(Object obj){
		if(! (obj instanceof MyAllTypesSecond)){
			return false;
		}
		MyAllTypesSecond checkObj = (MyAllTypesSecond)obj;
		if(myDoubleT == checkObj.myDoubleT 
			&& myFloatT == checkObj.myFloatT 
			&& myShortT == checkObj.myShortT 
			&& myCharT == checkObj.myCharT 
			&& myOtherDoubleT == checkObj.myOtherDoubleT){
			return true;
		}else{
			return false;
		}
	}

	public int hashCode() {
        int result = 0;
        result = (int) (myDoubleT / 11);
        return result;
    }

	@Override
	public String toString(){
		String str = "MyAllTypesSecond:";
		str += " myDoubleT = " + myDoubleT;
		str += "; myFloatT = " + myFloatT;
		str += "; myShortT = " + myShortT;
		str += "; myCharT = " + myCharT; 
		str += "; myOtherDoubleT = " + myOtherDoubleT; 
		return str;
	}
}
