package pronosticproject.dto;

import pronosticproject.entities.BetEntity;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("bet")
@RequestScoped
public class BetDto implements Serializable {

    private int user_id;
    private int match_id;
    private int winner_id;

    private String winner;

    public BetDto(){}
    public BetDto(int user_id, int match_id, int winner_id, String winner){
        this.user_id = user_id;
        this.match_id = match_id;
        this.winner_id = winner_id;
        this.winner = winner;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getWinner_id() {
        return winner_id;
    }

    public void setWinner_id(int winner_id) {
        this.winner_id = winner_id;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Inject
    public BetDto(BetEntity bet){
        this.match_id = Math.toIntExact(bet.getId());
        this.winner = bet.getWinner().getName();
    }

    public MatchDto getMatch(){
        return null;
    }

    public String getWinner(){
        return winner;
    }

}
