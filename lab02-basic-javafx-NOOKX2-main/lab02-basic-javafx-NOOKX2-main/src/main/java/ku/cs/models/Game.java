package ku.cs.models;

public class Game {
    private String playerName;
    private double hp;
    private double attack;

    public Game(String playerName, double hp, double attack) {
        this.playerName = playerName;
        this.hp = hp;
        this.attack = attack;

    }

    public String getPlayerName() {
        return playerName;
    }

    public double getHp() {
        return hp;
    }

    public double getAttack() {
        return attack;
    }

    public void buff(){
        attack = attack*100;
    }

    public boolean isPlayerName(String playerName) {
        return this.playerName.equals(playerName);
    }
    public void addHp(double hpAdd) {hp += hpAdd; }

    public void addAttack(double attackAdd) {attack += attackAdd ; }

    @Override
    public String toString() {
        return "Game{" +
                "playerName='" + playerName + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                '}';
    }
}