import living.*;
import regions.*;
import gameplay.*;
import items.*;

/**
*Test game! Creates some test elements and runs the game
*/
public abstract class Test{

  public static void main(String[] args) {

/*create world*/
    Region world = new Region();
    Player player = new Player();

/*create test rooms, npcs and items*/
    Room one = new Room("One","this is room one");
    Room two = new Room("Two", "this is another room");
    Room three = new Room("Three", "x");
    NPC them = new NPC("Not You", "someone else");
    NPC other = new NPC("A Third Person", "also not you");
    Item thing = new Item("This", "It's an item");
    Item stuff = new Item("That", "It's another item");

/*connect rooms and place npcs and items*/
    world.addRoom(one);
    world.addRoom(two);
    world.addExit(one,"north",two);
    world.addExit(two,"south", one);
    world.addExit(two,"north",three, true, "I have locked this door");
    world.addExit(three,"south", two, true);
    one.addLiving(them);
    one.addLiving(other);
    one.addItem(thing);
    one.addItem(stuff);

/*run the game*/
    Run.game(player, world, one);

  }

}
