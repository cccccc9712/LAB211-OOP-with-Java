/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.lang.*;
/**
 *
 * @author tmtmt
 */
public class binaryAndDecimal {
    public String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2;
        }

        return binary.toString();
    }

    public int binaryToDecimal(int binary) {
        String numberStr = Integer.toString(binary);
        int[] digits = new int[numberStr.length()];
        int result = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Integer.parseInt(Character.toString(numberStr.charAt(i)));
        }

        int n = numberStr.length() - 1;

        for (int i = 0; i < numberStr.length(); i++) {
            result += digits[i] * Math.pow(2, n);
            n--;
        }

        return result;
    }
}
