package org.futureCollars.lesson8.task4;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Set<Person> persons = new TreeSet<>();
        persons.add(new Person("Tomasz", "Kowalski", 1984, 174, 75));
        persons.add(new Person("Adam", "Marciniuk", 1970, 188, 90));
        persons.add(new Person("Piotr", "Citko", 1990, 176, 70));
        persons.add(new Person("Krzysztof", "Trybka", 1977, 160, 60));

        Comparator<Person> heightComparator = Comparator.comparingInt(Person::getHeight);
        Comparator<Person> weightComparator = Comparator.comparingInt(Person::getWeight).reversed();

        Set<Person> personListByHeight = new TreeSet<>(heightComparator);
        personListByHeight.addAll(persons);

        Set<Person> personListByWeight = new TreeSet<>(weightComparator);
        personListByWeight.addAll(persons);

        System.out.println("Person list by height from lowest to highest");
        for (Person people : personListByHeight) {
            System.out.println(people.getName() + " " + people.getSurname() + " " + people.getYearOfBirth() + " " +people.getHeight() + " " + people.getWeight());
        }

        System.out.println("Person list by weight from heaviest to lightest");
        for (Person people : personListByWeight) {
            System.out.println(people.getName() + " " + people.getSurname() + " " + people.getYearOfBirth() + " " +people.getHeight() + " " + people.getWeight());
        }

        System.out.println("Person list by age from the youngest to the oldest");
        for (Person people : persons) {
            System.out.println(people.getName() + " " + people.getSurname() + " " + people.getYearOfBirth() + " " +people.getHeight() + " " + people.getWeight());
        }
    }
}
