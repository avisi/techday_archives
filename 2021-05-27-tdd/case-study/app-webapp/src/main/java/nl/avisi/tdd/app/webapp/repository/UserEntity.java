package nl.avisi.tdd.app.webapp.repository;

import javax.persistence.*;

@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(nullable = false)
    public String username;

    @Column(nullable = false)
    public byte[] passwordHash;
}
