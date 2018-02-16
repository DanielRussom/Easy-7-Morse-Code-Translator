package application.util;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MorseToAudioConverter extends Thread {
	public static float SAMPLE_RATE = 8000f;
	private static String currentMessage = "";
	public static boolean isCurrentlyPlaying = false;
	public static MorseToAudioConverter currentPlaying;
	public boolean stopFlag = false;

	public static void tone(int msecs) throws LineUnavailableException {
		byte[] buf = new byte[1];
		AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, false);
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open(af);
		sdl.start();
		for (int i = 0; i < msecs * 8; i++) {
			double angle = i / (SAMPLE_RATE / 500) * 2.0 * Math.PI;
			buf[0] = (byte) (Math.sin(angle) * 127.0 * 1.0);
			sdl.write(buf, 0, 1);
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
	}

	public void run() {
		isCurrentlyPlaying = true;
		for (int i = 0; i < currentMessage.length(); i++) {
			// Exits if the stop flag has been triggered
			if(stopFlag) {
				return;
			}
			try {
				// Performs either a tone or a pause based on the character
				switch (currentMessage.charAt(i)) {
				case '.':
					tone(250);
					break;
				case '-':
					tone(750);
					break;
				case '/':
					Thread.sleep(1500);
				default:
					Thread.sleep(500);
				}
				// Pauses between characters
				Thread.sleep(250);
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isCurrentlyPlaying = false;
	}

	/**
	 * Sets the current stored message
	 * 
	 * @param currentMessage
	 *            - message to be stored
	 */
	public static void setCurrentMessage(String currentMessage) {
		MorseToAudioConverter.currentMessage = currentMessage;
	}

}
