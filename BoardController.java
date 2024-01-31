package application;
import javafx.fxml.FXML;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import javafx.scene.shape.Line;

public class BoardController {
	
	@FXML private Button reset;
	@FXML private Button easy;
	@FXML private Button hard;
	@FXML private Label winLabel;
	@FXML private Label warning;
	@FXML private Label title;
	@FXML private AnchorPane pane;
	@FXML private Line rightArrow;
	@FXML private Line leftArrow;
	@FXML private Line vertArrow;
	@FXML private Line hoArrow;
	
	@FXML private Button col1;
	@FXML private Button col2;
	@FXML private Button col3;
	@FXML private Button col4;
	@FXML private Button col5;
	@FXML private Button col6;
	@FXML private Button col7;
	
	@FXML private Circle aOne;
	@FXML private Circle aTwo;
	@FXML private Circle aThree;
	@FXML private Circle aFour;
	@FXML private Circle aFive;
	@FXML private Circle aSix;
	@FXML private Circle aSeven;
	
	@FXML private Circle bOne;
	@FXML private Circle bTwo;
	@FXML private Circle bThree;
	@FXML private Circle bFour;
	@FXML private Circle bFive;
	@FXML private Circle bSix;
	@FXML private Circle bSeven;

	@FXML private Circle cOne;
	@FXML private Circle cTwo;
	@FXML private Circle cThree;
	@FXML private Circle cFour;
	@FXML private Circle cFive;
	@FXML private Circle cSix;
	@FXML private Circle cSeven;
	
	@FXML private Circle dOne;
	@FXML private Circle dTwo;
	@FXML private Circle dThree;
	@FXML private Circle dFour;
	@FXML private Circle dFive;
	@FXML private Circle dSix;
	@FXML private Circle dSeven;
	
	@FXML private Circle eOne;
	@FXML private Circle eTwo;
	@FXML private Circle eThree;
	@FXML private Circle eFour;
	@FXML private Circle eFive;
	@FXML private Circle eSix;
	@FXML private Circle eSeven;

	@FXML private Circle fOne;
	@FXML private Circle fTwo;
	@FXML private Circle fThree;
	@FXML private Circle fFour;
	@FXML private Circle fFive;
	@FXML private Circle fSix;
	@FXML private Circle fSeven;
	
	@FXML private Rectangle topRect;
	@FXML private Rectangle bottomRect;
	@FXML private Rectangle leftRect;
	@FXML private Rectangle rightRect;
	
	private RandomAI rando = new RandomAI();
	
	private ArrayList<ArrayList<chips>> chip = new ArrayList<ArrayList<chips>>();
	
	private boolean thoughtAI = true;
	private boolean redo = false;
	private boolean disableBoard;
	private int rowLog = 0;
	private int colLog = 0;
	private boolean player = true;

	PauseTransition pause = new PauseTransition(Duration.seconds(1));
    BorderStroke borderStroke = new BorderStroke(
            Color.BLACK,
            BorderStrokeStyle.SOLID,
            new CornerRadii(2),
            BorderStroke.THIN
    );

    Border border = new Border(borderStroke);
    
    BorderStroke borderStroke2 = new BorderStroke(
            Color.BLACK,
            BorderStrokeStyle.SOLID,
            new CornerRadii(2),
            BorderStroke.THIN
    );

    Border border2 = new Border(borderStroke2);
	
	
	public void initialize() {
		
	    try {
	        File file = new File("filename.txt");
	        if (file.createNewFile()) {
	          System.out.println("File created: " + file.getName());
	        } 
	        else {
	          System.out.println("File already exists.");
	        }
	    }   
	    catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
		
	    hoArrow.setVisible(true);
	    vertArrow.setVisible(true);
	    leftArrow.setVisible(true);
	    rightArrow.setVisible(true);
	    easy.toFront();
	    hard.toFront();
	    rowLog = 0;
	    colLog = 0;
		easy.setText("Easy");
		hard.setText("Hard");
		easy.setVisible(true);
		hard.setVisible(true);
		easy.setDisable(false);
		hard.setDisable(false);
		easy.setFont(Font.font("Chalkboard", FontWeight.BOLD, 14));
		hard.setFont(Font.font("Chalkboard", FontWeight.BOLD, 14));
		easy.setStyle("-fx-background-color: #CCCCCC");
		hard.setStyle("-fx-background-color: #CCCCCC");
		easy.setTextFill(Color.rgb(0, 0, 0));
		hard.setTextFill(Color.rgb(0, 0, 0));
		easy.setBorder(border2);
		hard.setBorder(border2);
		reset.setDisable(false);
		reset.setFont(Font.font("Press Start 2P", FontWeight.BOLD, 14));
		reset.setShape(new Circle(1.5));
		reset.setStyle("-fx-background-color: red");
		reset.setTextFill(Color.rgb(255,255,255));
		reset.setBorder(border);
		reset.setPadding(new javafx.geometry.Insets(5));
		reset.setVisible(false);
		winLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		winLabel.setText("");
		winLabel.setTextFill(Color.rgb(0,0,102));
		warning.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		warning.setText("Choose a difficulty!");
		title.setFont(Font.font(30));
		title.setTextFill(Color.rgb(0, 50, 100));
		title.setText("Connect Four");
		title.setPrefSize(400, 20);
		disableBoard = false;
		pane.setStyle("-fx-background-color: #d6e1e5");
		
		col1.setStyle("-fx-background-color: #1f6ddb");
		col2.setStyle("-fx-background-color: #1f6ddb");
		col3.setStyle("-fx-background-color: #1f6ddb");
		col4.setStyle("-fx-background-color: #1f6ddb");
		col5.setStyle("-fx-background-color: #1f6ddb");
		col6.setStyle("-fx-background-color: #1f6ddb");
		col7.setStyle("-fx-background-color: #1f6ddb");
		bottomRect.setFill(Color.rgb(31, 109, 219));
		topRect.setFill(Color.rgb(31, 109, 219));
		leftRect.setFill(Color.rgb(31, 109, 219));
		rightRect.setFill(Color.rgb(31, 109, 219));
		col1.setDisable(true);
		col2.setDisable(true);
		col3.setDisable(true);
		col4.setDisable(true);
		col5.setDisable(true);
		col6.setDisable(true);
		col7.setDisable(true);
		
		aOne.setMouseTransparent(true);
		aTwo.setMouseTransparent(true);
		aThree.setMouseTransparent(true);
		aFour.setMouseTransparent(true);
		aFive.setMouseTransparent(true);
		aSix.setMouseTransparent(true);
		aSeven.setMouseTransparent(true);
		
		bOne.setMouseTransparent(true);
		bTwo.setMouseTransparent(true);
		bThree.setMouseTransparent(true);
		bFour.setMouseTransparent(true);
		bFive.setMouseTransparent(true);
		bSix.setMouseTransparent(true);
		bSeven.setMouseTransparent(true);
		
		cOne.setMouseTransparent(true);
		cTwo.setMouseTransparent(true);
		cThree.setMouseTransparent(true);
		cFour.setMouseTransparent(true);
		cFive.setMouseTransparent(true);
		cSix.setMouseTransparent(true);
		cSeven.setMouseTransparent(true);
		
		dOne.setMouseTransparent(true);
		dTwo.setMouseTransparent(true);
		dThree.setMouseTransparent(true);
		dFour.setMouseTransparent(true);
		dFive.setMouseTransparent(true);
		dSix.setMouseTransparent(true);
		dSeven.setMouseTransparent(true);
		
		eOne.setMouseTransparent(true);
		eTwo.setMouseTransparent(true);
		eThree.setMouseTransparent(true);
		eFour.setMouseTransparent(true);
		eFive.setMouseTransparent(true);
		eSix.setMouseTransparent(true);
		eSeven.setMouseTransparent(true);
		
		fOne.setMouseTransparent(true);
		fTwo.setMouseTransparent(true);
		fThree.setMouseTransparent(true);
		fFour.setMouseTransparent(true);
		fFive.setMouseTransparent(true);
		fSix.setMouseTransparent(true);
		fSeven.setMouseTransparent(true);
		
		aOne.setFill(Color.rgb(214, 225, 229));
		aTwo.setFill(Color.rgb(214, 225, 229));
		aThree.setFill(Color.rgb(214, 225, 229));
		aFour.setFill(Color.rgb(214, 225, 229));
		aFive.setFill(Color.rgb(214, 225, 229));
		aSix.setFill(Color.rgb(214, 225, 229));
		aSeven.setFill(Color.rgb(214, 225, 229));
		
		bOne.setFill(Color.rgb(214, 225, 229));
		bTwo.setFill(Color.rgb(214, 225, 229));
		bThree.setFill(Color.rgb(214, 225, 229));
		bFour.setFill(Color.rgb(214, 225, 229));
		bFive.setFill(Color.rgb(214, 225, 229));
		bSix.setFill(Color.rgb(214, 225, 229));
		bSeven.setFill(Color.rgb(214, 225, 229));
		
		cOne.setFill(Color.rgb(214, 225, 229));
		cTwo.setFill(Color.rgb(214, 225, 229));
		cThree.setFill(Color.rgb(214, 225, 229));
		cFour.setFill(Color.rgb(214, 225, 229));
		cFive.setFill(Color.rgb(214, 225, 229));
		cSix.setFill(Color.rgb(214, 225, 229));
		cSeven.setFill(Color.rgb(214, 225, 229));
		
		dOne.setFill(Color.rgb(214, 225, 229));
		dTwo.setFill(Color.rgb(214, 225, 229));
		dThree.setFill(Color.rgb(214, 225, 229));
		dFour.setFill(Color.rgb(214, 225, 229));
		dFive.setFill(Color.rgb(214, 225, 229));
		dSix.setFill(Color.rgb(214, 225, 229));
		dSeven.setFill(Color.rgb(214, 225, 229));
		
		eOne.setFill(Color.rgb(214, 225, 229));
		eTwo.setFill(Color.rgb(214, 225, 229));
		eThree.setFill(Color.rgb(214, 225, 229));
		eFour.setFill(Color.rgb(214, 225, 229));
		eFive.setFill(Color.rgb(214, 225, 229));
		eSix.setFill(Color.rgb(214, 225, 229));
		eSeven.setFill(Color.rgb(214, 225, 229));
		
		fOne.setFill(Color.rgb(214, 225, 229));
		fTwo.setFill(Color.rgb(214, 225, 229));
		fThree.setFill(Color.rgb(214, 225, 229));
		fFour.setFill(Color.rgb(214, 225, 229));
		fFive.setFill(Color.rgb(214, 225, 229));
		fSix.setFill(Color.rgb(214, 225, 229));
		fSeven.setFill(Color.rgb(214, 225, 229));
		
		
		ArrayList<chips> row;
		for (int r = 0; r < 6; r++) {
			row = new ArrayList<chips>();
			for (int c = 0; c < 7; c++) {
				row.add(new chips('x'));
			}
			chip.add(row);
		}
		assignCircles();
		for (int r = 0; r < 6; ++r) {
			for (int c = 0; c < 7; ++c) {
				chip.get(r).get(c).setWinningLine(false);
			}
		}
		
		clearFile("filename.txt");
	}
	
	public void assignCircles() {
		chip.get(0).get(0).setCircle(aOne);
		chip.get(0).get(1).setCircle(aTwo);
		chip.get(0).get(2).setCircle(aThree);
		chip.get(0).get(3).setCircle(aFour);
		chip.get(0).get(4).setCircle(aFive);
		chip.get(0).get(5).setCircle(aSix);
		chip.get(0).get(6).setCircle(aSeven);
		
		chip.get(1).get(0).setCircle(bOne);
		chip.get(1).get(1).setCircle(bTwo);
		chip.get(1).get(2).setCircle(bThree);
		chip.get(1).get(3).setCircle(bFour);
		chip.get(1).get(4).setCircle(bFive);
		chip.get(1).get(5).setCircle(bSix);
		chip.get(1).get(6).setCircle(bSeven);
		
		chip.get(2).get(0).setCircle(cOne);
		chip.get(2).get(1).setCircle(cTwo);
		chip.get(2).get(2).setCircle(cThree);
		chip.get(2).get(3).setCircle(cFour);
		chip.get(2).get(4).setCircle(cFive);
		chip.get(2).get(5).setCircle(cSix);
		chip.get(2).get(6).setCircle(cSeven);
		
		chip.get(3).get(0).setCircle(dOne);
		chip.get(3).get(1).setCircle(dTwo);
		chip.get(3).get(2).setCircle(dThree);
		chip.get(3).get(3).setCircle(dFour);
		chip.get(3).get(4).setCircle(dFive);
		chip.get(3).get(5).setCircle(dSix);
		chip.get(3).get(6).setCircle(dSeven);
		
		chip.get(4).get(0).setCircle(eOne);
		chip.get(4).get(1).setCircle(eTwo);
		chip.get(4).get(2).setCircle(eThree);
		chip.get(4).get(3).setCircle(eFour);
		chip.get(4).get(4).setCircle(eFive);
		chip.get(4).get(5).setCircle(eSix);
		chip.get(4).get(6).setCircle(eSeven);
		
		chip.get(5).get(0).setCircle(fOne);
		chip.get(5).get(1).setCircle(fTwo);
		chip.get(5).get(2).setCircle(fThree);
		chip.get(5).get(3).setCircle(fFour);
		chip.get(5).get(4).setCircle(fFive);
		chip.get(5).get(5).setCircle(fSix);
		chip.get(5).get(6).setCircle(fSeven);
		
		for (int r = 0; r < 6; ++r) {
			for (int c = 0; c < 7; ++c) {
				chip.get(r).get(c).setVert(0);
				chip.get(r).get(c).setHo(0);
				chip.get(r).get(c).setVertRed(0);
				chip.get(r).get(c).setHoRed(0);
				chip.get(r).get(c).setDiag1(0);
				chip.get(r).get(c).setDiag2(0);
				chip.get(r).get(c).setDiag1Red(0);
				chip.get(r).get(c).setDiag2Red(0);
			}
		}
		for (int row = 0; row < 6; ++row) {
			for (int col = 0; col < 7; ++col) {
				chip.get(row).get(col).setWinningLine(false);
			}
		}
	}
	
	public void setRandom(ActionEvent e) {
		thoughtAI = false;
		col1.setDisable(false);
		col2.setDisable(false);
		col3.setDisable(false);
		col4.setDisable(false);
		col5.setDisable(false);
		col6.setDisable(false);
		col7.setDisable(false);
		easy.setVisible(false);
		hard.setVisible(false);
		easy.setDisable(true);
		hard.setDisable(true);
		reset.setVisible(true);
	    hoArrow.setVisible(false);
	    vertArrow.setVisible(false);
	    leftArrow.setVisible(false);
	    rightArrow.setVisible(false);
		warning.setText("");
		winLabel.setText("Winner:");
	}
	
	public void setThoughtful(ActionEvent e) {
		thoughtAI = true;
		col1.setDisable(false);
		col2.setDisable(false);
		col3.setDisable(false);
		col4.setDisable(false);
		col5.setDisable(false);
		col6.setDisable(false);
		col7.setDisable(false);
		easy.setVisible(false);
		hard.setVisible(false);
		easy.setDisable(true);
		hard.setDisable(true);
		reset.setVisible(true);
	    hoArrow.setVisible(false);
	    vertArrow.setVisible(false);
	    leftArrow.setVisible(false);
	    rightArrow.setVisible(false);
		warning.setText("");
		winLabel.setText("Winner:");
	}
	
	public void resetGame(ActionEvent e) {
		initialize();
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				System.out.print(chip.get(r).get(c).getCharacter());
				System.out.print(" ");
				chip.get(r).get(c).setCharacter('x');
			}
			System.out.println("");
		}
		System.out.println("");
		
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				System.out.print(chip.get(r).get(c).getBool());
				System.out.print(" ");
				chip.get(r).get(c).setBool(false);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void clearFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, false);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the file: " + fileName);
            e.printStackTrace();
        }
    }
	
	public void win(char character) {
		ArrayList<Circle> highlight = new ArrayList<Circle>();
		if (character == 'x') {
			return;
		}
		else if (character == 'r') {
			for (int row = 0; row < 6; ++row) {
				for (int col = 0; col < 7; ++col) {
					System.out.print(chip.get(row).get(col).getWinningLine() + " ");
					if(chip.get(row).get(col).getWinningLine()) {
					    highlight.add(chip.get(row).get(col).getCircle());
					}
					System.out.println("");
				}
			}
			col1.setDisable(true);
			col2.setDisable(true);
			col3.setDisable(true);
			col4.setDisable(true);
			col5.setDisable(true);
			col6.setDisable(true);
			col7.setDisable(true);
			reset.setDisable(true);
		    pause.setOnFinished(e -> {
		    	for (int i = 0; i < highlight.size(); ++i) {
		    		highlight.get(i).setFill(Color.rgb(255, 0, 0));
			  	}
		    	winLabel.setTextFill(Color.rgb(255, 102, 102));
		    	winLabel.setText("Winner: Red!");
				col1.setDisable(false);
				col2.setDisable(false);
				col3.setDisable(false);
				col4.setDisable(false);
				col5.setDisable(false);
				col6.setDisable(false);
				col7.setDisable(false);
				reset.setDisable(false);
		    });
		    pause.play();
		}
		else if (character == 'y'){
			for (int row = 0; row < 6; ++row) {
				for (int col = 0; col < 7; ++col) {
					System.out.print(chip.get(row).get(col).getWinningLine() + " ");
					if(chip.get(row).get(col).getWinningLine()) {
						highlight.add(chip.get(row).get(col).getCircle());
					}
				}
				System.out.println("");
			}
			col1.setDisable(true);
			col2.setDisable(true);
			col3.setDisable(true);
			col4.setDisable(true);
			col5.setDisable(true);
			col6.setDisable(true);
			col7.setDisable(true);
			reset.setDisable(true);
		        pause.setOnFinished(e -> {
		        	for (int i = 0; i < highlight.size(); ++i) {
		        		highlight.get(i).setFill(Color.rgb(255, 255, 0));
		        	}
		        	winLabel.setTextFill(Color.rgb(255, 165, 0));
		        	winLabel.setText("Winner: Yellow!");
					col1.setDisable(false);
					col2.setDisable(false);
					col3.setDisable(false);
					col4.setDisable(false);
					col5.setDisable(false);
					col6.setDisable(false);
					col7.setDisable(false);
					reset.setDisable(false);
		        });
		        pause.play();

		}
		disableBoard = true;
	}
	
	public void randAIMove() {
		int colMove = rando.randomMove();
		int rowCnt = 5;
		while (rowCnt >= 0 && chip.get(rowCnt).get(colMove).getCharacter() != 'x') {
			rowCnt--;
		}
		if (chip.get(0).get(colMove).getCharacter() == 'x') {
			int rowNum = rowCnt;
			int colNum = colMove;
			chip.get(rowCnt).get(colMove).setCharacter('y');
	        chip.get(rowNum).get(colNum).getCircle().setFill(Color.rgb(255, 255, 153));
	        rowLog = rowNum;
	        colLog = colNum;
		}
		else {
			randAIMove();
		}
	}
	
	public void legalMoves() {
		for (int col = 0; col < 7; col++) {
			int rowCnt = 5;
			while (rowCnt >= 0 && chip.get(rowCnt).get(col).getCharacter() != 'x') {
				rowCnt--;
			}
			if (chip.get(0).get(col).getCharacter() == 'x') {
				chip.get(rowCnt).get(col).setBool(true);
			}
		}
	}
	
	
	public void thoughtfulAIMove() {
		legalMoves();
	    getMoveStats();
	    setAPiece();
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				chip.get(r).get(c).setBool(false);
			}
		}
	}
	
	public void getMoveStats() {
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				if (chip.get(r).get(c).getBool() == true) {
					if (r < 5) {
						int row = r + 1;
						int vertical = 0;
						while (row < 6 && chip.get(row).get(c).getCharacter() == 'y') {
							vertical++;
							chip.get(r).get(c).setVert(vertical);
							row++;
						}
						row = r + 1;
						vertical = 0;
						while (row < 6 && chip.get(row).get(c).getCharacter() == 'r') {
							vertical++;
							chip.get(r).get(c).setVertRed(vertical);
							row++;
						}
					}
					int horizontal = 0;
					int horizontalRed = 0;
					if (c > 0) {
						int col1 = c - 1;
						while (col1 >= 0 && chip.get(r).get(col1).getCharacter() == 'y') {
							System.out.println("Row: " + r + " Col: " + col1 + " " + chip.get(r).get(col1).getCharacter());
							horizontal++;
							chip.get(r).get(c).setHo(horizontal);
							col1--;
						}
						col1 = c - 1;
						while (col1 >= 0 && chip.get(r).get(col1).getCharacter() == 'r') {
							System.out.println("Row: " + r + " Col: " + col1 + " " + chip.get(r).get(col1).getCharacter());
							horizontalRed++;
							chip.get(r).get(c).setHoRed(horizontalRed);
							col1--;
						}
					}
					if (c < 6) {
						int col2 = c + 1;
						while (col2 < 7 && chip.get(r).get(col2).getCharacter() == 'y') {
							System.out.println("Row: " + r + " Col: " + col2 + " " + chip.get(r).get(col2).getCharacter());
							horizontal++;
							chip.get(r).get(c).setHo(horizontal);
							col2++;
						}
						col2 = c + 1;
						while (col2 < 7 && chip.get(r).get(col2).getCharacter() == 'r') {
							System.out.println("Row: " + r + " Col: " + col2 + " " + chip.get(r).get(col2).getCharacter());
							horizontalRed++;
							chip.get(r).get(c).setHoRed(horizontalRed);
							col2++;
						}
					}
					int downLeftTopRight = 0;
					int downLeftTopRightRed = 0;
					if (r < 5 && c > 0) {
						int rowNum1 = r + 1;
						int colNum1 = c - 1;
						while (colNum1 >= 0 && rowNum1 < 6 && chip.get(rowNum1).get(colNum1).getCharacter() == 'y') {
							downLeftTopRight++;
							chip.get(r).get(c).setDiag1(downLeftTopRight);
							rowNum1++;
							colNum1--;
						}
						rowNum1 = r + 1;
						colNum1 = c - 1;
						while (colNum1 >= 0 && rowNum1 < 6 && chip.get(rowNum1).get(colNum1).getCharacter() == 'r') {
							downLeftTopRightRed++;
							chip.get(r).get(c).setDiag1Red(downLeftTopRightRed);
							rowNum1++;
							colNum1--;
						}
					}
					if (c < 6 && r > 0) {
						int rowNum2 = r - 1;
						int colNum2 = c + 1;
						while (colNum2 < 7 && rowNum2 >= 0 && chip.get(rowNum2).get(colNum2).getCharacter() == 'y') {
							downLeftTopRight++;
							chip.get(r).get(c).setDiag1(downLeftTopRight);
							rowNum2--;
							colNum2++;
						}
						rowNum2 = r - 1;
						colNum2 = c + 1;
						while (colNum2 < 7 && rowNum2 >= 0 && chip.get(rowNum2).get(colNum2).getCharacter() == 'r') {
							downLeftTopRightRed++;
							chip.get(r).get(c).setDiag1Red(downLeftTopRightRed);
							rowNum2--;
							colNum2++;
						}
					}
					int downRightTopLeft = 0;
					int downRightTopLeftRed = 0;
					if (r < 5 && c < 6) {
						int rowNum3 = r + 1;
						int colNum3 = c + 1;
						while (colNum3 < 7 && rowNum3 < 6 && chip.get(rowNum3).get(colNum3).getCharacter() == 'y') {
							downRightTopLeft++;
							chip.get(r).get(c).setDiag2(downRightTopLeft);
							rowNum3++;
							colNum3++;
						}
						rowNum3 = r + 1;
						colNum3 = c + 1;
						while (colNum3 < 7 && rowNum3 < 6 && chip.get(rowNum3).get(colNum3).getCharacter() == 'r') {
							downRightTopLeftRed++;
							chip.get(r).get(c).setDiag2Red(downRightTopLeftRed);
							rowNum3++;
							colNum3++;
						}
					}
					if (r > 0 && c > 0) {
						int rowNum4 = r - 1;
						int colNum4 = c - 1;
						while (colNum4 >= 0 && rowNum4 >= 0 && chip.get(rowNum4).get(colNum4).getCharacter() == 'y') {
							downRightTopLeft++;
							chip.get(r).get(c).setDiag2(downRightTopLeft);
							rowNum4--;
							colNum4--;
						}
						rowNum4 = r - 1;
						colNum4 = c - 1;
						while (colNum4 >= 0 && rowNum4 >= 0 && chip.get(rowNum4).get(colNum4).getCharacter() == 'r') {
							downRightTopLeftRed++;
							chip.get(r).get(c).setDiag2Red(downRightTopLeftRed);
							rowNum4--;
							colNum4--;
						}
					}
					
				}
			}
		}
	}
	
	public void setAPiece() {
		boolean firstWin = true;
		boolean thoughtWin = false;
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				if (chip.get(r).get(c).getVert() == 3 || chip.get(r).get(c).getHo() == 3 || chip.get(r).get(c).getDiag1() == 3 || chip.get(r).get(c).getDiag2() == 3) {
					thoughtAIWinOrBlock(firstWin, r, c);
					firstWin = false;
					thoughtWin = true;
				}
			}
		}
		boolean block = false;
		if (!thoughtWin) {
			boolean firstBlock = true;
			for (int r = 0; r < 6; r++) {
				for (int c = 0; c < 7; c++) {
					if (chip.get(r).get(c).getVertRed() == 3 || chip.get(r).get(c).getHoRed() == 3 || chip.get(r).get(c).getDiag1Red() == 3 || chip.get(r).get(c).getDiag2Red() == 3) {
						thoughtAIWinOrBlock(firstBlock, r, c);
						firstBlock = false;
						block = true;
					}
				}
			}
		}
		
		if (!thoughtWin && !block) {
			int finRow = 0;
			int finCol = 0;
			int max = 0;
			boolean first = true;
			for (int r = 0; r < 6; r++) {
				for (int c = 0; c < 7; c++) {
					if (chip.get(r).get(c).getBool() == true) {
						System.out.println("Row: " + r + " Col: " + c + " " + chip.get(r).get(c).getVert() + chip.get(r).get(c).getHo());
						System.out.println("Row: " + r + " Col: " + c + " " + chip.get(r).get(c).getVertRed() + chip.get(r).get(c).getHoRed());
						if (first) {
							if (chip.get(r).get(c).getVert() > chip.get(r).get(c).getHo() && chip.get(r).get(c).getVert() > chip.get(r).get(c).getDiag1() && chip.get(r).get(c).getVert() > chip.get(r).get(c).getDiag2()) {
								finRow = r;
								finCol = c;
								max = chip.get(r).get(c).getVert();
							}
							else if (chip.get(r).get(c).getHo() > chip.get(r).get(c).getDiag1() && chip.get(r).get(c).getHo() > chip.get(r).get(c).getDiag2()) {
								finRow = r;
								finCol = c;
								max = chip.get(r).get(c).getHo();
							}
							else if (chip.get(r).get(c).getDiag1() > chip.get(r).get(c).getDiag2()) {
								finRow = r;
								finCol = c;
								max = chip.get(r).get(c).getDiag1();
							}
							else {
								finRow = r;
								finCol = c;
								max = chip.get(r).get(c).getDiag2();
							}
							first = false;
						}
						else {
							if (chip.get(r).get(c).getVert() > max) {
								finRow = r;								
								finCol = c;
								max = chip.get(r).get(c).getVert();
							}
							if (chip.get(r).get(c).getHo() > max) {
								finRow = r;
								finCol = c;
								max = chip.get(r).get(c).getHo();
							}
							if (chip.get(r).get(c).getDiag1() > max) {
								finRow = r;
								finCol = c;
								max = chip.get(r).get(c).getDiag1();
							}
							if (chip.get(r).get(c).getDiag2() > max) {
								finRow = r;
								finCol = c;
								max = chip.get(r).get(c).getDiag2();
							}
						}
					}
				}
			}
			
			
			if (max == 0) {
				randAIMove();			
			}
			else {
				int row = finRow;
				int col = finCol;
				chip.get(finRow).get(finCol).setCharacter('y');
		        chip.get(row).get(col).getCircle().setFill(Color.rgb(255, 255, 153));
		        rowLog = row;
		        colLog = col;
				checkWin();
			}
		}
		for (int r = 0; r < 6; ++r) {
			for (int c = 0; c < 7; ++c) {
				chip.get(r).get(c).setVert(0);
				chip.get(r).get(c).setHo(0);
				chip.get(r).get(c).setVertRed(0);
				chip.get(r).get(c).setHoRed(0);
				chip.get(r).get(c).setDiag1(0);
				chip.get(r).get(c).setDiag2(0);
				chip.get(r).get(c).setDiag1Red(0);
				chip.get(r).get(c).setDiag2Red(0);
			}
		}
		System.out.println("");
		
	}
	
	public void thoughtAIWinOrBlock(boolean first, int row, int col) {
		if (first) {
			chip.get(row).get(col).setCharacter('y');
	        chip.get(row).get(col).getCircle().setFill(Color.rgb(255, 255, 153));
			checkWin();
		}
	}
	
	public void humanTurn(int col) {
		int rowCnt = 5;
		while (rowCnt >= 0 && chip.get(rowCnt).get(col).getCharacter() != 'x') {
			rowCnt--;
		}
		if (chip.get(0).get(col).getCharacter() == 'x') {
			int row = rowCnt;
			chip.get(rowCnt).get(col).setCharacter('r');
	        chip.get(row).get(col).getCircle().setFill(Color.rgb(255, 102, 102));
	        rowLog = row;
	        colLog = col;
		}
		else {
			warning.setText("Column full! Try again.");
			redo = true;
		}
	}
	
	public void checkWin() {
		for(int r = 0; r < 6; r++) {
			char charc = chip.get(r).get(0).getCharacter();
			int count = 1;
			if (charc != 'x') {
				chip.get(r).get(0).setWinningLine(true);
			}
			for(int c = 1; c < 7; c++) {
				if (charc == chip.get(r).get(c).getCharacter()) {
					count++;
					if (charc != 'x') {
						chip.get(r).get(c).setWinningLine(true);
					}
					if (count == 4) {
						win(charc);
					}
				}
				else {
					for (int row = 0; row < 6; ++row) {
						for (int col = 0; col < 7; ++col) {
							chip.get(row).get(col).setWinningLine(false);
						}
					}
					charc = chip.get(r).get(c).getCharacter();
					if (charc != 'x') {
						chip.get(r).get(c).setWinningLine(true);
					}
					count = 1;
				}
			}
		}
		
		for(int c = 0; c < 7; c++) {
			char charc = chip.get(0).get(c).getCharacter();
			int count = 1;
			if (charc != 'x') {
				chip.get(0).get(c).setWinningLine(true);
			}
			for(int r = 1; r < 6; r++) {
				if (charc == chip.get(r).get(c).getCharacter()) {
					count++;
					if (charc != 'x') {
						chip.get(r).get(c).setWinningLine(true);
					}
					if (count == 4) {
						win(charc);
					}
				}
				else {
					for (int row = 0; row < 6; ++row) {
						for (int col = 0; col < 7; ++col) {
							chip.get(row).get(col).setWinningLine(false);
						}
					}
					charc = chip.get(r).get(c).getCharacter();
					if (charc != 'x') {
						chip.get(r).get(c).setWinningLine(true);
					}
					count = 1;
				}
			}
		}
		for(int r = 3; r < 6; r++) {
			for(int c = 0; c < 4; c++) {
				char charc = chip.get(r).get(c).getCharacter();
				if (charc != 'x') {
					chip.get(r).get(c).setWinningLine(true);
				}
				boolean winMet = false;
				for(int count = 1; count < 4; count++ ) {
					if (charc == chip.get(r - count).get(c + count).getCharacter()) {
						if (charc != 'x') {
							chip.get(r - count).get(c + count).setWinningLine(true);
						}
						winMet = true;
					}
					else {
						for (int row = 0; row < 6; ++row) {
							for (int col = 0; col < 7; ++col) {
								chip.get(row).get(col).setWinningLine(false);
							}
						}
						winMet = false;
						charc = 'e';
					}
				}
				if (winMet == true) {
					win(charc);
				}
			}
		}
		
		for(int r = 3; r < 6; r++) {
			for(int c = 6; c > 2; c--) {
				char charc = chip.get(r).get(c).getCharacter();
				if (charc != 'x') {
					chip.get(r).get(c).setWinningLine(true);
				}
				boolean winMet = false;
				for(int count = 1; count < 4; count++ ) {
					if (charc == chip.get(r - count).get(c - count).getCharacter()) {
						if (charc != 'x') {
							chip.get(r - count).get(c - count).setWinningLine(true);
						}
						winMet = true;
					}
					else {
						for (int row = 0; row < 6; ++row) {
							for (int col = 0; col < 7; ++col) {
								chip.get(row).get(col).setWinningLine(false);
							}
						}
						winMet = false;
						charc = 'e';
					}
				}
				if (winMet == true) {
					win(charc);
				}
			}
		}
	}
 	
	public void buttonClick(Button butt, int col) {
		warning.setText("");
		if (disableBoard == true) {
			warning.setText("Sorry, game's over!");
		}
		else {
			humanTurn(col);
			player = true;
			logMove(rowLog, col);
			checkWin();
			
			if (!disableBoard) {
				if (!thoughtAI && redo == false) {	
					randAIMove();
				}
				else if(thoughtAI && redo == false) {
					thoughtfulAIMove();
				}
				redo = false;
			}
			player = false;
			logMove(rowLog, colLog);
			int fullBoard = 0;
			for (int r = 0; r < 6; ++r) {
				for (int c = 0; c < 7; ++c) {
					if (chip.get(r).get(c).getCharacter() == 'r' || chip.get(r).get(c).getCharacter() == 'y') {
						fullBoard++;
					}
				}
			}
			if (fullBoard == 42) {
				winLabel.setText("It's a tie!");
				disableBoard = true;
			}
		}
		checkWin();
		
	}
	
	public void logMove(int row, int col) {
	    try {
	        FileWriter myWriter = new FileWriter("filename.txt", true);
	        if (player) {
	        	myWriter.write("Red Move -    Row: " + row + " Col: " + col + "\n");
	        }
	        else {
	        	myWriter.write("Yellow Move - Row: " + row + " Col: " + col + "\n");
	        }
	        myWriter.close();
	    } 
	    catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
	}
	
	public void col1Click(ActionEvent e) {
		buttonClick(col1, 0);
	}
	public void col2Click(ActionEvent e) {
		buttonClick(col2, 1);
	}
	public void col3Click(ActionEvent e) {
		buttonClick(col3, 2);
	}
	public void col4Click(ActionEvent e) {
		buttonClick(col4, 3);
	}
	public void col5Click(ActionEvent e) {
		buttonClick(col5, 4);
	}
	public void col6Click(ActionEvent e) {
		buttonClick(col6, 5);
	}
	public void col7Click(ActionEvent e) {
		buttonClick(col7, 6);
	}

}
	
