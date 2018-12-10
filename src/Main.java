import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainGUI myApp = new MainGUI();
				myApp.setVisible(true);
			}
			
		});

	}

}
