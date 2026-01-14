package online.voting.system;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Voter> voterList = new ArrayList<>();
        ArrayList<Candidate> candidateList = new ArrayList<>();
        HashMap<Integer, Integer> voteMap = new HashMap<>();


        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("\n===== Voting Management System =====");
            System.out.println("1. Create new voter");
            System.out.println("2. Create new candidate");
            System.out.println("3. List all candidates");
            System.out.println("4. List all voters");
            System.out.println("5. Make vote");
            System.out.println("6. Declare result");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter voter name: ");
                    String voterName = scanner.nextLine();

                    System.out.print("Enter DOB (yyyy-mm-dd): ");
                    LocalDate dob = LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter contact number: ");
                    int contact = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    Voter voter = new Voter(voterName, dob, contact, address);
                    voterList.add(voter);

                    System.out.println("Voter created with ID: " + voter.getVotarId());
                    break;

                case 2:
                    System.out.print("Enter candidate name: ");
                    String candidateName = scanner.nextLine();

                    System.out.print("Enter party name: ");
                    String party = scanner.nextLine();

                    System.out.print("Enter symbol: ");
                    String symbol = scanner.nextLine();

                    System.out.print("Enter constituency: ");
                    String constituency = scanner.nextLine();

                    Candidate candidate = new Candidate(candidateName, party, symbol, constituency);
                    candidateList.add(candidate);

                    System.out.println("Candidate created with ID: " + candidate.getCandidateId());
                    break;

                case 3:
                    System.out.println("\n--- Candidate List ---");
                    for (Candidate c : candidateList) {
                        System.out.println("ID: " + c.getCandidateId());
                    }
                    break;

                case 4:
                    System.out.println("\n--- Voter List ---");
                    for (Voter v : voterList) {
                        v.printVoter();
                    }
                    break;

                case 5:
                    System.out.print("Enter voter ID: ");
                    int voterId = scanner.nextInt();

                    System.out.print("Enter candidate ID: ");
                    int candidateId = scanner.nextInt();

                    Voter selectedVoter = null;
                    Candidate selectedCandidate = null;

                    for (Voter v : voterList) {
                        if (v.getVotarId() == voterId) {
                            selectedVoter = v;
                            break;
                        }
                    }

                    for (Candidate c : candidateList) {
                        if (c.getCandidateId() == candidateId) {
                            selectedCandidate = c;
                            break;
                        }
                    }

                    if (selectedVoter != null && selectedCandidate != null) {

                        // increment vote count using HashMap
                        voteMap.put(candidateId, voteMap.getOrDefault(candidateId, 0) + 1);

                        // simple random vote hash
                        String voteHash = UUID.randomUUID().toString();

                        System.out.println("Vote successful!");
                        System.out.println("Vote Hash: " + voteHash);

                    } else {
                        System.out.println("Invalid voter ID or candidate ID");
                    }
                    break;



                case 6:
                    if (voteMap.isEmpty()) {
                        System.out.println("No votes cast yet!");
                        break;
                    }

                    System.out.println("\n===== Election Results =====");

                    int maxVotes = 0;
                    int winnerId = -1;

                    for (Candidate c : candidateList) {
                        int votes = voteMap.getOrDefault(c.getCandidateId(), 0);

                        System.out.println(
                                "Candidate ID: " + c.getCandidateId() +
                                        " | Votes: " + votes
                        );

                        if (votes > maxVotes) {
                            maxVotes = votes;
                            winnerId = c.getCandidateId();
                        }
                    }

                    System.out.println("\n🏆 Winner Candidate ID: " + winnerId);
                    System.out.println("Total Votes: " + maxVotes);
                    break;



                case 7:
                    flag = false;
                    System.out.println("Thank you for using the voting system.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
