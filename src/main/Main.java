package main;

import java.io.IOException;

import net.beadsproject.beads.data.audiofile.FileFormatException;
import net.beadsproject.beads.data.audiofile.OperationUnsupportedException;
import net.beadsproject.beads.data.audiofile.WavFileReaderWriter;



public class Main{
	public static void main(String [] argc){
		WavFileReaderWriter wavFileReader = new WavFileReaderWriter();
		try {
			wavFileReader.readAudioFile("godKnows.wav");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationUnsupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}