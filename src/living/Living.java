package living;

import java.util.*;
import items.*;
import gameplay.*;
import attributes.*;
import stats.*;

/**
*This is an abstract living being, with health and an inventory
*/
public abstract class Living implements Describable{

/*properties*/
  private String name;
  private String desc;
  private ArrayList<Item> inventory;
  public Health HP;

/*initialise properties*/
  public Living(String n, String d){
    name=n;
    desc=d;
    inventory = new ArrayList<Item>();
    HP = new Health(100);
  }

/*return name*/
  public String getName(){
    return name;
  }

/*return desc*/
  public String getDesc(){
    return desc;
  }

/*add item to inventory*/
  public void addItem(Item n){

    inventory.add(n);

  }

/*remove item from inventory*/
  public void removeItem(Item n){

    inventory.remove(n);

  }

/*return inventory*/
  public ArrayList<Item> getInventory(){

    return inventory;

  }

}
