package org.laalka.HomeWork.Task1;

import java.io.*;

public class Program {

    public static void main(String[] args) {
        Student student = new Student("Никита", 25, 4.75);
        System.out.println(student);
        String fileName = "student.bin";
        writeToFile(student, fileName);
        student = readFromFile(fileName);
        System.out.println(student);
//        System.out.println(readFromFile(fileName));

         /*
         * Итог - Student{name='Никита', age=25, GPA=0.0}
         * GPA=0.0
         * Так как при сериализации, GPA не был найден, потому что данное поле помечено transient
         * и JVM присвоила ему дефолтное значение примитива double 0.0
         * */
        System.out.println("\n===========================================\n" +
                "Итог - Student{name='Никита', age=25, GPA=0.0}\n" +
                "GPA=0.0\n" +
                "Так как при сериализации, GPA не был найден, потому что данное поле помечено transient" +
                " и JVM присвоила ему дефолтное значение примитива double 0.0");
    }

    public static void writeToFile(Object obj, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            System.out.println("Объект сериализован!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student readFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Student student = (Student) ois.readObject();
            System.out.println("Объект десериализован!");
            return student;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
