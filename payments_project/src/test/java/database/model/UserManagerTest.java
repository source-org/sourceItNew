package database.model;

import static org.junit.Assert.*;

import java.util.Date;

import database.model.manager.UserManager;
import org.junit.Test;

import exception.DBException;
import model.User;

public class UserManagerTest {

    @Test
    public void shouldCreateUser() throws DBException {
        UserManager userManager = new UserManager();
        User user = new User();
        user.setBlocked(false);
        user.setEmail("adasd@asdff.c");
        user.setFullName("11111");
        user.setLogin("login");
        user.setPassword("1111");
        user.setRoleId(1);
        user.setRegisterDate(new Date());
        User user1 = userManager.createUser(user);
        assertNotEquals(user1.getUserId(), 0);
    }
}
