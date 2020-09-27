package streams.java;

import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {
        List<Person> persons = getPersons();


        //FILTER
        System.out.println("Filter");
        List<Person> females = persons.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
        females.forEach(person -> System.out.println(person));

        //SORT
        System.out.println("\n" + "Sort");
        List<Person> sortByAge = persons.stream()
                .sorted(Comparator.comparing(person -> person.getAge())).collect(Collectors.toList());
        sortByAge.forEach(System.out::println);

        //ALLMATCH
        boolean isEveryoneAbove18 = persons.stream()
                .allMatch(person -> person.getAge() > 18);
        System.out.println("\n" + "Is everyone's age above 18 " + isEveryoneAbove18);

        //ANYMATCH
        boolean isAnyoneAbove18 = persons.stream()
                .anyMatch(person -> person.getAge() > 18);
        System.out.println("\n" + "Is anyone's age above 18 " + isAnyoneAbove18);

        //NONMATCH
        boolean isNoOneWithAge19 = persons.stream()
                .noneMatch(person -> person.getAge() == 19);
        System.out.println("\n" + "Is no ones's age equals 19 " + isNoOneWithAge19);

        //MAX
        System.out.print("\n" + "Person with maximum age: ");
        persons.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);

        //MIN
        System.out.print("\n" + "Person with minimum age: ");
        persons.stream().min(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);

        //GROUP
        System.out.println("Group By Gender");
        Map<Gender, List<Person>> groupByGender = persons.stream().collect(Collectors.groupingBy(person -> person.getGender()));
        groupByGender.forEach(
                (gender, people) -> {
                    System.out.println(gender);
                    people.forEach(System.out::println);
                    System.out.println();

                }
        );


        //Chaining the stream() : FInd the oldest female person
        System.out.print("\n" + "Oldest Female among all people: ");
        persons.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(person -> person.getAge()))
                .map(Person::getName)
                .ifPresent(System.out::println);

    }

    private static List<Person> getPersons() {
        return List.of(
                new Person("Sruti", 52, Gender.FEMALE),
                new Person("Ankit", 43, Gender.MALE),
                new Person("Auro", 46, Gender.MALE),
                new Person("Shalini", 18, Gender.FEMALE)
        );
    }
}
