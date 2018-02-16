package application.util;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MorseToAudioConverter {
	public static float SAMPLE_RATE = 8000f;

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

	/**
	 * Plays the passed in morse code in audio format
	 * 
	 * @param morseCode
	 *            - the message to be played
	 */
	public static void playAudio(String morseCode) throws Exception {
		for (int i = 0; i < morseCode.length(); i++) {
			switch (morseCode.charAt(i)) {
			case '.':
				tone(400, 500);
				break;
			case '-':
				tone(400, 1000);
				break;
			default:
				Thread.sleep(500);
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			tone(400, 500);
		}
	}

}
