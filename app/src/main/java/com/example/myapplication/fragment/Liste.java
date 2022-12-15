package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import com.example.myapplication.R;


public class Liste extends Fragment {
    private ListView listView;

    public Liste() {

        // Required empty public constructor
    }
    public static Liste newInstance() {
        return new Liste();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liste, container, false);
        listView = view.findViewById(R.id.list_view);
        return view;
    }
}