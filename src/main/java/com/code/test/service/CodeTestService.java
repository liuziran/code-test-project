package com.code.test.service;

import com.code.test.exception.CodeTestException;

public class CodeTestService {

    public String removeDuplicateCharacter(String input) {
        validateInput(input);

        StringBuilder stringBuilder = new StringBuilder();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            int size = stringBuilder.length();
            if (hit3SameLetter(i, size, stringBuilder, input)) {
                stringBuilder.delete(size-2, size);
            } else {
                stringBuilder.append(input.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public String replaceDuplicateCharacter(String input) {
        validateInput(input);

        StringBuilder stringBuilder = new StringBuilder();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            int size = stringBuilder.length();
            if (hit3SameLetter(i, size, stringBuilder, input)) {
                stringBuilder.delete(size-2, size);
                if (size>2) {
                    stringBuilder.append(stringBuilder.charAt(stringBuilder.length()-1));
                    size = stringBuilder.length();
                    if (size == 3) {
                        char charAt = stringBuilder.charAt(0);
                        char[] charArray = {charAt, charAt, charAt};
                        String temp = String.valueOf(charArray);
                        if (temp.contentEquals(stringBuilder)){
                            stringBuilder.delete(0,size);
                        }
                    }
                }
            } else {
                stringBuilder.append(input.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private boolean hit3SameLetter(int index, int size, StringBuilder stringBuilder, String input) {
        return size > 1 && stringBuilder.charAt(size-2) == input.charAt(index)
                && stringBuilder.charAt(size-1) == input.charAt(index);
    }

    private void validateInput(String input) {
        String LETTER_REGEX = "[a-zA-Z]+";

        if (!input.matches(LETTER_REGEX)){
            throw new CodeTestException("Please enter the correct letter.");
        }
    }
}
