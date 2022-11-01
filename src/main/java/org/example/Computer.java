package org.example;

public class Computer implements Player{

    int MatchesNumber;
    int n = 0;

    @Override
    public int play(int MatchesNumber) {
        this.MatchesNumber = MatchesNumber;
        choseNumber();
        return this.MatchesNumber;
    }

    public void choseNumber(){
        if (MatchesNumber > (17-(4 *n))){
            int number = MatchesNumber - (17-(4 *n));
            winCheck(number);
        } else {
            int number = 1;
            winCheck(number);
        }
    }

    @Override
    public void winCheck(int number) {
        MatchesNumber = MatchesNumber - number;
        switch (MatchesNumber) {
            case 1 -> {
                System.out.println("Computer has taken " + number + " matches");
                System.out.println("1 match left, you lose");
            }
            case 0 -> {
                System.out.println("Computer has taken last match, you win");
            }
            default -> {
                System.out.println("Computer has taken " + number + " matches");
                System.out.println(MatchesNumber + " matches left");
                n = n + 1;
            }
        }
    }
}
