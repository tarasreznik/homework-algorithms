package sort.impl;

import model.Person;

import java.util.ArrayList;
import java.util.List;


public class FindUnique {

    // big O of this function is n
    public int find(Person[] input) {

        List<Person> output = new ArrayList<>();

        for (Person person : input) {
            addPerson(person, output);
        }

        return output.size();
    }


    /*
     * I don't really know how to count Big O of this function because
     *iteration of the output depends on our input array and if element will be added or not
     *It`s seems like progression
     */
    private void addPerson(Person p, List<Person> output) {
        if (output.isEmpty()) {
            output.add(p);
        } else {
            int count = 0;
            for (Person person : output) {
                if ((p.getWeight() != person.getWeight()) || (p.getWeight() == person.getWeight() && p.getHeight() != person.getHeight())) {
                    count++;
                }
            }
            if (count == output.size()) {
                output.add(p);
            }
        }
    }
}
