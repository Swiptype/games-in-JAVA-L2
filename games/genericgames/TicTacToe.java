package games.genericgames;

import java.util.ArrayList;
import games.players.*;

public class TicTacToe extends AbstractGame implements Game{

  public Player[][] boardGame;

  public TicTacToe(Player player1, Player player2){
    super(player1,player2);
    this.boardGame = new Player[3][3];
  }

  @Override
  public void doExecute(int coup){
    int row = coup/3;
    int column = coup%3;
    if (super.current == super.player1) {
      this.boardGame[row][column] = super.current;
    }
    else if (super.current == super.player2){
      this.boardGame[row][column] = super.current;
    }
  }

  public boolean isValid(int coup){
    int row = coup/3;
    int column = coup%3;
    if(coup <= 8 && this.boardGame[row][column] == null){
      return true;
    }
    return false;
  }

  public ArrayList<Integer> validMoves(){
    ArrayList<Integer> listMoves = new ArrayList<Integer>();
    for(int i = 0; i <= 8; i++){
      if(this.isValid(i)){
        listMoves.add(i);
      }
    }
    return listMoves;
  }

  public boolean wins(Player player, int row, int column, int deltaRow, int deltaColumn){
    for(int i = 0; i <= 2; i++) {
      if(this.boardGame[row + deltaRow * i][column + deltaColumn * i] != player){
        return false;
      }
    }
    return true;
  }

  public Player getWinner(){
    ArrayList<Player> listPlayer = new ArrayList<Player>();
    listPlayer.add(super.player1);
    listPlayer.add(super.player2);

    for(Player player: listPlayer){
      if(this.wins(player,0,2,0,-1)){
        return player;
      }
      else if(this.wins(player,0,2,1,-1)){
        return player;
      }
      else if(this.wins(player,0,2,1,0)){
        return player;
      }
      else if(this.wins(player,0,1,1,0)){
        return player;
      }
      else if(this.wins(player,0,0,0,1)){
        return player;
      }
      else if(this.wins(player,0,0,1,1)){
        return player;
      }
      else if(this.wins(player,0,0,1,0)){
        return player;
      }
      else if(this.wins(player,1,0,0,1)){
        return player;
      }
      else if(this.wins(player,2,0,0,1)){
        return player;
      }
    }
    return null;
  }

  public boolean isOver(){
    if(this.getWinner() != null){
      return true;
    }
    boolean ok = true;
    for(int i = 0; i <= 2; i++){
      for(int j = 0; j <= 2; j++){
        ok = ok && (this.boardGame[i][j] != null);
      }
    }
    return ok;
  }

  public String moveToString(int coup){
    int row = coup/3 + 1;
    int column = coup%3 + 1;
    return "(" + String.valueOf(row) + "," + String.valueOf(column) + ")";
  }

  public String situationToString(){
    String row1 = "\n  1 2 3";
    String row2 = "1";
    String row3 = "2";
    String row4 = "3";

    for(Player val : this.boardGame[0]){
      if(val == null){
        row2 += " .";
      }
      else if (val == super.player1){
        row2 += " X";
      }
      else if (val == super.player2){
        row2 += " O";
      }
    }

    for(Player val : this.boardGame[1]){
      if(val == null){
        row3 += " .";
      }
      else if (val == super.player1){
        row3 += " X";
      }
      else if (val == super.player2){
        row3 += " O";
      }
    }

    for(Player val : this.boardGame[2]){
      if(val == null){
        row4 += " .";
      }
      else if (val == super.player1){
        row4 += " X";
      }
      else if (val == super.player2){
        row4 += " O";
      }
    }
    return row1 + "\n" + row2 + "\n" + row3 + "\n" + row4 + "\n";
  }

  public Game copy(){
    TicTacToe jeu = new TicTacToe(super.player1,super.player2);
    jeu.current = super.current;
    jeu.boardGame = new Player[3][3];
    for(int i=0; i<3 ; i++){
      for(int j=0; j<3 ; j++){
        jeu.boardGame[i][j] = this.boardGame[i][j];
      }
    }
    return jeu;
  }

}
