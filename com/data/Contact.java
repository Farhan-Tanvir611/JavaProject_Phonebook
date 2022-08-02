package com.data;

public class Contact {
    private String phoneNumber;
    private String name;
    private String address;
    private String relation;

    public Contact(String phoneNumber, String name, String address, String relation) throws IllegalArgumentException {
        setPhoneNumber(phoneNumber);
        setName(name);
        setAddress(address);
        try {
            setRelation(relation);
        }
        catch(IllegalArgumentException e) {
            throw e;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRelation(String relation) throws IllegalArgumentException {
        if(!relation.equals("FRIEND") && !relation.equals("FAMILY") && !relation.equals("BUSINESS"))
            throw new IllegalArgumentException("invalid relation");
        this.relation = relation;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getRelation() { return relation; }

    @Override
    public String toString() {
        return "Name: " + name + " phone number: " + phoneNumber + " address: " + address + " relation: " + relation;
    }
}
