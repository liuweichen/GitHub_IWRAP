package iwrap.util;

public class Distribution {
	float meanValue;//The average of the valuesƽ��ֵ
	float variance;//The variance of the values����
	float min;//The minimum of the values��Сֵ
	float max;//The maximum of the values���ֵ
	float widthIntegration;//The width of the integration���ֳ���
	DistributionKind dk;//The kind of the distribution�ֲ���������
	
	public Distribution(float meanValue, float variance, float min, float max,
			float widthIntegration, DistributionKind dk) {
		super();
		this.meanValue = meanValue;
		this.variance = variance;
		this.min = min;
		this.max = max;
		this.widthIntegration = widthIntegration;
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
	public float getWidthIntegration() {
		return widthIntegration;
	}
	public void setWidthIntegration(float widthIntegration) {
		this.widthIntegration = widthIntegration;
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
		int n = 120;
		float temp = 0;
		for(int i = 0; i < n; i++) {
			temp += Math.random();
		}
		//standard normal distribution��׼��̬�ֲ�
		float standardNormalDistribution =(float) (Math.sqrt(12.0/n)*(temp - n / 2));
		//normal distribution by mean value and variance�������̬�ֲ� 
		//System.out.println((float)(meanValue + Math.sqrt(variance) * standardNormalDistribution));
		return (float)(meanValue + Math.sqrt(variance) * standardNormalDistribution);
	}
	
	//get the area for integration by reverse since we can not get the Max or Min of the number
	//ͨ���������ķ����õ������������Ϊ���ֵ����Сֵ�޷���Java�б�ʾ
	public float getIntegrationbyRectangle() {
		float widthIntegrationMax;
		float widthIntegrationMin;
		double areaIntegration = 0d;
		int n = 1000;
		if(meanValue > widthIntegration) {
			widthIntegrationMin = widthIntegration;
			widthIntegrationMax = meanValue ;
		} else {
			widthIntegrationMax = widthIntegration;
			widthIntegrationMin = meanValue;
		}
		float step = (widthIntegrationMax - widthIntegrationMin) / n;//The step of integration����
		for(int i = 0; i < n;i++) {
			areaIntegration += this.getNoramlDistribution(widthIntegrationMin+i*step);
		}
		return 0.5f - (float)(areaIntegration*step);
	}
	
	//get the normal distribution value by x  ͨ��X�õ���̬�ֲ�������ֵ
	public double getNoramlDistribution(float x) {
		double firstPart =1.0d/Math.sqrt(Math.PI * variance * 2);
		double secondPart = -(x-meanValue)*(x-meanValue)/(2*variance);
		return firstPart*Math.exp(secondPart);
	}
	
}
