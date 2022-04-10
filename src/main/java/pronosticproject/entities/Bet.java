package pronosticproject.entities;

import pronosticproject.dto.BetDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="bets")
@NamedQueries({
        @NamedQuery(name = "getAllBets", query = "SELECT b FROM Bet b")
})
public class Bet {


    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    @JoinColumn(name = "users")
    private User user;

    @ManyToOne
    @JoinColumn(name = "matchs")
    private Match team;

    @ManyToOne
    @JoinColumn(name = "teams")
    private Team winner;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Match getTeam() {
        return team;
    }

    public void setTeam(Match team) {
        this.team = team;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

}
