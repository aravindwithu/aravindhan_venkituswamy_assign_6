package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{
	
	private int myInt;
	private long myLong;
	private String myString;
	private boolean myBool;
	private int myOtherInt;

	// constructor
	public MyAllTypesFirst(){
	};

	// constructor with intialization
	public MyAllTypesFirst(int myIntIn, long myLongIn, String myStringIn, boolean myBoolIn, int myOtherIntIn){
		myInt = myIntIn;
		myLong = myLongIn;
		myString = myStringIn;
		myBool = myBoolIn;
		myOtherInt = myOtherIntIn;
	}

	// Getter setter methods
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

	// equals override
	@Override
	public boolean equals(Object obj){
		if(! (obj instanceof MyAllTypesFirst)){
			return false;
		}
		MyAllTypesFirst checkObj = (MyAllTypesFirst)obj;
		if(myInt == checkObj.myInt 
			&& myLong == checkObj.myLong 
			&& myString.equals(checkObj.myString) 
			&& myBool == checkObj.myBool 
			&& myOtherInt == checkObj.myOtherInt){
			return true;
		}else{
			return false;
		}
	}

	// hashCode override
	public int hashCode() {
        int result = 0;
        result = (int) (myInt / 11);
        return result;
    }

    // toString override
	@Override
	public String toString(){
		String str = "MyAllTypesFirst:";
		str += " myInt = " + myInt;
		str += "; myLong = " + myLong;
		str += "; myString = " + myString;
		str += "; myBool = " + myBool;
		str += "; myOtherInt = " + myOtherInt; 
		return str;
	}
}