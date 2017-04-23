package models;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Michi on 23.04.2017.
 */
public class FunctionalRequirement
{
    private  String name;
    private  String description;
    private  String stakeholder;

    public FunctionalRequirement(String name,
                                 String description,
                                 String stakeholder)
    {
        this.name = name;
        this.description = description;
        this.stakeholder = stakeholder;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setStakeholder(String stakeholder)
    {
        this.stakeholder = stakeholder;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getStakeholder()
    {
        return stakeholder;
    }
}
