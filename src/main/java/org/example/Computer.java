package org.example;

public class Computer implements Player{
    private final MatchCounter mCount;
    private boolean end = false;
    private int numberOfLaps = 0;
    private int number;
    private static final int START_NUMBER_TO_MIN = 17;

    Computer(MatchCounter mCount){
        this.mCount = mCount;
    }
    @Override
    public boolean play() {
        choseNumber();
        return end;
    }

    public void choseNumber(){
        int actualLogicOperator = (START_NUMBER_TO_MIN-(4 *numberOfLaps));
        if (mCount.get() > actualLogicOperator){
             number = mCount.get() - actualLogicOperator;
            makeTurn();
        } else {
             number = 1;
            makeTurn();
        }
    }

    @Override
    public void makeTurn() {
        mCount.set(mCount.get() - number);
        if (mCount.get() == 1 || mCount.get() == 0) {
            System.out.println(mCount.get() == 1 ? ("Computer has taken " + number + " matches" + "\n1 match left, you lose") : "Computer has taken last match, you win");
            end = true;
        }
        else {
            System.out.println("Computer has taken " + number + " matches");
            System.out.println(mCount.get() + " matches left");
            numberOfLaps += 1;
        }
    }


}
