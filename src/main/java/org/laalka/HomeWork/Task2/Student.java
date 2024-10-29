package org.laalka.HomeWork.Task2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.*;
import java.util.Random;

public class Student implements Serializable/*Externalizable*/ {
    private String name;
    private int age;
    private Random rand = new Random();

    @JsonIgnore
    private transient double GPA;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.GPA = Math.round(rand.nextDouble(2, 5) * 100D) / 100D;
    }

    /*@Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt(); // не приводим, так как читаем примитив
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }


}
