package com.example.sachinsharma.cricfun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BattingRvAdapter extends RecyclerView.Adapter<BattingRvAdapter.VH> {
   Context context;
   TeamsData objTeamsData;



   public BattingRvAdapter(Context context, String team){
       this.context = context;
       objTeamsData = new TeamsData(team);
   }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_batting, parent, false);

        VH viewHolder = new VH(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(VH holder, int position) {
       Team selectedTeam = objTeamsData.getTeam().get(position);
       holder.player.setText(selectedTeam.getPlayer());
       holder.runs.setText(Integer.toString(selectedTeam.getRuns()));
       holder.balls.setText(Integer.toString(selectedTeam.getBalls()));
       holder.status.setText(selectedTeam.getStatus());


    }

    @Override
    public int getItemCount() {
        return objTeamsData.getSize();
    }
    public class VH extends RecyclerView.ViewHolder{
    View v;
       TextView player,runs,balls,status;

        public VH(View itemView) {
            super(itemView);
            player = itemView.findViewById(R.id.player);
            runs =  itemView.findViewById(R.id.runs);
            balls =  itemView.findViewById(R.id.balls);
            status =  itemView.findViewById(R.id.status);
             v = itemView;
        }
    }
}

