package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentListTest {
    private StudentList studentList;

    @BeforeEach
    void init() {
        studentList = new StudentList();
        studentList.addNewStudent("6610450170", "August", 0.0);
    }

    @Test
    void testAddNewStudent() {
        assertEquals("6610450170", studentList.getStudents().get(0).getId());
    }

    @Test
    void testFindStudentById() {
        Student found = studentList.findStudentById("6610450170");
        assertNotNull(found);
        assertEquals("6610450170", found.getId());
    }

    @Test
    void testGiveScoreToId(){
        Student found = studentList.findStudentById("6610450170");
        studentList.giveScoreToId("6610450170", 80);
        assertEquals(80, found.getScore());
    }

    @Test
    void testViewGradeOfId(){
        Student found = studentList.findStudentById("6610450170");
        studentList.giveScoreToId("6610450170", 80);
        studentList.viewGradeOfId("6610450170");
        assertEquals("A", found.grade());
    }
}


