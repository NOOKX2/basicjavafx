package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.Game;
import ku.cs.models.GameList;
import ku.cs.services.FXRouter;
import ku.cs.services.GameHardCodeDatasource;

import java.io.IOException;

public class GameListController {
    @FXML private ListView<Game> gameListView;
    @FXML private Label playerNameLabel;
    @FXML private Label hpLabel;
    @FXML private Label attackLabel;
    @FXML private Label errorLabel;
    @FXML private TextField giveHpTextField;
    @FXML private TextField giveAtkTextField;



    private GameList gameList;
    private Game selectedPlayer;

    @FXML
    public void initialize() {
        errorLabel.setText("");
        clearPlayerInfo();
        GameHardCodeDatasource datasource = new GameHardCodeDatasource();
        gameList = datasource.readData();
        showList(gameList);
        gameListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Game>() {
            @Override
            public void changed(ObservableValue<? extends Game> observable, Game oldValue, Game newValue) {
                if (newValue == null) {
                    clearPlayerInfo();
                    selectedPlayer = null;
                } else {
                    showPlayerInfo(newValue);
                    selectedPlayer = newValue;
                }
            }
        });
    }
    @FXML
    private void showList(GameList gameList) {
        gameListView.getItems().clear();
        gameListView.getItems().addAll(gameList.getPlayers());
    }

    private void showPlayerInfo(Game game) {
        playerNameLabel.setText(game.getPlayerName());
        hpLabel.setText(String.format("%.2f", game.getHp()));
        attackLabel.setText(String.format("%.2f", game.getAttack()));
    }

    private void clearPlayerInfo() {
        playerNameLabel.setText("");
        hpLabel.setText("");
        attackLabel.setText("");
    }

    @FXML
    public void onBackButtonClick3() {
        try {
            FXRouter.goTo("student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addHpButton() {
        if (selectedPlayer != null) {
            String hpText = giveHpTextField.getText();
            String errorMessage = "";
            try {
                double hpAdd = Double.parseDouble(hpText);
                gameList.giveHp(selectedPlayer.getPlayerName(), hpAdd);
                showPlayerInfo(selectedPlayer);
            } catch (NumberFormatException e) {
                errorMessage = "Please insert number value";
                errorLabel.setText(errorMessage);
            } finally {
                if (errorMessage.equals("")) {
                    giveHpTextField.setText("");
                }
            }
        } else {
            giveHpTextField.setText("");
            errorLabel.setText("");
        }
    }

    public void addAtkButton() {
        if (selectedPlayer != null) {
            String atkText = giveAtkTextField.getText();
            String errorMessage = "";
            try {
                double attackAdd = Double.parseDouble(atkText);
                gameList.giveAttack(selectedPlayer.getPlayerName(), attackAdd);
                showPlayerInfo(selectedPlayer);
            } catch (NumberFormatException e) {
                errorMessage = "Please insert number value";
                errorLabel.setText(errorMessage);
            } finally {
                if (errorMessage.equals("")) {
                    giveAtkTextField.setText("");
                }
            }
        } else {
            giveAtkTextField.setText("");
            errorLabel.setText("");
        }
    }




}