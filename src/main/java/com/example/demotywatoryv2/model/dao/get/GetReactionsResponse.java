package com.example.demotywatoryv2.model.dao.get;

public class GetReactionsResponse {

    private Long votes_up;
    private Long votes_down;
    private Long balance;

    public Long getVotes_up() {
        return votes_up;
    }

    public void setVotes_up(Long votes_up) {
        this.votes_up = votes_up;
    }

    public Long getVotes_down() {
        return votes_down;
    }

    public void setVotes_down(Long votes_down) {
        this.votes_down = votes_down;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public GetReactionsResponse(Long votes_up, Long votes_down, Long balance) {
        this.votes_up = votes_up;
        this.votes_down = votes_down;
        this.balance = balance;
    }
}
