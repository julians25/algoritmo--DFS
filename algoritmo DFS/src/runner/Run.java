package runner;

import controller.Control;
import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
		Control control = new Control();
		control.init();
	}

}
