package attributes;

/**
*Interface for exits and any lockable items
*/
public interface Lockable{

  public void lock();

  public void Unlock();

  public Boolean isLocked();

  public String getLockedMessage();

}
