package outputs;

import attributes.*;

/**
*Formats for time and any other outputs
*/
public class Formatter{

  private static final int SECINMIN = 60;
  private static final int MININHR = 60;
  private static final int HRINDAY = 24;

  public static String formatGameTime(int ticks){

    int sec = ticks;
    int min = 0;
    int hr = 0;
    int day = 0;

    if (sec>SECINMIN){

    do{

      sec=sec-SECINMIN;
      min++;

    }while (sec>SECINMIN);

    if (min>MININHR){

    do{

      min=min-MININHR;
      min++;

    }while (min>MININHR);

    if (hr>HRINDAY){

    do{

      hr=hr-HRINDAY;
      day++;

    }while (hr>HRINDAY);

  }}}

    String time = hr + ":" + min + ":" + sec + " on Day " + day;
    return time;

  }

}
