import java.util.Random;

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
public final class Player {



		private final int maximumDamage;
		private final int minimalDamage;
		private final int maxAtkPoints;
		private final String name; 
		private final String descript;
		private int atkPoints;
		private int numShots;


		private final Random random = new Random();

		private Player(String name, String descript, int maxAtkPoints, int minimalDamage, int maximumDamage,
				int numShots) {
			this.name = name;
			this.descript = descript;
			this.maxAtkPoints = maxAtkPoints;
			this.minimalDamage = minimalDamage;
			this.maximumDamage = maximumDamage;
			this.numShots = numShots;
			this.atkPoints = maxAtkPoints;
		}

		public int attack() {
			return random.nextInt(maximumDamage - minimalDamage + 1) + minimalDamage;
		}

		public void defend(Monster monster) {
			int attackPower = monster.attack();
			atkPoints = (atkPoints > attackPower) ? atkPoints - attackPower : 0;
			System.out.printf("  " + name + " is Delt for %d HP of damage (%s)\n", attackPower,
					getStatus());
			if (atkPoints == 0) {
				System.out.println("  " + name + " has been defeated");
			}
		}

		public void heal() {
			if (numShots > 0) {
				atkPoints = Math.min(maxAtkPoints, atkPoints + 20);
				System.out.printf("  %s Injects Steriods to prevent Zombification (%s, %d shots left)\n", name,
						getStatus(), --numShots);
			} else {
				System.out.println("  You've Finished your Shots Inventory!");
			}
		}

		public boolean isAlive() {
			return atkPoints > 0;
		}

		public String getStatus() {
			return "Player HP: " + atkPoints;
		}

		@Override
		public String toString() {
			return name;
		}

		public String getDescription() {
			return descript;
		}

		public static Player newInstance() {
			return new Player("Survivor",
					"You wake up in a hospital filled with Zombies, there is nothing but the bed you've slept on. try your best and leave the hospital alive! ", 40, 6, 20, 10);
		}
}