package testScript.java.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	
	public String getdate() {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd MM yyyy hh mm ss");
		String date = f.format(d);
		return date;
	}

}
