import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator1;

    @BeforeEach
    public void setUp(){
        calculator1 = new Calculator();
    }


    @Test
    @DisplayName("Validar objeto de la clase Calculator")
    public void createCalculator(){
        assertInstanceOf(Calculator.class,calculator1);
        assertNotNull(calculator1);
    }

    @Test
    @DisplayName("Testear la resta")
    public void substractTest(){
        //calculator1.subtract(5,5);
        assertEquals(0,calculator1.subtract(5,5));

    }

    @Test
    @DisplayName("Testear Multiplicacion")
    public void multiplyTest(){
        assertEquals(0,calculator1.multiply(6,0));
        assertEquals(-10,calculator1.multiply(10,-1));
    }

    @Test
    @DisplayName("Testear division")
    public void divideTest(){
        assertEquals(5,calculator1.divide(10,2));
        assertEquals(-50,calculator1.divide(100,-2));
        assertEquals(0.875,calculator1.divide(7,8));

       ArithmeticException thrown = assertThrows(
                ArithmeticException.class,
                () -> calculator1.divide(10,0),
               "Debe lanzar ArithmeticException al dividir entre 0"
        );
       assertEquals("Cannot divide by zero",thrown.getMessage());
        
    }

    @Test
    @DisplayName("Validar si es par")
    public void isEvenTest(){
        assertEquals(true,calculator1.isEven(2));
        assertEquals(true,calculator1.isEven(100));
        assertEquals(false,calculator1.isEven(3));
        assertEquals(false,calculator1.isEven(17));
    }


    @Test
    @DisplayName("Validar valor absoluto")
    public void absoluteValueTest(){
        assertEquals(5,calculator1.absoluteValue(-5));
        assertEquals(5,calculator1.absoluteValue(5));
    }

    @Test
    @DisplayName("Validar average")
    public void averageTest(){
        List<Double> numbers = new ArrayList<>(Arrays.asList(
                10.0,10.0,10.0,10.0,10.0
        ));

        List<Double> numbersEmpty = new ArrayList<>();
        List<Double> numbersNull = null;
        assertEquals(10.0,calculator1.average(numbers));

        IllegalArgumentException thrown  = assertThrows(
                IllegalArgumentException.class ,
                () -> calculator1.average(numbersEmpty),

                "Debe lanza IllegalArgumentException al estar la lista vacia o nula"
        );
        assertEquals("List cannot be empty or null",thrown.getMessage());

        IllegalArgumentException thrown2  = assertThrows(
                IllegalArgumentException.class ,
                () -> calculator1.average(numbersNull),

                "Debe lanza IllegalArgumentException al estar la lista vacia o nula"
        );
        assertEquals("List cannot be empty or null",thrown2.getMessage());

    }

    @Test
    @DisplayName("Validar average")
    public void maximumTest(){
        List<Double> numbers = new ArrayList<>(Arrays.asList(
                1.0,2.0,3.0,4.0,5.0
        ));
        List<Double> numbersEquals = new ArrayList<>(Arrays.asList(
                10.0,10.0,10.0,10.0,10.0
        ));

        List<Double> numbersEmpty = new ArrayList<>();
        List<Double> numbersNull = null;
        assertEquals(5,calculator1.maximum(numbers));
        assertEquals(10,calculator1.maximum(numbersEquals));

        IllegalArgumentException thrown  = assertThrows(
                IllegalArgumentException.class ,
                () -> calculator1.maximum(numbersEmpty),

                "Debe lanza IllegalArgumentException al estar la lista vacia o nula"
        );
        assertEquals("List cannot be empty or null",thrown.getMessage());

        IllegalArgumentException thrown2  = assertThrows(
                IllegalArgumentException.class ,
                () -> calculator1.maximum(numbersNull),

                "Debe lanza IllegalArgumentException al estar la lista vacia o nula"
        );
        assertEquals("List cannot be empty or null",thrown2.getMessage());

    }

    @Test
    @DisplayName("Validar average")
    public void minimumTest(){
        List<Double> numbers = new ArrayList<>(Arrays.asList(
                1.0,2.0,3.0,4.0,5.0
        ));
        List<Double> numbersEquals = new ArrayList<>(Arrays.asList(
                10.0,10.0,10.0,10.0,10.0
        ));

        List<Double> numbersEmpty = new ArrayList<>();
        List<Double> numbersNull = null;
        assertEquals(1,calculator1.minimum(numbers));
        assertEquals(10,calculator1.minimum(numbersEquals));

        IllegalArgumentException thrown  = assertThrows(
                IllegalArgumentException.class ,
                () -> calculator1.minimum(numbersEmpty),

                "Debe lanza IllegalArgumentException al estar la lista vacia o nula"
        );
        assertEquals("List cannot be empty or null",thrown.getMessage());

        IllegalArgumentException thrown2  = assertThrows(
                IllegalArgumentException.class ,
                () -> calculator1.minimum(numbersNull),

                "Debe lanza IllegalArgumentException al estar la lista vacia o nula"
        );
        assertEquals("List cannot be empty or null",thrown2.getMessage());

    }




}
