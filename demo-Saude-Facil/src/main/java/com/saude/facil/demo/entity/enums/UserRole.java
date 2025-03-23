package com.saude.facil.demo.entity.enums;

public enum UserRole {

    COMUM("comum"),
    ADMIN("admin");


    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
