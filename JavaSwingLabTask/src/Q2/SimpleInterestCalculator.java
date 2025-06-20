package Q2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleInterestCalculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PrincipalAmount;
	private JTextField RateOfInterest;
	private JTextField TimeInYears;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleInterestCalculator frame = new SimpleInterestCalculator();
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
	public SimpleInterestCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PrincipalAmount = new JTextField();
		PrincipalAmount.setBounds(192, 27, 96, 20);
		contentPane.add(PrincipalAmount);
		PrincipalAmount.setColumns(10);
		
		RateOfInterest = new JTextField();
		RateOfInterest.setColumns(10);
		RateOfInterest.setBounds(192, 69, 96, 20);
		contentPane.add(RateOfInterest);
		
		TimeInYears = new JTextField();
		TimeInYears.setColumns(10);
		TimeInYears.setBounds(192, 114, 96, 20);
		contentPane.add(TimeInYears);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(192, 157, 96, 22);
		contentPane.add(textArea);
		
		JLabel Label1 = new JLabel("Principal amount");
		Label1.setBounds(66, 30, 82, 14);
		contentPane.add(Label1);
		
		JLabel Label2 = new JLabel("Rate of Interest");
		Label2.setBounds(66, 72, 82, 14);
		contentPane.add(Label2);
		
		JLabel Label3 = new JLabel("Time in Years");
		Label3.setBounds(66, 117, 82, 14);
		contentPane.add(Label3);
		
		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a,b,c,d;
				a = Integer.parseInt(PrincipalAmount.getText());
				b = Integer.parseInt(RateOfInterest.getText());
				c = Integer.parseInt(TimeInYears.getText());
				d = (a*b*c)/100;
				textArea.setText(String.valueOf(d));
			}
		});
		CalculateButton.setBounds(59, 158, 89, 23);
		contentPane.add(CalculateButton);
	}
}
