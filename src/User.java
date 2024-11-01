import java.util.ArrayList;
import java.util.List;

public class User implements UserInterface {
    private String userName;
    private String password;
    private List<User> friends;
    private List<User> blocklist;

    public User(String userName, String password) throws InvalidInputException {
        setUserName(userName);
        setPassword(password);
        this.friends = new ArrayList<>();
        this.blocklist = new ArrayList<>();
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) throws InvalidInputException {
        if (!isValidPassword(password)) {
            throw new InvalidInputException("Password must contain at least one capital letter.");
        }
        this.password = password;
    }

    @Override
    public void addFriend(User user) throws UserNotFoundException {
        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }
        if (!friends.contains(user)) {
            friends.add(user);
        }
    }

    @Override
    public void removeFriend(User user) throws UserNotFoundException {
        if (user == null || !friends.contains(user)) {
            throw new UserNotFoundException("User not found in friends list.");
        }
        friends.remove(user);
    }

    @Override
    public User[] getFriends() {
        return friends.toArray(new User[0]);
    }

    @Override
    public void block(User user) throws UserNotFoundException {
        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }
        if (!blocklist.contains(user)) {
            blocklist.add(user);
            friends.remove(user); // Remove from friends if blocking
        }
    }

    @Override
    public void unBlock(User user) throws UserNotFoundException {
        if (user == null || !blocklist.contains(user)) {
            throw new UserNotFoundException("User not found in blocklist.");
        }
        blocklist.remove(user);
    }

    @Override
    public User[] getBlocklist() {
        return blocklist.toArray(new User[0]);
    }

    @Override
    public String toString() {
        return "User Profile: " + userName + "\nFriends: " + friends.size() + "\nBlocked Users: " + blocklist.size();
    }

    //let me know if you want the valid password to be more specific but for now it's just checking for an uppercase letter
    private boolean isValidPassword(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }
}
