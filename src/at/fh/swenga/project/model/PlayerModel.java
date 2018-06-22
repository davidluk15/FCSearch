package at.fh.swenga.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Player")

public class PlayerModel implements java.io.Serializable {

	@Id
	@Column(name = "playerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	
	@Column(nullable = false, length = 30)
	private String firstName;
	 
	@Column(nullable = false, length = 30)
	private String lastName;
	
	@Column(nullable = false, length = 30)
	private String position;
	
	@Column(nullable = false, length = 30)
	private int age;
	
	@Column(nullable = false, length = 30)
	private String availabelTrainingDays;
	
	@Version
	long version;

	@ManyToOne (cascade = CascadeType.PERSIST)
	private ClubModel club;
	
	
	public PlayerModel() {
		super();
	}

	public PlayerModel(String firstName, String lastName, String position, int age, String availabelTrainingDays) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.age = age;
		this.availabelTrainingDays = availabelTrainingDays;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getAvailabelTrainingDays() {
		return availabelTrainingDays;
	}

	public void setAvailabelTrainingDays(String availabelTrainingDays) {
		this.availabelTrainingDays = availabelTrainingDays;
	}

	public ClubModel getClub() {
		return club;
	}

	public void setClub(ClubModel club) {
		this.club = club;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + playerId;
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
		PlayerModel other = (PlayerModel) obj;
		if (playerId != other.playerId)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
