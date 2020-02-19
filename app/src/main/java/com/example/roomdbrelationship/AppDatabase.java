package com.example.roomdbrelationship;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

@Database(entities = {Category.class,Account.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {


    public abstract CategoryDAO categoryDAO();

    public abstract AccountDAO accountDAO();

    public static AppDatabase instance;

    public List<Category> categories;

    public static synchronized AppDatabase getDatabase(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"LongDinh")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            new PopulateDbAsyncTask(instance).execute();
                        }

                        @Override
                        public void onOpen(@NonNull SupportSQLiteDatabase db) {
                            super.onOpen(db);
                        }
                    })
                    .build();
        }

        return instance;
    }

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private CategoryDAO categoryDAO;

        public PopulateDbAsyncTask(AppDatabase database) {
            this.categoryDAO = database.categoryDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            categoryDAO.save(new Category("Toàn Bộ"));
            categoryDAO.save(new Category("Ứng Dụng"));
            categoryDAO.save(new Category("Trò Chơi"));
            categoryDAO.save(new Category("Mục Khác"));
            return null;
        }
    }

}
