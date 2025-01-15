/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.taller07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author CltControl
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

    /**
     * Test of MakeFormula method, of class Operations.
     */
    
    @Test
    @DisplayName("Testeamos que la formula no sea nula")
    public void testFormulaIsNotNull() {
        String formula = Operations.MakeFormula();
        assertNotNull(formula);
    }

    @Test
    @DisplayName("Testeamos que la formula no este Vacia")
    public void testMakeFormula() {
        String formula = Operations.MakeFormula();
        assertTrue(formula.length() > 0);
    }

    @Test
    @DisplayName("Testeamos que los operadores esten en el arreglo creado")
    public void testMakeFormula2() {
        String formula = Operations.MakeFormula();
        assertTrue(formula.matches(".*[\\+\\-\\*/].*"));
    }
    
    @Test
    @DisplayName("Testeamos que los numeros sean enteros")
    public void testMakeFormula3() {
        String formula = Operations.MakeFormula();
        assertTrue(formula.matches(".*\\d.*"));
    }
    
    @Test
    @DisplayName("Testeamos que los numeros esten en el rango que fijamos de 01-99")
    public void testMakeFormula4() {
        String formula = Operations.MakeFormula();
        String[] numeros = formula.split("[\\+\\-\\*/]");
        for (String elemento : numeros) {
            if (!elemento.isEmpty()) {
                int number = Integer.parseInt(elemento);
                assertTrue(number >= 1 && number <= 99);
            }
        }
    }

    @Test
    @DisplayName("Testeamos que la formula entregue caracteres validos (numeros enteros y operadores validos)")
    public void testFormula5() {
        String formula = Operations.MakeFormula();
        assertFalse(formula.matches(".*[^\\d\\+\\-\\*/].*")); // No debe contener nada que no sea número o operador
    }

    @Test
    @DisplayName("Prueba si le ingresamos una letra")
    void TestSolveWithLetter() {
        String formula = "5+3+A";
        assertThrows(NumberFormatException.class, () -> Operations.Solve(formula));
    }

    @Test
    @DisplayName("Verificar que maneje correctamente numeros grandes")
    void testSolveNumerosGrandes() {
        String formula = "1000*1000";
        // 15,633,267,203,301,715,044,870,723,372
        assertEquals("1000*1000=1000000", Operations.Solve(formula));
    }

    
    
}
