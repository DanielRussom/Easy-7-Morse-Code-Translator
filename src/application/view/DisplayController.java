package application.view;

import application.util.MorseCodeTranslator;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class DisplayController {

	@FXML
	private TextArea taMorseCode;

	@FXML
	private TextArea taEnglish;
	
	@FXML
	private CheckBox cbAudio;

	@FXML
	public void translateToMorseCode() {
		String textEnglish = MorseCodeTranslator.translateToMorseCode(taEnglish.getText());
		taMorseCode.setText(textEnglish);
	}

	@FXML
	public void translateToEnglish() {
		String textMorse = MorseCodeTranslator.translateToEnglish(taMorseCode.getText());
		taEnglish.setText(textMorse);
	}
	
	public boolean isAudioEnabled() {
		return cbAudio.isSelected();
	}
}
