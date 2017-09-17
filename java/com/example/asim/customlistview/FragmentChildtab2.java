package com.example.asim.customlistview;

/**
 * Created by hp on 5/5/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Umair on 02/07/2015.
 */
public class FragmentChildtab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmentchildtab1, container, false);
        return rootView;
    }}
