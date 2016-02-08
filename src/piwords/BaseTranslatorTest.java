package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseTranslatorTest {
    @Test
    public void basicBaseTranslatorTest() {
        // Expect that .01 in base-2 is .25 in base-10
        // (0 * 1/2^1 + 1 * 1/2^2 = .25)
        int[] input = {0, 1};
        int[] expectedOutput = {2, 5};
        assertArrayEquals(expectedOutput,
                          BaseTranslator.convertBase(input, 2, 10, 2));
    }

    // TODO: Write more tests (Problem 2.a)
    @Test
    public void basicBaseTranslator2Test() {
    	int[] input = {1, 2, 3};
        int[] expectedOutput = {1, 15, 7, 12};        
        assertArrayEquals(expectedOutput, BaseTranslator.convertBase(input, 10, 16, 4));
    }
    
    @Test
    public void zeroBaseTranslatorTest() {
    	int[] input = {0};
        int[] expectedOutput = {0, 0, 0, 0, 0, 0};
        
        assertArrayEquals(expectedOutput, BaseTranslator.convertBase(input, 15, 34, 6));
    }
    
    @Test
    public void equalBaseTranslatorTest() {
    	int[] input = {1, 2, 3};
        int[] expectedOutput = {1, 2, 3};
        
        assertArrayEquals(expectedOutput, BaseTranslator.convertBase(input, 5, 5, 3));
    }
    
    @Test
    public void nullBaseTranslatorTest() {
    	int[] input = {0, 1, 10};
    	
    	assertArrayEquals(null, BaseTranslator.convertBase(input, 5, 5, 3));
    	assertArrayEquals(null, BaseTranslator.convertBase(input, 0, 5, 5));
        assertArrayEquals(null, BaseTranslator.convertBase(input, 0, 0, 5));
        assertArrayEquals(null, BaseTranslator.convertBase(input, 0, 5, 0));
    }    
}
