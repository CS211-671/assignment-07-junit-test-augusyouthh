package ku.cs.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testAddScore(){
        Student s = new Student("6610450170","StudentTest", 50);
        s.addScore(20);
        assertEquals(70, s.getScore());
    }

    @Test
    void testCalculateGrade(){
        Student s = new Student("6610450170", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    void testChangeName(){
        Student s = new Student("6610460170", "August");
        s.changeName("youth");
        assertEquals("youth", s.getName());
    }
    @Test
    void testIsId(){
        Student s = new Student("6610450170", "August");
        s.isId("6610450170");
        assertEquals("6610450170", s.getId());
    }
}
