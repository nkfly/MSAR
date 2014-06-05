package main;

import edu.emory.mathcs.jtransforms.fft.DoubleFFT_1D;
import edu.emory.mathcs.jtransforms.fft.FloatFFT_1D;


class Complex{
	public float real;
	public float imaginary;
	public Complex(float r, float i){
		real = r;
		imaginary = i;
	}
}

public class RPCA {
	
	public static void process( float [] wavData, String outputName,double lambda, 
			int nFFT,int windowSize,int maskType,double gain ,double power,double fs) {
		
		int hop = windowSize/4;
		double scf = 2/3;
		Complex[][] complex = stft(wavData, nFFT, windowSize, hop, 8000);
		
		
		
	}
	
	public static Complex [][] stft(float [] wavData, int nFFT, int windowSize, int hop, int sr) {
		int s = wavData.length;
		float [] win;
		if (windowSize == 0) {
			win = new float[nFFT];
			for(int i = 0;i < win.length;i++) {
				win[i] = 1.0f;
			}
			
		} else {
			if (windowSize % 2 == 0) {
				windowSize += 1;
			}
			int halfLen = (windowSize - 1)/2;
			int halfF = nFFT/2;
			float [] halfWin = new float[halfLen+1];
			for (int i = 0;i < halfWin.length;i++) {
				halfWin[i] = (float)(0.5 * (1 + Math.cos(Math.PI * i/halfLen)));
			}
			win = new float[nFFT];
			int actHalfWin = Math.min(halfF, halfLen);
			for (int i = halfF;i < halfF+actHalfWin;i++){
				win[i] = halfWin[i-halfF];
			}
			
			for (int i = halfF;i >= 1;i--){
				win[i] = halfWin[halfF-i];
			}
			
			
			
		}
		windowSize = win.length;
		
		if (hop == 0) {
			hop = (int) Math.floor(windowSize/2);
		}
		
		int c = 0;
		
		Complex [][] d = new Complex[1+nFFT/2][1+(int)Math.floor(s-nFFT)/hop];
		
		for (int b = 0;b <= s-nFFT; b+= hop) {
			float [] u = new float[win.length];
			for (int i = 0;i < u.length;i++){
				u[i] = win[i]*wavData[b+i];
			}
			
			FloatFFT_1D fftDo = new FloatFFT_1D(u.length);    
		    float[] fft = new float[u.length * 2];
		    fftDo.realForwardFull(fft);
			for (int i = 0;i < d.length;i++){
				d[i][c] = new Complex(fft[2*i], fft[2*i+1]); 
			}
			c++;
		}
		
		return d;
		
		
		
	}
	
	public static float [] inexactAlmRpca(float [] wavData, int nFFt, int windowSize, int hop, int sr) {
		int s = wavData.length;
		
		
		return null;
		
		
		
	}

}
