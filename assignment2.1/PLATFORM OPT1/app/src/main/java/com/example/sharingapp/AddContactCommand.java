package com.example.sharingapp;
import android.content.Context;

public class AddContactCommand extends Command {

    private ContactList mContactList;
    private Contact mContact;
    private Context mContext;

    public AddContactCommand(ContactList _contactList, Contact _contact, Context _context){
        this.mContact = _contact;
        this.mContactList = _contactList;
        this.mContext = _context;
    }

    @Override
    public void execute(){
        mContactList.addContact(mContact);
        setIsExecuted(mContactList.saveContacts(mContext));
    }
}
