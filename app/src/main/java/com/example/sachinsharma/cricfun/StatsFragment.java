package com.example.sachinsharma.cricfun;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class StatsFragment extends Fragment {
    GraphView scoresGraphView ,wicketsGraphView;
    Spinner spinner;

    View view;
    String team1;
    String team2;

    public StatsFragment newInstance(String team1,String team2){
        Bundle args=new Bundle();
        args.putString("team1",team1);
        args.putString("team2",team2);
        StatsFragment fragment=new StatsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        team1 = getArguments().getString("team1","ind");
        team2=getArguments().getString("team2","sa");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_stats, container, false);
        scoreGraph(view);
        wicketsGraph(view);
        return view;
    }

    private void scoreGraph(View view) {

        scoresGraphView =  view.findViewById(R.id.scoreGraph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint ( 10, 30 ),
                new DataPoint ( 20, 100 ),
                new DataPoint ( 30, 180 ),
                new DataPoint ( 40, 200 ),
                new DataPoint ( 45, 240 ),
                new DataPoint ( 50, 300 )


        });
        series.setTitle ( team1 );
        series.setColor ( Color.rgb ( 153, 153, 255 ) );
        series.setDrawDataPoints ( true );
        series.setDataPointsRadius ( 10 );
        series.setThickness ( 8 );
        scoresGraphView.addSeries ( series );

        LineGraphSeries <DataPoint> series2 = new LineGraphSeries <> ( new DataPoint[]{
                new DataPoint ( 10, 60 ),
                new DataPoint ( 20, 120 ),
                new DataPoint ( 30, 130 ),
                new DataPoint ( 40, 200 ),
                new DataPoint ( 50, 225 )
        } );
        series2.setTitle ( team2 );
        series2.setColor ( Color.rgb ( 255, 102, 102 ) );
        series2.setDrawDataPoints ( true );
        series2.setDataPointsRadius ( 10 );
        series2.setThickness ( 8 );
        scoresGraphView.addSeries ( series2 );

         /*
1        * Styling Code*/

        scoresGraphView.getLegendRenderer ( ).setVisible ( true );
        scoresGraphView.getLegendRenderer ( ).setAlign ( LegendRenderer.LegendAlign.TOP );
        scoresGraphView.getLegendRenderer ( ).setBackgroundColor ( Color.rgb ( 242, 242, 242 ) );
        scoresGraphView.getLegendRenderer ().setPadding ( 10 );
        scoresGraphView.getLegendRenderer ().setMargin ( 10 );
        scoresGraphView.getLegendRenderer ().setTextSize ( 40 );

        scoresGraphView.setTitle ( "Match Score Graph" );
        scoresGraphView.setTitleColor ( Color.rgb ( 230, 230, 230 ) );
        scoresGraphView.setTitleTextSize ( 60 );

        scoresGraphView.setBackgroundColor ( Color.rgb ( 0, 0, 102 ) );
        scoresGraphView.getGridLabelRenderer ( ).setGridColor ( Color.rgb ( 179, 179, 179 ) );
        scoresGraphView.getGridLabelRenderer ( ).setHorizontalLabelsColor ( Color.rgb ( 204, 204, 204 ) );
        scoresGraphView.getGridLabelRenderer ( ).setVerticalLabelsColor ( Color.rgb ( 204, 204, 204 ) );


    }

    private void wicketsGraph(View view) {

        wicketsGraphView =  view.findViewById(R.id.wicketsGraph);

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint ( 1, 40 ),
                new DataPoint ( 2, 100 ),
                new DataPoint ( 3, 180 ),
                new DataPoint ( 4, 230 ),
                new DataPoint ( 5, 240 ),
                new DataPoint ( 6, 280 ),
                new DataPoint ( 7, 280 ),
                new DataPoint ( 8, 300 )

        });
        series3.setTitle ( team1 );
        series3.setColor ( Color.rgb ( 153, 153, 255 ) );
        series3.setDrawDataPoints ( true );
        series3.setDataPointsRadius ( 10 );
        series3.setThickness ( 8 );
        wicketsGraphView.addSeries ( series3 );

        LineGraphSeries <DataPoint> series4 = new LineGraphSeries <> ( new DataPoint[]{
                new DataPoint ( 1, 50 ),
                new DataPoint ( 2, 150 ),
                new DataPoint ( 3, 180 ),
                new DataPoint ( 4, 200 ),
                new DataPoint ( 5, 220 ),
                new DataPoint ( 6, 270 ),
                new DataPoint ( 7, 280 ),
                new DataPoint ( 8, 300 )
        } );
        series4.setTitle ( team2 );
        series4.setColor ( Color.rgb ( 255, 102, 102 ) );
        series4.setDrawDataPoints ( true );
        series4.setDataPointsRadius ( 10 );
        series4.setThickness ( 8 );
        wicketsGraphView.addSeries ( series4 );

         /*
        * Styling Code*/

        wicketsGraphView.getLegendRenderer ( ).setVisible ( true );
        wicketsGraphView.getLegendRenderer ( ).setAlign ( LegendRenderer.LegendAlign.TOP );
        wicketsGraphView.getLegendRenderer ( ).setBackgroundColor ( Color.rgb ( 242, 242, 242 ) );
        wicketsGraphView.getLegendRenderer ().setPadding ( 10 );
        wicketsGraphView.getLegendRenderer ().setMargin ( 10 );
        wicketsGraphView.getLegendRenderer ().setTextSize ( 40 );

        wicketsGraphView.setTitle ( "Wickets Fall Down Graph" );
        wicketsGraphView.setTitleColor ( Color.rgb ( 230, 230, 230 ) );
        wicketsGraphView.setTitleTextSize ( 60 );

        wicketsGraphView.setBackgroundColor ( Color.rgb ( 0, 0, 102 ) );
        wicketsGraphView.getGridLabelRenderer ( ).setGridColor ( Color.rgb ( 179, 179, 179 ) );
        wicketsGraphView.getGridLabelRenderer ( ).setHorizontalLabelsColor ( Color.rgb ( 204, 204, 204 ) );
        wicketsGraphView.getGridLabelRenderer ( ).setVerticalLabelsColor ( Color.rgb ( 204, 204, 204 ) );


    }




}
