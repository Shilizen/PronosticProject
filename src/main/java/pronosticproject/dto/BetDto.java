package pronosticproject.dto;

import pronosticproject.beans.BetBean;
import pronosticproject.entities.Bet;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("bet")
@RequestScoped
public class BetDto implements Serializable {

    @EJB
    private BetBean betBean;

    private int user_id;
    private int match_id;
    private int winner_id;

    private String winner;

    @Inject
    public BetDto(Bet bet){
        this.match_id = Math.toIntExact(bet.getId());
        this.winner = bet.getWinner().getName();
    }

    public MatchDto getMatch(){
        return betBean.getMatch(match_id);
    }

    public String getWinner(){
        return winner;
    }

}
