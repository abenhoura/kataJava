package org.kata;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumerals {
    public static final String EMPTY_STRING = "";
    public static final String I = "I";
    public static final String V = "V";
    public static final String X = "X";
    public static final String D = "D";
    public static final String C = "C";
    public static final String M = "M";
    public static final String L = "L";

    Map<Integer, String> map = Map.of(1000, M, 500, D, 100, C, 50, L,10,X, 5,V, 1, I);

    public String convert(int number) {
        var ordredMap = new TreeMap<Integer, String>(Comparator.reverseOrder());
        ordredMap.putAll(map);

        StringBuilder result = new StringBuilder(EMPTY_STRING);

        while (number>0) {
            for (Map.Entry<Integer, String> entry : ordredMap.entrySet()) {
                if(number == 1000) {
                    result.append("M");
                    number -= 1000;
                    break;
                }
                int numberDivideBy9 = number / 9;
                boolean isMultipleOf9 = numberDivideBy9 % 10 == 0 && numberDivideBy9 != 0;
                if(isMultipleOf9 || number == 9 ) {
                    int i = number / 9;
                    int max = 10 * i;
                    number -= max-i;

                    result.append(ordredMap.get(i) + ordredMap.get(max));
                    break;
                }
                int numberDivideBy4 = number / 4;
                boolean isMultipleOf4 = numberDivideBy4 % 10 == 0 && numberDivideBy4 != 0;
                if((isMultipleOf4) || number == 4 ) {
                    int i = number / 4;
                    int max = 5 * i;
                    number -= max-i;

                    result.append(ordredMap.get(i) + ordredMap.get(max));
                    break;
                }


                if (number >= entry.getKey()) {
                    number -= entry.getKey();
                    result.append(entry.getValue());
                    break;
                }
            }
        }

        return result.toString();
    }
}
