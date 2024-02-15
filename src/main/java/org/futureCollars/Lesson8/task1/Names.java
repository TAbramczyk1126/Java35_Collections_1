package org.futureCollars.Lesson8.task1;

import java.util.*;

public class Names {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Katarzyna");
        names.add("Tymon");
        names.add("Tadeusz");
        names.add("Anna");
        names.add("Karolina");
        names.add("Dorota");
        names.add("Piotr");

        Set<String> uniqueNamesSet = new HashSet<>(names);
        System.out.println(uniqueNamesSet);

        Collections.reverse(names);
        System.out.println(names);

        String oldName = "Anna";
        String newName = "Joanna";
        names.replaceAll(name -> name.equals(oldName) ? newName : name);
        System.out.println(names);
    }
}
