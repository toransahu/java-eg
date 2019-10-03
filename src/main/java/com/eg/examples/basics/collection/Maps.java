package com.eg.examples.basics.collection;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static void main(String[] args) {
        // increment Map's integer element by 1
        Map<String, Object> map = new HashMap<>();
        map.put("count", 0);
        System.out.println(map);
        map.compute("count", (k,v) -> (Integer)v + 1);
        System.out.println(map);
        map.compute("count", (k,v) -> (Integer)v + 1);
        System.out.println(map);
    }
}
