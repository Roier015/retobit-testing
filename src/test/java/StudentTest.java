import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    Student st1;

    @BeforeEach
    public void setUp(){
        st1 = new Student("Roger","roger@gmail.com",21);
    }

    @Test
    @DisplayName("Validar creacion correcta de Objeto")
    public void studentTest(){
        assertInstanceOf(Student.class,st1);
        assertNull(st1);
        assertEquals("Roger",st1.getName());
        assertEquals("roger@gmail.com",st1.getEmail());
        assertEquals(21,st1.getAge());
    }

    @Test
    @DisplayName("Validar retorno de nombre")
    public void nameTest(){
        assertEquals("Roger",st1.getName());
    }

    @Test
    @DisplayName("Validar retorno de edad")
    public void ageTest(){
        assertEquals(21,st1.getAge());
    }

    @Test
    @DisplayName("Validar retorno de correo")
    public void emailTest(){
        assertEquals("roger@gmail.com",st1.getEmail());
    }




    @Test
    @DisplayName("Validar Excepciones en los Setters")
    public void settersExceptionsTest() {

        assertThrows(IllegalArgumentException.class, () -> st1.setName(""));
        assertThrows(IllegalArgumentException.class, () -> st1.setName(null));


        assertThrows(IllegalArgumentException.class, () -> st1.setEmail("rogergmail.com"));


        assertThrows(IllegalArgumentException.class, () -> st1.setAge(-1));
        assertThrows(IllegalArgumentException.class, () -> st1.setAge(121));
    }

    @Test
    @DisplayName("Validar el registro de calificaciones y excepciones")
    public void addGradeTest() {

        st1.addGrade(8.5);
        st1.addGrade(10.0);
        assertEquals(2, st1.getGrades().size());


        assertThrows(IllegalArgumentException.class, () -> st1.addGrade(-0.5));
        assertThrows(IllegalArgumentException.class, () -> st1.addGrade(10.5));
    }

    @Test
    @DisplayName("Validar cálculo del promedio")
    public void calculateAverageTest() {

        assertEquals(0.0, st1.calculateAverage());


        st1.addGrade(10.0);
        st1.addGrade(8.0);
        assertEquals(9.0, st1.calculateAverage());
    }

    @Test
    @DisplayName("Validar lógica de mayoría de edad")
    public void isAdultTest() {

        assertTrue(st1.isAdult());


        st1.setAge(17);
        assertFalse(st1.isAdult());
    }

    @Test
    @DisplayName("Validar los diferentes estatus académicos")
    public void academicStatusTest() {

        assertEquals("Needs improvement", st1.getAcademicStatus());
        st1.addGrade(6.0);
        assertEquals("Regular", st1.getAcademicStatus());


        st1.addGrade(10.0);
        assertEquals("Good", st1.getAcademicStatus());


        st1.addGrade(10.0);
        st1.addGrade(11.0);
        st1.addGrade(10.0);
        st1.addGrade(10.0);
        assertEquals("Excellent", st1.getAcademicStatus());
    }


}
