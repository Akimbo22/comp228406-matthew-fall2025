//Matthew Elliott - 301424215
//September 30, 2025
// Lab #2
package ex2;

import javax.swing.*;
import java.security.SecureRandom;

public class Lotto {
    // Declaring the array:
    public int[] lottoNums = new int[3];

    // Creating the constructor to randomize the array values
    public Lotto(int[] lottoNums)
    {
        SecureRandom randomNumbers = new SecureRandom();
        // Randomizing the values in the array
        lottoNums[0] = randomNumbers.nextInt(9);
        lottoNums[1] = randomNumbers.nextInt(9);
        lottoNums[2] = randomNumbers.nextInt(9);
    }

    // Method to play with the user and return the array
    public static int[] lottoGame(int[] lottoNums)
    {
        // Setting the value of the sum, based on the array numbers
        int sum = 0;
        for (int number : lottoNums) {
            sum += number;
        }

        // Creating a loop with JOptionPane to take 5 inputs from the user
        int userNum = 3; // default is 3, as to not trigger the error immediately
        int counter = 0;
        while(counter < 5)
        {
            if(userNum > 2 && userNum < 28) {
                try {
                    userNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a number: ", "Number Input",
                            JOptionPane.QUESTION_MESSAGE));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number between 3 and 27.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (userNum == sum) {
                    JOptionPane.showMessageDialog(null, "Congratulations, you win!", "You Win!!", JOptionPane.PLAIN_MESSAGE);
                    break;
                }
                counter++;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number between 3 and 27.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(counter == 5)
        {
            JOptionPane.showMessageDialog(null, "Sorry, I win this time.", "Please Try Again...", JOptionPane.PLAIN_MESSAGE);
        }

        return lottoNums;
    }
}
