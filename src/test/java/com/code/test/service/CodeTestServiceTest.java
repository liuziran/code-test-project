package com.code.test.service;

import com.code.test.exception.CodeTestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CodeTestServiceTest {

    @Test
    void testRemoveDuplicateCharacterShouldReturnCorrectValue(){
        CodeTestService service = new CodeTestService();
        String result1 = service.removeDuplicateCharacter("aabcccbbad");
        Assertions.assertEquals("d", result1);

        String result2 = service.removeDuplicateCharacter("aaabbcccbe");
        Assertions.assertEquals("e", result2);
    }

    @Test
    void testRemoveDuplicateCharacterShouldThrowExceptionWhenInputInValid(){
        CodeTestService service = new CodeTestService();
        Assertions.assertThrows(CodeTestException.class, ()-> service.removeDuplicateCharacter("123abc"));
    }

    @Test
    void testReplaceDuplicateCharacterShouldReturnCorrectValue(){
        CodeTestService service = new CodeTestService();
        String result1 = service.replaceDuplicateCharacter("abcccbad");
        Assertions.assertEquals("d", result1);

        String result2 = service.replaceDuplicateCharacter("abcccbaddfffahhhac");
        Assertions.assertEquals("c", result2);

        String result3 = service.replaceDuplicateCharacter("sssbcccbaaa");
        Assertions.assertEquals("", result3);
    }

    @Test
    void testReplaceDuplicateCharacterShouldThrowExceptionWhenInputInValid(){
        CodeTestService service = new CodeTestService();
        Assertions.assertThrows(CodeTestException.class, ()-> service.replaceDuplicateCharacter("123abc"));
    }
}
