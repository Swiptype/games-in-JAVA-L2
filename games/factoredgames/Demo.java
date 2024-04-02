package games.factoredgames;

public class Demo {

  public static void main(String[] args){

    Nim demoJeu = new Nim(24,3,"Jean","Pierre");
    System.out.println(demoJeu.getInitialNbMatches());
    System.out.println(demoJeu.getCurrentPlayer());
    System.out.println(demoJeu.getCurrentNbMatches());
    System.out.println(demoJeu.situationToString());

    demoJeu.execute(2);
    System.out.println(demoJeu.situationToString());

    
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
