package is.great.maratmamin.rentamate;

/**
 * Created by maratmamin on 4/1/16.
 */
public class User {
    String mPhotoUrl;
    String mInfo;

    public User (String profPic, String info) {
        mPhotoUrl = profPic;
        mInfo = info;
    }

    public String getProfPic () {
        return mPhotoUrl;
    }

    public String getInfo () {
        return mInfo;
    }
}
