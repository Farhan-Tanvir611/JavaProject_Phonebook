package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import com.access.Manager;
import com.data.Contact;

class IO {
	private static final BufferedReader reader;
	
	static {
		try {
			FileInputStream instream = new FileInputStream("C:/Users/shahr/OneDrive/Desktop/phone-book/com/utils/input.txt");
			System.setIn(instream);
		} 
		catch(IOException e) {
		   System.err.println(e);
		}
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	static String readLine() {
		try {
			return reader.readLine().trim();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

public class InputOutput {
    private static final String message = "welcome to contact management software\nwhat would you like to do(ADD/DELETE/UPDATE/SEARCH/EXIT)\n";
    public static void performAction() {
        String input;
        String name, phoneNumber, address, relation;
        String updateAttrib;
        loop: do {
            System.out.println(message);
            input = IO.readLine();
            switch(input) {
                case "ADD":
                    System.out.printf("Name: ");
                    name = IO.readLine();
                    System.out.printf("\nPhone: ");
                    phoneNumber = IO.readLine();
                    System.out.printf("\nAddress: ");
                    address = IO.readLine();
                    System.out.printf("\nRelation: ");
                    relation = IO.readLine();
                    try {
                        Manager.addContact(new Contact(phoneNumber, name, address, relation));
                        System.out.println("\nContact added successfully");
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println(e);
                    }
                break;
                case "DELETE":
                    System.out.printf("Enter the name of the contact to delete: ");
                    name = IO.readLine();
                    System.out.println(name);
                    try {
                        Manager.deleteContact(name);
                        System.out.println("Contact deleted");
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                break;
                case "UPDATE":
                    System.out.printf("Enter the name of the contact to update: ");
                    name = IO.readLine();
                    if(Manager.searchContact(name, true) == null)
                        System.out.println("\ncontact with that name does not exist\n");
                    else {
                        System.out.printf("\nwhich attribute to update?");
                        String attrib = IO.readLine();
                        if(attrib.equals("name")) {
                            System.out.printf("\nEnter the new name: ");
                            updateAttrib = IO.readLine();
                            Manager.update(name, updateAttrib, 2);
                            System.out.println("\nupdated");
                            
                        }
                        else if(attrib.equals("phone")) {
                            System.out.printf("\nEnter the new phone number: ");
                            updateAttrib = IO.readLine();
                            Manager.update(name, updateAttrib, 1);
                            System.out.println("\nupdated");
                        }
                        else if(attrib.equals("address")) {
                            System.out.printf("\nEnter the new address: ");
                            updateAttrib = IO.readLine();
                            Manager.update(name, updateAttrib, 3);
                            System.out.println("\nupdated");
                        }
                        else {
                            System.out.printf("\nEnter the new relation: ");
                            updateAttrib = IO.readLine();
                            Manager.update(name, updateAttrib, 4);
                            System.out.println("\nupdated");
                        }
                    }
                break;
                case "SEARCH":
                    System.out.printf("Enter the name of the contact to search: ");
                    name = IO.readLine();
                    if(Manager.searchContact(name, true) == null)
                        System.out.println("\ncontact with that name does not exist\n");
                    else System.out.println("\n" + Manager.searchContact(name, true));
                break;
                default:
                    System.out.println("Exiting");
                    break loop;

            }
        }while(true);
    }
}