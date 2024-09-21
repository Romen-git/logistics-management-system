package com.ro.ejb.dao;

import com.ro.ejb.entity.User;
import com.ro.ejb.remote.dao.UserDAO;
import jakarta.ejb.embeddable.EJBContainer;
import org.junit.jupiter.api.*;


import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    private static EJBContainer ejbContainer;
    private static Context context;
    private UserDAO userDAO;

    @BeforeAll
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        ejbContainer = EJBContainer.createEJBContainer(properties);
        context = ejbContainer.getContext();
    }

    @AfterAll
    public static void tearDownClass() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

    @BeforeEach
    public void setUp() throws NamingException {
        userDAO = (UserDAO) context.lookup("java:global/ear-1.0/com.ro-web-1.0/UserDAOImpl");
    }

    @Test
    @Order(1)
    public void testCreateUser() throws Exception {

        User user = new User("password123", "test@example.com", "John Doe", "1234567890", 2);
        userDAO.save(user);


        User found = userDAO.findById(user.getId());
        Assertions.assertNotNull(found);
        Assertions.assertEquals("John Doe", found.getName());
    }

    @Test
    @Order(2)
    public void testFindAllUsers() throws Exception {

        User user1 = new User("password123", "test1@example.com", "John Doe", "1234567890", 2);
        User user2 = new User("password123", "test2@example.com", "Jane Doe", "0987654321", 3);
        userDAO.save(user1);
        userDAO.save(user2);

        List<User> users = userDAO.findAll();
        Assertions.assertEquals(2, users.size());
    }

    @Test
    @Order(3)
    public void testUpdateUser() throws Exception {
        User user = new User("password123", "test@example.com", "John Doe", "1234567890", 2);
        userDAO.save(user);

        user.setName("John Smith");
        userDAO.update(user);

        User found = userDAO.findById(user.getId());
        Assertions.assertEquals("John Smith", found.getName());
    }

    @Test
    @Order(4)
    public void testDeleteUser() throws Exception {
        User user = new User("password123", "test@example.com", "John Doe", "1234567890", 2);
        userDAO.save(user);

        userDAO.delete(user);

        User found = userDAO.findById(user.getId());
        Assertions.assertNull(found);
    }
}
