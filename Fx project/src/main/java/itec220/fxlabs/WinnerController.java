package itec220.fxlabs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WinnerController {
	
	@FXML
    private Button playAgain;

    @FXML
    private Label winnerLabel;
    
    @FXML
    private ImageView winnerImage;
    
    @FXML
    void switchToEmptyGameBoard(ActionEvent event) throws IOException {
    	App.setRoot("gameboard");
    }
    
   
    public void initialize() {
    	
    	winnerLabel.setText(TicTacToe.getWinnerText());
    	winnerImage.setImage(new Image(getClass().getResourceAsStream("winner.png")));
    	
    	
    }

}
