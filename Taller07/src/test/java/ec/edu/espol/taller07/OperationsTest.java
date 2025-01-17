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
    
    
    @Test
    @DisplayName("Se desea combrobar si hace operaciones mixtas con parentesis")
    public void testOperacionMixta(){
        String formula = "(3+5)*6";
        String expected = "(3+5)*6 = 48";
        assertEquals(expected, Operations.Solve(formula));
    }
    
    @Test
    @DisplayName("Se desea comprobar si opera expresiones con espacios")
    public void testEspacios(){
        String formula = "3 + 1 * 2";
        String expected = "3 + 1 * 2 = 6";
        assertEquals(expected, Operations.Solve(formula));
    }
    
    
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

    @Test
    @DisplayName("Division para cero")
     void testSolve1() {
        String formula = "5/0+5";
        assertThrows(ArithmeticException.class, () -> Operations.Solve(formula), "Deberia lanzar ArithmeticException ");
        
    }
     
    @Test
    @DisplayName("Operacion solo multiplicacion")
     void testSolve4() {
        String formula = "5*5*1";
        assertEquals("5*5*1=25",Operations.Solve(formula),"La operacion deberia dar:" );
       
     }
     
    @Test
    @DisplayName("Operacion Combinada con multiplicacion")
     void testSolve2() {
        String formula = "5*5+5";
        assertEquals("5*5+5=30",Operations.Solve(formula),"La operacion deberia dar:" );
       
     }
     
    @Test
    @DisplayName("Operacion  solo sumas")
     void testSolve3() {
        String formula2 = "5+5";
        assertEquals("5+5=10",Operations.Solve(formula2),"La operacion deberia dar:" );
       
     }
    
    
}
