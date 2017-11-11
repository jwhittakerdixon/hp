package items;

import gameplay.*;
import attributes.*;

/**
*This is an abstract item
*/
public class Item implements Describable{

/*properties*/
  private String name;
  private String desc;

/*initialise properties*/
  public Item(String n, String d){
    name=n;
    desc=d;
  }

/*return name*/
  public String getName(){
    return name;
  }

/*return desc*/
  public String getDesc(){
    return desc;
  }

}
