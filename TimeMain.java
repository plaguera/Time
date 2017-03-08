package time;

public class TimeMain {
	
	private final static int N_ITER = 1000;

	public static void main(String[] args) {
		
		Time time = new Time(0, 0, 0);
		for(int i = 0; i < 10; i++)
			System.out.println(addSeconds(time));

	}
	
	public static Time addSeconds(Time time) {
		for(int i = 0; i < N_ITER; i++)
			time.nextSecond();
		return time;
	}

}
