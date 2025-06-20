package Q5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class q5 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					q5 frame = new q5();
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
	public q5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Number 1 ");
		lblNewLabel.setBounds(55, 77, 103, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Number 2");
		lblNewLabel_1.setBounds(55, 121, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(161, 74, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 118, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Compare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
					 

					  	int num1 = Integer.parseInt(textField.getText().trim());
	                    int num2 = Integer.parseInt(textField_1.getText().trim());
	                    if (num1 > num2) {
	                      JOptionPane.showInputDialog(null, "Greater number is: " + num1);
	                    } else if (num2 > num1) {
	                        JOptionPane.showMessageDialog(null, "Greater number is: " + num2);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Both are equal");
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Please enter valid integers.");
	                }
	            }
	       
			
		});
		btnNewButton.setBounds(68, 174, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Result");
		lblNewLabel_2.setBounds(186, 222, 71, 14);
		contentPane.add(lblNewLabel_2);
	}

}
