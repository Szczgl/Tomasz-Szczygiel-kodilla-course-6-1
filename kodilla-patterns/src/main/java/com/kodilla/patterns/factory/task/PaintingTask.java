package com.kodilla.patterns.factory.task;

public final class PaintingTask implements Task {

    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean taskExecute;

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public void executeTask() {
        System.out.println("Malowanie " + whatToPaint + " kolorem " + color);
        taskExecute = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecute;
    }
}
