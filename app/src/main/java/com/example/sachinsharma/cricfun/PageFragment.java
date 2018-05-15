package com.example.sachinsharma.cricfun;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sachinsharma on 1/1/18.
 */

public class PageFragment extends Fragment{

    public static final String ARG_PAGE = "ARG_PAGE";
    public String date;
    private int mPage;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView rv;
    View rootView;

    //int currentDate=Calendar.DATE;

    public PageFragment newInstance(String date){
        PageFragment fragment=new PageFragment();
        Bundle args=new Bundle();
        //date=String.valueOf(currentDate);
        //Calendar cal=Calendar.getInstance();
        //int currentDate=cal.get(Calendar.DAY_OF_MONTH);
        //System.out.println(currentDate);
        args.putString("date",date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        date = getArguments().getString("date","21");
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_page, container, false);
        rv=rootView.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        RVAdapter listadapter=new RVAdapter(date);
        rv.setAdapter(listadapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        mSwipeRefreshLayout = rootView.findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshcontent();
            }

            private void refreshcontent() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        RVAdapter newadapter=new RVAdapter(date);
                        newadapter.refreshData();
                        rv.setAdapter(newadapter);
                        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                        rv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                },1);

            }
        });
        return rootView;


    }
}
