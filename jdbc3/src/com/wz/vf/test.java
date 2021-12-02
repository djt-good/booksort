package com.wz.vf;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        map.put("tom","123");
        boolean tom = map.containsKey("tom");
    }
}
