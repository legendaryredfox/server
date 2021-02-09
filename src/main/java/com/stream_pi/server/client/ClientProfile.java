/*
Stream-Pi - Free & Open-Source Modular Cross-Platform Programmable Macropad
Copyright (C) 2019-2021  Debayan Sutradhar (rnayabed),  Samuel Quiñones (SamuelQuinones)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

Written by : Debayan Sutradhar (rnayabed)
*/

package com.stream_pi.server.client;

import com.stream_pi.action_api.action.Action;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class ClientProfile implements Cloneable {

    private String name, ID;

    private int rows, cols, actionSize, actionGap;

    private final HashMap<String, Action> actions;

    public ClientProfile(String name, String ID, int rows, int cols, int actionSize, int actionGap)
    {
        this.actions = new HashMap<>();
        this.ID = ID;
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.actionGap = actionGap;
        this.actionSize = actionSize;
    }

    public ClientProfile(String name, int rows, int cols, int actionSize, int actionGap)
    {
        this(name, UUID.randomUUID().toString(), rows, cols, actionSize, actionGap);
    }

    public Action getActionByID(String ID)
    {
        return actions.get(ID);
    }

    public void removeActionByID(String ID)
    {
        actions.remove(ID);
    }


    public Set<String> getActionsKeySet() {
        return actions.keySet();
    }

    public synchronized void addAction(Action action) throws CloneNotSupportedException {
        actions.put(action.getID(), action.clone());
    }

    public String getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public int getRows()
    {
        return rows;
    }

    public int getCols()
    {
        return cols;
    }

    public int getActionSize()
    {
        return actionSize;
    }

    public int getActionGap()
    {
        return actionGap;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public void setCols(int cols)
    {
        this.cols = cols;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setActionSize(int actionSize)
    {
        this.actionSize = actionSize;
    }

    public void setActionGap(int actionGap)
    {
        this.actionGap = actionGap;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
