package com.kodilla.stream.forum;

import java.util.*;
import java.util.stream.Collectors;

public final class ForumUser {

    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(final String username,final String realName,final String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public Set<String> getLocationsOfFriends() {
        return friends.stream()
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }

    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()
                .flatMap(user -> user.getFriends().stream())
                .filter(user -> user != this)
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }

    public void addFriend(ForumUser user) {
        friends.add(user);
    }

    public boolean removeFriend(ForumUser user) {
        return friends.remove(user);
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username= '" + username + '\'' +
                ", realName= '" + realName + '\'' +
                ", location= '" + location + '\'' +
                ", friends= " + friends +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ForumUser forumUser)) return false;

        if (getUsername() != null ? !getUsername().equals(forumUser.getUsername()) : forumUser.getUsername() != null)
            return false;
        if (getRealName() != null ? !getRealName().equals(forumUser.getRealName()) : forumUser.getRealName() != null)
            return false;
        if (getLocation() != null ? !getLocation().equals(forumUser.getLocation()) : forumUser.getLocation() != null)
            return false;
        return getFriends().equals(forumUser.getFriends());
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }


}
