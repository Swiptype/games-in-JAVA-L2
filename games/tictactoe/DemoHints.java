package games.tictactoe;

public class DemoHints {

  public static void main(String[] args){

    TicTacToeWithHints DemoJeu = new TicTacToeWithHints("Jean","Pierre");
    System.out.println(DemoJeu.isValid(9));
    System.out.println(DemoJeu.validMoves());

    /*System.out.println(DemoJeu.getWinner());*/

    DemoJeu.execute(0); /*Jean*/
    DemoJeu.execute(3); /*Pierre*/

    DemoJeu.execute(4); /*Jean*/
    DemoJeu.execute(2); /*Pierre*/

    DemoJeu.execute(1); /*Jean*/
    DemoJeu.execute(5); /*Pierre*/

    System.out.println(DemoJeu.getCurrentPlayer());
    System.out.println(DemoJeu.hints());

    //System.out.println(DemoJeu.getWinner());
  }

}
