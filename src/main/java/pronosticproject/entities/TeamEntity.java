package pronosticproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "TeamEntity")
@NamedQueries({
        @NamedQuery(name = "findAllTeams", query = "SELECT t FROM TeamEntity t")
})
public class TeamEntity {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
