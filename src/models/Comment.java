package models;

/**
 * Created by Michi on 23.04.2017.
 */
public class Comment
{
    private String keyword;
    private String description;

    public Comment(String keyword,
                   String description)
    {
        this.keyword = keyword;
        this.description = description;
    }

    public String getKeyword()
    {
        return keyword;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
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
