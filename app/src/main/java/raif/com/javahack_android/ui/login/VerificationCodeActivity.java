package raif.com.javahack_android.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import raif.com.javahack_android.R;
import raif.com.javahack_android.ui.main.MainActivity;

public class VerificationCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        initToolbar();

        Button button = (Button) findViewById(R.id.to_main);
        button.setOnClickListener((view) ->{
            Intent intent = new Intent(VerificationCodeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            backToLogin();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



    public void backToLogin() {
        Intent intent = new Intent(VerificationCodeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
