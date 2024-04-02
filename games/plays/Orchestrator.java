package games.plays;

import games.genericgames.*;
import games.players.*;

public class Orchestrator{

  public Game jeu;

  public Orchestrator(Game jeu){
    this.jeu = jeu;
  }

  public void play(){
    while(!this.jeu.isOver()){
      System.out.print("\n>>> A " + this.jeu.getCurrentPlayer() + " de jouer !");
      System.out.println(this.jeu.situationToString());
      this.jeu.execute(this.jeu.getCurrentPlayer().chooseMove(this.jeu));
    }
    System.out.println(this.jeu.situationToString());
    if (jeu.getWinner() == null){
      System.out.println("La partie s'est finie sur un match nul");
    } else {
      System.out.println("Le vainqueur est : " + this.jeu.getWinner());
    }
  }

}
