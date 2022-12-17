package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTest {

    private static final String TEAM_NAME = "test_name";
    private static final int VACANT_POSITIONS = 10;
    private FootballTeam footballTeam;
    private Footballer footballer;

    @Before
    public void setUp() {
        footballer = new Footballer("Ronaldo");
        footballTeam = new FootballTeam("Levski", VACANT_POSITIONS);
    }

    @Test(expected = NullPointerException.class)
    public void testSetTeamNameThrowWhenNameIsNull() {
        FootballTeam team = new FootballTeam(null, VACANT_POSITIONS);
    }

    @Test(expected = NullPointerException.class)
    public void testSetTeamNameThrowWhenNameIsEmpty() {
        FootballTeam team = new FootballTeam("     ", VACANT_POSITIONS);
    }

    @Test
    public void testSetTeamNameShouldSet() {
        FootballTeam team = new FootballTeam(TEAM_NAME, VACANT_POSITIONS);

        assertEquals(TEAM_NAME, team.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTeamVacantPositionsThrowWhenNegative() {
        FootballTeam team = new FootballTeam(TEAM_NAME, -1);
    }

    @Test
    public void testSetTeamVacantPositionsShouldSet() {
        FootballTeam team = new FootballTeam(TEAM_NAME, VACANT_POSITIONS);

        assertEquals(VACANT_POSITIONS, team.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerShouldThrowWhenTeamIsFull() {
        FootballTeam team = new FootballTeam(TEAM_NAME, 0);

        team.addFootballer(footballer);
    }

    @Test
    public void testAddFootballerShouldAddP() {
        int teamSize = footballTeam.getCount();
        footballTeam.addFootballer(footballer);

        assertEquals(teamSize + 1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerShouldThrowWhenPlayerNotExist() {
        footballTeam.addFootballer(footballer);

        footballTeam.removeFootballer("not_added");
    }

    @Test
    public void testRemoveFootballerShouldRemovePlayerFromTheTeam() {
        footballTeam.addFootballer(footballer);

        footballTeam.removeFootballer(footballer.getName());
        assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleShouldThrowWhenPlayerNotExist() {
        footballTeam.addFootballer(footballer);

        footballTeam.footballerForSale("not_added");
    }

    @Test
    public void testForSaleShouldSetPlayerActiveToFalse() {
        footballTeam.addFootballer(footballer);

        footballTeam.footballerForSale(footballer.getName());
        assertFalse(footballer.isActive());
    }
}