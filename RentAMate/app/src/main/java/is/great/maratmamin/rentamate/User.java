package is.great.maratmamin.rentamate;

import java.io.Serializable;

/**
 * Created by maratmamin on 4/1/16.
 */
public class User implements Serializable {

    private String id;

    private String profileImageURL;

    private String accessToken;

    private String displayName;

    private String email;

    private String isTemporaryPassword;

    private CachedUserProfile cachedUserProfile;

    private String requested;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getProfileImageURL ()
    {
        return profileImageURL;
    }

    public void setProfileImageURL (String profileImageURL)
    {
        this.profileImageURL = profileImageURL;
    }

    public String getAccessToken ()
    {
        return accessToken;
    }

    public void setAccessToken (String accessToken)
    {
        this.accessToken = accessToken;
    }

    public String getDisplayName ()
    {
        return displayName;
    }

    public void setDisplayName (String displayName)
    {
        this.displayName = displayName;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getisTemporaryPassword ()
    {
        return isTemporaryPassword;
    }

    public void setisTemporaryPassword (String isTemporaryPassword)
    {
        this.isTemporaryPassword = isTemporaryPassword;
    }

    public CachedUserProfile getCachedUserProfile ()
    {
        return cachedUserProfile;
    }

    public void setCachedUserProfile (CachedUserProfile cachedUserProfile)
    {
        this.cachedUserProfile = cachedUserProfile;
    }

    public String getRequested () { return requested; }

    public void setRequested (String requested) { this.requested = requested; }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", profileImageURL = "+profileImageURL+", accessToken = "+accessToken+", displayName = "+displayName+", cachedUserProfile = "+cachedUserProfile+"]";
    }
}
