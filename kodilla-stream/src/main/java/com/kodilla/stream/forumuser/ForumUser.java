package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int idUser;
    private final String nameUser;
    private final char sexUser;
    private final LocalDate birthDateUser;
    private final int numberOfPosts;

    public ForumUser(int idUser, String nameUser, char sexUser, LocalDate birthDateUser, int numberOfPosts) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.sexUser = sexUser;
        this.birthDateUser = birthDateUser;
        this.numberOfPosts = numberOfPosts;

    }

    public int getIdUser() {
        return idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public char getSexUser() {
        return sexUser;
    }

    public LocalDate getBirthDateUser() {
        return birthDateUser;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "idUser= " + idUser +
                ", nameUser=' " + nameUser + '\'' +
                ", sexUser= " + sexUser +
                ", birthDateUser= " + birthDateUser +
                ", numberOfPosts= " + numberOfPosts +
                '}';
    }
}
