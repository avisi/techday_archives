package nl.avisi.server.persistence;

public class NaiveIdProvider implements IdProvider {

    private Long nextId;

    public NaiveIdProvider() {
        nextId = 1L;
    }

    @Override
    public Long getNextId() {
        return nextId++;
    }

}
