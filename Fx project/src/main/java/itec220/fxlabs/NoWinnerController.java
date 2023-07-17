package itec220.fxlabs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class NoWinnerController {
	
	@FXML
    private Button playAgain;

    @FXML
    private Label tieLabel;

    @FXML
    void restartGame(ActionEvent event) throws IOException {
    	App.setRoot("gameboard");

    }

	public void initialize() {
		tieLabel.setText(TicTacToe.getWinnerText());
		
	}
	
	

}
