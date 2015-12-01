package com.netcracker.edu.dao;

import com.netcracker.edu.businessobjects.IDObject;

/**
 * Created by FlowRyder on 26.11.2015.
 */
public abstract class DAO {
    public abstract void add(IDObject idObject);
    public abstract IDObject load(int id);
    public abstract void delete(int id);
}
