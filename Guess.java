/*  
 * @Author Vivek Singh
 * 		
 * Step1. Ask user for number
 * Step2. Generate a Random number between 1-100;
 * Step2. Create a method Guess which take count and Random value
 * Step4. compare the number with the random value 
 * Step5. repeat step 4 until perfect match is not found
 * Step6. Create a  object of class
 * Step7. call method Guess
 * Step8. Print the no of count by whenever step4 occur.
 * Step9: Whenever wrong guess is done wither prompt to the dialog box asking for the new number
 */
package complex;
//import swings
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


@SuppressWarnings("serial")
public class Guess extends JFrame {



public static Object prompt1;
private JTextField userInput;

private int randomNumber;
private int counter = 0;

		
public Guess() {
   super("Guessing Game using Swing");
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  // creating the design or layout how application should look 
   setLayout(new FlowLayout());
   Container c = getContentPane();

   // Create components
   JButton guessButton = new JButton("Guess");
   JButton newGameButton = new JButton("New Game");
   JButton quitButton = new JButton("Exit");
   JLabel prompt1 = new JLabel("Enter a number between 1 and 100.");
   JLabel prompt3 = new JLabel("Please enter your guess: ");
   
   userInput = new JTextField(5);

   // Adding components to the pane
   c.add(prompt1);
   c.add(prompt3);
   c.add(userInput);
   c.add(guessButton);
   c.add(newGameButton);
   c.add(quitButton);
   

   // Setting the size of application window with its height and width, visibiltiy, resizable
   setSize(500, 100);
   setLocationRelativeTo(null);
   setVisible(true);
   setResizable(true);

   Numbergenerator();


   GuessButtonHandler guess = new GuessButtonHandler(); 						//event handler object guess
   guessButton.addActionListener(guess); 

   NewButtonHandler newgame = new NewButtonHandler();							//event handler object newgame
   newGameButton.addActionListener(newgame);

   QuitButtonHandler Exit = new QuitButtonHandler();							//event handler object Exit
   quitButton.addActionListener(Exit);
} 


private void Numbergenerator() {
   randomNumber = new Random().nextInt(101) + 1;
}

// what to do on clicking button Guess
private class GuessButtonHandler implements ActionListener 
{
   public void actionPerformed(ActionEvent e) 
   {
       int getUserInput;
       // take the user input
       try {
           getUserInput = Integer.parseInt(userInput.getText().trim());
           counter++;
           // if guess is compared to the random number
           //if equal create a dialog box to Pass message you win
           if (getUserInput == randomNumber)
           {
               JOptionPane.showMessageDialog(null, "You Won! No is "
                       + counter + " guesses", "Random Number: "
                       + randomNumber, JOptionPane.INFORMATION_MESSAGE);
              return;
           }
           //message to enter lower number
           if (getUserInput > randomNumber)
           {
        	   JOptionPane.showMessageDialog(null, "Try a lower number ", "You tried: "+ getUserInput , JOptionPane.INFORMATION_MESSAGE);
               return;  
           } else 
           {
        	   // message to enter higher number
        	   JOptionPane.showMessageDialog(null, "Try a higher number ", "You tried  " +  getUserInput , JOptionPane.INFORMATION_MESSAGE);
                return;
    
           }
 
       } catch (NumberFormatException ex) {
           
       }
   }
} 
// method to call constructor to start another instance of Guess on clicking New Game
private class NewButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			@SuppressWarnings("unused")
			Guess application = new Guess();

		}
} 
//  Method to be called when the Exit button is clicked
	private class QuitButtonHandler implements ActionListener 
		{
		public void actionPerformed(ActionEvent e)
		{
       System.exit(0);
		}
		} 

		public static void main(String args[]) 
			{
			   // Guess object is created and it call itself as it is constructor
			   @SuppressWarnings("unused")
			Guess application = new Guess();
			
			}
}
