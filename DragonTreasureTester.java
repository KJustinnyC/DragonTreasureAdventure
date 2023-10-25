import java.util.ArrayList;

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
 * This class is used to test the functionality of other methods within different classes. Basic
 * function is to act as a tester
 */
public class DragonTreasureTester {


  // TESTERS FOR THE ROOM CLASS

  /**
   * Tester for checking the correctness of ALL instance (non-static) methods including the
   * contructor for the Room class
   */
  public static boolean testRoomInstanceMethods() {

    try {
      Room one = new Room(1, "Start");
      Room two = new Room(2, "Portal");
      Room three = new Room(3, "Treasure");
      one.setRoomType(RoomType.START);

      // Tests if room type is set and if the getter for roomType functions
      if (one.getType() != RoomType.START) {
        System.out.println("STOP: Problem with roomType");
        return false;
      }

      // Tests if the getter method for ID functions
      if (one.getID() != 1) {
        System.out.println("STOP: Problem with ID");
        return false;
      }

      // Tests if the add to adjacent rooms method works and the getter functions
      one.addToAdjacentRooms(two);
      one.addToAdjacentRooms(three);
      ArrayList<Room> adj = new ArrayList();
      adj.add(two);
      adj.add(three);
      if (!one.getAdjacentRooms().equals(adj)) {
        System.out.println("STOP: Problem with adjecent rooms");
      }

      // Test to see if the getter for Room Description functions
      if (!one.getRoomDescription().equals("Start")) {
        System.out.println("STOP: Problem with description getter");
        return false;
      }

      // Test to check the isAdjacent Method is functioning
      if (!one.isAdjacent(two)) {
        return false;
      }
    } catch (Exception e) {
      // an unexpected exception was thrown
      e.printStackTrace(); // this will help locate the source of the bug
      return false;
    }
    return true;
  }

  /**
   * Tester to check the correctness of ALL static methods for the Room class
   */
  public static boolean testRoomStaticMethods() {

    try {
      if (!Room.getPortalWarning().equals("You feel a distortion in space nearby.\n")) {
        System.out.println("STOP: Problem with Portal Warning method");
        return false;
      }
      if (!Room.getTreasureWarning().equals("You sense that there is treasure nearby.\n")) {
        System.out.println("STOP: Problem with Treasure Warning method");
        return false;
      }
      Room.assignTeleportLocation(0);
      if (Room.getTeleportationRoom() != 0) {
        System.out.println("STOP: Problem with teleportation Room");
        return false;
      }
    } catch (Exception e) {
      // an unexpected exception was thrown
      e.printStackTrace(); // this will help locate the source of the bug
      return false;
    }
    return true;
  }


  // TESTERS FOR PLAYER CLASS

  /**
   * Tester for checking the correctness of the canMoveTo() method
   */
  public static boolean testPlayerCanMoveTo() {
    Room first = new Room(1, "Start");
    Room second = new Room(2, "Portal");
    Room third = new Room(3, "Treasure");
    Room fourth = new Room(4, "Normal");
    first.addToAdjacentRooms(second);
    first.addToAdjacentRooms(third);
    ArrayList<Room> adj = new ArrayList();
    adj.add(second);
    adj.add(third);
    Player one = new Player(first);

    if (!one.canMoveTo(third)) {
      System.out.println("STOP: Problem with canMoveTo method");
      return false;
    } else if (one.canMoveTo(fourth)) {
      System.out.println("STOP: Problem with canMoveTo method");
      return false;
    }

    return true;
  }

  /**
   * Tester for checking the correctness of the shouldTeleport() method
   */
  public static boolean testPlayerShouldTeleport() {
    Room first = new Room(1, "Start");
    Room second = new Room(2, "Portal");
    Room third = new Room(3, "Normal");
    Room fourth = new Room(4, "Treasure");
    first.addToAdjacentRooms(second);
    first.addToAdjacentRooms(third);
    ArrayList<Room> adj = new ArrayList();
    adj.add(second);
    adj.add(third);
    Player one = new Player(first);

    if (one.shouldTeleport()) {
      System.out.println("STOP: Problem with shouldTeleport method");
      return false;
    }

    return true;
  }

  /**
   * Tester for checking the correctness of both the isPortalNearby() and isTreasureNearby methods
   */
  public static boolean testPlayerDetectNearbyRooms() {
    Room first = new Room(1, "Start");
    Room second = new Room(2, "Portal");
    Room third = new Room(3, "Treasure");
    Room fourth = new Room(4, "Normal");
    second.setRoomType(RoomType.PORTAL);
    third.setRoomType(RoomType.TREASURE);
    first.addToAdjacentRooms(second);
    first.addToAdjacentRooms(third);
    ArrayList<Room> adj = new ArrayList();
    adj.add(second);
    adj.add(third);
    Player one = new Player(first);

    if (!one.isTreasureNearby()) {
      System.out.println("STOP: Problem with Treasure method");
      return false;
    } else if (!one.isPortalNearby()) {
      System.out.println("STOP: Problem with Portal method");
      return false;
    }

    return true;
  }


  // TESTER FOR DRAGON CLASS

  /**
   * Tester to check for the correctness of the changeRooms() method within the Dragon class
   */
  public static boolean testDragonChangeRooms() {
    Room first = new Room(1, "Start");
    Room second = new Room(2, "Portal");
    Room third = new Room(3, "Treasure");
    Room fourth = new Room(4, "Normal");
    second.setRoomType(RoomType.PORTAL);
    third.setRoomType(RoomType.TREASURE);
    fourth.setRoomType(RoomType.NORMAL);
    first.setRoomType(RoomType.NORMAL);
    third.addToAdjacentRooms(second);
    third.addToAdjacentRooms(first);
    third.addToAdjacentRooms(fourth);
    ArrayList<Room> adj = new ArrayList();
    adj.add(second);
    adj.add(first);
    adj.add(fourth);
    Dragon beast = new Dragon(third);


    beast.changeRooms();
    if (beast.getCurrentRoom().equals(second)) {
      return false;
    }


    return true;
  }

  /**
   * Main method that allows all testers to be called
   */
  public static void main(String[] args) {
    System.out.println(testRoomInstanceMethods());
    System.out.println(testRoomStaticMethods());
    System.out.println(testPlayerCanMoveTo());
    System.out.println(testPlayerShouldTeleport());
    System.out.println(testPlayerDetectNearbyRooms());
    System.out.println(testDragonChangeRooms());
  }

}
