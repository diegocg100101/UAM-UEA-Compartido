package com.uam.UamCompartido.JPA;

import jakarta.persistence.*;

/**
 * @author diego
 */

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //nuevo tipo de id
    @Column(name = "id_role")
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
