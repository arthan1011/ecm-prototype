package ru.atc.sbrf.ecm.guice.core.model;

/**
 * Created by ashamsiev on 01.10.2015
 */
public class FnAccess {

    private int userID;
    private String objectStoreName;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getObjectStoreName() {
        return objectStoreName;
    }

    public void setObjectStoreName(String objectStoreName) {
        this.objectStoreName = objectStoreName;
    }
}
