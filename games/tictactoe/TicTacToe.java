package games.tictactoe;

import java.util.ArrayList;

public class TicTacToe{

  private String player1;
  private String player2;
  public String[][] boardGame;
  private String current;

  public TicTacToe(String player1, String player2){
    this.player1 = player1;
    this.player2 = player2;
    this.boardGame = new String[3][3];
    this.current = this.player1;
  }

  public String getCurrentPlayer(){
    return this.current;
  }

  public void execute(int coup){
    int row = coup/3;
    int column = coup%3;
    if (this.current == this.player1) {
      this.boardGame[row][column] = this.current;
      this.current = this.player2;
    }
    else if (this.current == this.player2){
      this.boardGame[row][column] = this.current;
      this.current = this.player1;
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

  public boolean wins(String player, int row, int column, int deltaRow, int deltaColumn){
    for(int i = 0; i <= 2; i++) {
      if(this.boardGame[row + deltaRow * i][column + deltaColumn * i] != player){
        return false;
      }
    }
    return true;
  }

  public String getWinner(){
    ArrayList<String> listPlayer = new ArrayList<String>();
    listPlayer.add(this.player1);
    listPlayer.add(this.player2);

    for(String player: listPlayer){
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
    String row1 = "  1 2 3";
    String row2 = "1";
    String row3 = "2";
    String row4 = "3";
    for(String val : this.boardGame[0]){
      if(val == null){
        row2 += " .";
      }
      else if (val == this.player1){
        row2 += " X";
      }
      else if (val == this.player2){
        row2 += " O";
      }
    }

    for(String val : this.boardGame[1]){
      if(val == null){
        row3 += " .";
      }
      else if (val == this.player1){
        row3 += " X";
      }
      else if (val == this.player2){
        row3 += " O";
      }
    }

    for(String val : this.boardGame[2]){
      if(val == null){
        row4 += " .";
      }
      else if (val == this.player1){
        row4 += " X";
      }
      else if (val == this.player2){
        row4 += " O";
      }
    }
    return row1 + "\n" + row2 + "\n" + row3 + "\n" + row4 + "\n";
  }

}
