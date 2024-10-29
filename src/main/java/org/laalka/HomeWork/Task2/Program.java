package org.laalka.HomeWork.Task2;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class Program {

    private final static String FILE_JSON = "student.json";
    private final static String FILE_XML = "student.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) {
        Student student = new Student("Nickita", 24);
        System.out.println(student);

        saveInFile(student, FILE_JSON);
        saveInFile(student, FILE_XML);

        Student jsonStudent = loadFromFile(FILE_JSON);
        System.out.println(jsonStudent);

        Student xmlStudent = loadFromFile(FILE_XML);
        System.out.println(xmlStudent);

    }

    public static void saveInFile(Student student, String fileName) {
        try {
            if(fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), student);
            }else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), student);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Student loadFromFile(String fileName) {
        Student student = null;
        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    student = objectMapper.readValue(file, Student.class);
                } else if (fileName.endsWith(".xml")) {
                    student = xmlMapper.readValue(file, Student.class);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
