package at.fh.swenga.project.model;

import java.util.Calendar;
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
@Table(name = "MatchDay")
public class MatchDayModel implements java.io.Serializable{
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private LeagueModel league;
	
    @OneToMany(mappedBy="matchDay")
    @OrderBy("home, guest")
    private Set<MatchModel> matchs;

	@Id
	@Column(name = "matchDayId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matchDayId;
	
	@Column(nullable = false, length = 30)
	private Calendar matchDate;

	public MatchDayModel() {
		super();
	}

	public MatchDayModel(Calendar matchDate) {
		super();
		this.matchDate = matchDate;
	}

	public int getMatchDayId() {
		return matchDayId;
	}

	public void setMatchDayId(int matchDayId) {
		this.matchDayId = matchDayId;
	}

	public Calendar getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Calendar matchDate) {
		this.matchDate = matchDate;
	}

	public LeagueModel getLeague() {
		return league;
	}

	public void setLeague(LeagueModel league) {
		this.league = league;
	}

	public Set<MatchModel> getMatchs() {
		return matchs;
	}

	public void setMatchs(Set<MatchModel> matchs) {
		this.matchs = matchs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matchDayId;
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
		MatchDayModel other = (MatchDayModel) obj;
		if (matchDayId != other.matchDayId)
			return false;
		return true;
	}
	
	public void addMatch(MatchModel match) {
		if (matchs==null) {
			matchs= new HashSet<MatchModel>();
		}
		matchs.add(match);
	}
}
