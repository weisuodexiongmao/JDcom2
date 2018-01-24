package bwe.com.bawei.jdcom.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.jdcom.MainActivity;
import bwe.com.bawei.jdcom.R;

public class exit extends AppCompatActivity {

    @BindView(R.id.button4)
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button4)
    public void onViewClicked() {
        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("login",false);
        edit.commit();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
