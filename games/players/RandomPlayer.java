package games.players;

import games.genericgames.*;
import java.util.Random;
import java.util.ArrayList;

public class RandomPlayer implements Player{

  public Random alea;

  public RandomPlayer(Random alea){
    this.alea = alea;
  }

  @Override
  public int chooseMove(Game jeu){
    ArrayList<Integer> listMoves = jeu.validMoves();
    int move = listMoves.get( this.alea.nextInt( listMoves.size() ) );
    System.out.println("Le coup du bot : " + move);
    return move;
  }

  @Override
  public String toString(){
    return "Joueur aléatoire n° " + this.hashCode();
  }

}
