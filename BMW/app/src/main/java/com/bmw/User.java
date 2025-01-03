package com.bmw;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

    public Integer userID() {
        return userID;
    }

    public void setuserID(Integer userID) {
        this.userID = userID;
    }


public String email(){
    return email;
}

public void setemail(String email){
    this.email = email;
}

public String password(){
    return password;
}

public void setpassword(String password){
    this.password = password;
}

public String name(){
    return name;
}

public void setname (String name){
    this.name = name;
}


}
