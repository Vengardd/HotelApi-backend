package com.spaghettiteam.hotelapi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name = "Roles_privalages",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Set<Privilage> privilages;

    private String name;

    public Role() {
    }

    public Role(Set<Privilage> privilages, String name) {
        this.privilages = privilages;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Privilage> getPrivilages() {
        return privilages;
    }

    public void setPrivilages(Set<Privilage> privilages) {
        this.privilages = privilages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
