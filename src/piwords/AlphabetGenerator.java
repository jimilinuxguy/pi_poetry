package piwords;

public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     * 
     * This method will try to weight each character of the alphabet
     * proportional to their occurrence in words in a training set.
     * 
     * This method should do the following to generate an alphabet:
     *   1. Count the occurrence of each character a-z in trainingData.
     *   2. Compute the probability of each character a-z by taking
     *      (occurrence / total_num_characters).
     *   3. The output generated in step (2) is a PDF of the characters in the
     *      training set. Convert this PDF into a CDF for each character.
     *   4. Multiply the CDF value of each character by the base we are
     *      converting into.
     *   5. For each index 0 <= i < base,
     *      output[i] = (the first character whose CDF * base is > i)
     * 
     * A concrete example:
     * 	 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     *               "ccccc..." (198 "c"s)}, base = 93
     *   1. Count(a) = 302, Count(b) = 500, Count(c) = 193
     *   2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
     *      Pr(c) = 198 / 1000 = .198
     *   3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
     *   4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
     *   5. Output = {"a", "a", ... (28 As, indexes 0-27),
     *                "b", "b", ... (47 Bs, indexes 28-74),
     *                "c", "c", ... (18 Cs, indexes 75-92)}
     * 
     * The letters should occur in lexicographically ascending order in the
     * returned array.
     *   - {"a", "b", "c", "c", "d"} is a valid output.
     *   - {"b", "c", "c", "d", "a"} is not.
     *   
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     * 
     * If base < 0, return null.
     * 
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     * 
     * @param base A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     *         digit should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base,
                                                   String[] trainingData) {
        // Error checking, yay!
    	if(base < 0){return null;}

    	// letterCount: Counts the occurrence of each character a-z in trainingData.
    	// i.e. [0] = a-count, [1] = b-count, ..., [25] = z-count.
    	int[] letterCount = new int[26];
    	int total = 0;

    	// Loop over each string in trainingData and count the letters into [total]
		for( int i = 0; i < trainingData.length; i++){
    		for( int j = 0; j < trainingData[i].length(); j++){
    			/* Convert letter to ASCII.
    			 * This way we can allow only lowercase, plus
    			 * with the right offset it can be its own array index! */
    			int letter = (int) trainingData[i].charAt(j);
    			
    			if(letter >= 97 && letter <= 122){
    				letterCount[letter-97]++;
    				total++;
    			}
    		}
    	}

		// letterWeight: The probability of each letter occurring.
		float[] letterWeight = new float[26];

		for( int i = 0; i < letterWeight.length; i++){
			letterWeight[i] = (float) letterCount[i] / total;
		}
		
		/* Convert to CDF
		 * According to the example, if A = .1, B = .2 and C = .7,
		 * the CDF would be A = .1, B = .3 (A+B), and C = 1 (A+B+C).*/		
		float previous = letterWeight[0];
		for( int i = 1; i < 26; i++){
			if(letterWeight[i] != 0){ //Ignore unused letters
				letterWeight[i] += previous;
				previous = letterWeight[i];
			}
		}

		// 5. For each index, output[i] = (the first character whose CDF * base is > i)
		char[] output = new char[base];
		for( int i = 0; i < 26; i++){
			float CDFbase = base*letterWeight[i];
			if( CDFbase - Math.round(CDFbase) < 0.0001){CDFbase = Math.round(CDFbase);}
			letterWeight[i] = (int)(CDFbase);
		}
		
		// We need to compare each letter's weight * base with i.
		// [base] is the number of entries in [output], and the
		// first letter with a weight > i will be outputted.
		for( int i = 0; i < base; i++){
			for( int j = 0; j < 26; j++){
				if(letterWeight[j] > i){
					output[i] = (char)(j+97);
					break;
				}
			}
		}
       return output;
    }
}
