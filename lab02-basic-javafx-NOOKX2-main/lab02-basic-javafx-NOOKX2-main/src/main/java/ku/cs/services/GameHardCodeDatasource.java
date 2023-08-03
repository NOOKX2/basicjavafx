package ku.cs.services;
import ku.cs.models.GameList;
public class GameHardCodeDatasource {
    public GameList readData() {
        GameList list = new GameList();
        list.addNewPlayer("First", 100, 1000);
        list.addNewPlayer("Second", 200, 2000);
        list.addNewPlayer("Third", 300, 3000);
        list.addNewPlayer("Fourth", 400, 4000);
        return list;
    }
}
