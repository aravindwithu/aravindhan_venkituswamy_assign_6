package genericCheckpointing.driver;

public class Driver 
{
	public static void main(String[] args) 
	{
	    try{
	    }
	    catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.

	    }
	}
}