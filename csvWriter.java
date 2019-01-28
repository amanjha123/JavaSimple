import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

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
      String Name= "";
      boolean stringValidator;
      int id;
      String email;
      Date date = new Date();
      List<String> City={"Delhi","chennai","Banglore", "Karnataka","Mumbai"};
      List<String> State={"Delhi","Tamil Naidu","Karnataka","Maharashtra"};
      String Country="India";


      Scanner sc = new Scanner(Sytem.in);
      name= sc.next();
        if(name.length>5 && name.length<12)
        {
            stringValidator = true;
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
   out.flush();
       
   //Close the Print Writer
   out.close();
       
   //Close the File Writer
   fw.close();       
  }
}