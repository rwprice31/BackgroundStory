import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**Class: {file}
 * @author Abdisalam Abdulhakim
 * @version 1.0
 * Course : ITEC 3150 Spring 2013
 * Written: {date}
 *
 *
 * This class – now describe what the class does
 *
 * Purpose: – Describe the purpose of this class
 */
public final class Battle {

    public Battle(Player player, Monster monster) throws IOException {
        System.out.println("Oh No here comes! " + monster + ": " + monster.getDescription() + "\n");
        System.out.println("here it comes " + monster + " starts (" + player.getStatus() + " / "
                + monster.getStatus() + ")");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (player.isAlive() && monster.isAlive()) {
            System.out.print("Attack (atk) or heal (h)? ");
            String action = in.readLine();
            if (action.equals("h")) {
                player.heal();
            } 
            else {
                monster.defend(player);
            }
            if (monster.isAlive()) {
                player.defend(monster);
            }
        }
    }

}