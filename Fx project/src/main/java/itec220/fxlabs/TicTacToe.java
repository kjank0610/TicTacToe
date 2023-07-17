package itec220.fxlabs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;


public class TicTacToe {
	
	private int turnCount = 0;
	private ArrayList<Button> buttons = new ArrayList<>();
	private static String winnerText = "";
	private Image x = new Image(getClass().getResourceAsStream("x.png"));
	private Image o = new Image(getClass().getResourceAsStream("o.png"));
	private ImageCursor oCursor = new ImageCursor(x);
	private ImageCursor xCursor = new ImageCursor(o);

    @FXML
    private Label playerTurnLabel;

    @FXML
    private Button row0Col0;

    @FXML
    private Button row0Col1;

    @FXML
    private Button row0Col2;

    @FXML
    private Button row1Col0;

    @FXML
    private Button row1Col1;

    @FXML
    private Button row1Col2;

    @FXML
    private Button row2Col0;

    @FXML
    private Button row2Col1;

    @FXML
    private Button row2Col2;

    @FXML
    private Label title;

    @FXML
    private AnchorPane gameWindow;

    @FXML
    void buttonClick(ActionEvent actionEvent) {
    	if(actionEvent.getSource() == row0Col0) {
			row0Col0.setText(playerChar(row0Col0));
			row0Col0.setDisable(true);
		}else if(actionEvent.getSource() == row0Col1) {
			row0Col1.setText(playerChar(row0Col1));
			row0Col1.setDisable(true);
		}else if(actionEvent.getSource() == row0Col2) {
			row0Col2.setText(playerChar(row0Col2));
			row0Col2.setDisable(true);
		}else if(actionEvent.getSource() == row1Col0) {
			row1Col0.setText(playerChar(row1Col0));
			row1Col0.setDisable(true);
		}else if(actionEvent.getSource() == row1Col1) {
			row1Col1.setText(playerChar(row1Col1));
			row1Col1.setDisable(true);
		}else if(actionEvent.getSource() == row1Col2) {
			row1Col2.setText(playerChar(row1Col2));
			row1Col2.setDisable(true);
		}else if(actionEvent.getSource() == row2Col0) {
			row2Col0.setText(playerChar(row2Col0));
			row2Col0.setDisable(true);
		}else if(actionEvent.getSource() == row2Col1) {
			row2Col1.setText(playerChar(row2Col1));
			row2Col1.setDisable(true);
		}else {
			row2Col2.setText(playerChar(row2Col2));
			row2Col2.setDisable(true);
		}
		
		try {
			hasWinner();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    	
		turnCount++;

    }
    
    
    public void initialize() {
    	
    	buttons.add(row0Col0);
    	buttons.add(row0Col1);
    	buttons.add(row0Col2);
    	buttons.add(row1Col0);
    	buttons.add(row1Col1);
    	buttons.add(row1Col2);
    	buttons.add(row2Col1);
    	buttons.add(row2Col2);
    	buttons.add(row2Col0);
    	
        for(Button button : buttons) {
            button.setOnAction(this::buttonClick); 
        }
    	
    }
    
    public String playerChar(Button button) {
    	if(turnCount % 2 == 0) {
    		playerTurnLabel.setText("O's turn");
    		gameWindow.setCursor(xCursor);
    		button.setStyle("-fx-background-color: #ff0000;");
    		return "X";
    	}else {
    		playerTurnLabel.setText("X's turn");
    		gameWindow.setCursor(oCursor);
    		button.setStyle("-fx-background-color: #9acd32;");
    		return "O";
    	}
    }
    
    
    
    public void hasWinner() throws IOException {
    	ArrayList<Button[]> winningCombos = new ArrayList<>();
    	winningCombos.add(new Button[] {row0Col0, row0Col1, row0Col2}); // top row
    	winningCombos.add(new Button[] {row1Col0, row1Col1, row1Col2}); // middle row
    	winningCombos.add(new Button[] {row2Col0, row2Col1, row2Col2}); // bottom row
    	winningCombos.add(new Button[] {row0Col0, row1Col0, row2Col0}); // left col
    	winningCombos.add(new Button[] {row0Col1, row1Col1, row2Col1}); // middle col
    	winningCombos.add(new Button[] {row0Col2, row1Col2, row2Col2}); // right col
    	winningCombos.add(new Button[] {row0Col0, row1Col1, row2Col2}); // diagonal top left to bottom right
    	winningCombos.add(new Button[] {row2Col0, row1Col1, row0Col2}); // diagonal bottom left to top right
    	
    	boolean xWins = false;
    	boolean oWins = false;
    	boolean hasWinner = false;
    	
    	for(Button[] buttons : winningCombos) {
    		xWins = buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X");
    		oWins = buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O");
    		
    		if(xWins || oWins) {
    			hasWinner = true;
    			setWinnerText(buttons[0].getText());
    			App.setRoot("winnerscreen");
    		}

    	}
    	if(noWinner() && hasWinner == false) {
			setWinnerText("It's a tie!");
			App.setRoot("nowinnerscreen");
		}

    }
    
    public boolean noWinner() {
    	
    	for(Button b : buttons) {
    		if(!b.isDisabled()) {
    			return false;
    		}
    	}
    	return true;
    }

	public static String getWinnerText() {
		return winnerText;
	}

	public static void setWinnerText(String winner) {
		winnerText = winner;
	}

	
	
}
