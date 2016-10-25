package labs.lab1.p1;

class RomanConverter {
    /**
     * Roman to decimal converter
     *
     * @param n number in decimal format
     * @return string representation of the number in Roman numeral
     */
     static String toRoman(int n) {
         int[]    numbers = {1000 , 900 , 500, 400 , 100,  90 , 50 ,  40 , 10 ,   9 ,  5 ,   4  ,  1  };
         String[] letters = { "M" , "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",  "IV", "I" };

         String roman = "";
         int length = numbers.length;

         for (int i = 0; i < length; ++i) {
             while (n >= numbers[i]) {
                 roman += letters[i];
                 n -= numbers[i];
             }
         }

         return roman;
    }

}
