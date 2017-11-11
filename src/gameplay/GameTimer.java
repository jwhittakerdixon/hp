package gameplay;

import java.util.*;
import living.*;

/**
*Moves the time through the game
*/
public class GameTimer extends TimerTask{

  private int count;
  private Boolean isPaused=false;
  private int pause;
  private Boolean statEffect=false;
  private Player player;

  public void run(){
    count++;
    if (statEffect){
      player.updateStats(count);
    }
  }

  public void statEffect(Player p){

    player=p;
    statEffect=true;

  }

  public int getTime(){
    if (isPaused){
      return pause;
    }else{
      return count;
    }
  }

  public void setTime(int i){
    if (isPaused){
      pause=i;
    }else{
      count=i;
    }
  }

  public void pauseTime(){
    if (!isPaused){
      pause=count;
      isPaused=true;
      statEffect=false;
    }
  }

  public void resumeTime(){
    if (isPaused){
      count=pause;
      isPaused=false;
      statEffect=true;
    }
  }

}
