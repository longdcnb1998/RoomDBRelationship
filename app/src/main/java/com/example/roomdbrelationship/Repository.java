package com.example.roomdbrelationship;

import android.content.Context;

import java.util.List;

public class Repository {

    AppDatabase database;

    CategoryDAO categoryDAO;

    AccountDAO accountDAO;

    List<Category> categories;

    List<Account> accounts;


    public Repository(Context context) {
        database = AppDatabase.getDatabase(context);

        categoryDAO = database.categoryDAO();

        accountDAO = database.accountDAO();

        categories = categoryDAO.getAllCat();

        accounts = accountDAO.getAllAccount();

    }

    public List<Category> getCategories(){
        return categories;
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public List<Account> findAcc(int id_cat){
        return accountDAO.findAccountForCat(id_cat);
    }

}
