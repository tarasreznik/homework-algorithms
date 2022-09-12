package sort.impl;

import model.Person;

/*
 * Big O is - O(n)
 * I made my personal research for this task.
 * I created about 3000 instances of class Person and sorted them by different sorting algorithms.
 * The best was Merge Sort. It's space complexity is lineal function what is pretty good.
 */
public class SortByAge {

    public Person[] sort(Person[] people) {
        mergeSort(0, people.length - 1, people);
        return people;
    }

    private void mergeSort(int begin, int end, Person[] people) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(begin, mid, people);
            mergeSort(mid + 1, end, people);
            merge(begin, mid, end, people);
        }
    }

    private void merge(int begin, int mid, int end, Person[] people) {
        int n1 = mid - begin + 1;
        int n2 = end - mid;
        Person[] left = new Person[n1];
        Person[] right = new Person[n2];
        System.arraycopy(people, begin, left, 0, n1);

        for (int j = 0; j < n2; j++) {
            right[j] = people[mid + j + 1];
        }

        int k = begin;
        int i = 0;
        int j = 0;

        while (i < n1 && j < n2) {
            if (compare(left[i], right[j]) <= 0) {
                people[k] = left[i];
                i++;
            } else {
                people[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            people[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            people[k] = right[j];
            j++;
            k++;
        }
    }

    public static int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}