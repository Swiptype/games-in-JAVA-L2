package games.genericgames;

import games.players.*;

public abstract class AbstractGame implements Game{

  public Player player1;
  public Player player2;
  public Player current;

  public AbstractGame(Player player1, Player player2){
    this.player1 = player1;
    this.player2 = player2;
    this.current = this.player1;
  }

  public Player getCurrentPlayer(){
    return this.current;
  }

  protected abstract void doExecute(int coup);

  public void execute(int coup){
    this.doExecute(coup);
    if(this.current == this.player1){
      this.current = this.player2;
    } else {
      this.current = this.player1;
    }
  }

}
