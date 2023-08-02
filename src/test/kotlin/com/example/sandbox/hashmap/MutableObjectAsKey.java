package com.example.sandbox.hashmap;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MutableObjectAsKey {

    @Test
    void testWithoutMutation() {
        Map<DataKey, String> map = new HashMap<>();
        DataKey dataKey = new DataKey(1, "initial name");
        map.put(dataKey, "some value");

        assertNotNull(map.get(dataKey));
    }

    @Test
    void testWithMutation() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1, 0);

        Map<DataKey, String> map = new HashMap<>();
        DataKey dataKey = new DataKey(1, "initial name");
        map.put(dataKey, "some value");

        dataKey.setName("new name");

        assertNull(map.get(dataKey));
    }

    static class DataKey {
        private Integer id;
        private String name;

        public DataKey(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DataKey dataKey = (DataKey) o;
            return Objects.equals(id, dataKey.id) && Objects.equals(name, dataKey.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}
