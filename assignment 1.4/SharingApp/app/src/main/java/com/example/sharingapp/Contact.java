package com.example.sharingapp;
import java.util.UUID;

public class Contact {
    public Contact(String _username, String _email, String _id)
    {
        this.email = _email;
        this.username = _username;

        if(_id == null)
        {
            setId();
        }
        else
        {
            updateId(_id);
        }
    }

    public void setId(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId(){
        return this.id;
    }

    public void updateId(String _id){
        this.id = _id;
    }

    public void setUsername(String _username)
    {
        this.username = _username;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setEmail(String _email)
    {
        this.email = _email;
    }

    public String getEmail()
    {
        return this.email;
    }

    private String username;
    private String email;
    private String id;
}
