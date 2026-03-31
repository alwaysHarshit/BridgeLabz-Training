package com.Linkedlist;

import java.util.Scanner;

public class TextEditorApp {

    static class TextState {
        String content;
        TextState prev, next;

        public TextState(String content) {
            this.content = content;
            this.prev = null;
            this.next = null;
        }
    }

    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private final int MAX_HISTORY = 10;

    public void type(String newText) {
        TextState newState = new TextState(newText);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        } else {
            head = newState;
        }
        current = newState;
        tail = current;

        int count = 0;
        TextState temp = current;
        while (temp != null) {
            count++;
            temp = temp.prev;
        }
        if (count > MAX_HISTORY) {
            head = head.next;
            if (head != null) head.prev = null;
        }

        System.out.println("Typed: \"" + current.content + "\"");
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: \"" + current.content + "\"");
        } else {
            System.out.println("Undo not available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: \"" + current.content + "\"");
        } else {
            System.out.println("Redo not available.");
        }
    }

    public void showCurrentState() {
        if (current != null) {
            System.out.println("Current State: \"" + current.content + "\"");
        } else {
            System.out.println("Editor is empty.");
        }
    }

    public void displayAllHistory() {
        System.out.println("History (Oldest to Latest):");
        TextState temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println(i + ". " + temp.content);
            temp = temp.next;
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditorApp editor = new TextEditorApp();

        while (true) {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type New Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current State");
            System.out.println("5. Show All History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.type(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.showCurrentState();
                    break;
                case 5:
                    editor.displayAllHistory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
