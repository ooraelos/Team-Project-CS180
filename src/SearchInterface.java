//Interface for searching

public interface SearchInterface {
    //Finds the given user or post in their respective databases
    public User findUser(User user) throws UserNotFoundException;
    public User findPost(Post post);
}
