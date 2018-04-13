package com.example.princ.fragmentpractice;

import android.app.Fragment;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements AFragment.OnFragmentTextChange,BFragment.OnFragmentInteractionListener {

    RadioGroup radioGroup;
    AFragment aFragment;
    BFragment bFragment,bFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.container,new BFragment(),"bFragment").commit();

        getSupportFragmentManager().beginTransaction().add(R.id.container,new BFragment(),"bFragment2").commit();

        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                aFragment=(AFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
                bFragment=(BFragment) getSupportFragmentManager().findFragmentByTag("bFragment");
               bFragment2=(BFragment) getSupportFragmentManager().findFragmentByTag("bFragment2");
                if(i==R.id.radioButtonRed){
                    aFragment.changeColor(Color.RED);
                    bFragment.changeColor(Color.RED);
                    bFragment2.changeColor(Color.RED);
                }else if(i==R.id.radioButtonBlue){
                    aFragment.changeColor(Color.BLUE);
                    bFragment.changeColor(Color.BLUE);
                    bFragment2.changeColor(Color.BLUE);
                }else {
                    aFragment.changeColor(Color.GREEN);
                    bFragment.changeColor(Color.GREEN);
                    bFragment2.changeColor(Color.GREEN);
                }
            }
        });
    }

    @Override
    public void onTextChanged(String text) {
            Button heyButton= findViewById(R.id.heyButton);
            heyButton.setText(text);
    }

    @Override
    public void onFragmentInteraction(String text) {
        Button heyButton= findViewById(R.id.heyButton);
        heyButton.setText(text);
    }
}
