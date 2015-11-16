
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
		
		//������Frame��Ŀ���Լ�ÿ��frame�ĳ���(in second)
		int numFrames = sg.getNumFrames();
		double frameInSec = (double)sg.getFftSampleSize() / (double)sampleRate;
		
		//������Ƶ�ʵ�Ԫ���Լ�ÿ��Ƶ�ʵ�Ԫ����(in HZ)
		int numFrequencyUnit = sg.getNumFrequencyUnit();
		double frequncyInHZ = (double)sampleRate / (double)numFrequencyUnit;
		
		System.out.println(numFrames + "	" + frameInSec + "	" + numFrequencyUnit + "	" + frequncyInHZ);
		
		//������ĳ��Ƶ�����������
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
