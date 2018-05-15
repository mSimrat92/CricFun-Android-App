package com.example.sachinsharma.cricfun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachinsharma on 1/2/18.
 */

public class ResultsFragmentAdapter extends RecyclerView.Adapter<ResultsFragmentAdapter.VH> {

    List<ResultView> results;
    List<String>teams=new ArrayList<>();
    Context context;
    @Override
    public ResultsFragmentAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.results_cell,parent,false);
        ResultsFragmentAdapter.VH viewHolder=new ResultsFragmentAdapter.VH(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ResultsFragmentAdapter.VH holder, int position) {
        ResultView result=results.get(position);
        holder.team1.setText(result.getTeam1());
        holder.team2.setText(result.getTeam2());
        holder.scores.setText(result.getScores());
        holder.matchStatus.setText(result.getMatchStatus());
    }

    public ResultsFragmentAdapter(List<ResultView> results, Context context) {
        this.results = results;
        this.context = context;
    }
    public ResultsFragmentAdapter(){
        results=new ResultsView().getAllResults();
    }

    public List<String> getlistofteams(){
        teams.add("Select a Team");
        teams.add("Ind \uD83C\uDDEE\uD83C\uDDF3");
        teams.add("Aus \uD83C\uDDE6\uD83C\uDDFA");
        teams.add("NZ \uD83C\uDDF3\uD83C\uDDFF");
        teams.add("Pak \uD83C\uDDF5\uD83C\uDDF0");
        teams.add("WI \uD83C\uDDF9\uD83C\uDDF9");
        teams.add("Ire \uD83C\uDDEE\uD83C\uDDEA");
        return teams;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        TextView team1;
        TextView team2;
        TextView scores;
        TextView matchStatus;
        public VH(View itemView) {
            super(itemView);
            team1=itemView.findViewById(R.id.teamResult1);
            team2=itemView.findViewById(R.id.teamResult2);
            scores=itemView.findViewById(R.id.resultScores);
            matchStatus=itemView.findViewById(R.id.matchStatus);
        }
    }
}
