package games.factoredgames;

public class Nim extends AbstractGame{

  private int n;
  private int k;

  private int nbAllumette;


  public Nim(int n, int k, String player1, String player2){
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

  public String situationToString(){
    return "Il reste " + this.nbAllumette + " allumette(s) !";
  }

  @Override
  public void doExecute(int take){
    if(this.k >= take){
      this.nbAllumette -= take;
    }
  }

  public boolean isValid(int take) {
    if (take > 0 && take <= this.k && take <= this.nbAllumette) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isOver() {
    if (this.nbAllumette == 0){
      return true;
    } else {
      return false;
    }
  }

  public String getWinner(){
    if(isOver()){
      if (this.current == this.player1){
        return this.player1;
      }
      else if (this.current == this.player2) {
        return this.player2;
      }
    } else {
      return null;
    }
    return null;
  }


}
