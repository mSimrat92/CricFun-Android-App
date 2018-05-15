package com.example.sachinsharma.cricfun;

import android.arch.lifecycle.Lifecycle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.LayoutInflater;


public class CurrentMatchesFragment extends Fragment{
    View root;
    RecyclerView rvCurrent;
    RecyclerView.Adapter rvCurrentAdapter;
    SwipeRefreshLayout mswipeRefreshLayout;

    public static CurrentMatchesFragment newInstance(){
        CurrentMatchesFragment cmf=new CurrentMatchesFragment();
        Bundle args=new Bundle();
        return cmf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState){
        root= inflater.inflate(R.layout.current_matches_fragment, container, false);
        rvCurrent=root.findViewById(R.id.rvCurrent);
        //rvCurrent.setHasFixedSize(true);
        CurrentMatchesFragmentAdapter cv=new CurrentMatchesFragmentAdapter();
        rvCurrent.setAdapter(cv);
        rvCurrent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCurrent.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
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
                        CurrentMatchesFragmentAdapter newadapter=new CurrentMatchesFragmentAdapter();
                        newadapter.refreshData();
                        rvCurrent.setAdapter(newadapter);
                        rvCurrent.setLayoutManager(new LinearLayoutManager(getActivity()));
                        rvCurrent.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
                        mswipeRefreshLayout.setRefreshing(false);
                    }
                },1);

            }
        });
        return root;

    }
}
