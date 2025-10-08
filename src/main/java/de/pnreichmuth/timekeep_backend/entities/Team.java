package de.pnreichmuth.timekeep_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
public class Team  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Setter
    private String teamName;

    private boolean firstSemesterTeam;

    @OneToMany(cascade = CascadeType.ALL)
    private Map<String, Racer> members;

    @OneToMany(cascade = CascadeType.ALL)
    private Map<String, Station> passedStations;

    public Team(){
        this.teamName = "Team-" + UUID.randomUUID();
        this.firstSemesterTeam = true;
        this.members = new HashMap<>(4);
        this.passedStations = new HashMap<>();
    }



    /**
    * Treat this team as a team of first semester students, if at least 50% of its members are in the first semester
     */
    private void checkFirstSemesterTeam(){
        long erstiCount = members.entrySet().stream()
                .filter(
                        e -> e.getValue().getIsFirstSemester()
                ).count();
        double percentFirstSemester = erstiCount /(double)members.size();
        this.firstSemesterTeam = percentFirstSemester >= 0.5;
    }

    /**
     * Adds a new member to the team and checks whether the team still qualifies as a first semester team
     * @param newMember the Racer object to be added to the team
     */
    public void addMember(Racer newMember){
        this.members.put(newMember.getName(), newMember);
        this.checkFirstSemesterTeam();
    }

    /**
     * Removes a member from the team by name
     * @param name the name of the member to be removed
     */
    public void removeMember(String name){
        this.members.remove(name);
        this.checkFirstSemesterTeam();
    }
}
