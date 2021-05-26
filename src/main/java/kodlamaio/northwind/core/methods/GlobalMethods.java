package kodlamaio.northwind.core.methods;

import java.util.Random;

public class GlobalMethods {
	public static String passwordGenerator(int passLength) {
		   int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(passLength);
		    for (int i = 0; i < passLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedString = buffer.toString();
		    return generatedString;
	}
}
