package complex;


import java.util.Random;
import java.util.Scanner;

public class Hangman {
	
	public String StringGenerator(int targetStringLength)
	{
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
		Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    
		return generatedString.toUpperCase();
	}
	
    public void SecretWord(String word, int length) {
        int NoOfTries = 0;
        Scanner keyboard = new Scanner(System.in);
       // int length = word.length();
        char output[] = new char[length];
        int Guessed = 0;

        for (int i = 0; i < length; i++) {
            output[i] = '-';
        }
        System.out.println("Please, the hidden words is in Uppercase so use UpperCase ");
        while (Guessed < length) {
            	
        	for (int i = 0; i < length; i++)
                System.out.print(output[i] + "\t ");
            
            char input = keyboard.next().charAt(0);

            boolean matched = false;
            for (int i = 0; i < length; i++) {
            		
                
                if ((input == word.charAt(i)) && (output[i] == '-')) {
                    output[i] = word.charAt(i);
                    Guessed++;
                    matched = true;
                } 
            }
            
            if (!matched)
                NoOfTries++;
            
        }
        if(NoOfTries>length)
        {
     	   System.out.println("You lost");
        		System.out.println("tries are: " + NoOfTries);
        }	
        
        keyboard.close();
        System.out.println(" Word is \"" + word + "\"");
        System.out.println(" No of tries is \"" + NoOfTries + "\"");
      
    }
	
		public static void main(String args[])
		{
		  
		   Scanner sc =new Scanner(System.in);
			System.out.println("Enter the Size of the String");
				   int targetStringLength = sc.nextInt();
				   Hangman Hang = new Hangman();
				   String letter =Hang.StringGenerator(targetStringLength);
				   System.out.println(letter);
				    Hang.SecretWord(letter, targetStringLength);
				 
				 sc.close();  
				  
		   
		 
		}
		
	}
	


