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

    public void addUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userOutput, true))) {
            writer.write(user.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(User user) {
        
    }

    public void addPost(Post post) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(postOutput, true))) {
            writer.write(post.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removePost(Post post) {
        
    }
}
