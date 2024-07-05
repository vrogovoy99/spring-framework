import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCase1() {
        fail("Test fail testCase1");
    }

    @Test
    void testCase2() {
        assertTrue(Calculator.operator.equals("add"), "Really?");
        assertEquals("adding", Calculator.operator,"Really?");
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
    }

    @Test
    void testCase5() {}


        @Test
    void add() {
//        int actual = Calculator.add(2,3);
        assertEquals(5, Calculator.add(2,3), "Expected 5");
        assertEquals(5, Calculator.add(6,3), "Expected 5 but not 6");
    }

}