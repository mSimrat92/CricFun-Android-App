package com.example.sachinsharma.cricfun;

import com.orm.SugarRecord;

/**
 * Created by sachinsharma on 1/2/18.
 */

public class ResultView extends SugarRecord<ResultView>{
        private String team1;
        private String team2;
        private String scores;
        private String Date;
        private String matchStatus;

    public ResultView(String team1, String team2, String scores, String date, String matchStatus) {
        this.team1 = team1;
        this.team2 = team2;
        this.scores = scores;
        Date = date;
        this.matchStatus = matchStatus;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public ResultView() {
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }
}
