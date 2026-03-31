package com.DSA.LinearBinarySearch;
public class ConcatenateString {
    public static void main(String[] args) {
        String[] arr = {"Java", "is", "awesome"};
        StringBuffer sb = new StringBuffer();
        for (String s : arr) sb.append(s).append(" ");
        System.out.println("Concatenated: " + sb.toString().trim());
    }
}
