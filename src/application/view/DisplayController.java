package application.view;

import application.util.MorseCodeTranslator;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class DisplayController {

	@FXML
	private TextArea taMorseCode;
	
	@FXML private TextArea taEnglish;
	
	@FXML
	public void translateToMorseCode(){
		String textEnglish = taEnglish.getText();
		taMorseCode.setText(textEnglish + " but translated - TODO");
	}
	
	@FXML
	public void translateToEnglish(){
		String textMorse = MorseCodeTranslator.translateToEnglish(taMorseCode.getText());
		taEnglish.setText(textMorse);
	}
}
