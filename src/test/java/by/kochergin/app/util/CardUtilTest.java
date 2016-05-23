package by.kochergin.app.util;

import org.apache.log4j.Logger;
import org.junit.Test;

public class CardUtilTest {
	Logger log = Logger.getLogger(this.getClass());

	@Test
	public void shouldGenerateCardNumber() throws InterruptedException {

		for (int i = 0; i < 10; i++) {
			//Thread.sleep(1000);
			log.info(CardUtil.generateCardNumber());
		}
	}
}
