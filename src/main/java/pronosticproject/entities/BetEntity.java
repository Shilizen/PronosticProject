package pronosticproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "BetEntity")
@NamedQueries({
        @NamedQuery(name = "findAllBets", query = "SELECT b FROM BetEntity b")
})
public class BetEntity {
    private Long id;

    private UserEntity user;

    private MatchEntity team;

    private TeamEntity winner;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "UserEntity")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "MatchEntity")
    public MatchEntity getTeam() {
        return team;
    }

    public void setTeam(MatchEntity team) {
        this.team = team;
    }

    @ManyToOne
    @JoinColumn(name = "TeamEntity")
    public TeamEntity getWinner() {
        return winner;
    }

    public void setWinner(TeamEntity winner) {
        this.winner = winner;
    }
}
