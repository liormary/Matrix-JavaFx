/*******************************************************************
Create matrix and fill 10% of the rectangles in it 
Lior Mary 
*********************************************************************/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import java.util.Random;

public class MyProjectController {

  	@FXML
	private Canvas canvas;
	@FXML
	private VBox vbox;
	@FXML
	private GraphicsContext gc;

	public void initialize() {
		gc = canvas.getGraphicsContext2D();
	}
	
	@FXML
	void buttonPressed(ActionEvent event) {
		canvas.widthProperty().bind(vbox.widthProperty());
		canvas.heightProperty().bind((vbox.heightProperty()));
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		final int TEN = 10; //size of every rectangle inside the matrix
		int numOfColoredRects; //the number of the rectangles we need to fill
		int rectCounter = 0; //the number of the rectangles in the matrix
		int w = 0;
		int h = 0;
		Random r = new Random(); 
		
		//create empty matrix
		for (int i = 0; i < (canvas.getWidth() - TEN); i+=TEN) {
			for (int j = 0; j < (canvas.getHeight() - TEN); j+=TEN) {
				gc.strokeRect(i, j, TEN, TEN);
				rectCounter++;
			}
		}
		
		numOfColoredRects = (int)(rectCounter*0.1); //calculate the number of the rectangles we need to fill
		w = (int)((canvas.getHeight()-1)/TEN); //calculate the number of the rectangles in the height
		h = (int)((canvas.getWidth()-1)/TEN); //calculate the number of the rectangles in the width
		
		//fills 10% from the rectangles in the matrix
		for (int k = 0; k <= numOfColoredRects; k++) {
			gc.fillRect(r.nextInt(h)*TEN, r.nextInt(w)*TEN, TEN, TEN);
		}
	}

}


