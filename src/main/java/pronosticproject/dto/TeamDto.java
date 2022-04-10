package pronosticproject.dto;

import pronosticproject.entities.Match;

public class TeamDto {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamDto(String name) {
    }
}
