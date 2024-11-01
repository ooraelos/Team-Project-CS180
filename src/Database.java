import java.io.*;
import java.util.ArrayList;
public class Database implements DatabaseInterface {
    private ArrayList<User> users;
    private ArrayList<Post> posts;

    // Creates a Database object with users and posts ArrayLists initialized
    public Database(ArrayList<User> users, ArrayList<Post> posts) {
        this.users = users;
        this.posts = posts;
    }

    // Creates a Database object with empty users and posts ArrayLists
    public Database() {
        this.users = new ArrayList<User>();
        this.posts = new ArrayList<Post>();
    }

    public void addUser(User user, String userOutput) {
        
    }

    public void removeUser(User user, String userOutput) {
        
    }

    public void addPost(Post post, String postOutput) {
        
    }

    public void removePost(Post post, String postOutput) {

    }
}
