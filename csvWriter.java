import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.Random;
import java.io.EOFException;


public class csvWriter
 {
    public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
  
  public static void main(String[] args) throws IOException
  {
      String name= "";
      boolean stringValidator=false;
      int id;
      String email;
      //Date date = new Date();
      String[] City={"Delhi","chennai","Banglore", "Karnataka","Mumbai"};
      String[] State={"Delhi","Tamil Naidu","Karnataka","Maharashtra"};
      String Country="India";


      Scanner sc = new Scanner(System.in);
      String name1= sc.next();
        if((name1.length()>5) && (name1.length()<12))
        {
            stringValidator = true;
            name= name1;
            
        }
        else
        {
            System.out.println("wrong username");
        name=sc.next();
    }
      id= sc.nextInt();

        email = sc.next(); 
      if (isValid(email)) 
          System.out.print("Yes"); 
      else
          System.out.print("No"); 




   FileWriter fw = new FileWriter("WriteTest.csv");
   PrintWriter out = new PrintWriter(fw);
   // ',' divides the word into columns
   
   

   out.print("Name");// first row first column
   out.print(",");
   out.print("Id");// first row second column
   out.print(",");
   out.print("email");// first row third column
  
   out.print(",");
   out.print("City"); // second row first column.
   out.print(",");
   out.print("State");// second row second column
   out.print(",");
   out.println("Country");// second row third column
      
   //Flush the output to the file
   Random rand = new Random();


   
   while(true)
   {
        out.println();
        if(stringValidator)
        {
        out.print(name);
        }
        out.print(",");
        out.print(id);
        out.print(",");
        out.print(email);
        out.print(",");
        int  n = rand.nextInt(4) + 0;
        out.print(City[n]);
        out.print(",");
        out.print(State[n]);
        out.print(",");
        out.print(Country);
   }
   
   
   out.flush();
       
   //Close the Print Writer
   out.close();
       
   //Close the File Writer
   fw.close();       
  }
}