import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
public final class Room {

    private final String description;
    private final Monster monster;
    private final Boolean bossRoom;
    private final static Random random = new Random();
    private final static Set<Integer> roomsSeen = new HashSet<Integer>();
    private final static int NUM_ROOMS = 40;

    private Room(String description, Monster monster, Boolean isBossRoom) {
        this.description = description;
        this.monster = monster;
        this.bossRoom = isBossRoom;
    }

    public static Room newRegularInstance() {
        if (roomsSeen.size() == NUM_ROOMS) {
            roomsSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_ROOMS);
        } while (roomsSeen.contains(i));
        roomsSeen.add(i);

        String roomDescription = null;
        if (i == 0) {
            roomDescription = "the  waiting room, the light flickers while smelling the stench of the decay";
        } else if (i == 1) {
            roomDescription = "the kitchen seems pretty good except the fact that there is zombies everywhere!";
        } else if (i == 2) {
            roomDescription = "you entered the bathroom only thing working is the faucet";
        } else if (i == 3) {
            roomDescription = "be careful its pretty dark in here";
        } else if (i == 4) {
            roomDescription =
                    "this room doesnt to be that bad";
        } else if (i == 5) {
            roomDescription =
                    "the E.R is filled with plenty of items try looking around!";
        } else if (i == 6) {
            roomDescription =
                    "Room#6";
        } else if (i == 7) {
            roomDescription =
                    "Room#7";
        } else if (i == 8) {
            roomDescription =
                    "Room#8";
        } else if (i == 9) {
            roomDescription =
                    "Room#9";
        } else if (i == 10) {
            roomDescription =
                    "Room#10";
        } else if (i == 11) {
            roomDescription =
                    "Room#11";
        } else if (i == 12) {
            roomDescription =
                    "Room#12";
        } else if (i == 13) {
            roomDescription =
                    "Room#13";
        } else if (i == 14) {
            roomDescription =
                    "Room#14";
        } else if (i == 15) {
            roomDescription =
                    "Room#15";
        } else if (i == 16) {
            roomDescription =
                    "Room#16";
        } else if (i == 17) {
            roomDescription =
                    "Room#17";
        } else if (i == 18) {
            roomDescription = "the lobby";
        } else {
        }
        return new Room(roomDescription, Monster.newRandomInstance(), false);
    }

    public static Room newBossInstance() {
        return new Room("you've entered the basement and there seems to be only one exit out of the hospital", Monster.newBossInstance(),
                true);
    }

    public boolean isBossRoom() {
        return bossRoom;
    }

    public boolean isComplete() {
        return !monster.isAlive();
    }

    @Override
    public String toString() {
        return description;
    }

    public void enter(Player player) throws IOException {
        System.out.println("You are in " + description);
        if (monster.isAlive()) {
            new Battle(player, monster);
        }
    }

}