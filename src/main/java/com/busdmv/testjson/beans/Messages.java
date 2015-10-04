package com.busdmv.testjson.beans;

public class Messages {

    private String id;
    private String client_id;
    private String message;

    public Messages(String id, String client_id, String message) {
        this.id = id;
        this.client_id = client_id;
        this.message = message;
    }

    public Messages() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getMessage() {
        return message;
    }

}
