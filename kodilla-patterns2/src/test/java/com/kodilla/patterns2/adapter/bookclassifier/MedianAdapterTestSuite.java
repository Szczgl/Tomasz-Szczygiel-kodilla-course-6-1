package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.BookA;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {

        //GIVEN
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<BookA> bookA = new HashSet<>();

        BookA book1 = new BookA("Kowalski1","Nowa1", 2000, "signature1");
        BookA book2 = new BookA("Kowalski2","Nowa2", 2010, "signature2");
        BookA book3 = new BookA("Kowalski3","Nowa3", 2020, "signature3");


        bookA.add(book1);
        bookA.add(book2);
        bookA.add(book3);

        //THEN
        int result = medianAdapter.publicationYearMedian(bookA);

        //THEN
        assertEquals(2010,result);
     }
}
