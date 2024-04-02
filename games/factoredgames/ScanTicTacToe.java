package games.tictactoe;

import java.util.Scanner;

public class Scan{

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Bonjour à tout le monde !");

    System.out.println("Saissez le nom du joueur n°1 : ");
    String player1 = scanner.next();

    System.out.println("Saissez le nom du joueur n°2 : ");
    String player2 = scanner.next();

    System.out.println("Commençons notre partie !");
    TicTacToe jeu = new TicTacToe(player1,player2);
    System.out.println(player1 + " est représenté(e) par X !");
    System.out.println(player2 + " est représenté(e) par O !");

    while (!jeu.isOver()){

      System.out.println(">>> A " + jeu.getCurrentPlayer() + " de jouer !");
      System.out.println(jeu.situationToString());
      for (int coupPossible : jeu.validMoves()){
        System.out.print(String.valueOf(coupPossible)+ " : " + jeu.moveToString(coupPossible) + " / ");
      }
      System.out.println("\nCoups possibles : " + jeu.validMoves());
      System.out.println("Votre coup :");
      int n = Integer.parseInt(scanner.next());
      if (jeu.isValid(n)){
        jeu.execute(n);
      }
      else {
        System.out.println("Votre coup n'est disponible ! Recommencez !");
      }
    }

    if (jeu.getWinner() == null){
      System.out.println("La partie s'est finie sur un match nul");
    }
    else {
      System.out.println("Le vainqueur est : " + jeu.getWinner());
    }


    scanner.close();

  }

}
