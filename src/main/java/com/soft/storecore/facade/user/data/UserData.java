package com.soft.storecore.facade.user.data;

import com.soft.storecore.facade.validation.EmailUniqueConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserData {

    private String code;

    @NotEmpty
    @Size(max = 32)
    private String firstName;
    @NotEmpty
    @Size(max = 32)
    private String lastName;
    @NotEmpty
    @Email
    @EmailUniqueConstraint
    private String email;
    @NotEmpty
    @Size(min = 6, max = 21)
    @Pattern(regexp = "\\S*(\\S*([a-zA-Z]\\S*[0-9])|([0-9]\\S*[a-zA-Z]))\\S*")
    private String password;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
