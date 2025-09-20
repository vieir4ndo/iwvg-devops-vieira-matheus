package es.upm.miw.devops.code;

import java.util.List;
import java.util.stream.Stream;

public class UsersDatabase {

    public Stream<User> findAll() {

        List<Fraction> fractions1 = List.of(

        );
        List<Fraction> fractions2 = List.of(

        );
        List<Fraction> fractions3 = List.of(

        );
        List<Fraction> fractions4 = List.of(

        );
        List<Fraction> fractions5 = List.of(

        );

        List<Fraction> fractions6 = List.of(

        );

        return Stream.of(
                new User("1", "Oscar", "Fernandez", fractions1),
                new User("2", "Ana", "Blanco", fractions2),
                new User("3", "Oscar", "López", fractions3),
                new User("4", "Paula", "Torres", fractions4),
                new User("5", "Antonio", "Blanco", fractions5),
                new User("6", "Paula", "Torres", fractions6)
        );
    }
}