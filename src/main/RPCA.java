package main;

import net.beadsproject.beads.data.Sample;
import net.beadsproject.beads.ugens.SamplePlayer;

public class RPCA {
	
	public static void process( float [] wavData, String outputName,double lambda, 
			int nFFT,int windowSize,int maskType,double gain ,double power,double fs) {
		
		int hop = windowSize/4;
		double scf = 2/3;
		
		
		
	}
	
	public static float [] stft(float [] wavData, int nFFT, int windowSize, int hop, int sr) {
		int s = wavData.length;
		double [] win;
		if (windowSize == 0) {
			win = new double[nFFT];
			for(int i = 0;i < win.length;i++) {
				win[i] = 1.0;
			}
			
		} else {
			if (windowSize % 2 == 0) {
				windowSize += 1;
			}
			int halfLen = (windowSize - 1)/2;
			int halfF = nFFT/2;
			double [] halfWin = new double[halfLen+1];
			for (int i = 0;i < halfWin.length;i++) {
				halfWin[i] = 0.5 * (1 + Math.cos(Math.PI * i/halfLen));
			}
			win = new double[nFFT];
			int actHalfWin = Math.min(halfF, halfLen);
			for (int i = halfF+1;i <= halfF+actHalfWin;i++){
				win[i] = halfWin[i-(halfF+1)];
			}
			// TODO
			for (int i = 0;i >= halfF-actHalfWin+2;i++){
				win[i] = halfWin[i];
			}
			
			
			
		}
		double [] win
		
		return null;
		
		
		
	}
	
	public static float [] inexactAlmRpca(float [] wavData, int nFFt, int windowSize, int hop, int sr) {
		int s = wavData.length;
		
		
		return null;
		
		
		
	}

}
