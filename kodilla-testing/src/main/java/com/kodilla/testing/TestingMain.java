package com.kodilla.testing;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie do testowania oprogramowania");
        // zadanie dodatkowe
        TestingMain testingMain = new TestingMain();
        testingMain.vowelSearchInAString("Alabama jest mIastem");


    }
    public void vowelSearchInAString(String string) {
        String[] stringToCompare = new String[] {"e","a","y","u","i","o","E","A","Y","U","I","O"} ;
        String[] splitEnterString =  string.split("");
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < stringToCompare.length; j++) {
                if(stringToCompare[j].equals(splitEnterString[i])) {
                    String word = splitEnterString[i];
                    //System.out.print(word);
                }
            }
        }
    }
}
