package pronosticproject.beans;

import listener.ApplicationListener;
import pronosticproject.dto.BetDto;
import pronosticproject.dto.MatchDto;
import pronosticproject.entities.Bet;
import pronosticproject.entities.Match;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class BetBean {

    public List<BetDto> getBet(){
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("getAllBets", Bet.class);
        List<Bet> bets = query.getResultList();

        List<BetDto> toReturn = new ArrayList<>();
        bets.forEach(bet -> toReturn.add(new BetDto(bet)));

        return toReturn;
    }

    public MatchDto getMatch(int id){
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT b FROM Bet b WHERE b.id =?1");

        List<Match> match = query.getResultList();
        return new MatchDto(match.get(0));
    }



}
