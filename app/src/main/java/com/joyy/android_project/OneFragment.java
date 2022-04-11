package com.joyy.android_project;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneFragment extends Fragment {

    public OneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneFragment newInstance() {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        MainActivity.Companion.log("onAttach", "Fragment");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        MainActivity.Companion.log("onCreate", "Fragment");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.Companion.log("onCreateView", "Fragment");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        MainActivity.Companion.log("onViewCreated", "Fragment");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        MainActivity.Companion.log("onStart", "Fragment");
        super.onStart();
    }

    @Override
    public void onResume() {
        MainActivity.Companion.log("onResume", "Fragment");
        super.onResume();
    }

    @Override
    public void onPause() {
        MainActivity.Companion.log("onPause", "Fragment");
        super.onPause();
    }

    @Override
    public void onStop() {
        MainActivity.Companion.log("onStop", "Fragment");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        MainActivity.Companion.log("onDestroyView", "Fragment");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        MainActivity.Companion.log("onDestroy", "Fragment");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        MainActivity.Companion.log("onDetach", "Fragment");
        super.onDetach();
    }
}