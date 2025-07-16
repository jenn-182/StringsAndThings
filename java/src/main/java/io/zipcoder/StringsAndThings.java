package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        // Initialize a counter for 'y' and 'z' at the end of words
        int count = 0;

      
        // Iterate through the string character by character
        for (int i = 0; i < input.length(); i++) {

            //set the current character
            char c = input.charAt(i);

            //Check if the current character is 'y' or 'z'
            // AND check if it is the last character OR not followed by a letter
            //(use Character.isLetter to check if next character is a letter)
            if ((c == 'y' || c == 'z') &&
                (i == input.length() - 1 || !Character.isLetter(input.charAt(i + 1)))) {
                
                //increment the count
                count++;
            }
        }
        // Return the total count of 'y' and 'z'
        return count;
    }


    
    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        
        //Simplest solution:
        String result = base.replace(remove, "");
        return result;
        
        //this code works too: 


        // //initiate a string variable to hold the parts we want to store
        // String removed = "";

        // //Create variable to keep track of current position
        // int currentPos = 0;

        // //loop until we find the string that will be removed
        // while (currentPos<base.length()) {

        //     // Find the index of the next occurrence of the remove string
        //     int index = base.indexOf(remove, currentPos);

        //     // If the index is found, append the part before the index to the removed string
        //     if (index != -1) {
        //         removed = removed + base.substring(currentPos, index);

        //         // Update currentPos to the index after the found occurrence
        //         currentPos = index + remove.length();
        //     } else {
        //     // If no more occurrences are found, append the remaining part of the base string
        //     removed = removed + base.substring(currentPos);
        //     break;
        //     }
        // }
        // //return the modified string 
        // return removed;
    
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        
        // Initialize counters for "is" and "not"
        int countIs = 0;
        int countNot = 0;

        // Count occurrences of "is"
        int index = input.indexOf("is");
       // Loop through the string to count occurrences of "is"
        while (index != -1) {
            // Increment the count for "is"
            countIs++;
            // Find the next occurrence of "is"
            // Increment the index
            index = input.indexOf("is", index + 1);
        }

        // Count occurrences of "not"
        index = input.indexOf("not");
        // Loop through the string to count occurrences of "not"
        while (index != -1) {
            // Increment the count for "not"
            countNot++;
            // Find the next occurrence of "not"
            // Increment the index 
            index = input.indexOf("not", index + 1);
        }

        // Return true if counts are equal, false otherwise
        return countIs == countNot;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){

        // Initialize a boolean variable to track happiness
        boolean isHappy = true;

        // Iterate through the string
        for (int i = 0; i < input.length(); i++) {

            // Check if the current character is 'g'
            if (input.charAt(i) == 'g') {

                // Check the neighbors of 'g'
                
                // If the 'g' is at the end, check only the left character
                boolean leftIsG = (i > 0) && (input.charAt(i - 1) == 'g');

                // If the 'g' is at the start, check only the right character
                boolean rightIsG = (i < input.length() - 1) && (input.charAt(i + 1) == 'g');

                // If neither neighbor is 'g', set g to false and break the loop
                if (!leftIsG && !rightIsG) {
                    isHappy = false;
                    break;
                }
            }
        }

        // Return the final happiness status
        return isHappy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        // Initialize a counter for triples
        int count = 0;

        // Iterate through the string, stopping at the third-to-last character
        for (int i = 0; i < input.length() - 2; i++) {
            // Check if the current character and the next two characters are the same
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i + 2)) {
                // If they are, increment
                count++;
            }
        }

        // Return the total count of triples
        return count;
    }
}
