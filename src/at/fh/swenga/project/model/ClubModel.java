package at.fh.swenga.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "Club")

public class ClubModel implements java.io.Serializable {

	@Id
	@Column(name = "clubId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clubId;

	@OneToMany(mappedBy = "club")
	@OrderBy("lastName, firstName")
	private Set<ClubPlayerModel> clubPlayers;

	@Column(nullable = false, length = 30)
	private String clubName;

	@Column(nullable = false, length = 30)
	private String location;

	@Column(nullable = false, length = 30)
	private String trainingDays;

	@Column(nullable = false, length = 30)
	private String coach;

	@Column(nullable = false, length = 30)
	private String trainingTime;

	@Column(nullable = false, length = 30)
	private String sponsor;

	@Column(nullable = false, length = 30)
	private int foundingYear;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private LeagueModel league;

	public ClubModel() {
		super();
	}

	public ClubModel(String clubName, String location, String trainingDays, String coach, String trainingTime,
			String sponsor, int foundingYear) {
		super();
		this.clubName = clubName;
		this.location = location;
		this.trainingDays = trainingDays;
		this.coach = coach;
		this.trainingTime = trainingTime;
		this.sponsor = sponsor;
		this.foundingYear = foundingYear;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTrainingDays() {
		return trainingDays;
	}

	public void setTrainingDays(String trainingDays) {
		this.trainingDays = trainingDays;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getTrainingTime() {
		return trainingTime;
	}

	public void setTrainingTime(String trainingTime) {
		this.trainingTime = trainingTime;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public int getFoundingYear() {
		return foundingYear;
	}

	public void setFoundingYear(int foundingYear) {
		this.foundingYear = foundingYear;
	}

	public LeagueModel getLeague() {
		return league;
	}

	public void setLeague(LeagueModel league) {
		this.league = league;
	}
	
	public void addClubPlayer(ClubPlayerModel clubPlayer) {
		if (clubPlayers==null) {
			clubPlayers= new HashSet<ClubPlayerModel>();
		}
		clubPlayers.add(clubPlayer);
	}

}
