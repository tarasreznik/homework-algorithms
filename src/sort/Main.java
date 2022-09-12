package sort;

import model.Person;
import sort.impl.FindUnique;
import sort.impl.SortByAge;
import sort.impl.UniversalSort;

import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Person(190, 86, 21),
                new Person(174, 86, 56),
                new Person(174, 86, 34),

                new Person(180, 80, 43),
                new Person(155, 55, 11),//5

                new Person(195, 120, 34),
                new Person(181, 84, 25),
                new Person(174, 74, 36),

                new Person(171, 64, 75),
                new Person(154, 44, 12),//10


        };


        SortByAge personSort = new SortByAge();

        long before = System.currentTimeMillis();
        Person[] result1 = personSort.sort(people);



        System.out.println("Sorting by age");
        for (Person person : result1) {
            System.out.println(person);
        }

        System.out.println("--------------------------------------------\n");

        UniversalSort uniSort = new UniversalSort();
        Person[] result2 = uniSort.sort(people, Comparator.comparingInt(Person::getWeight));
        System.out.println("Universal sort");
        for (Person person : result2) {
            System.out.println(person);
        }

        System.out.println("--------------------------------------------\n");

        FindUnique uniFinder = new FindUnique();
        System.out.println("Count unique");
        int count = uniFinder.find(people);
        System.out.println("Count of unique elements is : " + count);

    }


}

