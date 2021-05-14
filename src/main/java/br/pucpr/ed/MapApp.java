package br.pucpr.ed;

import br.pucpr.ed.map.Map;
import br.pucpr.ed.map.OrderedMap;

public class MapApp {

    public static void main(String[] args) {
        Map<String, Integer> myMap = new OrderedMap<>();
        myMap.put("map", 1);
        myMap.put("test", 4);
        myMap.put("pom.xml", 2);
        myMap.put("java", 5);
        Integer test = myMap.remove("test");
        System.out.println(myMap.get("map"));
        System.out.println(myMap.get("teste"));
        System.out.println(myMap.keySet());
        System.out.println(myMap.values());
        System.out.println(myMap.entrySet());
    }
}
