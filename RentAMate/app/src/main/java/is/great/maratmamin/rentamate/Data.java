package is.great.maratmamin.rentamate;

import java.io.Serializable;

/**
 * Created by maratmamin on 4/4/16.
 */
public class Data implements Serializable {
    private String is_silhouette;

    private String url;

    public String getIs_silhouette ()
    {
        return is_silhouette;
    }

    public void setIs_silhouette (String is_silhouette)
    {
        this.is_silhouette = is_silhouette;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [is_silhouette = "+is_silhouette+", url = "+url+"]";
    }
}
