package cm.tafotech.activities.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import cm.tafotech.R;

public class TestFragmentActivity extends AppCompatActivity implements FragmentOne.FagmentOneListerner,FragmentTwo.FagmentTwoListerner{

    /*FrameLayout container_1;
    FrameLayout container_2;*/
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_1,fragmentOne)
                .replace(R.id.container_2,fragmentTwo)
                .commit();


    }

    public  void changeFragment(View v){
        Fragment fragment;

        if (v == findViewById(R.id.btn_frg1)){
            fragment = new FragmentOne();
            switchFragmentContent(fragment);

        }else if (v == findViewById(R.id.btn_frg2)){
            fragment = new FragmentTwo();
            switchFragmentContent(fragment);
        }
    }

    private void switchFragmentContent(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment,fragment);
        ft.commit();
    }

    @Override
    public void onInputOneSent(CharSequence charSequence) {
        fragmentTwo.updateeditText(charSequence);
    }

    @Override
    public void onInputTwoSent(CharSequence charSequence) {
        fragmentOne.updateeditText(charSequence);
    }
}
