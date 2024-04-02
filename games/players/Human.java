package games.players;

import games.genericgames.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Human implements Player{

  public String nom;
  public Scanner scan;

  public Human(String nom, Scanner scan){
    this.nom = nom;
    this.scan = scan;
  }

  @Override
  public int chooseMove(Game jeu){
    System.out.println("Coups possibles : " + jeu.validMoves());
    for (int move : jeu.validMoves()){
      System.out.print(jeu.moveToString(move) + " / ");
    }
    System.out.println("\nVotre coup :");
    int move = Integer.parseInt(this.scan.next());
    if (jeu.isValid(move)){
      return move;
    }
    System.out.println("Votre coup n'est disponible ! Recommencez !");
    return chooseMove(jeu);
  }

  @Override
  public String toString(){
    return this.nom;
  }



}
