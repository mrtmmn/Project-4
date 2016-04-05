package is.great.maratmamin.rentamate;

import java.io.Serializable;

/**
 * Created by maratmamin on 4/4/16.
 */
public class Age_range implements Serializable {
    private String min;
    private String max;

    public String getMin ()
    {
        return min;
    }

    public void setMin (String min)
    {
        this.min = min;
    }

    public String getMax () { return max; }

    public void setMax (String max)
    {
        this.max = max;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [min = "+min+"]";
    }
}
