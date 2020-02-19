package com.example.roomdbrelationship;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Query("SELECT * FROM tb_category WHERE id = :id")
    Category get(int id);

    @Query("SELECT * FROM tb_category")
    List<Category> getAllCat();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Category category);

    @Update
     void update(Category category);

    @Delete
     void delete(Category category);

}
