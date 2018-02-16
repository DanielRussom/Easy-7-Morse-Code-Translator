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
		if (cbAudio.isSelected()) {
			// Checks if an audio converter is already running
			if (MorseToAudioConverter.isCurrentlyPlaying) {
				// Triggers the stop flag
				MorseToAudioConverter.currentPlaying.stopFlag = true;
			}
			try {
				// Starts a new converter and stores it
				MorseToAudioConverter converter = new MorseToAudioConverter();
				MorseToAudioConverter.currentPlaying = converter;
				// Sets the message to play and runs a thread
				MorseToAudioConverter.setCurrentMessage(textEnglish);
				converter.start();
			} catch (Exception e) {
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
