package pronosticproject.entities;

import javax.persistence.*;

@Entity
public class Match {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
