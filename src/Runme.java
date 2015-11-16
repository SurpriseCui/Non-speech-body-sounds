
public class Runme {

	/**
	 * @param args
	 */
	private static int sampleRate = 8000;
	public static void main(String[] args) {
//		demo9 demo = new demo9();
		// TODO Auto-generated method stub
		Wave wave = new Wave("Speaking.wav");
		Spectrogram sg = new Spectrogram(wave);
		
		//计算总Frame数目，以及每个frame的长度(in second)
		int numFrames = sg.getNumFrames();
		double frameInSec = (double)sg.getFftSampleSize() / (double)sampleRate;
		
		//计算总频率单元，以及每个频率单元长度(in HZ)
		int numFrequencyUnit = sg.getNumFrequencyUnit();
		double frequncyInHZ = (double)sampleRate / (double)numFrequencyUnit;
		
		System.out.println(numFrames + "	" + frameInSec + "	" + numFrequencyUnit + "	" + frequncyInHZ);
		
		//计算在某个频率区间的能量
		double [][] test = sg.getAbsoluteSpectrogramData();
		for(int i = 0; i < test.length; i ++){
			System.out.print(i * frameInSec + "	");
			for(int j = (int) ((sampleRate / 16) / (frequncyInHZ)); j < (sampleRate / 8) / (frequncyInHZ) ; j ++){
				System.out.print(Math.log(test[i][j]) + "	");
			}
			System.out.println();
		}
	}

}
