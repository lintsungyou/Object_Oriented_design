package com.example.sharingapp;
import android.content.Context;

public class DeleteContactCommand extends Command {
    private ContactList mContactList;
    private Contact mContact;
    private Context mContext;

    public DeleteContactCommand(ContactList _contactList, Contact _contact, Context _context){
        this.mContact = _contact;
        this.mContactList = _contactList;
        this.mContext = _context;
    }
    public void execute(){
        mContactList.deleteContact(mContact);
        setIsExecuted(mContactList.saveContacts(mContext));
    }
}
