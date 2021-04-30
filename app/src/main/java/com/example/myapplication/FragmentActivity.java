package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;

public class FragmentActivity extends AppCompatActivity implements MyFragment.IOMessageOnClick {
//    private FragmentManager fragmentManager;
    private MyFragment f1,f2,f3,f4;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        rg = findViewById(R.id.rg_tab);

        f1 = MyFragment.newInstance("消息");

        //getSupoort可以向前兼容
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.f1_content,f1).commitAllowingStateLoss();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                hideAllFragment(fragmentTransaction);
                switch (checkedId){
                    case R.id.rb_message:
                        if (f1 == null) {
                            f1 = MyFragment.newInstance("消息");
                            fragmentTransaction.add(R.id.f1_content,f1);
                        }else{
                            fragmentTransaction.show(f1);
                        }
                        break;
                    case R.id.rb_phone:
                        if (f2 == null) {
                            f2 = MyFragment.newInstance("通讯录");
                            fragmentTransaction.add(R.id.f1_content,f2);
                        }else{
                            fragmentTransaction.show(f2);
                        }
                        break;
                    case R.id.rb_discover:
                        if (f3 == null) {
                            f3 = MyFragment.newInstance("发现");
                            fragmentTransaction.add(R.id.f1_content,f3);
                        }else{
                            fragmentTransaction.show(f3);
                        }
                        break;
                    case R.id.rb_me:
                        if (f4 == null) {
                            f4 = MyFragment.newInstance("我的");
                            fragmentTransaction.add(R.id.f1_content,f4);
                        }else{
                            fragmentTransaction.show(f4);
                        }
                        break;
                }
                        fragmentTransaction.commitAllowingStateLoss();
            }
        });

//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(,f1).commitAllowingStateLoss();
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (f1 != null) {
            fragmentTransaction.hide(f1);
        }
        if (f2 != null) {
            fragmentTransaction.hide(f2);
        }
        if (f3 != null) {
            fragmentTransaction.hide(f3);
        }
        if (f4 != null) {
            fragmentTransaction.hide(f4);
        }
    }


    @Override
    public void onClick(String context) {
        setTitle(context);
    }
}