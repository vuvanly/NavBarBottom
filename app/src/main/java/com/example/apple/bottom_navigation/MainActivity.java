package com.example.apple.bottom_navigation;

import android.net.Uri;
import android.support.v4.app.*;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements
        InfoFragment.OnFragmentInteractionListener,
        OtherFragment.OnFragmentInteractionListener,
        CartFragment.OnFragmentInteractionListener,
        MondaiListFragment.OnFragmentInteractionListener{
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private enum FragmentTab {
        LIST,
        CART,
        INFO,
        OTHER
    }
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        RadioButton radioButton;
        radioButton = (RadioButton) findViewById(R.id.btnList);
        radioButton.setTag(FragmentTab.LIST);
        radioButton.setChecked(true);
        initializeFragment(radioButton);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnCart);
        radioButton.setTag(FragmentTab.CART);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnInfo);
        radioButton.setTag(FragmentTab.INFO);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnOther);
        radioButton.setTag(FragmentTab.OTHER);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);

        // Set Initialize

    }

    private CompoundButton.OnCheckedChangeListener btnNavBarOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                initializeFragment(buttonView);
            }
        }
    };

    public void initializeFragment(View buttonView){
        Fragment fragment = null;
        switch ((FragmentTab)buttonView.getTag()){
            case LIST:
                Toast.makeText(MainActivity.this, "LIST", Toast.LENGTH_SHORT).show();
                fragment = new MondaiListFragment();
                break;
            case CART:
                Toast.makeText(MainActivity.this, "CART", Toast.LENGTH_SHORT).show();
                fragment = new CartFragment();
                break;
            case INFO:
                Toast.makeText(MainActivity.this, "INFO", Toast.LENGTH_SHORT).show();
                fragment = new InfoFragment();
                break;
            case OTHER:
                Toast.makeText(MainActivity.this, "OTHER", Toast.LENGTH_SHORT).show();
                fragment = new OtherFragment();
                break;
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }
}
