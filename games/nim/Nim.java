package games.nim;

public class Nim {

  private int n;
  private int k;
  private String player1;
  private String player2;
  private int nbAllumette;
  private String current;

  public Nim(int n, int k, String player1, String player2){
    this.n = n;
    this.k = k;
    this.player1 = player1;
    this.player2 = player2;
    this.nbAllumette = n;
    this.current = this.player1;
  }

  public int getInitialNbMatches(){
    return this.n;
  }

  public int getCurrentNbMatches(){
    return this.nbAllumette;
  }

  public String getCurrentPlayer(){
    return this.current;
  }

  public String situationToString(){
    return "Il reste " + this.nbAllumette + " allumette(s) !";
  }

  public void removeMatches(int take){
    /*Verifie si on n enleve pas trop*/
    if(this.k >= take){
      this.nbAllumette -= take;

      /*Change le joueur courrant après avoir joué*/
      if(this.current == this.player1){
        this.current = this.player2;
      } else {
        this.current = this.player1;
      }
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
