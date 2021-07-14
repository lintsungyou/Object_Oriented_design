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

public class ContactListController {

    private ContactList contact_list;

    public ContactListController(ContactList contact_list){
        this.contact_list = contact_list;
    }

    public void setContacts(ArrayList<Contact> contact_list) {
        this.contact_list.setContacts(contact_list);
    }

    public ArrayList<Contact> getContacts() {
        return this.contact_list.getContacts();
    }

    public ArrayList<String> getAllUsernames(){
        return this.contact_list.getAllUsernames();
    }

    public boolean addContact(Contact contact, Context context) {
        AddContactCommand add_contact_cmd = new AddContactCommand(contact_list, contact, context);
        add_contact_cmd.execute();
        return add_contact_cmd.isExecuted();
    }

    public boolean deleteContact(Contact contact, Context context) {
        DeleteContactCommand delete_contact_cmd = new DeleteContactCommand(contact_list, contact, context);
        delete_contact_cmd.execute();
        return delete_contact_cmd.isExecuted();
    }

    public boolean editContact(Contact contact, Contact update_contact, Context context)
    {
        EditContactCommand edit_contact_cmd = new EditContactCommand(contact_list, contact, update_contact, context);
        edit_contact_cmd.execute();
        return edit_contact_cmd.isExecuted();
    }

    public Contact getContact(int index) {
        return contact_list.getContact(index);
    }

    public int getSize() {
        return this.contact_list.getSize();
    }

    public Contact getUserByUsername(String username){
        return this.contact_list.getUserByUsername(username);
    }

    public boolean hasContact(Contact contact) {
        return this.contact_list.hasContact(contact);
    }

    public int getIndex(Contact contact) {
       return this.contact_list.getIndex(contact);
    }

    public boolean isUsernameAvailable(String username){
        return this.contact_list.isUsernameAvailable(username);
    }

    public void loadContacts(Context context) {
        contact_list.loadContacts(context);
    }

    /**
     * @param context
     * @return true: if save is successful, false: if save is unsuccessful
     */
    public boolean saveContacts(Context context) {
      return contact_list.saveContacts(context);
    }

    public Contact getContactByUsername(String username){
        return contact_list.getContactByUsername(username);
    }

    public void addObserver(Observer observer)
    {
        contact_list.addObserver(observer);
    }

    public void remove(Observer observer){
        contact_list.removeObserver(observer);
    }
}
