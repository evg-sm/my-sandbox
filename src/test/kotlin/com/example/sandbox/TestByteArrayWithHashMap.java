package com.example.sandbox;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestByteArrayWithHashMap {

    @Test
    void testWithReference() {
        byte[] array1 = new byte[1];
        Map<byte[], String> map = new HashMap<>();

        map.put(array1, "some value");
        String mapValue = map.get(array1);

        assertNotNull(mapValue);
    }

    @Test
    void assertSameByteArraysNotEquals() {
        byte[] array1 = new byte[1];
        byte[] array2 = new byte[1];

        assertNotEquals(array1, array2);
    }

    @Test
    void assertSameByteArraysHashCodesNotEquals_1() {
        byte[] array1 = new byte[1];
        byte[] array2 = new byte[1];

        assertNotEquals(array1.hashCode(), array2.hashCode());
    }

    @Test
    void assertSameByteArraysHashCodesEqualsAsArraysHashCode() {
        byte[] array1 = new byte[1];
        byte[] array2 = new byte[1];

        assertEquals(Arrays.hashCode(array1), Arrays.hashCode(array2));
    }
}
