package test;

import java.util.List;

class Demo1 {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo1(String name) {
        this.name = name;
    }
}

class Demo2 {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo2(String name) {
        this.name = name;
    }
}

public class JavaTest {

    public static void main(String[] args) {
        List<Demo1> demo1s = List.of(new Demo1("D1"), new Demo1("D11"));
        List<Demo2> demo2s = List.of(new Demo2("D2"), new Demo2("D22"));


    }
}
