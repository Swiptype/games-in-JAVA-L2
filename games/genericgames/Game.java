package games.genericgames;

import games.players.*;
import java.util.ArrayList;

public interface Game{

  public Player getCurrentPlayer();

  public ArrayList<Integer> validMoves();

  public boolean isValid(int move);

  public void execute(int move);

  public boolean isOver();

  public Player getWinner();

  public String moveToString(int move);

  public String situationToString();

  public Game copy();

}
