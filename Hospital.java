import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
public final class Hospital {

    private final Map<Integer, Map<Integer, Room>> map = new HashMap<Integer, Map<Integer, Room>>();
    private Room currentRoom;
    private int currentX = 0;
    private int currentY = 0;

    private Hospital() {
    }

    private void putRoom(int x, int y, Room room) {
        if (!map.containsKey(x)) {
            map.put(x, new HashMap<Integer, Room>());
        }
        map.get(x).put(y, room);
    }

    private Room getRoom(int x, int y) {
        return map.get(x).get(y);
    }

    private boolean roomExists(int x, int y) {
        if (!map.containsKey(x)) {
            return false;
        }
        return map.get(x).containsKey(y);
    }

    private boolean isComplete() {
        return currentRoom.isBossRoom() && currentRoom.isComplete();
    }

    public void movePlayer(Player player) throws IOException {
        boolean northPossible = roomExists(currentX, currentY + 1);
        boolean southPossible = roomExists(currentX, currentY - 1);
        boolean eastPossible = roomExists(currentX + 1, currentY);
        boolean westPossible = roomExists(currentX - 1, currentY);
        System.out.print("Where would you like to go in the Hospital :");
        if (northPossible) {
            System.out.print(" ");//north
        }
        if (eastPossible) {
            System.out.print(" East (e)");
        }
        if (southPossible) {
            System.out.print(" South (s)");
        }
        if (westPossible) {
            System.out.print(" West (w)");
        }
        System.out.print(" ? ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String direction = in.readLine();
        if (direction.equals("north") && northPossible) {
            currentY++;
        } else if (direction.equals("south") && southPossible) {
            currentY--;
        } else if (direction.equals("east") && eastPossible) {
            currentX++;
        } else if (direction.equals("west") && westPossible) {
            currentX--;
        }
        currentRoom = getRoom(currentX, currentY);
        currentRoom.enter(player);
    }

    public void startQuest(Player player) throws IOException {
        while (player.isAlive() && !isComplete()) {
            movePlayer(player);
        }
        if (player.isAlive()) {
            System.out.println(Info.CROWN);
        } else {
            System.out.println(Info.REAPER);
        }
    }

    public static Hospital newInstance() {
        Hospital hospital = new Hospital();
        hospital.putRoom(0, 0, Room.newRegularInstance());
        hospital.putRoom(-1, 1, Room.newRegularInstance());
        hospital.putRoom(0, 1, Room.newRegularInstance());
        hospital.putRoom(1, 1, Room.newRegularInstance());
        hospital.putRoom(-1, 2, Room.newRegularInstance());
        hospital.putRoom(1, 2, Room.newRegularInstance());
        hospital.putRoom(-1, 3, Room.newRegularInstance());
        hospital.putRoom(0, 3, Room.newRegularInstance());
        hospital.putRoom(1, 3, Room.newRegularInstance());
        hospital.putRoom(0, 4, Room.newRegularInstance());
        hospital.putRoom(1,5, Room.newRegularInstance());
        hospital.putRoom(0, 5, Room.newRegularInstance());
        hospital.putRoom(1, 6, Room.newRegularInstance());
        hospital.putRoom(0, 6, Room.newRegularInstance());
        hospital.putRoom(1, 7, Room.newRegularInstance());
        hospital.putRoom(-1, 6, Room.newRegularInstance());
        hospital.putRoom(-1, 7, Room.newRegularInstance());
        hospital.putRoom(0, 7, Room.newBossInstance());
        hospital.currentRoom = hospital.getRoom(0, 0);
        return hospital;
    }

}