package com.kodilla.testing.forum.statistics;

import java.util.*;

public class ForumStatistics{

    private int userCount;
    private int postCount;
    private int commentCount;
    private double averagePostForUser;
    private double averageCommentForUser;
    private double averageCommentForPost;

    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getAveragePostForUser() {
        return averagePostForUser;
    }

    public double getAverageCommentForUser() {
        return averageCommentForUser;
    }

    public double getAverageCommentForPost() {
        return averageCommentForPost;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ForumStatistics that)) return false;

        if (getUserCount() != that.getUserCount()) return false;
        if (getPostCount() != that.getPostCount()) return false;
        if (getCommentCount() != that.getCommentCount()) return false;
        if (Double.compare(getAveragePostForUser(), that.getAveragePostForUser()) != 0) return false;
        if (Double.compare(getAverageCommentForUser(), that.getAverageCommentForUser()) != 0) return false;
        return Double.compare(getAverageCommentForPost(), that.getAverageCommentForPost()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getUserCount();
        result = 31 * result + getPostCount();
        result = 31 * result + getCommentCount();
        temp = Double.doubleToLongBits(getAveragePostForUser());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getAverageCommentForUser());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getAverageCommentForPost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        List<String> userName = statistics.usersNames();
        userCount = userName.size();
        postCount = statistics.postsCount();
        commentCount = statistics.commentsCount();

        if (postCount > 0 && !userName.isEmpty()) {
            averageCommentForUser = (double) commentCount / userCount;
            averagePostForUser = (double) postCount / userCount;

        } else {
            averageCommentForUser = 0;
            averagePostForUser = 0;
        }

        if (commentCount > 0 && !userName.isEmpty()) {
            averageCommentForPost = (double) commentCount / postCount;
        } else {
            averageCommentForPost =0;
        }


    }

    public void showStatistics() {
        System.out.println("User count : " + userCount);
        System.out.println("Post count : " + postCount);
        System.out.println("Comment count : " + commentCount);
        System.out.println("Average post for user : " + averagePostForUser);
        System.out.println("Average comment for user : " + averageCommentForUser);
        System.out.println("Average comment for post : " +averageCommentForPost);

    }
}
