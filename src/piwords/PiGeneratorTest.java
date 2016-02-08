package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {
    @Test
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
    	assertEquals(17, PiGenerator.powerMod(5, 7, 23));

    	assertEquals(1, PiGenerator.powerMod(10, 2, 3));

    	assertEquals(-1, PiGenerator.powerMod(-1, 7, 23));

    	assertEquals(0, PiGenerator.powerMod(2, 5, 2));    
    }

    @Test
	public void computePiInHexTest() {
		assertEquals(null, PiGenerator.computePiInHex(-1));
		//assertEquals(null, PiGenerator.computePiInHex(0));
		assertEquals(2, PiGenerator.computePiInHex(1)[0]);
		assertEquals(2, PiGenerator.computePiInHex(2)[0]);
		assertEquals(4, PiGenerator.computePiInHex(2)[1]);
		assertEquals(2, PiGenerator.computePiInHex(3)[0]);
		assertEquals(4, PiGenerator.computePiInHex(3)[1]);
		assertEquals(3, PiGenerator.computePiInHex(3)[2]);
		assertEquals(2, PiGenerator.computePiInHex(1000)[0]);
	}

    @Test
    public void piDigitTest() {
    	assertEquals(-1, PiGenerator.piDigit(-100));
    	assertEquals(-1, PiGenerator.piDigit(-1));
    	assertEquals( 3, PiGenerator.piDigit(0));
    	assertEquals( 2, PiGenerator.piDigit(1));
    	assertEquals( 4, PiGenerator.piDigit(2));
    	assertEquals( 3, PiGenerator.piDigit(3));
    	assertEquals(15, PiGenerator.piDigit(4));
    	assertEquals( 6, PiGenerator.piDigit(5));
    	assertEquals(10, PiGenerator.piDigit(6));
    	assertEquals( 8, PiGenerator.piDigit(7));
    	assertEquals( 8, PiGenerator.piDigit(8));
    }	
}
