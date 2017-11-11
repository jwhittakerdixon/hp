package gameplay;

import living.*;
import regions.*;
import items.*;
import java.util.*;
import outputs.*;
import attributes.*;

/**
*runs the game, allows input/output and causes events
*/
public class Run{

  public static final double SECPERTICK = 1;

  private static Region currentRegion;
  private static Room currentRoom;
  private static GameTimer gameTime;
  private static Player player;

  public static void game(Player nplayer, Region startRegion, Room startRoom){

/*start time*/
    gameTime = new GameTimer();
    Timer timer = new Timer(true);
    timer.scheduleAtFixedRate(gameTime, 0, Math.round(SECPERTICK*1000));

/*initialise*/
    player=nplayer;
    gameTime.statEffect(player);
    String input;
    currentRegion=startRegion;
    currentRoom=startRoom;
    Boolean q=false;

/*starting conditions*/

    look();

/*loop ongoing game*/
    do{

/*read console line*/
      System.out.print(">");
      input = System.console().readLine();

/*try moving first*/
      if (!move(input)){
        switch(input){

/*quit command*/
          case "quit": q=true; break;

/*look command*/
          case "look": look(); break;

/*enter debug mode*/
          case "debug": debug(); break;

/*print unknown statement by default*/
          default: Printer.printUnknown();

        }

      }

    } while (!q);

    timer.cancel();

  }


/*update room; print, look and return true if moved*/

  private static Boolean move(String input){

    Room newRoom=currentRegion.useExit(currentRoom,input);
    if (currentRoom!=newRoom){
      currentRoom=newRoom;
      look();
      return true;
    }
    return false;

  }

  private static void look(){

    Printer.printDescription(currentRoom);
    Printer.printList(currentRoom.getPopulation());
    Printer.printList(currentRoom.getContents());
    Printer.printList(currentRegion.getExits(currentRoom));

  }

/*debug mode of checking stuff*/

  private static void debug(){

    String input;
    Boolean q = false;

    do{

    System.out.print("debug>");
    input = System.console().readLine();

    ArrayList<Room> far = currentRegion.getMoreExits(currentRoom,input);

    if (far.get(0)!=currentRoom){
      Printer.printList(far);
    }else{

      switch(input){

        case "quit": q=true; break;

        case "time": int time = gameTime.getTime(); Printer.printTime(time); break;

        case "pause": gameTime.pauseTime(); break;

        case "resume": gameTime.resumeTime(); break;

        case "health": Printer.printHealth(player); break;

        case "hunger": Printer.printHunger(player); break;

        case "thirst": Printer.printThirst(player); break;

        case "energy": Printer.printEnergy(player); break;

        default: Printer.printUnknown();

      }
  }

  }while (!q);

  }

}
