package application.view;

import application.util.MorseCodeTranslator;
import application.util.MorseToAudioConverter;
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
		if(cbAudio.isSelected()){
			try {
				MorseToAudioConverter converter = new MorseToAudioConverter();
				MorseToAudioConverter.setCurrentMessage(textEnglish);
				converter.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void translateToEnglish() {
		String textMorse = MorseCodeTranslator.translateToEnglish(taMorseCode.getText());
		taEnglish.setText(textMorse);
	}
}
