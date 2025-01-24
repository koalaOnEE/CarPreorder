package com.bmw;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity 
@Table(name = "users")

public class User {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private String name; 
private String email;
private String password;
private Integer userID;

//getters and setters

    public Integer getuserID() {
        return userID;
    }

    public void setuserID(Integer userID) {
        this.userID = userID;
    }


public String getEmail(){
    return email;
}

public void setEmail(String email){
    this.email = email;
}

public String getPassword(){
    return password;
}

public void setPassword(String password){
    this.password = password;
}

public String getname(){
    return name;
}

public void setname (String name){
    this.name = name;
}


}
