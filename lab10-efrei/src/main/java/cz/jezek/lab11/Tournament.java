package cz.jezek.lab11;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tournament {

  private List<Player> players;
  private List<Match> matches;

  public static Tournament generate() {
	// TODO 1.a Generate a list of 10 random players using the stream and then filter so that it does not contain players with the same name
	List<Player> players;
	players = Stream.generate(Player::generateRandom)
			.limit(10)
			.collect(Collectors.toList());
	
	// generaterandom in player

	Random rnd = new Random();
    List<Match> matches;
    matches = Stream.generate(()-> generateOneRandomMatch(players,rnd))
			.filter(t->true)
			.limit(50)
			.collect(Collectors.toList());


    return new Tournament(players, matches);
  }

  private static Match generateOneRandomMatch(List<Player> players, Random rnd) {
	  return new Match(RandomGenarator.selectRandom(players),rnd.nextInt(100), RandomGenarator.selectRandom(players), rnd.nextInt(100));
  }
  
  public Tournament(List<Player> players, List<Match> matches) {
    this.players = players;
    this.matches = matches;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public List<Match> getMatches() {
    return matches;
  }

  public Player getRandomPlayer() {
    return RandomGenarator.selectRandom(players);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Player count ").append(players.size())
        .append(" Match count: ").append(matches.size());
    builder.append("\n");

    builder.append("\n\nPlayers:\n");
    // TODO 2.a Use the stream to add a listing of all players to the builder. Individual players are separated by a "\ n" character
    String playerNames = players.stream().map(p -> p.toString()).collect(Collectors.joining("\n"));
    builder.append(playerNames);

    builder.append("\n\nMatches:\n");
    // TODO 2.b Use the stream to add a listing of all entries to the builder. Individual matches are separated by a "\ n" character
    String MatchNames = matches.stream().map(p -> p.toString()).collect(Collectors.joining("\n"));
    builder.append(MatchNames);

    return builder.toString();
  }

}
