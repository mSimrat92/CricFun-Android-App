package com.example.sachinsharma.cricfun;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by sachinsharma on 1/2/18.
 */

public class ResultsFragment extends Fragment {
    View root;
    List<String> resultList;
    RecyclerView rvRecentResults;
    Spinner ResultSpinner;
    RecyclerView.Adapter rvResultsAdapter;
    SwipeRefreshLayout mswipeRefreshLayout;


    public static ResultsFragment newInstance(){
        ResultsFragment fragment=new ResultsFragment();
        Bundle args=new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root= inflater.inflate(R.layout.recent_results_fragment, container, false);
        rvRecentResults=root.findViewById(R.id.rvRecentResults);
        rvRecentResults.setHasFixedSize(true);
        ResultSpinner=root.findViewById(R.id.spinner_results);
        ResultsFragmentAdapter rv=new ResultsFragmentAdapter();
        rvRecentResults.setAdapter(rv);
        resultList=rv.getlistofteams();
        System.out.println(resultList);
        ArrayAdapter adapterResults=new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,resultList);
        adapterResults.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ResultSpinner.setAdapter(adapterResults);
        rvRecentResults.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecentResults.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mswipeRefreshLayout=root.findViewById(R.id.activity_current_swipe_refresh_layout);

        mswipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshcontent();
            }

            private void refreshcontent() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //ResultsFragmentAdapter newadapter=new ResultsFragmentAdapter();
                        //newadapter.refreshData();
                        //rvRecentResults.setAdapter(newadapter);
                        //rvRecentResults.setLayoutManager(new LinearLayoutManager(getActivity()));
                        //rvRecentResults.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
                        mswipeRefreshLayout.setRefreshing(false);
                    }
                },1);

            }
        });
        return root;

    }
}
