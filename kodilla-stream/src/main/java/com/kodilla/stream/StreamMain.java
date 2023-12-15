package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("7.3 Stream");


        Forum forum = new Forum();

        Map<Integer, ForumUser> theResultStringOfUser = forum.getList().stream()
                .filter(sex -> sex.getSexUser() == 'M')
                .filter(date -> Period.between(date.getBirthDateUser(),LocalDate.now()).getYears() > 20)
                .filter(post -> post.getNumberOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getIdUser,forumUser -> forumUser));

        theResultStringOfUser.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);





    }
}