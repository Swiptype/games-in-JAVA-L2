package games.nim;

public class Demo {

  public static void main(String[] args){

    Nim demoJeu = new Nim(24,3,"Jean","Pierre");
    System.out.println(demoJeu.getInitialNbMatches());
    System.out.println(demoJeu.getCurrentPlayer());
    System.out.println(demoJeu.getCurrentNbMatches());
    System.out.println(demoJeu.situationToString());

    demoJeu.removeMatches(2);
    System.out.println(demoJeu.situationToString());


  }

}
