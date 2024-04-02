package games.factoredgames;

public abstract class AbstractGame{

  public String player1;
  public String player2;
  public String current;

  public AbstractGame(String player1, String player2){
    this.player1 = player1;
    this.player2 = player2;
    this.current = this.player1;
  }

  public String getCurrentPlayer(){
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
