package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        User user1 = new User("user01", "a");
        User user2 = new User("user02", "b");
        User user3 = new User("user03", "c");
        userList.addUser("user01", "a");
        userList.addUser("user02", "b");
        userList.addUser("user03", "c");
        // TODO: find one of them
        User foundUser = userList.findUserByUsername("user02");
        // TODO: assert that UserList found User;
        assertEquals("user02", foundUser.getUsername());
        // String expected = "<one of username>";
        // String actual = user.getUsername();
        // assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        User user1 = new User("user01", "a");
        User user2 = new User("user02", "b");
        User user3 = new User("user03", "c");
        userList.addUser("user01", "a");
        userList.addUser("user02", "b");
        userList.addUser("user03", "c");
        // TODO: change password of one user
        user2.setPassword("new-b");

        // TODO: assert that user can change password
        boolean isPasswordValid = user2.validatePassword("new-b");
        assertTrue(isPasswordValid);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        User user1 = new User("user01", "a");
        User user2 = new User("user02", "b");
        User user3 = new User("user03", "c");
        userList.addUser("user01", "a");
        userList.addUser("user02", "b");
        userList.addUser("user03", "c");
        // TODO: call login() with correct username and password
        User loggedInUser = userList.login("user02", "b");
        // TODO: assert that User object is found
        assertEquals("user02", loggedInUser.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        User user1 = new User("user01", "a");
        User user2 = new User("user02", "b");
        User user3 = new User("user03", "c");
        userList.addUser("user01", "a");
        userList.addUser("user02", "b");
        userList.addUser("user03", "c");
        // TODO: call login() with incorrect username or incorrect password
        User loggedInUser = userList.login("user02", "not-b");
        // TODO: assert that the method return null
        assertNull(loggedInUser);
    }

}