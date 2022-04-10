package pronosticproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "LeagueEntity")
@NamedQueries({
        @NamedQuery(name = "findAllLeague", query = "SELECT l FROM LeagueEntity l")
})
public class LeagueEntity {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
