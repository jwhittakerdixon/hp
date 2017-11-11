package regions;

import java.util.*;
import living.*;
import items.*;
import gameplay.*;
import attributes.*;

/**
*This is a single room, which can contain livings and items
*/
public class Room implements Describable{

  private String name;
  private String desc;
  private ArrayList<Living> population;
  private ArrayList<Item> contents;

  public Room(String n, String d){

    name=n;
    desc=d;
    population=new ArrayList<Living>();
    contents=new ArrayList<Item>();

  }

  public String getName(){
    return name;
  }

  public String getDesc(){
    return desc;
  }

  public void addLiving(Living n){

    population.add(n);

  }

  public void removeLiving(Living n){

    population.remove(n);

  }

  public ArrayList<Living> getPopulation(){

    return population;

  }

  public void addItem(Item n){

    contents.add(n);

  }

  public void removeItem(Item n){

    contents.remove(n);

  }

  public ArrayList<Item> getContents(){

    return contents;

  }

  public void printBrief(){

    System.out.println(name);
    System.out.println("  " + desc);

  }


}
