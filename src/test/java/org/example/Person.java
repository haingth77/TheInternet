package org.example;

public class Person {

    String name;
    String height;
    String mass;
    String hairColor;
    String skinColor;
    String eyeColor;
    String birthYear;
    String gender;

    public Person(String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
    }
    
    public Person(){}
    public void info(){
        System.out.println(this.name);
        System.out.println(this.height);
        System.out.println(this.mass);
        System.out.println(this.hairColor);
        System.out.println(this.skinColor);
        System.out.println(this.eyeColor);
        System.out.println(this.birthYear);
        System.out.println(this.gender);
    }

    public String getName () {
        System.out.println(name);
        return name;
    }

    public String getHeight() {
        return height;
    }

    public int getMass() {
        return Integer.parseInt(mass);
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }
}
