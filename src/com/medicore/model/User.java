package com.medicore.model;

public abstract class User {
    protected int id;
    protected  String name;
    protected String phone;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }


    public User(int id,String name,String phone){
        this.id=id;
        this.name=name;
        this.phone=phone;
    }
    public abstract String getRole();

    public void displayBasicInfo(){
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Role  : " + getRole());
    }
    @Override
    public String toString() {
        return name + " (" + getRole() + ")";
    }


}
