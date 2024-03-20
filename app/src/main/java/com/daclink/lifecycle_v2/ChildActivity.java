package com.daclink.lifecycle_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.daclink.lifecycle_v2.databinding.ActivityChildBinding;
import com.daclink.lifecycle_v2.databinding.ActivityMainBinding;

public class ChildActivity extends AppCompatActivity {
    ActivityChildBinding binding;
    public boolean showMessage1Child;
    public static final String SHOW_MESSAGE_ONE = "com.daclink.lifecycle_v2_show_message_one";

    public static Intent intentFactory(Context packageContext, Boolean showMessageOne) {
        Intent intent = new Intent(packageContext, ChildActivity.class);
        intent.putExtra(SHOW_MESSAGE_ONE, showMessageOne);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        binding = ActivityChildBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showMessage1Child = getIntent().getBooleanExtra(SHOW_MESSAGE_ONE, true);
        binding.button2.setText("Example text bc i am uncreative");
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChildActivity.this, "Wow it actually worked!", Toast.LENGTH_LONG).show();
            }
        });

    }
}