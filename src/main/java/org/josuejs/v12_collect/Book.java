package org.josuejs.v12_collect;

import java.util.Objects;

public class Book implements Comparable<Book> {

    private final String id;
    private final String name;
    private final int year;
    private final Genre genre;

    public Book(String id, String name, int year, Genre genre) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(year);
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId().equals(book.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public int compareTo(Book book){
        return name.compareTo(book.getName());
    }
}
