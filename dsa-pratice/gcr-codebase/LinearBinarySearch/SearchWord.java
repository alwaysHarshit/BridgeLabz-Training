package com.DSA.LinearBinarySearch;

public class SearchWord {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences)
            if (sentence.contains(word))
                return sentence;
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"Hello world", "Java is fun", "I love coding"};
        String word = "Java";
        System.out.println("Found in: " + findSentence(sentences, word));
    }
}
