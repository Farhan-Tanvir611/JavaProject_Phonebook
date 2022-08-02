package com.access;

import java.util.ArrayList;
import com.data.Contact;

public class Manager {
    private static ArrayList<Contact> contacts = new ArrayList<Contact>();

    private static int searchContact(String name) {
        for(int i = 0; i < contacts.size(); ++i)
            if(contacts.get(i).getName().equals(name)) return i;
        return -1;
    }

    public static void addContact(Contact contact) {
        contacts.add(contact);
    }

    public static Contact searchContact(String name, boolean flag) {
        int j = searchContact(name);
        if(j == -1) return null;
        return contacts.get(j);
    }

    public static void deleteContact(String name) throws IllegalArgumentException {
        int j = searchContact(name);
        if(j == -1) throw new IllegalArgumentException("contact not found");
        contacts.remove(j);
    }

    public static void update(String name, String updateAttrib, int updateFlag) {
        int j = searchContact(name);
        Contact contact = contacts.get(j);
        contacts.remove(j);
        
        if(updateFlag == 1)
            contact.setPhoneNumber(updateAttrib);
        else if(updateFlag == 2)
            contact.setName(updateAttrib);
        else if(updateFlag == 3)
            contact.setAddress(updateAttrib);
        else contact.setRelation(updateAttrib);

        contacts.add(contact);
    }
}