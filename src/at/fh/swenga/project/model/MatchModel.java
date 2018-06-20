package at.fh.swenga.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Match")
public class MatchModel implements java.io.Serializable{
	
	@Id
	@Column(name = "matchId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matchId;
	
	@Column(nullable = false, length = 30)
	private String home;
	
	@Column(nullable = false, length = 30)
	private String guest;
	
	@Column(nullable = false, length = 30)
	private String matchTime;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private MatchDayModel matchDay;
	
	
	public MatchModel() {
		super();
	}
	
	public MatchModel(String home, String guest, String matchTime) {
		super();
		this.home = home;
		this.guest = guest;
		this.matchTime = matchTime;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getHome() {
		return home;
	}


	public void setHome(String home) {
		this.home = home;
	}


	public String getGuest() {
		return guest;
	}


	public void setGuest(String guest) {
		this.guest = guest;
	}


	public String getMatchTime() {
		return matchTime;
	}


	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matchId;
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
		MatchModel other = (MatchModel) obj;
		if (matchId != other.matchId)
			return false;
		return true;
	}
}
