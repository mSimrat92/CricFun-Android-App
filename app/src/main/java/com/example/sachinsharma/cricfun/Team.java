package com.example.sachinsharma.cricfun;

/**
 * Created by sachinsharma on 1/8/18.
 */

public class Team {


    private String player, type, status;
    private int runs;
    private int balls;
    private int overs;
    private int wickets;

    public Team(String player, String type, String status, int runs, int balls, int overs, int wickets) {

        this.player = player;
        this.type = type;
        this.status = status;
        this.runs = runs;
        this.balls = balls;
        this.overs = overs;
        this.wickets = wickets;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        wickets = wickets;
    }


    public String getPlayer() {

        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }
}
