package games.genericgames;

import java.util.ArrayList;
import games.players.*;

public class TicTacToeWithHints extends TicTacToe {

  public TicTacToeWithHints(Player player1, Player player2){
    super(player1,player2);
  }

  public ArrayList<Integer> hints() {
    ArrayList<Integer> coupPossible = validMoves();
    Player joueurAdverse;
    ArrayList<Integer> menace = new ArrayList<Integer>();

    if(super.getCurrentPlayer() == super.player1){
      joueurAdverse = super.player2;
    } else {
      joueurAdverse = super.player1;
    }

    for(int coup : coupPossible){
      int row = coup/3;
      int column = coup%3;
      if(super.isValid(coup)){
        super.boardGame[row][column] = joueurAdverse;
        if(super.getWinner() == joueurAdverse){
          menace.add(coup);
        }
        super.boardGame[row][column] = null;
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

    for(Player val : super.boardGame[0]){
      if(this.hints().contains(coup)){
        row2 += " !";
      }
      else if(val == null){
        row2 += " .";
      }
      else if (val == super.player1){
        row2 += " X";
      }
      else if (val == super.player2){
        row2 += " O";
      }
      coup+=1;
    }

    for(Player val : super.boardGame[1]){
      if(this.hints().contains(coup)){
        row3 += " !";
      }
      else if(val == null){
        row3 += " .";
      }
      else if (val == super.player1){
        row3 += " X";
      }
      else if (val == super.player2){
        row3 += " O";
      }
      coup+=1;
    }

    for(Player val : super.boardGame[2]){
      if(this.hints().contains(coup)){
        row4 += " !";
      }
      else if(val == null){
        row4 += " .";
      }
      else if (val == super.player1){
        row4 += " X";
      }
      else if (val == super.player2){
        row4 += " O";
      }
      coup+=1;
    }
    return row1 + "\n" + row2 + "\n" + row3 + "\n" + row4 + "\n";
  }

}
