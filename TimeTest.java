package time;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	
	private Time time;

	@Before
	public void setUp() throws Exception {
		time = new Time(59, 59, 23);
	}

	/** Tests for previous and next second, minute and hour methods */
	@Test
	public void test() {
		assertEquals(time.nextSecond().toString(), "0:0:0");
		assertEquals(time.previousSecond().toString(), "23:59:59");
		assertEquals(time.nextMinute().toString(), "0:0:59");
		assertEquals(time.nextHour().toString(), "1:0:59");
		assertEquals(time.previousMinute().toString(), "23:59:59");
		assertEquals(time.previousHour().toString(), "23:59:59");
	}

}
