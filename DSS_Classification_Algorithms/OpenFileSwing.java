import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class OpenFileSwing {

	private JFrame frame;
	private JTextField textFieldforPath;
	private JTextField newInstanceTF;
	private JTextField classifyresult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenFileSwing window = new OpenFileSwing();
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
	public OpenFileSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 540, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JTextArea textAreaforResults = new JTextArea();
		textAreaforResults.setBackground(Color.CYAN);
		textAreaforResults.setBounds(21, 73, 325, 414);
		frame.getContentPane().add(textAreaforResults);
		
		textFieldforPath = new JTextField();
		textFieldforPath.setBounds(242, 12, 291, 26);
		frame.getContentPane().add(textFieldforPath);
		textFieldforPath.setColumns(10);
		
		newInstanceTF = new JTextField();
		newInstanceTF.setBounds(21, 513, 325, 26);
		frame.getContentPane().add(newInstanceTF);
		newInstanceTF.setColumns(10);
		
		JPanel ThePanel = new JPanel();
		ThePanel.setBackground(Color.CYAN);
		ThePanel.setBounds(358, 73, 175, 458);
		frame.getContentPane().add(ThePanel);
		ThePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));		
		
		JButton btnOpenfilebutton = new JButton("Browse");
		btnOpenfilebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				OpenFile of = new OpenFile();
				
				try{
					of.PickMe();
				} catch (Exception e){
					e.printStackTrace();
				}
				
				Test2 t = new Test2();
				int k = 0;
				
				  
			  try {
				
				//t.main(String[] args, of.fileChooser.getSelectedFile().toString());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				JButton btnDisc = new JButton("disc2");
				btnDisc.setBackground(Color.WHITE);
				btnDisc.setText("Classify");
				btnDisc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{	

						
					}
				});
				btnDisc.setBounds(402, 531, 117, 29);
				frame.getContentPane().add(btnDisc);				
				
			}
		});
		btnOpenfilebutton.setBounds(19, 9, 111, 52);
		frame.getContentPane().add(btnOpenfilebutton);
		
		classifyresult = new JTextField();
		classifyresult.setBounds(144, 546, 202, 26);
		frame.getContentPane().add(classifyresult);
		classifyresult.setColumns(10);
		
		JLabel lblFileDirection = new JLabel("File Direction :");
		lblFileDirection.setBounds(149, 17, 97, 16);
		frame.getContentPane().add(lblFileDirection);
		
		JLabel lblRateResult = new JLabel("Rate Result");
		lblRateResult.setBounds(159, 50, 70, 16);
		frame.getContentPane().add(lblRateResult);
		
		JLabel lblClassOfInstance = new JLabel("Class of Instance :");
		lblClassOfInstance.setBounds(21, 551, 123, 16);
		frame.getContentPane().add(lblClassOfInstance);
		
		JLabel lblTheInstance = new JLabel("The Instance");
		lblTheInstance.setBounds(149, 495, 80, 16);
		frame.getContentPane().add(lblTheInstance);
		
		JLabel lblVariables = new JLabel("Variables");
		lblVariables.setBounds(418, 50, 61, 16);
		frame.getContentPane().add(lblVariables);

		
	}
}
