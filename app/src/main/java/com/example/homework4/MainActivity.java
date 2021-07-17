package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnOpenFragment;
    EditText etValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etValue=findViewById(R.id.et_value);
        btnOpenFragment=findViewById(R.id.btn_open_Fragment);
        btnOpenFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etValue.getText().toString();
                if (!text.equals("")) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container_fragment, FirstFragment.newInstance(text, "TEXT2"));
                    transaction.addToBackStack("FirstFragment");
                    transaction.commit();
                }else {etValue.setError("Please, enter text");} }
        });
    }
}