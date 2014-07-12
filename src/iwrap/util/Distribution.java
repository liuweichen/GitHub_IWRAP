package iwrap.util;

public class Distribution {
	float meanValue;//The average of the values平均值
	float variance;//The variance of the values方差
	float min;//The minimum of the values最小值
	float max;//The maximum of the values最大值
	DistributionKind dk;//The kind of the distribution分布函数种类
	
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
	
	//get the distribution 得到分布函数值
	public float getDistribution() {
		switch(dk) {
		case uniformDistribution:
			return uniformDistribution();
		case normalDistribution:
			return normalDistribution();
			default: return 0;
		}	
	}
	
	//minimum-max之间的均匀分布
	public float uniformDistribution() {
		return (float)(min + (max - min) * Math.random());
	}
	
	//normal distribution正态分布
	public float normalDistribution() {
		int n = 1200;
		float temp = 0;
		for(int i = 0; i < n; i++) {
			temp += Math.random();
		}
		//standard normal distribution标准正态分布
		float standardNormalDistribution =(float) (Math.sqrt(12.0/n)*(temp - n / 2));
		//normal distribution by mean value and variance任意的正态分布 
		return (float)(meanValue + Math.sqrt(variance) * standardNormalDistribution);
	}
	
}
