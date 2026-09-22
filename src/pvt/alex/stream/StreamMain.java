package pvt.alex.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Goku", 35));
        personList.add(new Person("Vegeta", 38));
        personList.add(new Person("Gohan", 26));
        personList.add(new Person("Trunks", 13));
        personList.add(new Person("Goten", 11));

        /* List<Person> minors = new ArrayList<>();
        for (Person p : personList) {
            if (p.getAge() < 18) {
                minors.add(p);
            }
        } */

        /** Esempio con "filter"
         * FILTRA gli elementi dello stream, sulla base del predicato fornito.
         * */
        List<Person> minorsStream = personList
                .stream()
                .limit(2) //server per prendere i primi "n" record della collection
                .filter(p -> p.getAge() < 18)
                .toList();

        minorsStream.forEach(p -> System.out.println(p.toString()));
        System.out.println("############################################");

        /** Esempi:
         * "sorted" -> ORDINA gli elementi dello stream, secondo il Comparator fornito (vedi ".comperTo()" di String).
         * "map" -> MANIPOLA gli elementi dello stream, con la funzione applicata
         * */
        List<String> personNames = personList
                .stream()
                .sorted(Comparator.comparing(Person::getName)) //(p1, p2) -> p1.getName().compareTo(p2.getName())
                .map(p -> p.getName())
                .toList();

        personNames.forEach(p -> System.out.println(p));
        System.out.println("############################################");

        List<Company> companies = new ArrayList<>();
        companies.add(new Company("Amazon", new ArrayList<>() {{
            add(new Person("john", 40));
            add(new Person("Philip", 34));
        }}));
        companies.add(new Company("Apple", new ArrayList<>() {{
            add(new Person("Nora", 26));
            add(new Person("Carla", 57));
        }}));
        companies.add(new Company("Google", new ArrayList<>() {{
            add(new Person("Chris", 41));
            add(new Person("Martha", 22));
        }}));

        companies.stream()
                .map(Company::getCompanyName)
                .forEach(System.out::println);

        System.out.println("############################################");

        /** Esempio con "flatMap"
         * serve per accedere a Stream annidati
         * */
        String s = companies.stream()
                .flatMap(company -> company.getEmployees().stream())
                .filter(employee -> employee.getAge() < 40)
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .collect(Collectors.joining(", ")); //Colleziona gli elementi dello Stream in un'unica Stringa

        System.out.println(s);
    }
}
