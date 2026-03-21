
/**
 *
 * Daljeet Singh 3169763
 * 25th October, 2024
 */

public class Driver{
    public static void main(String[] args){
        PlayerCharacter pc = new PlayerCharacter(2, 10, 0, 4, "John", "Link");
        NonPlayerCharacter npc =
        new NonPlayerCharacter (5, 40, 0, "Hard", "It’s a secret to everyone", "Moblin");
        System.out.println(pc);
        System.out.println(npc);
        }
}
