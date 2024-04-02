package games.tictactoe;

public class Demo {

  public static void main(String[] args){

    TicTacToe DemoJeu = new TicTacToe("Jean","Pierre");
    System.out.println(DemoJeu.isValid(9));
    System.out.println(DemoJeu.validMoves());

    /*System.out.println(DemoJeu.getWinner());*/

    DemoJeu.execute(0); /*Jean*/
    DemoJeu.execute(3); /*Pierre*/

    DemoJeu.execute(4); /*Pierre*/
    DemoJeu.execute(2); /*Jean*/

    System.out.println(DemoJeu.getWinner());
  }

}
