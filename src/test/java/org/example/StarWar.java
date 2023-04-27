package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StarWar {
    public static void main(String[] args) {
        Person Darth_Vader = new Person(
                "Darth Vader",
                "202",
                "316",
                "none",
                "white",
                "yellow",
                "42.9BBY",
                "male");

        Person Luke_Skywalker = new Person(
                "Luke Skywalker",
                "172",
                "77",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male");

        Person Leia_Organa= new Person(
                "Leia Organa",
                "150",
                "49",
                "brown",
                "light",
                "brown",
                "19BBY",
                "male");

        Person Owen_Lars= new Person(
                "Owen Lars",
                "178",
                "120",
                "brown, grey",
                "light",
                "blue",
                "52BBY",
                "male");

        Person Beru_Whitesun_lars = new Person(
                "Beru Whitesun lars",
                "165",
                "75",
                "brown",
                "light",
                "blue",
                "47BBY",
                "female"
        );

        Person Biggs_Darklighter = new Person(
                "Biggs Darklighter",
                "183",
                "84",
                "black",
                "light",
                "brown",
                "24BBY",
                "male"
        );

        Person Obi_Wan_Kenobi = new Person(
                "Obi-Wan Kenobi",
                "182",
                "77",
                "auburn, white",
                "fair",
                "blue-gray",
                "57BBY",
                "male"
        );


        List<Person> stars = Arrays.asList(Darth_Vader, Luke_Skywalker, Leia_Organa, Owen_Lars, Beru_Whitesun_lars, Biggs_Darklighter, Obi_Wan_Kenobi);
        //stars.forEach(Person::info);

        List<Person> personHasMassGreater100 = stars
                .stream()
                .filter(star -> star.getMass() >100)
                .collect(Collectors.toList());
        personHasMassGreater100.forEach(Person::getName);

        int totalMass = stars.stream()
                .mapToInt(Person::getMass)
                .sum();
        System.out.println(totalMass);

        stars
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
