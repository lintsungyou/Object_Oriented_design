package com.example.sharingapp;
import android.content.Context;

public class EditContactCommand extends Command{
    private ContactList mContactList;
    private Contact mOldContact;
    private Contact mNewContact;
    private Context mContext;

    public EditContactCommand(ContactList _contactList, Contact _oldContact, Contact _newContact, Context _context){
        this.mOldContact = _oldContact;
        this.mNewContact = _newContact;
        this.mContactList = _contactList;
        this.mContext = _context;
    }
    public void execute(){
        mContactList.deleteContact(mOldContact);
        mContactList.addContact(mNewContact);
        setIsExecuted(mContactList.saveContacts(mContext));
    }
}
