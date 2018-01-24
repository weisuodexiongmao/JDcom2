package bwe.com.bawei.jdcom.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.jdcom.MainActivity;
import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.login.login_bean.Login_Bean;
import bwe.com.bawei.jdcom.login.login_presenter.Login_Presenter;
import bwe.com.bawei.jdcom.login.login_view.Login_view;
import bwe.com.bawei.jdcom.register.Register_Activity;

public class Login_activity extends AppCompatActivity implements Login_view{

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    private String name;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                name = editText.getText().toString();
                pass = editText2.getText().toString();
                Login_Presenter login_presenter=new Login_Presenter(this);
                login_presenter.prsen();
                break;
            case R.id.button2:
                startActivity(new Intent(Login_activity.this, Register_Activity.class));
                break;
        }
    }

    @Override
    public void getlogin(Login_Bean login_bean) {
        if (login_bean.getCode().equals("0")){
            Toast.makeText(Login_activity.this,login_bean.getMsg(),Toast.LENGTH_SHORT).show();
            SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("uid",login_bean.getData().getUid()+"");
            edit.putString("token",login_bean.getData().getToken());
            edit.putString("name",login_bean.getData().getUsername());
            edit.putBoolean("login",true);
            edit.commit();
            startActivity(new Intent(Login_activity.this, MainActivity.class));
            finish();
        }else {
            Toast.makeText(Login_activity.this,login_bean.getMsg(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public String login_name() {
        return name;
    }

    @Override
    public String login_pass() {
        return pass;
    }
}
