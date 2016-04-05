package is.great.maratmamin.rentamate;

import java.io.Serializable;

/**
 * Created by maratmamin on 4/4/16.
 */
public class CachedUserProfile implements Serializable {
    private Picture picture;

    private String id;

    private String first_name;

    private String middle_name;

    private String timezone;

    private String name;

    private String locale;

    private String link;

    private String last_name;

    private String gender;

    private Age_range age_range;

    public Picture getPicture ()
    {
        return picture;
    }

    public void setPicture (Picture picture)
    {
        this.picture = picture;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    public String getMiddle_name () { return middle_name;}

    public void setMiddle_name (String middle_name)
    {
        this.middle_name = middle_name;
    }

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLocale ()
    {
        return locale;
    }

    public void setLocale (String locale)
    {
        this.locale = locale;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getLast_name ()
    {
        return last_name;
    }

    public void setLast_name (String last_name)
    {
        this.last_name = last_name;
    }

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    public Age_range getAge_range ()
    {
        return age_range;
    }

    public void setAge_range (Age_range age_range)
    {
        this.age_range = age_range;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [picture = "+picture+", id = "+id+", first_name = "+first_name+", timezone = "+timezone+", name = "+name+", locale = "+locale+", link = "+link+", last_name = "+last_name+", gender = "+gender+", age_range = "+age_range+"]";
    }
}
