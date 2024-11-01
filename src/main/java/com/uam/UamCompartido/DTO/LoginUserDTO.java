package com.uam.UamCompartido.DTO;

import jakarta.validation.constraints.NotNull;

/**
 * @author diego
 */

public class LoginUserDTO {

    private String email;

    private String password;

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
