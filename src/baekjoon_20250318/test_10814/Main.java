package baekjoon_20250318.test_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final Comparator<Person> AGE_COMPARATOR = Comparator.comparingInt(p -> p.age);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < loop; i++) {
            Object[] param = Arrays.stream(br.readLine().split(" ")).toArray();
            persons.add(new Person(Integer.parseInt(String.valueOf(param[0])), String.valueOf(param[1])));
        }

        List<Person> arrayPersons = persons.stream()
                                           .sorted(AGE_COMPARATOR)
                                           .collect(Collectors.toList());

        for (Person person : arrayPersons) {
            System.out.println(person.age + " " + person.name);
        }
    }

    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
