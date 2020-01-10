package battleship;

import battleship.components.Boat;

public class Player {
	
	public static final int PLAYER_NUMBER = 1;
	public static final boolean IS_TURN = false;
	
	public boolean isTurn;
	public int playerNumber;
	public Boat[] playerBoats;
	
	public boolean playerWon = false;
	
	
	public Player(int playerNumber, boolean isTurn)
	{
		this.setPlayerNumber(playerNumber);
		this.setTurn(isTurn);
	}
	
	public Player(boolean isTurn)
	{
		this(PLAYER_NUMBER, isTurn);
	}
	
	public Player(int playerNumber)
	{
		this(playerNumber, IS_TURN);
	}
	
	public Player()
	{
		this(PLAYER_NUMBER, IS_TURN);
	}
	
	// Getters && Setters

	public boolean isTurn() {
		return this.isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public int getPlayerNumber() {
		return this.playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public Boat[] getPlayerBoats() {
		return this.playerBoats;
	}

	public void setPlayerBoats(Boat[] playerBoats) {
		this.playerBoats = playerBoats;
	}
	
	public boolean hasPlayerWon() {
		return this.playerWon;
	}

	public void setPlayerWon(boolean playerWon) {
		this.playerWon = playerWon;
	}

	
	// Methods
	
	public boolean arePlayerBoatsSunk()
	{
		for(int i = 0; i < this.getPlayerBoats().length; i++)
		{
			if (!this.getPlayerBoats()[i].isShipSunk())
			{
				return false;
			}
		}
		return true;
	}
	
	public void placeBoats()
	{
		
	}
	
}
