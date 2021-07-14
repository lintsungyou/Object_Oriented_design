package com.example.sharingapp;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
public class ContactList {

    public ContactList(){
        contacts = new ArrayList<Contact>();
    }

    public void setContacts(ArrayList<Contact> _contact_list){
        this.contacts = _contact_list;
    }

    public ArrayList<Contact> getContacts(){
        return this.contacts;
    }

    public ArrayList<String> getAllUsernames(){
        ArrayList<String> resultStrings = new ArrayList<String>();
        for(Contact contactElement : contacts)
        {
            resultStrings.add(contactElement.getUsername());
        }
        return resultStrings;
    }

    public void addContact(Contact _contact)
    {
        contacts.add(_contact);
    }

    public void deleteContact(Contact _contact)
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i).getUsername().equals(_contact.getUsername()) &&
               contacts.get(i).getEmail().equals(_contact.getEmail()) &&
               contacts.get(i).getId().equals(_contact.getId()))
            {
                contacts.remove(i);
            }
        }
    }

    public Contact getContact(int _index)
    {
        return contacts.get(_index);
    }

    public int getSize(){
        return contacts.size();
    }

    public int getIndex(Contact _contact){
        return contacts.indexOf(_contact);
    }

    public boolean hasContact(Contact _contact){
        boolean resultHasContact = false;
        for(Contact _contactElement : contacts)
        {
            if(_contactElement.getUsername().equals(_contact.getUsername()) &&
                    _contactElement.getEmail().equals(_contact.getEmail()) &&
                    _contactElement.getId().equals(_contact.getId()))
            {
                resultHasContact = true;
                break;
            }
        }

        return resultHasContact;
    }

    public Contact getContactByUsername(String _username)
    {
       for(Contact contactElement : contacts)
       {
           if(contactElement.getUsername().equals(_username))
               return contactElement;
       }

       return null;
    }

    public void loadContacts(Context _context){
        try {
            FileInputStream fis = _context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Contact>>() {}.getType();
            contacts = gson.fromJson(isr, listType); // temporary
            fis.close();
        } catch (FileNotFoundException e) {
            contacts = new ArrayList<Contact>();
        } catch (IOException e) {
            contacts = new ArrayList<Contact>();
        }
    }

    public void saveContacts(Context _context) {
        try {
            FileOutputStream fos = _context.openFileOutput(FILENAME, Context.MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(contacts, osw);
            osw.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isUsernameAvailable(String _username)
    {
        for(Contact contactElement : contacts)
        {
            if(contactElement.getUsername().equals(_username))
                return false;
        }
        return true;
    }

    private ArrayList<Contact> contacts;
    private String FILENAME = "contact.sav";
}
