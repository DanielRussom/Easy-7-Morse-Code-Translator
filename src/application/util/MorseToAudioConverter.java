package application.util;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MorseToAudioConverter extends Thread {
	public static float SAMPLE_RATE = 8000f;
	private static String currentMessage = "";

	public static void tone(int hz, int msecs) throws LineUnavailableException {
		byte[] buf = new byte[1];
		AudioFormat af = new AudioFormat(SAMPLE_RATE, // sampleRate
				8, // sampleSizeInBits
				1, // channels
				true, // signed
				false); // bigEndian
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open(af);
		sdl.start();
		for (int i = 0; i < msecs * 8; i++) {
			double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
			buf[0] = (byte) (Math.sin(angle) * 127.0 * 1.0);
			sdl.write(buf, 0, 1);
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
	}

	public void run() {
		for (int i = 0; i < currentMessage.length(); i++) {
			try {
				switch (currentMessage.charAt(i)) {
				case '.':
					tone(500, 250);
					break;
				case '-':
					tone(500, 750);
					break;
				case '/':
					Thread.sleep(1500);
				default:
					Thread.sleep(500);
				}
				Thread.sleep(250);
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
