package by.kochergin.app.util;

public class CardUtil {
	public static String generateCardNumber() {
		return "MM" +  System.currentTimeMillis() ;
	}
}
