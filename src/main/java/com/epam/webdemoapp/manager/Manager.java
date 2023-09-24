package com.epam.webdemoapp.manager;

public interface Manager<Entity, Id> {
    void create(Entity entity);

    Entity getByUsernamePassword(String username, String password);

}
