package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlphabetGeneratorTest {
    @Test
    public void generateFrequencyAlphabetTest() {
        // Expect in the training data that Pr(a) = 2/5, Pr(b) = 2/5,
        // Pr(c) = 1/5.
        String[] trainingData = {"aa", "bbc"};
        // In the output for base 10, they should be in the same proportion.
        char[] expectedOutput = {'a', 'a', 'a', 'a',
                                 'b', 'b', 'b', 'b',
                                 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        10, trainingData));
    }

    @Test
    public void secondTest() {
    	String[] testme = {"a","b"};
    	assertNull(AlphabetGenerator.generateFrequencyAlphabet(-1, testme));
    }
    
    @Test
    public void StrongerTest(){
    	int size = 20;
    	String[] trainingData = {"absd", "esss", "fgqq", "darr", "eggabss"};
    	char[] testMe = new char[size];
    	testMe = AlphabetGenerator.generateFrequencyAlphabet(size, trainingData);
    	
    	for(int i = 0; i < size; i++){
    		System.out.print(testMe[i] + " ");
    	}
    }
}
