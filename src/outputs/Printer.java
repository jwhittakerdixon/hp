package outputs;

import java.util.*;
import attributes.*;
import living.*;

/**
*Everything that prints goes via here
*/
public class Printer{

  public static void printList(ArrayList<? extends Listable> l){

    for (int i=0; i<l.size(); i++){
      if (i<l.size()-2) {
        System.out.print(l.get(i).getName() + ", ");
      }else if (i==l.size()-2){
        System.out.print(l.get(i).getName() + " and ");
      } else {
        System.out.print(l.get(i).getName());
      }
    }
    System.out.println();

  }

  public static void printUnknown(){

    System.out.println("???");

  }

  public static void printDescription(Describable d){

    System.out.println(d.getName());
    System.out.println(d.getDesc());

  }

  public static void printTime(int ticks){

    System.out.println(Formatter.formatGameTime(ticks));

  }

  public static void printHealth(Living p){

    System.out.println("Health: " + p.HP.getCurrent() + "/" + p.HP.getMax());

  }

  public static void printHunger(Player p){

    System.out.println("Hunger: " + p.hunger.getCurrent() + "/" + p.hunger.getMax());

  }

  public static void printThirst(Player p){

    System.out.println("Thirst: " + p.thirst.getCurrent() + "/" + p.thirst.getMax());

  }

  public static void printEnergy(Player p){

    System.out.println("Energy: " + p.energy.getCurrent() + "/" + p.energy.getMax());

  }

  public static void printLockedMessage(Lockable l){

    System.out.println(l.getLockedMessage());

  }

}
