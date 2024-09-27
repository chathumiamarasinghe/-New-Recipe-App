package com.example.foodrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodrecipe.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    private ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(LayoutInflater.from(this));
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        binding.startBtn.setOnClickListener(view -> {
            Intent intent=new Intent(IntroActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Window window=getWindow();
        window.clearFlags(WindowManager .LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager .LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        View decor=window.getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}