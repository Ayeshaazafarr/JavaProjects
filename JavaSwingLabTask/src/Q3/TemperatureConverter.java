package Q3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TemperatureConverter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TempinCelsius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemperatureConverter frame = new TemperatureConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TemperatureConverter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label1 = new JLabel("Enter Temperature in Celsius");
		Label1.setBounds(134, 34, 151, 14);
		contentPane.add(Label1);
		
		TempinCelsius = new JTextField();
		TempinCelsius.setBounds(134, 59, 139, 20);
		contentPane.add(TempinCelsius);
		TempinCelsius.setColumns(10);
		
		JButton Button = new JButton("Convert to Fahrenhiet");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int C,F;
				C = Integer.parseInt(TempinCelsius.getText());
				F = (C * (9/5)) + 32;
				textArea.setText(String.valueOf(F));
			}
		});
		Button.setBounds(134, 90, 139, 23);
		contentPane.add(Button);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(134, 124, 139, 22);
		contentPane.add(textArea);
	}

}
