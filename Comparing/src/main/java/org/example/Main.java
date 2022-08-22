package org.example;


import lombok.Data;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Data
class A {
    int a;
    int b;

    @Override public String toString() {
        return a + " " + b + "\n";
    }
}

public class Main {
    public static void main(String[] args) {
        A a1 = new A();
        a1.a = 2;
        a1.b = 3;
        A a2 = new A();
        a2.a = 2;
        a2.b = 4;
        A a3 = new A();
        a3.a = 2;
        a3.b = 5;
        A a4 = new A();
        a4.a = 3;
        a4.b = 90;
        A a5 = new A();
        a5.a = 3;
        a5.b = 8;
        A a6 = new A();
        a6.a = 3;
        a6.b = 300;
        A a7 = new A();
        a7.a = 3;
        a7.b = -7;
        A a8 = new A();
        a8.a = 1;
        a8.b = 100;


        Comparator<A> comparator = (o1, o2) -> {
            Integer x1 = o1.a;
            Integer x2 = o2.a;
            int sComp = x1.compareTo(x2);

            if (sComp != 0) {
                return sComp;
            }

            Integer y1 = o1.b;
            Integer y2 = o2.b;
            return y1.compareTo(y2);
        };

        Comparator<A> comparator2 =
                Comparator.comparing(A::getA).thenComparing(A::getB);

        Set<A> lst = new TreeSet<>(comparator2);

        lst.add(a1);
        lst.add(a2);
        lst.add(a3);
        lst.add(a4);
        lst.add(a5);
        lst.add(a6);
        lst.add(a7);
        lst.add(a8);

        System.out.println(lst.stream().

                map(Object::toString).

                collect(Collectors.joining("")));

    }

    ;
}