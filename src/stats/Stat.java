package stats;

import attributes.*;

public abstract class Stat implements Describable{

  private String name;
  private String desc;
  private int max;
  private int current;

  public Stat(String nName, String nDesc, int nMax, int nCurrent){

    name=nName;
    desc=nDesc;
    max=nMax;
    current=nCurrent;

  }

  public String getName(){

    return name;

  }

  public String getDesc(){

    return desc;

  }

  public int getMax(){

    return max;

  }

  public int getCurrent(){

    return current;

  }

  public void change(int amount){

    current=current+amount;
    if (current>max){
      current=max;
    }

  }

  public void changeMax(int amount){

    max=max+amount;

  }

  public void set(int amount){

    current=amount;
    if (current>max){
      current=max;
    }

  }

  public void setMax(int amount){

    max=amount;

  }

}
