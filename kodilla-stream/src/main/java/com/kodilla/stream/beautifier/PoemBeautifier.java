package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String text, PoemDecorator poemDecorator) {
        String words = poemDecorator.decorate(text);
        System.out.println("Słowo: " + words);

    }
}
