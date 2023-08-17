package org.josuejs.v12_collect;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("234-90", "Matrix", 2000, Genre.ACTION),
                new Book("231-91", "Lord of the Ring", 2001, Genre.FANTASY),
                new Book("212-90", "MIB", 2000, Genre.COMEDY),
                new Book("211-00", "30 years on lonelyness", 2002, Genre.FANTASY),
                new Book("211-00", "30 years on lonelyness", 2002, Genre.FANTASY)
        );

//        Set<Book> booksFiltred = books.stream()
//                .filter( book -> book.getYear() == 2002)
//                // With this way with select what tipe of datastructure we want to use to collect
//                .collect(Collectors.toCollection(TreeSet::new));
//                // On this way we use the default datastructure
//                // .collect(Collectors.toSet());

        Map<String, Book> booksMapped = books.stream()
                        .filter((book -> book.getYear() > 2000))
                        // To not repeat elements
                        //.distinct()
                        // By default return a HashMap
                        .collect(Collectors.toMap(Book::getId, Function.identity(),
                                (book1, book2)-> new Book( book1.getId(),
                                        book1.getName(),
                                        book1.getYear(),
                                        book1.getGenre()),
                                // As third parameter we can pass a factory collector
                                TreeMap::new));
        Book[] arrayBooks = books.stream()
                        .filter(book -> book.getGenre() ==Genre.FANTASY)
                        .toArray(Book[]::new);

        Arrays.stream(arrayBooks)
                        .forEach(System.out::println);

        System.out.println(booksMapped);

        //Collecting or joining a stream o string
        String booksNames = books.stream().distinct()
                .map(Book::getName)
                .collect(Collectors.joining(", ","[ ", " ]"));
        System.out.println(booksNames);

        //Grouping collection
        Map<Integer, String> booksGrouped = books.stream()
                .collect(Collectors
                        .groupingBy(
                                //Term to group
                                Book::getYear,
                                //Create a supplier to escepify the data structure
                                TreeMap::new,
                                //DownStream
                                Collectors.mapping(
                                        Book::getName,
                                        Collectors.joining(""))));
        System.out.println("booksGrouped = " + booksGrouped);

        // Counting a group
        Map<Integer, Long> countinByGroup = books.stream()
                .collect(Collectors.groupingBy(Book::getYear, Collectors.counting()));
        System.out.println("countinByGroup = " + countinByGroup);

        // Summing values
        Map<Genre, Integer> sumingYears = books.stream().collect(Collectors.groupingBy(Book::getGenre,
                Collectors.summingInt(Book::getYear)));
        System.out.println(sumingYears);

        // Getting min or Max
        Map<Genre, Optional<Book>> minBook = books.stream().collect(Collectors.groupingBy(Book::getGenre,
                Collectors.minBy(Comparator.comparing(Book::getYear))));
        System.out.println("minBook = " + minBook);

        //Gettin statistic
        Map<Genre, IntSummaryStatistics> statisticsBook = books.stream().collect(Collectors.groupingBy(Book::getGenre,
                Collectors.summarizingInt(Book::getYear)));

        System.out.println("statisticsBook = " + statisticsBook);
        
        //Partitioning stream
        Map<Boolean, Long> booksAfter = books.stream().collect(Collectors.partitioningBy(book -> book.getYear() > 2000,
                Collectors.counting()));
        System.out.println("booksAfter.get(false) = " + booksAfter.get(false));
        System.out.println("booksAfter.get(true) = " + booksAfter.get(true));
        
        //Books by genre
        Map<Genre, Long> booksByGenre = books.stream()
                .filter(book -> book.getYear() > 2000)
                .collect(Collectors
                .groupingBy(Book::getGenre, Collectors.counting()));

        //Another way but filtering after grouping

        Map<Genre, Long> booksByGenre2 = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.filtering(book -> book.getYear() > 2000, Collectors.counting())));

        System.out.println("booksByGenre = " + booksByGenre);
        System.out.println("booksByGenre2 = " + booksByGenre2);

        // Sorting
        List<Book> sorted = books.stream()
                .sorted(Comparator.comparingInt(Book::getYear))
                .toList();
        System.out.println("sorted = " + sorted);

        //Advanced Sorting
        books.stream()
                .sorted(Comparator.comparing(Book::getName, Comparator.reverseOrder()).thenComparing(Book::getYear))
                .forEach(System.out::println);
        
    }


}
