package com.tse.miray.fise3_projetandroid;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager INSTANCE;
    private List<String> nameList;

    private DataManager()
    {
        nameList = new ArrayList<>();
    }

    public static DataManager getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public void addItem(String name)
    {
        nameList.add(name);
    }
}

