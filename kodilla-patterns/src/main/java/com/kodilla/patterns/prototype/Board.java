package com.kodilla.patterns.prototype;

import java.util.*;
public class Board extends Prototype<Board> {

    private String name;
    private Set<TaskList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TaskList> getLists() {
        return lists;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setLists(Set<TaskList> lists) {
        this.lists = lists;
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board cloneBoard = super.clone();
        cloneBoard.lists = new HashSet<>();
        for (TaskList theList : lists) {
            TaskList cloneList = new TaskList(theList.getName());
            for (Task task : theList.getTasks()) {
                cloneList.getTasks().add(task);
            }
            cloneBoard.getLists().add(cloneList);
        }
        return cloneBoard;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (TaskList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(name, board.name) &&
                Objects.equals(lists, board.lists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lists);
    }
}
