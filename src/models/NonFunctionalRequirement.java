package models;

/**
 * Created by Michi on 23.04.2017.
 */
public class NonFunctionalRequirement
{
    private  String businessProcess;
    private  String description;

    public NonFunctionalRequirement(String businessProcess,
                                    String description)
    {
        this.businessProcess = businessProcess;
        this.description = description;
    }

    public String getBusinessProcess()
    {
        return businessProcess;
    }

    public void setBusinessProcess(String businessProcess)
    {
        this.businessProcess = businessProcess;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
