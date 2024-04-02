package games.tictactoe;

import java.util.ArrayList;

public class TicTacToeWithHints extends TicTacToe {

  private String player1;
  private String player2;
  //private String[][] boardGame;
  //private String current;

  public TicTacToeWithHints(String player1, String player2){
    super(player1,player2);
    this.player1 = player1;
    this.player2 = player2;
  }

  public ArrayList<Integer> hints() {
    ArrayList<Integer> coupPossible = validMoves();
    String joueurAdverse;
    ArrayList<Integer> menace = new ArrayList<Integer>();

    if(this.getCurrentPlayer() == this.player1){
      joueurAdverse = this.player2;
    } else {
      joueurAdverse = this.player1;
    }

    for(int coup : coupPossible){
      int row = coup/3;
      int column = coup%3;
      if(this.isValid(coup)){
        this.boardGame[row][column] = joueurAdverse;
        if(this.getWinner() == joueurAdverse){
          menace.add(coup);
        }
        this.boardGame[row][column] = null;
      }
    }

    return menace;
  }

  @Override
  public String situationToString(){
    String row1 = "  1 2 3";
    String row2 = "1";
    String row3 = "2";
    String row4 = "3";

    int coup = 0;

    for(String val : this.boardGame[0]){
      if(this.hints().contains(coup)){
        row2 += " !";
      }
      else if(val == null){
        row2 += " .";
      }
      else if (val == this.player1){
        row2 += " X";
      }
      else if (val == this.player2){
        row2 += " O";
      }
      coup+=1;
    }

    for(String val : this.boardGame[1]){
      if(this.hints().contains(coup)){
        row3 += " !";
      }
      else if(val == null){
        row3 += " .";
      }
      else if (val == this.player1){
        row3 += " X";
      }
      else if (val == this.player2){
        row3 += " O";
      }
      coup+=1;
    }

    for(String val : this.boardGame[2]){
      if(this.hints().contains(coup)){
        row4 += " !";
      }
      else if(val == null){
        row4 += " .";
      }
      else if (val == this.player1){
        row4 += " X";
      }
      else if (val == this.player2){
        row4 += " O";
      }
      coup+=1;
    }
    return row1 + "\n" + row2 + "\n" + row3 + "\n" + row4 + "\n";
  }

}
