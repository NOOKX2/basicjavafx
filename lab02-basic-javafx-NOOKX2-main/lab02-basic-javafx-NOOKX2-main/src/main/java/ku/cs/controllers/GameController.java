package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Game;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class GameController {
    @FXML
    Label playerNameLabel;
    @FXML
    Label hpLabel;
    @FXML
    Label attackLabel;

    public void initialize() {
        Game game = new Game("NOOKX2", 20000, 1000);
        showGame(game);
    }

    private void showGame(Game game) {
        playerNameLabel.setText(game.getPlayerName());
        hpLabel.setText(game.getHp()+"");
        attackLabel.setText(game.getAttack()+"");

    }

    @FXML protected void onHandleButtonClick2(){
        try {
            FXRouter.goTo("game-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}