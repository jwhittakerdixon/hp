package living;

import stats.*;

/**
*This is you
*/
public class Player extends Living{

  public Hunger hunger;
  public Thirst thirst;
  public Energy energy;

/*initialise player*/
  public Player(){
    super("You","You are the player");
    hunger = new Hunger(1000);
    thirst = new Thirst(1000);
    energy = new Energy(1000);
  }

  public void updateStats(int ticks){

    if (ticks % 10 == 0){
      hunger.change(-1);
      thirst.change(-1);
      energy.change(-1);
    }
  }

}
