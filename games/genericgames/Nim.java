package games.genericgames;

import games.players.*;
import java.util.ArrayList;

public class Nim extends AbstractGame implements Game{

  private int n;
  private int k;

  private int nbAllumette;


  public Nim(int n, int k, Player player1, Player player2){
    super(player1,player2);
    this.n = n;
    this.k = k;
    this.nbAllumette = n;
  }

  public int getInitialNbMatches(){
    return this.n;
  }

  public int getCurrentNbMatches(){
    return this.nbAllumette;
  }

  @Override
  public ArrayList<Integer> validMoves(){
    ArrayList<Integer> coupValid = new ArrayList<Integer>();

    int coupMax = this.k;
    if(this.nbAllumette < coupMax){
      coupMax = this.nbAllumette;
    }
    for(int i=1; i <= coupMax; i++){
      coupValid.add(i);
    }
    return coupValid;
  }

  @Override
  public String moveToString(int move){
    return move + "";
  }

  @Override
  public String situationToString(){
    return "\nIl reste " + this.nbAllumette + " allumette(s) !";
  }

  @Override
  public void doExecute(int take){
    if(this.k >= take){
      this.nbAllumette -= take;
    }
  }

  @Override
  public boolean isValid(int take) {
    if (take > 0 && take <= this.k && take <= this.nbAllumette) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isOver() {
    if (this.nbAllumette == 0){
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Player getWinner(){
    if(isOver()){
      if (this.current == this.player1){
        return this.player1;
      }
      else if (this.current == this.player2) {
        return this.player2;
      }
    }
    return null;
  }

  @Override
  public Game copy(){
    Nim newJeu = new Nim(this.n, this.k, this.player1, this.player2);
    newJeu.current = super.current;
    newJeu.nbAllumette = this.nbAllumette;
    return newJeu;
  }

}
