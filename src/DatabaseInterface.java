public interface DatabaseInterface {
    public static final String userOutput = "src\\Users.txt";
    public static final String postOutput = "src\\Posts.txt";

    // Adds or removes a user string to Users.txt
    public void addUser(User user, String userOutput);
    public void removeUser(User use, String userOutput);

    // Adds or removes a post string to Posts.txt
    public void addPost(Post post, String postOutput);
    public void removePost(Post post, String postOutput);

}
