package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given

        Book book1 = new Book("book1", "author1", LocalDate.of(2000,11,1));
        Book book2 = new Book("book2", "author2", LocalDate.of(2001,11,1));
        Book book3 = new Book("book3", "author3", LocalDate.of(2002,11,1));
        Book book4 = new Book("book4", "author4", LocalDate.of(2003,11,1));
        Book book5 = new Book("book5", "author5", LocalDate.of(2004,11,1));

        Library library = new Library("First Library");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        Library cloneLibrary = null;
        try {
            cloneLibrary = library.shallowCopy();
            cloneLibrary.setName("Second Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepLibrary = null;
        try {
            deepLibrary = library.deepCopy();
            deepLibrary.setName("Third Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book5);

        //Then
        assertEquals(4, library.getBooks().size());
        assertEquals(4, cloneLibrary.getBooks().size());
        assertEquals(5, deepLibrary.getBooks().size());
        assertEquals(library.getBooks(),cloneLibrary.getBooks());
        assertNotEquals(deepLibrary.getBooks(),library.getBooks());

        System.out.println(library.getName());
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }

        System.out.println(cloneLibrary.getName());
        for (Book book : cloneLibrary.getBooks()) {
            System.out.println(book);
        }

        System.out.println(deepLibrary.getName());
        for (Book book : deepLibrary.getBooks()) {
            System.out.println(book);
        }
    }
}
