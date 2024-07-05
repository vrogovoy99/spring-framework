import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Integer testCounter=0;

    @BeforeAll
    static void runBeforeAll(){
        System.out.println("Run BeforeAll");
    }

    @AfterAll
    static void runAfterAll(){
        System.out.println("Run AfterAll");
    }

    @BeforeEach
    void runBeforeEach(){
        this.testCounter=this.testCounter+1;
        System.out.println( this.testCounter + ". run BeforeEach test case");
    }

    @AfterEach
    void runAfterEach(){
        System.out.println(  "Run AfterEach test case");
    }



    @Test
    void testCase1() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(5,1));
//        fail("Test fail testCase1");
    }

    @Test
    void testCase2() {
        assertTrue(Calculator.operator.equals("add"), "Really?");
        assertEquals("add", Calculator.operator,"Really?");
        Integer i1 = 1;
        Integer i2 = 1;
        assertEquals(i1, i2);
    }

    @Test
    void testCase3() {
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
    }

    @Test
    void testCase4() {
        String nullString = null;
        String notNullString = "Cydeo";
        assertNull(nullString);
        assertNotNull(notNullString);
        System.out.println("This test will pass");
    }

    @Test
    void testCase5() {
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        assertSame(c1, c2);
        Calculator c3 = new Calculator();
        assertNotSame(c1, c3, "Same calculators");
        Integer i1 = 1;
        Integer i2 = 1;
        assertSame(i1, i2);
        System.out.println("This test will fail");
        assertSame(c1, c3);
    }


        @Test
    void add() {
//        int actual = Calculator.add(2,3);
        assertEquals(5, Calculator.add(2,3), "Expected 5");
//        assertEquals(5, Calculator.add(6,3), "Expected 5 but not 6");
    }

}