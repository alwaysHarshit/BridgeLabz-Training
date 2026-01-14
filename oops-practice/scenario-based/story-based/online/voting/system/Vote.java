package online.voting.system;

import java.time.LocalDateTime;
import java.util.UUID;

public class Vote {

    private String voteHash;
    private LocalDateTime timeStamp;
    private Voter voter;
    private Candidate candidate;

    public Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
        this.timeStamp = LocalDateTime.now();
        this.voteHash = generateVoteHash();
    }

    // Getter for vote hash
    public String getVoteHash() {
        return voteHash;
    }

    // Generate simple random hash
    private String generateVoteHash() {
        return UUID.randomUUID().toString();
    }

    // Getter for candidate
    public Candidate getCandidate() {
        return candidate;
    }
}
