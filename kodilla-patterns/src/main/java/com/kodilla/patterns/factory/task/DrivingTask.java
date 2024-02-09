package com.kodilla.patterns.factory.task;

public final class DrivingTask implements Task {

    private final String taskName;
    private final String where;
    private final String using;
    private boolean taskExecute;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public void executeTask() {
        System.out.println("Dojechać do " + where + " środkiem transporu: " + using);
        taskExecute = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecute;
    }
}
