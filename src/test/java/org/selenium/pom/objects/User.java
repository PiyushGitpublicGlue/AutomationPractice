package org.selenium.pom.objects;

public class User {

    private String userEmail;
    private String password;

    public User(String email,String pwd){
        this.userEmail=email;
        this.password=pwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
