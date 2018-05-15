package com.example.sachinsharma.cricfun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by sachinsharma on 1/2/18.
 */

public class CurrentMatchesFragmentAdapter extends RecyclerView.Adapter<CurrentMatchesFragmentAdapter.VH> {
    List<MatchView> livematches;
    Context context;
    @Override
    public CurrentMatchesFragmentAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.current_cell,parent,false);
       CurrentMatchesFragmentAdapter.VH viewHolder=new CurrentMatchesFragmentAdapter.VH(v);
        return viewHolder;
    }

    public CurrentMatchesFragmentAdapter(Context context,List<MatchView> matcheslive){
        this.livematches=matcheslive;
    }

    public CurrentMatchesFragmentAdapter(){
        Calendar cal=Calendar.getInstance();
        livematches=new MatchesLive().returnMatches(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));

    }
    public void refreshData(){
        MatchView match=MatchView.findById(MatchView.class,(long)1);
        match.setGametTime("292/8");
        match.save();

        MatchView match2=MatchView.findById(MatchView.class,(long)2);
        match2.setGametTime("212/9");
        match2.save();
    }

    @Override
    public void onBindViewHolder(CurrentMatchesFragmentAdapter.VH holder, final int position) {
        MatchView match=livematches.get(position);
        holder.teamCurrent1.setText(match.getTeam1());
        holder.teamCurrent2.setText(match.getTeam2());
        holder.currentGameTime.setText(match.getGametTime());
    }

    @Override
    public int getItemCount() {
        return livematches.size();
    }


    public class VH extends RecyclerView.ViewHolder {

        TextView teamCurrent1;
        TextView teamCurrent2;
        TextView currentGameTime;
        public VH(View itemView) {
            super(itemView);
            teamCurrent1=itemView.findViewById(R.id.teamCurrent1);
            teamCurrent2=itemView.findViewById(R.id.teamCurrent2);
            currentGameTime=itemView.findViewById(R.id.CurrentGameTime);
        }
    }
}
