package com.example.sachinsharma.cricfun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BowlingRvAdapter extends RecyclerView.Adapter<BowlingRvAdapter.VH> {
    Context context;
    TeamsData bowlersData;

    public BowlingRvAdapter(Context context, String team){
        this.context = context;
        bowlersData = new TeamsData(team);
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_bowling, parent, false);

       VH viewHolder = new VH(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
       Team selectedTeam = bowlersData.getBowler().get(position);
        holder.player.setText(selectedTeam.getPlayer());
        holder.runs.setText(Integer.toString(selectedTeam.getRuns()));
        holder.overs.setText(Integer.toString(selectedTeam.getOvers()));
        holder.wickets.setText(Integer.toString(selectedTeam.getWickets()));
    }


    @Override
    public int getItemCount() {
        return bowlersData.getBowlersSize();
    }
    public class VH extends RecyclerView.ViewHolder{
        View v;
        TextView player,overs,wickets,runs;

        public VH(View itemView) {
            super(itemView);
            player = itemView.findViewById(R.id.bowler);
            overs =  itemView.findViewById(R.id.Overs);
            runs =  itemView.findViewById(R.id.bRuns);
            wickets =  itemView.findViewById(R.id.Wickets);
            v = itemView;
        }
    }
}
