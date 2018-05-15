package com.example.sachinsharma.cricfun;

/**
 * Created by sachinsharma on 1/1/18.
 */
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.VH>{
    List<MatchView> livematches;
    Context context;
    @Override
    public RVAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cell,parent,false);
        VH viewHolder=new VH(v);
        return viewHolder;
    }

    public RVAdapter(Context context,List<MatchView> matcheslive){
        this.livematches=matcheslive;
        this.context=context;
    }
    public RVAdapter(String date){
        livematches=new MatchesLive().returnMatches(date);

    }
    public void refreshData(){
        MatchView match=MatchView.findById(MatchView.class,(long)1);
        match.setGametTime("232/4");
        match.save();

        MatchView match2=MatchView.findById(MatchView.class,(long)2);
        match2.setGametTime("112/5");
        match2.save();
    }

    @Override
    public void onBindViewHolder(final RVAdapter.VH holder, final int position) {
        MatchView match=livematches.get(position);
        holder.team1.setText(match.getTeam1());
        holder.team2.setText(match.getTeam2());
        holder.time.setText(match.getGametTime());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print(ScoreCard.class);
                Intent intent=new Intent(v.getContext(),ScoreCard.class);
                intent.putExtra("team1",holder.team1.getText());
                intent.putExtra("team2",holder.team2.getText());
                v.getContext().startActivity(intent);



            }
        });
    }

    @Override
    public int getItemCount() {
        return livematches.size();
    }


    public class VH extends RecyclerView.ViewHolder {

        View v;
        TextView team1;
        TextView team2;
        TextView time;
        public VH(View itemView) {
            super(itemView);
            team1=itemView.findViewById(R.id.team1);
            team2=itemView.findViewById(R.id.team2);
            time=itemView.findViewById(R.id.GameTime);
            v=itemView;
        }
    }
}
