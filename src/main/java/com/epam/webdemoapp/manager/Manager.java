package com.epam.webdemoapp.manager;

public interface Manager<Entity, Id> {
    void create(Entity entity);

    boolean getByEmailPassword(String username, String password);

}
