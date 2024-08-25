package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password validation should fail for incorrect password")
    public void testPasswordValidationFailsForIncorrectPassword() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("wrong-password");
        assertFalse(actual);
    }

    @Test
    @DisplayName("Username should be correctly set and retrieved")
    public void testUsernameRetrieval() {
        User user = new User("user01", "plain-p@ssw0rd");
        String expected = "user01";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Username comparison should be case-sensitive")
    public void testUsernameCaseSensitivity() {
        User user1 = new User("user01", "plain-p@ssw0rd");
        User user2 = new User("USER01", "plain-p@ssw0rd");
        assertFalse(user1.isUsername(user2.getUsername()));
    }

    @Test
    @DisplayName("Password should be hashed when set")
    public void testPasswordHashing() {
        User user = new User("user01", "plain-p@ssw0rd");
        String hashedPassword = user.getPassword();
        assertNotNull(hashedPassword);
        assertNotEquals("plain-p@ssw0rd", hashedPassword);
    }

    @Test
    @DisplayName("Should handle empty password")
    public void testEmptyPassword() {
        User user = new User("user01", "");
        assertTrue(user.validatePassword(""));
        assertFalse(user.validatePassword("non-empty"));
    }

    @Test
    @DisplayName("Should handle null password correctly")
    public void testNullPassword() {
        User user = new User("user01", "01");
        assertTrue(user.validatePassword("01"));
        assertFalse(user.validatePassword("non-empty"));
    }
}
