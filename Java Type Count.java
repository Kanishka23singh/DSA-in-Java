/*To solve this problem, we need to parse the given string and classify each token as an integer, double, or string. We'll break the input string into tokens separated by spaces, then determine the type of each token.

Here's the approach we'll take:

1. **Tokenize the Input String**:
   - Split the input string by one or more spaces to get individual tokens.

2. **Classify Each Token**:
   - Check if a token is an integer.
   - If it's not an integer, check if it's a double.
   - If it's neither an integer nor a double, classify it as a string.

3. **Count the Number of Each Type**:
   - Maintain counters for integers, doubles, and strings.

### Implementation:

Here's a Java program that implements the above approach:

```java
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String input = "42 3.14 hello world 100 2.71828 123abc";
        countTypes(input);
    }

    public static void countTypes(String s) {
        // Split the string by one or more spaces
        String[] tokens = s.trim().split("\\s+");

        int integerCount = 0;
        int doubleCount = 0;
        int stringCount = 0;

        for (String token : tokens) {
            if (isInteger(token)) {
                integerCount++;
            } else if (isDouble(token)) {
                doubleCount++;
            } else {
                stringCount++;
            }
        }

        System.out.println("Integers: " + integerCount);
        System.out.println("Doubles: " + doubleCount);
        System.out.println("Strings: " + stringCount);
    }

    // Check if a string is an integer
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Check if a string is a double
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


/*
```

### Explanation:

1. **Tokenize the Input String**:
   - `String[] tokens = s.trim().split("\\s+");`
     - `s.trim()` removes any leading or trailing whitespace.
     - `split("\\s+")` splits the string by one or more spaces.

2. **Classify Each Token**:
   - We iterate through each token and use helper methods `isInteger` and `isDouble` to classify them.
   - `isInteger` and `isDouble` use `parseInt` and `parseDouble` respectively, and catch `NumberFormatException` to determine if the parsing was successful.

3. **Count the Number of Each Type**:
   - Based on the result of the helper methods, we increment the respective counters (`integerCount`, `doubleCount`, `stringCount`).

### Example Output:

For the input `input = "42 3.14 hello world 100 2.71828 123abc"`, the output will be:
```
Integers: 2
Doubles: 2
Strings: 3
```

This approach ensures that we correctly classify and count integers, doubles, and strings from a given input string separated by spaces.
*/
