package test;

import revision.arrays.Solution;

import javax.sound.midi.Soundbank;
import java.io.*;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class SerializationDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person("chaman", 20);
        FileOutputStream fileOutputStream = new FileOutputStream("obj.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(p);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("obj.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person p2 = (Person) objectInputStream.readObject();
        objectOutputStream.close();
        System.out.println("P1 " + p);
        System.out.println("P2 " + p2);


    }
}


