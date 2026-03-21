/**
 * ACS-2947 Assingment - 1
 * Daljeet Singh 3169763
 */

public class Assign1PartA_Driver {
    public static void main(String[] args) {

        Game newGame = new Game();              //creates the game instance

        //adds the players into the game
        newGame.addPlayer("Alvin");
        newGame.addPlayer("Simon");
        newGame.addPlayer("Theodore");
        newGame.addPlayer("David");

        //start the game
        newGame.play();
    }
}
