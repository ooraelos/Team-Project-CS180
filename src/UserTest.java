import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User user;
    private User friend;
    private User blockedUser;

    @Before
    public void setUp() throws InvalidInputException {
        user = new User("testUser", "Password1");
        friend = new User("friendUser", "FriendPass1");
        blockedUser = new User("blockedUser", "BlockedPass1");
    }

    @Test
    public void testUserInitialization() {
        assertEquals("testUser", user.getUserName());
        assertNotNull(user.getUserId());
        assertEquals("", user.getBio());
        assertEquals("", user.getEmail());
    }

    @Test
    public void testPasswordValidationSuccess() throws InvalidInputException {
        user.setPassword("NewPassword1");
        assertEquals("NewPassword1", user.getPassword());
    }

    @Test(expected = InvalidInputException.class)
    public void testPasswordValidationFailure() throws InvalidInputException {
        user.setPassword("nopassword");
    }

    @Test
    public void testAddFriendSuccess() throws UserNotFoundException {
        user.addFriend(friend);
        assertTrue(user.isFriend(friend));
    }

    @Test(expected = UserNotFoundException.class)
    public void testAddFriendFailureAlreadyFriend() throws UserNotFoundException {
        user.addFriend(friend);
        user.addFriend(friend); // Attempt to add friend again should throw exception
    }

    @Test
    public void testRemoveFriendSuccess() throws UserNotFoundException {
        user.addFriend(friend);
        user.removeFriend(friend);
        assertFalse(user.isFriend(friend));
    }

    @Test(expected = UserNotFoundException.class)
    public void testRemoveFriendFailureNotFriend() throws UserNotFoundException {
        user.removeFriend(friend); // Attempt to remove non-existent friend
    }

    @Test
    public void testBlockUser() throws UserNotFoundException {
        user.blockUser(blockedUser);
        assertTrue(user.isBlocked(blockedUser));
    }

    @Test
    public void testIsBlockedFalse() {
        assertFalse(user.isBlocked(friend));
    }

    @Test
    public void testSetAndGetBio() {
        user.setBio("This is my bio");
        assertEquals("This is my bio", user.getBio());
    }

    @Test
    public void testSetAndGetEmail() {
        user.setEmail("user@example.com");
        assertEquals("user@example.com", user.getEmail());
    }

    @Test
    public void testEquals() throws InvalidInputException {
        User sameUser = user;
        assertEquals(user, sameUser); // Test for reference equality

        User newUser = new User("newUser", "Password2");
        assertNotEquals(user, newUser); // Test for different users

    }
}
