//Interface for creating posts

public interface PostInterface {

    //Deletes this post from the post database
    public void deletePost();

    //Edits this post with the new message
    public void editPost(String oldMessage, String newMessage);

    //Liking and disliking function for the posts
    public void likePost();
    public void dislikePost();
}
