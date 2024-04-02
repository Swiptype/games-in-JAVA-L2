package games.plays;

import gamestests.plays.OrchestratorTests;

public class Test {

  public static void main(String[] args){

    boolean ok = true;

    OrchestratorTests tester = new OrchestratorTests();
    ok = ok && tester.testPlay(false);

    System.out.println(ok ? "All tests passed" : "At least one test failed");


  }

}
