package com.example.roomdbrelationship;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AccountDAO {
    @Insert
    void insert(Account account);

    @Update
    void update(Account account);

    @Delete
    void delete(Account account);

    @Query("SELECT * FROM tb_account")
    List<Account> getAllAccount();

    @Query("SELECT * FROM tb_account WHERE cat_id=:cat_id")
    List<Account> findAccountForCat(final int cat_id);
}
