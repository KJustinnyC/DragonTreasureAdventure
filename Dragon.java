import java.util.Random;

// Title: Dragon Treasure Adventure Program
// Course: CS 300 Fall 2022
//
// Author: Justin Chiang
// Email: jkchiang@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class represents the dragon within the caves. It is responsible for keeping track of the
 * dragon's current location and picking a room to move to and then moving to it.
 */
public class Dragon {
  private Room currentRoom; // current location of the dragon
  private Random randGen; // random num generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";

  /**
   * Constructor for a dragon object. Assigns values to all non-static fields
   * 
   * @param currentRoom - the current location of the dragon
   */
  public Dragon(Room currentRoom) {
    this.currentRoom = currentRoom;
    randGen = new Random();
  }

  /**
   * Getter for this Dragon's currentRoom
   * 
   * @return this Dragon's current room
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }

  /**
   * Method that allows the Dragon to pick one of the rooms at random and move there if possible. If
   * not valid, then it will pick again.
   */
  public void changeRooms() {
    boolean moved = false;
    while (!moved) {
      int num = randGen.nextInt(currentRoom.getAdjacentRooms().size());
      if (currentRoom.getAdjacentRooms().get(num).getType() != RoomType.PORTAL) {
        this.currentRoom = currentRoom.getAdjacentRooms().get(num);
        moved = true;
      }
    }
  }

  /**
   * Returns the string that is the dragon class's warning, indicating that there is one nearby
   *
   * @return The dragon warning message string
   */
  public static String getDragonWarning() {
    return DRAGON_WARNING;
  }
}
