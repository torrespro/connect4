package connect4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

	private static Console instance = new Console();
	
	public static Console getInstance() {
		return instance;
	}
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		this.write(title);
		try {
			input = this.bufferedReader.readLine();
		} catch (Exception ex) {
		}
		return input;
	}

	public void write(String string) {
		System.out.print(string);
	}


}
