package is.great.maratmamin.rentamate;

import java.io.Serializable;

/**
 * Created by maratmamin on 4/4/16.
 */
public class Picture implements Serializable {
    private Data data;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+"]";
    }
}
