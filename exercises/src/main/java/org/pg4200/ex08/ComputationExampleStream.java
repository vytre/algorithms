package org.pg4200.ex08;

import org.pg4200.ex06.Book;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputationExampleStream implements ComputationExample {
    @Override
    public List<String> compute(List<Book> books) {

        return books.stream()
                .filter(book -> book.getYear() >=2010 && book.getYear() <=2015)
                .filter(book -> book.getAuthors().size() >= 2)
                .flatMap(book -> book.getAuthors().stream())
                .filter(author -> author.getName() != null && author.getSurname() != null)
                .map(author -> author.getName() + " "+ author.getSurname())
                .distinct()
                .collect(Collectors.toList());
    }
}
