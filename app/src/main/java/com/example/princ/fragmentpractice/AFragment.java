package com.example.princ.fragmentpractice;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class AFragment extends Fragment {


    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        view.findViewById(R.id.helloButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Hello from onCreateView", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private OnFragmentTextChange mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener=(OnFragmentTextChange) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" should implement OnFragmentTextChange");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().findViewById(R.id.helloButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Hello from onActivityCreated", Toast.LENGTH_SHORT).show();
                EditText et=(EditText) getActivity().findViewById(R.id.editText);
                mListener.onTextChanged(et.getText().toString());
            }
        });

    }

    public void changeColor(int color) {
        //getView().setBackgroundColor(color);-----changes color of topmost view
        getActivity().findViewById(R.id.fragment_root).setBackgroundColor(color);
    }

    public  interface OnFragmentTextChange{
        void onTextChanged(String text);
    }
}
