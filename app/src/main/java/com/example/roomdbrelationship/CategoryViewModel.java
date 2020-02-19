package com.example.roomdbrelationship;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    Repository repository;

    List<Category> categories;

    List<Account> accounts;

    public CategoryViewModel(Context context) {
        repository = new Repository(context);

        categories = repository.getCategories();

        accounts = repository.getAccounts();
    }

    public List<Category> getCategories(){
        return categories;
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public List<Account> findAcc(int id_cat){
        return repository.findAcc(id_cat);
    }
}
