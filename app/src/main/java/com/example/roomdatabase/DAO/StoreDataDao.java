package com.example.roomdatabase.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase.ENTITY.StoreData;

import java.util.List;

@Dao
public interface StoreDataDao {

    @Query("select * from Storage")
    List<StoreData> getData();

    @Insert
    void addData(StoreData storeData);

    @Update
    void updateData(StoreData storeData);

    @Delete
    void deleteData(StoreData storeData);






}
