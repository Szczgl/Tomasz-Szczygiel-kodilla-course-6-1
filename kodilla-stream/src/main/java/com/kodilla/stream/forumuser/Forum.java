package com.kodilla.stream.forumuser;

import com.kodilla.stream.book.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(0001, "Dylan Murphy", 'M',
                LocalDate.of(2005,1,1), 1));
        theUserList.add(new ForumUser(0002, "Phoebe Pearson", 'F',
                LocalDate.of(2004,4,12), 12));
        theUserList.add(new ForumUser(0003, "Morgan Walsh", 'F',
                LocalDate.of(1980,7,30), 0));
        theUserList.add(new ForumUser(0004, "Aimee Murphy", 'F',
                LocalDate.of(1945,9,20), 105));
        theUserList.add(new ForumUser(0005, "Ryan Talley", 'M',
                LocalDate.of(1999,11,4), 0));
        theUserList.add(new ForumUser(0006, "Madelynn Carson", 'F',
                LocalDate.of(2001,3,18), 31));
        theUserList.add(new ForumUser(0007, "Giancarlo Guerrero", 'M',
                LocalDate.of(1987,5,11), 205));
    }

    public List<ForumUser> getList() {
        return new ArrayList<>(theUserList);
    }
}

