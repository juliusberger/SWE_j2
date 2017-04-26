package com.company;

/**
 * Created by Michi on 21.04.2017.
 */
public class Player {
    private String _name;
    private String _position;
    private int _id;

    public String getName()
    {
        return this._name;
    }

    public String getPosition()
    {
        return this._position;
    }

    public int getId()
    {
        return this._id;
    }

    public void setId(int id)
    {
        this._id = id;
    }

    public void setPosition(String position)
    {
        this._position = position;
    }

    public void setName(String name)
    {
        this._name = name;
    }

    @Override
    public String toString()
    {
        return this._name + ", " + this._position;
    }
}
