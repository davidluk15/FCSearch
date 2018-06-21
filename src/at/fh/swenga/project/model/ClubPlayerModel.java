package at.fh.swenga.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClubPlayer")
public class ClubPlayerModel implements java.io.Serializable {

	@Id
	@Column(name = "clubPlayerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clubPlayerId;
	
	@Column(nullable = false, length = 30)
	private String firstName;
	
	@Column(nullable = false, length = 30)
	private String lastName;
	
	@Column(nullable = false, length = 30)
	private int age;
	
	@Column(nullable = false, length = 30)
	private String playerPosition;
	
	@Column(nullable = false, length = 30)
	private int trikotNumber;
	
	
	public ClubPlayerModel() {
		super();
	}

	public ClubPlayerModel(String firstName, String lastName, int age, String playerPosition, int trikotNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.playerPosition = playerPosition;
		this.trikotNumber = trikotNumber;
	}

	public int getClubPlayerId() {
		return clubPlayerId;
	}

	public void setClubPlayerId(int clubPlayerId) {
		this.clubPlayerId = clubPlayerId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	public int getTrikotNumber() {
		return trikotNumber;
	}

	public void setTrikotNumber(int trikotNumber) {
		this.trikotNumber = trikotNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clubPlayerId;
		result = prime * result + trikotNumber;
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
		ClubPlayerModel other = (ClubPlayerModel) obj;
		if (clubPlayerId != other.clubPlayerId)
			return false;
		if (trikotNumber != other.trikotNumber)
			return false;
		return true;
	}
	
}
