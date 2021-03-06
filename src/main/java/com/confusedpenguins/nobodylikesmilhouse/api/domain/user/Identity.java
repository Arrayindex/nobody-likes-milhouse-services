package com.confusedpenguins.nobodylikesmilhouse.api.domain.user;

public class Identity {
    private String id;
    private String name;

    public Identity() {
    }

    public Identity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
