import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class ListofDigits
{
    public static void main(String[] args)
    {
        List<Integer>  Digit = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int length = String.valueOf(number).length();
        //System.out.println(length);
        while(length>=1)
        {
             int temp= number%10;
             Digit.add(temp);
            number = number/10;
            length--;
        }
        Collections.reverse(Digit);
        System.out.println(Digit);
        
    }




}