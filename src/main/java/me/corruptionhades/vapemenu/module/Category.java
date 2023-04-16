package me.corruptionhades.vapemenu.module;

public enum Category {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    RENDER("Render"),
    PLAYER("Player"),
    MISC("Misc"),
    CLIENT("Client");

    public String name;

    Category(String name) {
        this.name = name;
    }
}
