package nl.avisi.shared.domain;

public class Pizza {

    private final Long id;

    private final String name;

    public Pizza(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
