package com.uam.UamCompartido.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

/**
 * @author diego
 */

@Entity
public class Roles {

    @Id
    private long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
