package games.nim;

import java.util.Scanner;

public class Scan{

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Saissez le nombre d'allumettes : ");
    int n = Integer.parseInt(scanner.next());

    System.out.println("Saissez le nombre maximum d'allumettes que l'on peut retirer : ");
    int k = Integer.parseInt(scanner.next());

    System.out.println("Saissez le nom du joueur n°1 : ");
    String player1 = scanner.next();

    System.out.println("Saissez le nom du joueur n°2 : ");
    String player2 = scanner.next();

    Nim jeu = new Nim(n,k,player1,player2);

    System.out.println("\n Nous allons commencer la partie !\n");
    while (false == jeu.isOver()){

      System.out.println(">>> A " + jeu.getCurrentPlayer() + " de jouer !" );

      System.out.println("Saissez le nombre d'allumette(" + jeu.getCurrentNbMatches() + "/" + jeu.getInitialNbMatches() + ") que vous voulez retirer(<="+ k +") : ");
      int take = Integer.parseInt(scanner.next());

      if (jeu.isValid(take)){
        System.out.println(jeu.getCurrentPlayer() + " a enlevé " + take + " allumette(s).\n" );
        jeu.removeMatches(take);
      }

    }

    System.out.println("Le grand vainqueur est " + jeu.getWinner());


    scanner.close();

  }

}
