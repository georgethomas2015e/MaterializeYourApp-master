package com.antonioleiva.materializeyourapp;

/**
 * Created by kishan on 5/27/2016.
 */
public class Messages_Model {

    private String messagetitle;
    private String messagebody;
    private String postedOn;
    private String messageId;
    private String authorfirstname;
    private String authorlastname;
    private String authoravatorurl;

    public String getAuthorfirstname() {
        return authorfirstname;
    }

    public void setAuthorfirstname(String authorfirstname) {
        this.authorfirstname = authorfirstname;
    }

    public String getAuthorlastname() {
        return authorlastname;
    }

    public void setAuthorlastname(String authorlastname) {
        this.authorlastname = authorlastname;
    }


    public String getAuthoravatorurl() {
        return authoravatorurl;
    }

    public void setAuthoravatorurl(String authoravatorurl) {
        this.authoravatorurl = authoravatorurl;
    }


    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle;
    }


    public String getMessagebody() {
        return messagebody;
    }

    public void setMessagebody(String messagebody) {
        this.messagebody = messagebody;
    }

    public String getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }


    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }


}
