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
 * This class represents the character that the player of the game controls Responsible for keeping
 * track of the current player location, moving the player between rooms, and determining if the
 * player is near a room that as a special property
 */
public class Player {
  private Room currentRoom; // current location of the player

  /**
   * Constructor for the player object. Assigns values to the non-static field.
   * 
   * @param currentRoom - the current location of the player
   */
  public Player(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  /**
   * Getter for this player's current room.
   * 
   * @return the current location of the player
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }

  /**
   * Setter for this player's current room
   * 
   * @param newRoom - the location that the player is moving to
   */
  public void changeRoom(Room newRoom) {
    this.currentRoom = newRoom;
  }

  /**
   * Determines whether or not the player can move to the given destination room. A valid player
   * move is ONLY to adjacent rooms.
   * 
   * @param destination - room player wants to move to
   * @return true if it is a valid movement, false otherwise
   */
  public boolean canMoveTo(Room destination) {
    if (currentRoom.isAdjacent(destination)) {
      return true;
    }
    return false;
  }

  /**
   * Determines whether or not the player needs to teleport. Players teleport when their current
   * room is of type PORTAL
   * 
   * @return true if they should teleport, false otherwise
   */
  public boolean shouldTeleport() {
    if (currentRoom.getType() == RoomType.PORTAL) {
      return true;
    }
    return false;
  }

  /**
   * Gets the list of rooms adjacent to where the player is currently at
   * 
   * @return list of rooms adjacent to the current room
   */
  public ArrayList<Room> getAdjacentRoomsToPlayer() {
    return currentRoom.getAdjacentRooms();
  }

  /**
   * Determines whether or not the given dragon is in a nearby room
   * 
   * @param d - the dragon to check if nearby
   * @returns true if the dragon is nearby, false otherwise
   */
  public boolean isDragonNearby(Dragon d) {
    if (currentRoom.isAdjacent(d.getCurrentRoom())) {
      return true;
    }
    return false;
  }

  /**
   * Determines whether or not the portal room is in a nearby room
   * 
   * @return true if the portal room is nearby, false otherwise
   */
  public boolean isPortalNearby() {
    for (int i = 0; i < currentRoom.getAdjacentRooms().size(); i++) {
      if (currentRoom.getAdjacentRooms().get(i).getType() == RoomType.PORTAL) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determines whether or not the treasure room is in a nearby room
   * 
   * @return true if the treasure room is nearby, false otherwise
   */
  public boolean isTreasureNearby() {
    for (int i = 0; i < currentRoom.getAdjacentRooms().size(); i++) {
      if (currentRoom.getAdjacentRooms().get(i).getType() == RoomType.TREASURE) {
        return true;
      }
    }
    return false;
  }
}
