package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.BookA;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.*;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<BookA> bookASet) {
        Map<BookSignature, BookB> books = new HashMap<>();
        for (BookA bookA : bookASet) {
            BookB bookB = new BookB(bookA.getAuthor()
                    , bookA.getTitle(), bookA.getPublicationYear());
            BookSignature bookSignature = new BookSignature(bookA.getSignature());
            books.put(bookSignature, bookB);
        }
        return medianPublicationYear(books);
    }
}
