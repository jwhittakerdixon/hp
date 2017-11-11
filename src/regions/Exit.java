package regions;

import gameplay.*;
import attributes.*;

/**
*This is an exit, allowing the player to move between rooms
*/
public class Exit implements Listable, Lockable{

  private Room one;
  private String name;
  private Room two;
  private Boolean locked;
  private String lockedMessage;

  public Exit(Room a, String n, Room b){

    one=a;
    name=n;
    two=b;
    locked=false;
    lockedMessage="locked";

  }

  public Exit(Room a, String n, Room b, Boolean l){

    one=a;
    name=n;
    two=b;
    locked=l;
    lockedMessage="locked";

  }

  public Exit(Room a, String n, Room b, Boolean l, String m){

    one=a;
    name=n;
    two=b;
    locked=l;
    lockedMessage=m;

  }

  public Room getStart(){

    return one;

  }

  public Room getEnd(){

    return two;

  }

  public String getName(){

    return name;

  }

  public void lock(){

    locked=true;

  }

  public void Unlock(){

    locked=false;

  }

  public Boolean isLocked(){

    return locked;

  }

  public String getLockedMessage(){

    return lockedMessage;

  }

}
