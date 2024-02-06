package com.kodilla.patterns.singleton;

public enum SettingsFileEngine {

    INSTANCE;

    private String fileName = "";


    public String getFileName() {
        return fileName;
    }

    public void close() {
        this.fileName = "";
        System.out.println("Closing the setting file");
    }

    public void open(final String fileName) {
        this.fileName = fileName;
        System.out.println("Opening the setting file");
    }

    public boolean loadSettings() {
        System.out.println("Loading the setting file");
        return true;
    }

    public boolean saveSettings() {
        System.out.println("Saving the setting file");
        return true;
    }
}
