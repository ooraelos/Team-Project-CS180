//Interface for User class

public interface UserInterface {
    //Username and password getters and setters
    //might update with more getters and setters if we add like age for example
    public String getUserName();
    public void setUserName(String userName);
    public String getPassword();
    //Example exception InvalidInputException, for when the password doesn't
    //meet certain criteria like having a capital letter
    public void setPassword(String password) throws InvalidInputException;

    //Other potential exception for when a user doesn't exist or is
    //on the blocklist
    //I've included the friend function as part of the User class itself
    //since I think it'll be easier but we can make it a separate class
    public void addFriend(User user) throws UserNotFoundException;
    public void removeFriend(User user) throws UserNotFoundException;
    public User[] getFriends();

    //Blocking and unblocking users. Should make you unable to see their
    //posts even in public feeds and unable to find them when searching
    //(and vice versa for both)
    public void block(User user) throws UserNotFoundException;
    public void unBlock(User user) throws UserNotFoundException;
    public User[] getBlocklist();

    //toString to return a String format of the User's profile
    public String toString();
}
