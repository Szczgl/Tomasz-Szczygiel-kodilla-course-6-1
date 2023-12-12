package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }
    @BeforeEach
    void setUp() {
        statisticsMock = Mockito.mock(Statistics.class);
    }

    @Nested
    @DisplayName("test for post ")
    class testPost {
        @Test
        void testForumStatisticsWhenNoPost () {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> users = List.of("User");
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, forumStatistics.getAverageCommentForPost());
            assertEquals(0, forumStatistics.getAveragePostForUser());
            assertEquals(0, forumStatistics.getAverageCommentForUser());
            assertEquals(1, forumStatistics.getUserCount());
            assertEquals(0, forumStatistics.getPostCount());
            assertEquals(0, forumStatistics.getCommentCount());


        }

        @Test
        void testForumStatisticsWhen1000Post () {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> users = List.of("User");
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(500);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0.5, forumStatistics.getAverageCommentForPost());
            assertEquals(1000, forumStatistics.getAveragePostForUser());
            assertEquals(500, forumStatistics.getAverageCommentForUser());
            assertEquals(1, forumStatistics.getUserCount());
            assertEquals(1000, forumStatistics.getPostCount());
            assertEquals(500, forumStatistics.getCommentCount());
        }
    }

    @Nested
    @DisplayName("test for comment ")
    class testComment {
        @Test
        void testForumStatisticsWhenNoComment() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> users = List.of("User");
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, forumStatistics.getAverageCommentForPost());
            assertEquals(1000, forumStatistics.getAveragePostForUser());
            assertEquals(0, forumStatistics.getAverageCommentForUser());
            assertEquals(1, forumStatistics.getUserCount());
            assertEquals(1000, forumStatistics.getPostCount());
            assertEquals(0, forumStatistics.getCommentCount());
        }

        @Test
        void testForumStatisticsWhenCommentMoreThenPost() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> users = List.of("User");
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(500);
            when(statisticsMock.commentsCount()).thenReturn(1000);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(2, forumStatistics.getAverageCommentForPost());
            assertEquals(500, forumStatistics.getAveragePostForUser());
            assertEquals(1000, forumStatistics.getAverageCommentForUser());
            assertEquals(1, forumStatistics.getUserCount());
            assertEquals(500, forumStatistics.getPostCount());
            assertEquals(1000, forumStatistics.getCommentCount());
        }

        @Test
        void testForumStatisticsWhenPostMoreThenComment() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> users = List.of("User");
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(500);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0.5, forumStatistics.getAverageCommentForPost());
            assertEquals(1000, forumStatistics.getAveragePostForUser());
            assertEquals(500, forumStatistics.getAverageCommentForUser());
            assertEquals(1, forumStatistics.getUserCount());
            assertEquals(1000, forumStatistics.getPostCount());
            assertEquals(500, forumStatistics.getCommentCount());
        }
    }

    @Nested
    @DisplayName("test for user ")
    class testUser {


        @Test
        void testForumStatisticsWhenNoUser() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, forumStatistics.getAverageCommentForPost());
            assertEquals(0, forumStatistics.getAveragePostForUser());
            assertEquals(0, forumStatistics.getAverageCommentForUser());
            assertEquals(0, forumStatistics.getUserCount());
            assertEquals(0, forumStatistics.getPostCount());
            assertEquals(0, forumStatistics.getCommentCount());
        }

        @Test
        void testForumStatisticsWhen100User() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> users = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                users.add("User " + i);
            }
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(500);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0.5, forumStatistics.getAverageCommentForPost());
            assertEquals(10, forumStatistics.getAveragePostForUser());
            assertEquals(5, forumStatistics.getAverageCommentForUser());
            assertEquals(100, forumStatistics.getUserCount());
            assertEquals(1000, forumStatistics.getPostCount());
            assertEquals(500, forumStatistics.getCommentCount());
        }
    }
}
