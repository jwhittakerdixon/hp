package regions;

import java.util.*;
import outputs.*;

/**
*This is a region of the world, containing rooms and controlling exits
*/
public class Region{

/*properties*/
  ArrayList<Room> locations;
  ArrayList<Exit> exits;

/*initialise properties*/
  public Region(){
      locations = new ArrayList<Room>();
      exits = new ArrayList<Exit>();
  }

/*add room to region*/
  public void addRoom(Room n){

    locations.add(n);

  }

/*remove room from region*/
  public void removeRoom(Room n){

    locations.remove(n);

  }

/*return all rooms*/
  public ArrayList<Room> getLocations(){

    return locations;

  }

/*add an exit*/
  public void addExit(Room one, String n, Room two){

    Exit e = new Exit(one,n,two);
    exits.add(e);

  }

  public void addExit(Room one, String n, Room two, Boolean l){

    Exit e = new Exit(one,n,two,l);
    exits.add(e);

  }

  public void addExit(Room one, String n, Room two, Boolean l, String m){

    Exit e = new Exit(one,n,two,l,m);
    exits.add(e);

  }

/*remove an exit*/
  public void removeExit(Exit n){

    exits.remove(n);

  }

/*return exits*/
  public ArrayList<Exit> getExits(){

    return exits;

  }

/*get all exits from one room*/
  public ArrayList<Exit> getExits(Room n){

    ArrayList<Exit> e = new ArrayList<Exit>();

    for (int i=0; i<exits.size(); i++){

      if (exits.get(i).getStart()==n){

        e.add(exits.get(i));

      }

    }

    return e;

  }

/*checks if a string is an exit from a given room*/
  public boolean isExit(Room one, String n){

    for (int i=0; i<exits.size(); i++){

      if ((exits.get(i).getStart()==one) && (exits.get(i).getName().equals(n))){

        return true;

      }

    }

    return false;

  }

/*gets the location a room exits to*/

  public Room getExit(Room one, String n){

    if (isExit(one,n)){

    for (int i=0; i<exits.size(); i++){

      if ((exits.get(i).getStart()==one) && (exits.get(i).getName().equals(n))){

        return exits.get(i).getEnd();

      }

    }

    }

    return one;

  }

  public Room useExit(Room one, String n){

    if (isExit(one,n)){

    for (int i=0; i<exits.size(); i++){

      if ((exits.get(i).getStart()==one) && (exits.get(i).getName().equals(n))){

        if (exits.get(i).isLocked()){
          Printer.printLockedMessage(exits.get(i));
        }else{
          return exits.get(i).getEnd();
        }

      }

    }

  }

  return one;

  }

  public ArrayList<Room> getMoreExits(Room one, String n){

    ArrayList<Room> moreExits = new ArrayList<Room>();

    moreExits.add(getExit(one,n));

    return followExit(moreExits, n);

  }

  private ArrayList<Room> followExit(ArrayList<Room> more, String n){

    Room a = more.get(more.size()-1);

    if (isExit(a,n)){
      more.add(getExit(a,n));
      more = followExit(more,n);
    }else{
      return more;
    }

    return more;

  }

}
