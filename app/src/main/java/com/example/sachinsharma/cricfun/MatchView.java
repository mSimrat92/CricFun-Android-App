package com.example.sachinsharma.cricfun;
import com.orm.SugarRecord;
import java.util.Calendar;
/**
 * Created by sachinsharma on 1/1/18.
 */

public class MatchView extends SugarRecord<MatchView> {

    private String team1;
    private String team2;
    private String GametTime;
    private String date;

    public MatchView() {

    }

    public MatchView(String team1, String team2, String gametTime, String date) {
        this.team1 = team1;
        this.team2 = team2;
        this.GametTime = gametTime;
        this.date = date;
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

    public String getGametTime() {
        return GametTime;
    }

    public void setGametTime(String gametTime) {
        GametTime = gametTime;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
}
