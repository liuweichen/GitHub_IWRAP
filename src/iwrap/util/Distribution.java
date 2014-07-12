package iwrap.util;

public class Distribution {
	float meanValue;//The average of the valuesƽ��ֵ
	float variance;//The variance of the values����
	float min;//The minimum of the values��Сֵ
	float max;//The maximum of the values���ֵ
	DistributionKind dk;//The kind of the distribution�ֲ���������
	
	public Distribution(float meanValue, float variance, float min, float max,DistributionKind dk) {
		super();
		this.meanValue = meanValue;
		this.variance = variance;
		this.min = min;
		this.max = max;
		this.dk = dk;
	}
	
	public float getMeanValue() {
		return meanValue;
	}
	public void setMeanValue(float meanValue) {
		this.meanValue = meanValue;
	}
	public float getVariance() {
		return variance;
	}
	public void setVariance(float variance) {
		this.variance = variance;
	}
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}	
	public DistributionKind getDk() {
		return dk;
	}
	public void setDk(DistributionKind dk) {
		this.dk = dk;
	}
	
	//get the distribution �õ��ֲ�����ֵ
	public float getDistribution() {
		switch(dk) {
		case uniformDistribution:
			return uniformDistribution();
		case normalDistribution:
			return normalDistribution();
			default: return 0;
		}	
	}
	
	//minimum-max֮��ľ��ȷֲ�
	public float uniformDistribution() {
		return (float)(min + (max - min) * Math.random());
	}
	
	//normal distribution��̬�ֲ�
	public float normalDistribution() {
		int n = 1200;
		float temp = 0;
		for(int i = 0; i < n; i++) {
			temp += Math.random();
		}
		//standard normal distribution��׼��̬�ֲ�
		float standardNormalDistribution =(float) (Math.sqrt(12.0/n)*(temp - n / 2));
		//normal distribution by mean value and variance�������̬�ֲ� 
		return (float)(meanValue + Math.sqrt(variance) * standardNormalDistribution);
	}
	
}
