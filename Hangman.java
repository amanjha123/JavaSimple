package complex;

import java.util.Arrays;
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
	
    
	
	public static void main(String args[])
	{
		  
		    Scanner sc = new Scanner(System.in);
		    int targetStringLength = sc.nextInt();
		  
	 Hangman obj = new Hangman();
		 String Generate = obj.StringGenerator(targetStringLength);
		   int length =Generate.length();
		   char[] str = Generate.toCharArray();
		    //Arrays.sort(str);
		  int count=0;
		  int duplicate=0;
		  int mintries=0;
		  char missed[] = new char[length];
		  for(int i=0;i<length;i++)
		  {
			  missed[i]='-';
		  }
		  System.out.println("word is:" + Generate);
	for(int i=0;i<Generate.length();i++)
			{
		 System.out.println("\n Enter the word");
			String   Guess = sc.next();
			  char c= Guess.charAt(0);
				   if(c!=str[i])
				   {
					   for(int k=0;k<length;k++)
						   System.out.print( missed[k] + " " );	 	  
					 mintries++; 
					 		if(mintries>=8)
					 			System.out.println("You lost");
					 		else
					 			System.out.println("One try decreased, tries left :" + (length-mintries) );
				   }
				   if(c==str[i])
				   {
					    Misses[i]=str[i];
					   			for(int k=0;k<length;k++)
					   					System.out.print( Misses[k] + "\t ");	 
					 count = count + 1;
					   mintries++;
					   for(int j = i+1;j<length; j++)
					   {
						   if(c==str[j])
						   {
							   duplicate++;
							   Misses[j]=str[j];
							   count = count + duplicate;   
							   
						   }
						  
					   }
					   System.out.println(" word MATCHING:" + count);
					   System.out.println(" word dUPLICATE:" + duplicate);   
				   }
				   
				   if(length==count)
				   {
					   System.out.println("You won");
					   System.out.println("word is:" + Generate);
					   break;
				   }
				  
				   if(mintries==8)
				   {
					   System.out.println("Person Hanged, you lost");
					   System.out.println("word is:" + Generate);
					   
				   }
				   
			}
		  
		 
		}
		
	}
	


