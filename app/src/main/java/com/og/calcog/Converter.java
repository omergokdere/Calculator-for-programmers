package com.og.calcog;

/**
 * Created by OG on 08/03/2016.
 */
import android.util.Log;

public class Converter {
    public static String ConvertInt(String number, int FromBase, int ToBase) {
        if (number == "") {
            return "";
        }
        return ConvertToBase(ConvertToDecimal(number, FromBase), ToBase);
    }
    private static int ConvertToDecimal(String number, int FromBase) {
        int result = 0;

        for (int i = 0; i < number.length(); i++) {
            result = result * FromBase + DigitConvertToInt(number.charAt(i));
        }
        return result;
    }
    private static String ConvertToBase(int number, int base) {
        String result = "";
        while (number != 0) {
            int remainder = number % base;
            result += DigitConvertToChar(remainder);
            number /= base;
        }
        return new StringBuilder(result).reverse().toString();
    }

    private static int DigitConvertToInt(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        return c - 'a' + 10;
    }
    private static char DigitConvertToChar(int d) {
        if (0 <= d && d <= 9) {
            return (char)(d + '0');
        }
        return (char)(d + 'a' - 10);
    }
}
