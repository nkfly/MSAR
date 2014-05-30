package main;

import java.io.IOException;

import filter.Filter;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Sample;
import net.beadsproject.beads.data.audiofile.FileFormatException;
import net.beadsproject.beads.data.audiofile.OperationUnsupportedException;
import net.beadsproject.beads.data.audiofile.WavFileReaderWriter;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.SamplePlayer;




public class Main{
	public static void main(String [] argc) throws OperationUnsupportedException, FileFormatException{
		WavFileReaderWriter wavFileReader = new WavFileReaderWriter();
		try {
			AudioContext ac = new AudioContext();
			
			String wavFileName = "godKnows.wav";
			WavFileReaderWriter wavReaderWriter =  new WavFileReaderWriter(); 
			//SamplePlayer sp = new SamplePlayer(ac, new Sample(wavFileName));
			
			String outputName = "out_" + wavFileName;
			double lambda = 1;
			int nFFT = 1024;
			int windowSize = 1024;
			int maskType = 1;
			double gain = 1;
			double power = 1;
			double fs = wavReaderWriter.getSampleAudioFormat().sampleRate;
			float[][] wavData = wavReaderWriter.readAudioFile(wavFileName);
			// only take one channel
			
			
			
//			BiquadFilter filter1 = new BiquadFilter(ac, 2); 
//			filter1.setType(BiquadFilter.HP); 
//			filter1.setFrequency(2000.0f); 
//			filter1.setQ(0.5f); 
//			filter1.addInput(sp);
//			Glide gainValue = new Glide(ac, 0, 20);
//			Gain g = new Gain(ac, 1, gainValue);
//			g.addInput(filter1);
//			
//			ac.out.addInput(g);
//			ac.start();
//			
//			gainValue.setValue((float)0.9);
//			sp.setToLoopStart();
//			sp.start();


//			float[][] wavData = wavFileReader.readAudioFile("godKnows.wav");
//			
//			float [] monoWavData = new float[wavData[0].length];
//			float [] highPassWavData = Filter.highpass(wavData[1], 8000);
//			float [] lowPassWavData = Filter.lowpass(wavData[1], 5000);
//			
//			
//			for (int i = 0;i < monoWavData.length;i++) {
//				monoWavData[i] = wavData[0][i] - wavData[i][i] + highPassWavData[i] + lowPassWavData[i];
//				
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	
}