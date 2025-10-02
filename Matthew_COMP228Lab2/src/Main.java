//Matthew Elliott - 301424215
//September 29, 2025
// Lab #2

import ex2.Lotto;
import ex3.Overloaded;

import static ex1.Test.inputAnswer;
import static ex2.Lotto.lottoGame;

public class Main {
    public static void main(String[] args) {
        // Exercise 1
        inputAnswer();

        // Exercise 2
        int[] lottoNums = new int[3];
        new Lotto(lottoNums);
        lottoGame(lottoNums);

        // Exercise 3
        Overloaded overloaded = new Overloaded();
        System.out.println("Adding two integers: " + overloaded.add(10, 20));
        System.out.println("Adding four integers: " + overloaded.add(10, 20, 30, 40));
        System.out.println("Adding four doubles: " + overloaded.add(10.9, 20.2,30.7,40.65));
    }
}