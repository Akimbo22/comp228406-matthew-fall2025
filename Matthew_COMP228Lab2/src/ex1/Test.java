//Matthew Elliott - 301424215
//September 29, 2025
// Lab #2
package ex1;

import javax.swing.*;
import java.security.SecureRandom;

public class Test {
    //Setting up variables to calculate correct answers (correct answers will increase the number by one)
    public static int numCorrect = 0;

    //To begin, I will set up the method to simulate the questions:
    public static int simulateQuestion(int i)
    {
        int answer = 0; // int that will be returned. If it equals 2, the answer was wrong. If it is 1, the answer is true.

        // The instructions ask for a loop to display the questions, however it also asks us to use
        // JOptionPane to ask the questions. I cannot for the life of me find a way to take my
        // questions and subsequent if statements for each question and put it all into an array
        // to then be called in a loop. Therefore, I decided to use a switch case instead, as it
        // really seems a lot more straightforward for this task, then make a loop in the
        // inputAnswer method instead.


        //Creating the switch and questions:
        switch (i) {
            // Depending on the value of i, a different question will be asked
            case 0:
                String[] q1Options = {"//", "||", "#", "<!--"};
                var question1 = JOptionPane.showOptionDialog(null, "How do you comment out a line in Java?", null,
                        0, 3, null, q1Options, null);
                // When the answers are submitted, the value of answer is returned to then be verified in the checkAnswer method
                if (question1 == 0) {
                  answer = 1;
                }
                else
                {
                    answer = 2;
                }
                return answer;
            case 1:
                String[] q2Options = {"5.7", "5.5", "5", "6"};
                var question2 = JOptionPane.showOptionDialog(null, "What is the result of floor(5.6)?", null,
                        0, 3, null, q2Options, null);
                if (question2 == 2) {
                    answer = 1;
                }
                else
                {
                    answer = 2;
                }
                return answer;
            case 2:
                String[] q3Options = {"float", "long", "boolean", "None"};
                var question3 = JOptionPane.showOptionDialog(null, "What can a double be promoted to?", null,
                        0, 3, null, q3Options, null);
                if (question3 == 3) {
                    answer = 1;
                }
                else
                {
                    answer = 2;
                }
                return answer;
            case 3:
                String[] q4Options = {"void", "none", "empty", "nothing"};
                var question4 = JOptionPane.showOptionDialog(null, "Which answer represents a return type that returns nothing?", null,
                        0, 3, null, q4Options, null);
                if (question4 == 0) {
                    answer = 1;
                }
                else
                {
                    answer = 2;
                }
                return answer;
            case 4:
                String[] q5Options = {"gethub", "github", "githud", "getgrub"};
                var question5 = JOptionPane.showOptionDialog(null, "What site/program was demonstrated for uploading assignments?", null,
                        0, 3, null, q5Options, null);
                if (question5 == 1) {
                    answer = 1;
                }
                else
                {
                    answer = 2;
                }
                return answer;

        }
        return answer;
    }

    public static void checkAnswer(int answer)
    {
        // Simple if check to see if the answer was correct. If it is, numCorrect increases by 1
        if (answer == 1)
        {
            numCorrect++;
        }
    }

    public static void generateMessage(int answer)
    {
        // This method contains the arrays of messages and chooses one to send depending on if the answer was right or wrong
        String[] correct = {"Great job!", "Correct!", "Fantastic!", "You got it!"};
        String[] incorrect = {"Ah shucks.", "Better luck next time", "Try again, I know you can get it!", "So close!"};
        // Creating the random number:
        SecureRandom randomNumbers = new SecureRandom();
        int randNum = randomNumbers.nextInt(4);

        // If statement to decide if the user needs a correct or incorrect message:
        if (answer == 1)
        {
            System.out.println(correct[randNum]);
        }
        else
        {
            System.out.println(incorrect[randNum]);
        }
    }

    // Finally, the inputAnswer method will loop these methods and give the results
    public static void inputAnswer()
    {
        for (int i=0;i<5;i++)
        {
            int answer = simulateQuestion(i);
            checkAnswer(answer);
            generateMessage(answer);
        }
        double finalPercent = (double) numCorrect / 5 * 100;
        System.out.println("You got " + numCorrect + " answers right. That's " + finalPercent + "%!");
    }
}
