import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Choice;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFileChooser;;

public class testswing {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testswing window = new testswing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testswing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 34, 222, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNotchosed = new JLabel("NotChosed");
		lblNotchosed.setBounds(102, 95, 82, 16);
		frame.getContentPane().add(lblNotchosed);
		
		
		JButton btnSelectArffFile = new JButton("Select Arff file");
		btnSelectArffFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jFileChooser = new JFileChooser();
				String dialogTitle = "select file";
				jFileChooser.setDialogTitle(dialogTitle);
				int result = jFileChooser.showSaveDialog(null);
				
				lblNotchosed.setText("a");
			}
		});
		btnSelectArffFile.setBounds(278, 34, 127, 29);
		frame.getContentPane().add(btnSelectArffFile);
		
		
		
		JLabel lblFileName = new JLabel("File Name : ");
		lblFileName.setBounds(16, 95, 74, 16);
		frame.getContentPane().add(lblFileName);
		
	
	}
}
