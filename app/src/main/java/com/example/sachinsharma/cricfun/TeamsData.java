package com.example.sachinsharma.cricfun;

import java.util.ArrayList;

/**
 * Created by sachinsharma on 1/8/18.
 */

public class TeamsData {

    private ArrayList<Team> team;
    private ArrayList<Team> bowlers;

    public TeamsData(String teamName) {
        team = new ArrayList<Team>();
        bowlers = new ArrayList<Team>();
        if (teamName.equals("Ind")) {
            System.out.println("true");
            team.add(new Team("Rohit Sharma", "batsman", "out", 80, 30, 10, 0));
            team.add(new Team("Rahane", "batsman", "out", 40, 33, 12, 0));
            team.add(new Team("Virat Kohali", "batsman", "out", 60, 35, 12, 0));
            team.add(new Team("Yuvraj Singh", "batsman", "out", 100, 40, 12, 0));
            team.add(new Team("M.S Dhoni", "bowler", "out", 50, 34, 12, 0));
            team.add(new Team("Ravider Jadeja", "batsman", "out", 20, 30, 12, 0));
            team.add(new Team("Ashwin", "bowler", "out", 50, 30, 10, 2));
            team.add(new Team("Umesh Yadav", "bowler", "out", 40, 30, 10, 4));
            team.add(new Team("Ishant Sharma", "bowler", "not out", 60, 30, 10, 1));
            team.add(new Team("R Ashwin", "bowler", " not out", 45, 30, 10, 2));

            bowlersData();
        }
        else if(teamName.equals("Pak")) {
            team.add(new Team("Shoib Malik", "batsman", "out", 50, 35, 10, 0));
            team.add(new Team("Saeed Ajmal", "batsman", "not out", 33, 30, 10, 0));
            team.add(new Team("Sarfraz", "batsman", "out", 40, 34, 10, 0));
            team.add(new Team("Shehzad", "batsman", "out", 55, 40, 10, 0));
            team.add(new Team("Hafeez", "batsman", "out", 70, 30, 10, 0));
            team.add(new Team("Akmal", "batsman", "out", 30, 40, 10, 0));
            team.add(new Team("Ifran", "bowler", "out", 50, 30, 10, 2));
            team.add(new Team("Mohmad amir", "bowler", "out", 30, 30, 10, 4));
            team.add(new Team("Mohmad Sami", "bowler", "out", 35, 30, 10, 3));
            team.add(new Team("Nawaz", "bowler", "not out", 150, 30, 10, 1));
            bowlersData();


        }
        else if(teamName.equals("Aus")){
            team.add(new Team("david warner", "batsman", "out", 50, 35, 10, 0));
            team.add(new Team("usman khawaja", "batsman", "out", 33, 30, 10, 0));
            team.add(new Team("steve smith", "batsman", "out", 40, 34, 10, 0));
            team.add(new Team("Shaun marsh", "batsman", "out", 55, 40, 10, 0));
            team.add(new Team("mitchel marsh", "batsman", "not out", 70, 30, 10, 0));
            team.add(new Team("Andrew symonds", "batsman", "out", 30, 40, 10, 0));
            team.add(new Team("warne", "bowler", "out", 50, 30, 10, 2));
            team.add(new Team("mcgrath", "bowler", "out", 30, 30, 10, 4));
            team.add(new Team("Brett Lee", "bowler", "out", 35, 30, 10, 3));
            team.add(new Team("Roman reign", "bowler", "not out", 150, 30, 10, 1));
            bowlersData();
        }

        else if(teamName.equals("Eng")){
            team.add(new Team("atherton", "batsman", "out", 50, 35, 10, 0));
            team.add(new Team("james lee", "batsman", "out", 33, 30, 10, 0));
            team.add(new Team("karan thapar", "batsman", "out", 40, 34, 10, 0));
            team.add(new Team("narendra modi", "batsman", "out", 55, 40, 10, 0));
            team.add(new Team("arvind kejriwal", "batsman", "out", 70, 30, 10, 0));
            team.add(new Team("rahul gandhi", "batsman", "not out", 30, 40, 10, 0));
            team.add(new Team("sachin pilot", "bowler", "out", 50, 30, 10, 2));
            team.add(new Team("Capt. Amrinder singh", "bowler", "out", 30, 30, 10, 4));
            team.add(new Team("saif ali khan", "bowler", "out", 35, 30, 10, 3));
            team.add(new Team("Taimur khan", "bowler", "not out", 150, 30, 10, 1));
            bowlersData();
        }

        else if(teamName.equals("WI")){
            team.add(new Team("Gayle", "batsman", "out", 50, 35, 10, 0));
            team.add(new Team("Bravo", "batsman", "out", 33, 30, 10, 0));
            team.add(new Team("Bravo", "batsman", "out", 40, 34, 10, 0));
            team.add(new Team("kristen", "batsman", "out", 55, 40, 10, 0));
            team.add(new Team("Pollard", "batsman", "out", 70, 30, 10, 0));
            team.add(new Team("Roach", "batsman", "out", 30, 40, 10, 0));
            team.add(new Team("Ambrose", "bowler", "out", 50, 30, 10, 2));
            team.add(new Team("Gayle", "bowler", "out", 30, 30, 10, 4));
            team.add(new Team("Mohmad Sami", "bowler", "not out", 35, 30, 10, 3));
            team.add(new Team("Nawaz", "bowler", "not out", 150, 30, 10, 1));
            bowlersData();
        }

        else if(teamName.equals("SA")){
            team.add(new Team("Shoib Malik", "batsman", "out", 50, 35, 10, 0));
            team.add(new Team("Saeed Ajmal", "batsman", "out", 33, 30, 10, 0));
            team.add(new Team("Sarfraz", "batsman", "out", 40, 34, 10, 0));
            team.add(new Team("Shehzad", "batsman", "out", 55, 40, 10, 0));
            team.add(new Team("Hafeez", "batsman", "out", 70, 30, 10, 0));
            team.add(new Team("Akmal", "batsman", "out", 30, 40, 10, 0));
            team.add(new Team("Ifran", "bowler", "out", 50, 30, 10, 2));
            team.add(new Team("Mohmad amir", "bowler", "out", 30, 30, 10, 4));
            team.add(new Team("Mohmad Sami", "bowler", "not out", 35, 30, 10, 3));
            team.add(new Team("Nawaz", "bowler", "not out", 150, 30, 10, 1));
            bowlersData();
        }
        else if(teamName.equals("Ire")){
            team.add(new Team("Gayle", "batsman", "out", 50, 35, 10, 0));
            team.add(new Team("Bravo", "batsman", "out", 33, 30, 10, 0));
            team.add(new Team("Bravo", "batsman", "out", 40, 34, 10, 0));
            team.add(new Team("kristen", "batsman", "out", 55, 40, 10, 0));
            team.add(new Team("Pollard", "batsman", "not out", 70, 30, 10, 0));
            team.add(new Team("Roach", "batsman", "out", 30, 40, 10, 0));
            team.add(new Team("Ambrose", "bowler", "out", 50, 30, 10, 2));
            team.add(new Team("Gayle", "bowler", "out", 30, 30, 10, 4));
            team.add(new Team("Mohmad Sami", "bowler", "out", 35, 30, 10, 3));
            team.add(new Team("Nawaz", "bowler", "not out", 150, 30, 10, 1));
            bowlersData();
        }
        else if(teamName.equals("NZ")){
            team.add(new Team("Gayle", "batsman", "out", 50, 35, 10, 0));
            team.add(new Team("Bravo", "batsman", "out", 33, 30, 10, 0));
            team.add(new Team("Bravo", "batsman", "out", 40, 34, 10, 0));
            team.add(new Team("kristen", "batsman", "out", 55, 40, 10, 0));
            team.add(new Team("Pollard", "batsman", "out", 70, 30, 10, 0));
            team.add(new Team("Roach", "batsman", "out", 30, 40, 10, 0));
            team.add(new Team("Ambrose", "bowler", "out", 50, 30, 10, 2));
            team.add(new Team("Gayle", "bowler", "out", 30, 30, 10, 4));
            team.add(new Team("Mohmad Sami", "bowler", "not out", 35, 30, 10, 3));
            team.add(new Team("Nawaz", "bowler", "not out", 150, 30, 10, 1));
            bowlersData();
        }


    }

    private void bowlersData() {
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getType() == "bowler") {
                bowlers.add(team.get(i));
            }
        }
    }


    public ArrayList<Team> getTeam() {
        return team;
    }

    public ArrayList<Team> getBowler() {
        return bowlers;
    }

    public int getSize() {
        return team.size();
    }

    public int getBowlersSize() {
        return bowlers.size();
    }
}
