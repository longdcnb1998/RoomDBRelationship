package com.example.roomdbrelationship;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CategoryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new CategoryViewModel(this);

        ArrayList<Category> categories = (ArrayList<Category>) viewModel.getCategories();

        ArrayList<Account> accounts = (ArrayList<Account>) viewModel.getAccounts();


        Log.d("LongDinh", String.valueOf(accounts.size())+" "+categories.size());
    }
}
