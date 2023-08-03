package ku.cs.models;

import java.util.ArrayList;
public class GameList {

    private ArrayList<Game> games;

    public GameList(){
        games = new ArrayList<>();
    }

    public void addNewPlayer(String playerName, double hp, double attack){
        playerName = playerName.trim();

        if (!playerName.equals("")) {
            Game exist = findPlayerByName(playerName);
            if (exist == null) {
                games.add(new Game(playerName.trim(), hp, attack));
            }
        }

    }

    public Game findPlayerByName(String playerName){
        for (Game game : games) {
            if (game.isPlayerName(playerName)) {
                return game;
            }
        }
        return null;
    }

    public void giveHp(String playerName, double hp) {
        Game exist = findPlayerByName(playerName);
        if (exist != null) {
            exist.addHp(hp);
        }
    }

    public void giveAttack(String playerName, double attack) {
        Game exist = findPlayerByName(playerName);
        if (exist != null) {
            exist.addAttack(attack);
        }
    }

    public void buffAtk(String playerName, double attack){
        Game exist = findPlayerByName(playerName);
        if (exist != null) {
            exist.buff();
        }
    }

    public ArrayList<Game> getPlayers() {
        return games;
    }
}
