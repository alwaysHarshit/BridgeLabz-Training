package com.java.Collections;

import java.util.*;

public class VotingSystem {
    Map<String, Integer> voteMap = new HashMap<>();            // Core vote storage
    Map<String, Integer> voteOrder = new LinkedHashMap<>();    // Maintains voting order
    TreeMap<String, Integer> sortedResults = new TreeMap<>();  // For sorted display
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        if (!voteOrder.containsKey(candidate)) {
            voteOrder.put(candidate, 1);
        } else {
            voteOrder.put(candidate, voteOrder.get(candidate) + 1);
        }

        sortedResults.put(candidate, voteMap.get(candidate));
    }

    public void displayVoteOrder() {
        System.out.println("\n📋 Votes in the order they were cast:");
        voteOrder.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public void displaySortedResults() {
        System.out.println("\n🏁 Final results (sorted by candidate name):");
        sortedResults.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🗳️ Voting System Started. Enter candidate names to cast votes.");
        System.out.println("Type 'done' to finish voting and view results.\n");

        while (true) {
            System.out.print("Cast vote for: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;

            system.castVote(input);
            System.out.println("✅ Vote cast for " + input);
        }

        system.displayVoteOrder();
        system.displaySortedResults();
    }
}