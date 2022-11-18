package org.example;

import java.util.Scanner;

public class Human implements Player{
    private final MatchCounter mCount;
    private boolean end = false;
    private final Scanner scanner;
    private int number;
    Human(Scanner scanner, MatchCounter mCount){
        this.scanner = scanner;
        this.mCount = mCount;
    }
    @Override
    public boolean play() {
        input();
        return end;
    }

    public void input(){
        System.out.println("write number of matches you want take ( 1 or 2 or 3 )");
        number = scanner.nextInt();
        if (isValid()){
            makeTurn();
        }
        else {
            System.out.println("invalid value");
            input();
        }
    }

    public boolean isValid(){
        return (number >= 1 && number <= 3 && (mCount.get() - number >= 0));
    }

    @Override
    public void makeTurn() {
        mCount.set(mCount.get() - number);
        if (mCount.get() == 1 || mCount.get() == 0) {
            System.out.println(mCount.get() == 1 ? "1 match left, you win" : "you've taken last match, you lose");
            end = true;
        }
        else {
            System.out.println("you've taken " + number + " matches");
            System.out.println(mCount.get() + " matches left");
        }
    }


}
