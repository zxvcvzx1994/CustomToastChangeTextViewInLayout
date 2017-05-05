package com.example.kh.inputmethodframework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et , et1;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et  = (EditText) findViewById(R.id.et);
        et1  = (EditText) findViewById(R.id.et1);

        View v = getLayoutInflater().inflate(R.layout.toast_layout, null);




        et1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEND)
                    try {
                        txt.setText(et1.getText().toString().trim());
                    }catch ( Exception e){

                    }
                createToast();
                return false;
            }
        });
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId  == EditorInfo.IME_ACTION_SEND)
                    Toast.makeText(MainActivity.this, et.getText().toString().trim(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    private void createToast() {
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0 ,0 );


        View view  = getLayoutInflater().inflate(R.layout.toast_layout, null);
        txt  = (TextView) view.findViewById(R.id.txt);
        txt.setText(et1.getText().toString().trim());
        toast.setView(view);
        toast.show();
    }
}
