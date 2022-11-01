package org.example;

import java.util.Scanner;

public class Human implements Player{

    Scanner scanner;
    int MatchesNumber;
    Human(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public int play(int MatchesNumber) {
        this.MatchesNumber = MatchesNumber;
        input();
        return this.MatchesNumber;
    }

    public void input(){
        System.out.println("write number of matches you want take ( 1 or 2 or 3 )");
        int number = scanner.nextInt();
        if (number >= 1 && number <= 3){
            if ((MatchesNumber - number >= 0)){
                winCheck(number);
            }
            else {
                System.out.println("invalid value");
                input();
            }
        }
        else {
            System.out.println("invalid value");
            input();
        }
    }

    @Override
    public void winCheck(int number) {
        MatchesNumber = MatchesNumber - number;
        switch (MatchesNumber) {
            case 1 -> {
                System.out.println("1 match left, you win");
            }
            case 0 -> {
                System.out.println("you've taken last match, you lose");
            }
            default -> {
                System.out.println("you've taken " + number + " matches");
                System.out.println(MatchesNumber + " matches left");
            }
        }
    }


}
