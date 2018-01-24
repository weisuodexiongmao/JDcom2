package bwe.com.bawei.jdcom.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.register.register_bean.Register_Bean;
import bwe.com.bawei.jdcom.register.register_presenter.Register_Presenter;
import bwe.com.bawei.jdcom.register.register_view.Register_view;

public class Register_Activity extends AppCompatActivity implements Register_view {

    @BindView(R.id.editText6)
    EditText editText6;
    @BindView(R.id.editText7)
    EditText editText7;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.editText8)
    EditText editText8;
    private String regname;
    private String regpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        ButterKnife.bind(this);

    }

    @Override
    public void getregister(Register_Bean register_bean) {
        String msg = register_bean.getMsg();
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public String regname() {
        return regname;
    }

    @Override
    public String regpass() {
        return regpass;
    }

    @OnClick(R.id.button3)
    public void onViewClicked() {
        regname = editText6.getText().toString();
        if (editText7.getText().toString().equals(editText8.getText().toString())){
            regpass = editText8.getText().toString();
            Register_Presenter presenter=new Register_Presenter(this);
            presenter.presen();
        }else {
            Toast.makeText(Register_Activity.this,"您输入的密码不一致",Toast.LENGTH_SHORT).show();
        }

    }


}
