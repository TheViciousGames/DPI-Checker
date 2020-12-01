package com.theviciousgames.dpichecker;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.theviciousgames.dpichecker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(declareVars());
    }

    protected View declareVars() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getInfo();
        buttonFunctions();
        lockPortrait();
        return binding.getRoot();
    }

    protected void getInfo() {
        binding.currentDPIValueTextView.setText("" + Tools.getDPI(this));
    }

    protected void buttonFunctions() {
        binding.exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        binding.refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.currentDPIValueTextView.setText("" + Tools.getDPI(MainActivity.this));
            }
        });
    }

    protected void lockPortrait() {
        Tools.lockPortrait(this);
    }

}