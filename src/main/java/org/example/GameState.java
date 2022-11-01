package org.example;

import java.util.Scanner;

public class GameState {
    int MatchesNumber;
    Scanner scanner = new Scanner(System.in);
    Player player2;
    Player player1;

        void startGame(){
            System.out.println("Start Game");
            MatchesNumber = 20;
            createPlayers();
            while (true){
                this.MatchesNumber = player1.play( MatchesNumber);
                if (MatchesNumber <= 1){
                    break;
                }
                this.MatchesNumber = player2.play( MatchesNumber);
                if (MatchesNumber <= 1) {
                    break;
                }
            }
        }

        void createPlayers(){
            System.out.println("who goes first?");
            if (order()){
                createPlayers();
            }
        }

        boolean order(){
            System.out.println("Write 1 if you are starting   Write 2 if computer");
            switch (scanner.nextInt()) {
                case 1 -> {
                    player1 = new Human(scanner);
                    player2 = new Computer();
                    return false;
                }
                case 2 -> {
                    player2 = new Human(scanner);
                    player1 = new Computer();
                    return false;
                }
                default -> {
                    System.out.println("invalid value");
                    return true;
                }
            }
        }

}
