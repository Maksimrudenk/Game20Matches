package org.example;

import java.util.Scanner;

public class GameState {
    int matchesNumber;
    boolean whoseTurn = false;
    Scanner scanner = new Scanner(System.in);
    Player player2;
    Player player1;
    Player mainPlayer;
    MatchCounter mCount;

        void startGame(){
            System.out.println("Start Game");
            mCount = new MatchCounter();
            mCount.set(20);
            createPlayers();
            while(true){
                if (mainPlayer.play()){
                    break;
                }
                whoseTurn = !whoseTurn;
                mainPlayer = whoseTurn ? player1 : player2;
            }
        }

        void createPlayers(){
            player1 = new Human(scanner, mCount);
            player2 = new Computer(mCount);
            inputOrder();

        }

        void inputOrder(){
            System.out.println("who goes first?");
            System.out.println("Write 1 if you are starting   Write 2 if computer");
            whoseTurn = scanner.nextInt() == 1;
            order();
        };

        void order(){
            mainPlayer = whoseTurn ? player1 : player2;
        }

}
