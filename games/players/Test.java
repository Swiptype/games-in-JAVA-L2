package games.players;

import gamestests.players.HumanTests;
import gamestests.players.RandomPlayerTests;

public class Test {

  public static void main(String[] args){

    boolean ok = true;

    HumanTests humanTester = new HumanTests();
    ok = ok && humanTester.testChooseMove(false);

    RandomPlayerTests randomTester = new RandomPlayerTests();
    ok = ok && randomTester.testChooseMove();

    System.out.println(ok ? "All tests passed" : "At least one test failed");


  }

}
