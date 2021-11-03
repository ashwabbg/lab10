package cz.jezek.lab11;

public class StreamMain {

  public static void main(String[] args) {
    Tournament tournament = Tournament.generate();

    printStatAboutTournament(tournament);

    saveTournament(tournament);
    loadTournament();
  }

  public static void printStatAboutTournament(Tournament tournament) {
    System.out.println(tournament);
    Player player = tournament.getRandomPlayer();

    System.out.println(player);
    System.out.print("Number of matches: ");
    //TODO 3.a Show the number of matches played by a given player (using Streams)
    long numOfMatches = tournament.getMatches()
    .stream()
    .filter(m-> m.getOponents().getPlayer1().equals(player) || m.getOponents().getPlayer2().equals(player)).count();
    System.out.print(numOfMatches);
    System.out.print("Goals scored: ");

    //TODO 3.b Show the number of goals scored by a given player (help Streams)
    tournament.getMatches()
    .stream()
	.filter(m -> m.getOponents().getPlayer1().equals(player) 
			||m.getOponents().getPlayer2().equals(player))
	.map(m -> getScoreOfGivenPlayer(m, player))
	.mapToInt( val -> val.intValue());
    
    Oponents oponents = new Oponents(tournament.getRandomPlayer(),
        tournament.getRandomPlayer());
    System.out.println("Mutual statistics of oponents:" + oponents);
    
    System.out.print("Matches: ");
    //TODO 4.a List the matches played between the given players (using the stream)
    System.out.print("Number of mathes: ");
    //TODO 4.b Print the number of matches played between the given players (using the stream)
    System.out.print("Zápas s největším počtem branek:");
    //TODO 4.c Show match with the largest total number (sum of both players) scored goals between relevant players (help Streams)
  }
  
  private static Integer getScoreOfGivenPlayer(Match m, Player player) {
	  if (m.getOponents().getPlayer1() == player)
		  return m.getPlayer1Scorel();
	  else
		  return m.getPlayer2Scorel();
  }

  public static void loadTournament() {
    //TODO 5.b Load a serialized tournament from a file
  }

  public static void saveTournament(Tournament tournament) {
    //TODO 5.a Save the tournament to a file using object serialization.
  }
}
