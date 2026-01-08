package com.Linkedlist;

import java.util.*;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }
}

class SocialMedia {
    User head = null;

    void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
        System.out.println("User added: " + name + " (ID: " + id + ")");
    }

    User getUserById(int id) {
        User curr = head;
        while (curr != null) {
            if (curr.userId == id) return curr;
            curr = curr.next;
        }
        return null;
    }

    void addFriendConnection(int userId1, int userId2) {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }
        if (user1.userId == user2.userId) {
            System.out.println("Cannot add self as a friend.");
            return;
        }
        if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
        if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    void removeFriendConnection(int userId1, int userId2) {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }
        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("Friend connection removed.");
    }

    void displayFriends(int userId) {
        User user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + " (ID: " + user.userId + "):");
        if (user.friendIds.isEmpty()) {
            System.out.println("- No friends found.");
        } else {
            for (int id : user.friendIds) {
                User friend = getUserById(id);
                if (friend != null) {
                    System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
                }
            }
        }
    }

    void searchUser(String key) {
        boolean found = false;
        User curr = head;
        while (curr != null) {
            if (curr.name.equalsIgnoreCase(key) || String.valueOf(curr.userId).equals(key)) {
                System.out.println("User Found: " + curr.name + " (ID: " + curr.userId + ", Age: " + curr.age + ")");
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("User not found.");
    }

    void findMutualFriends(int userId1, int userId2) {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Mutual Friends of " + user1.name + " and " + user2.name + ":");
        boolean found = false;
        for (int id : user1.friendIds) {
            if (user2.friendIds.contains(id)) {
                User mutual = getUserById(id);
                if (mutual != null) {
                    System.out.println("- " + mutual.name + " (ID: " + mutual.userId + ")");
                    found = true;
                }
            }
        }
        if (!found) System.out.println("- No mutual friends found.");
    }

    void countFriends() {
        User curr = head;
        while (curr != null) {
            System.out.println(curr.name + " (ID: " + curr.userId + ") has " + curr.friendIds.size() + " friend(s).");
            curr = curr.next;
        }
    }

    void displayAllUsers() {
        if (head == null) {
            System.out.println("No users found.");
            return;
        }
        System.out.println("All Users:");
        User curr = head;
        while (curr != null) {
            System.out.println("ID: " + curr.userId + ", Name: " + curr.name + ", Age: " + curr.age);
            curr = curr.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        while (true) {
            System.out.println("\n--- Social Media Friend Management ---");
            System.out.println("1. Add New User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display All Friends of a User");
            System.out.println("5. Search User by ID or Name");
            System.out.println("6. Find Mutual Friends");
            System.out.println("7. Count Friends of All Users");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            int id1, id2, age;
            String name, key;

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    sm.addUser(id1, name, age);
                    break;

                case 2:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();
                    sm.addFriendConnection(id1, id2);
                    break;

                case 3:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();
                    sm.removeFriendConnection(id1, id2);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    id1 = sc.nextInt();
                    sm.displayFriends(id1);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter User Name or ID to Search: ");
                    key = sc.nextLine();
                    sm.searchUser(key);
                    break;

                case 6:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();
                    sm.findMutualFriends(id1, id2);
                    break;

                case 7:
                    sm.countFriends();
                    break;

                case 8:
                    sm.displayAllUsers();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

