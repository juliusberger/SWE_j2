package models.Requirements;

/**
 * Created by Michi on 23.04.2017.
 */
public class QualityRequirementEntry
{
    private String name;
    private Priority priority;

    public enum Priority
    {
        HIGH, MEDIUM, LOW, IRRELEVANT
    }

    public QualityRequirementEntry(String name,
                                   Priority priority)
    {
        this.name = name;
        this.priority = priority;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Priority getPriority()
    {
        return this.priority;
    }

    public void setPriority(Priority priority)
    {
        this.priority = priority;
    }
}
