package iwrap.util;

public class Sailor {
	public static double forgetCheckPosition = 0.00015;//Not true ����ȷ��ֵ
	public static double distanceCheckPosition = 100.0d;//The distance to check ship position��⴬λ�ľ���

	public static double getProbabilityForgetCheckPosition(float distanceToObstacle) {
		double tempTimesForgetCheckPosition = 
				(distanceToObstacle - distanceCheckPosition)/distanceToObstacle;
		return Math.pow(forgetCheckPosition, tempTimesForgetCheckPosition);
	}
}
