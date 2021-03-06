package at.fh.swenga.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "League")
public class LeagueModel {
	
	@Id
	@Column(name = "leagueId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leagueId;
	
    @OneToMany(mappedBy="league")
    @OrderBy("clubName")
    private Set<ClubModel> clubs;
    
    @OneToMany(mappedBy="league")
    @OrderBy("matchDayID")
    private Set<MatchDayModel> matchDays;

	@Column(nullable = false, length = 30)
	private String leagueName;
	
	@Column(nullable = false, length = 30)
	private int numberOfClubs;
	
	@Column(nullable = false, length = 30)
	private String numberOfPromotedTeams;
	
	@Column(nullable = false, length = 30)
	private String numberOfRelegatedTeams;


	public LeagueModel() {
		super();
	}

	public LeagueModel(String leagueName, int numberOfClubs, String numberOfPromotedTeams,
			String numberOfRelegatedTeams) {
		super();
		this.leagueName = leagueName;
		this.numberOfClubs = numberOfClubs;
		this.numberOfPromotedTeams = numberOfPromotedTeams;
		this.numberOfRelegatedTeams = numberOfRelegatedTeams;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public int getNumberOfClubs() {
		return numberOfClubs;
	}

	public void setNumberOfClubs(int numberOfClubs) {
		this.numberOfClubs = numberOfClubs;
	}

	public String getNumberOfPromotedTeams() {
		return numberOfPromotedTeams;
	}

	public void setNumberOfPromotedTeams(String numberOfPromotedTeams) {
		this.numberOfPromotedTeams = numberOfPromotedTeams;
	}

	public String getNumberOfRelegatedTeams() {
		return numberOfRelegatedTeams;
	}

	public void setNumberOfRelegatedTeams(String numberOfRelegatedTeams) {
		this.numberOfRelegatedTeams = numberOfRelegatedTeams;
	}

	public Set<ClubModel> getClubs() {
		return clubs;
	}

	public void setClubs(Set<ClubModel> clubs) {
		this.clubs = clubs;
	}

	public Set<MatchDayModel> getMatchDays() {
		return matchDays;
	}

	public void setMatchDays(Set<MatchDayModel> matchDays) {
		this.matchDays = matchDays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leagueId;
		result = prime * result + ((leagueName == null) ? 0 : leagueName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeagueModel other = (LeagueModel) obj;
		if (leagueId != other.leagueId)
			return false;
		if (leagueName == null) {
			if (other.leagueName != null)
				return false;
		} else if (!leagueName.equals(other.leagueName))
			return false;
		return true;
	}
	
	public void addClub(ClubModel club) {
		if (clubs==null) {
			clubs= new HashSet<ClubModel>();
		}
		clubs.add(club);
	}
	
	public void addMatchDay(MatchDayModel matchDay) {
		if (matchDays==null) {
			matchDays= new HashSet<MatchDayModel>();
		}
		matchDays.add(matchDay);
	}
}
