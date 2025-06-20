package Q1;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

public class NetSalaryCalculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBasicSalary;
	private JTextField txtBonus;
	private JTextField txtDeductions;
	private JTextField txtNetSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetSalaryCalculator frame = new NetSalaryCalculator();
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
	public NetSalaryCalculator() {
		setTitle("Net Salary Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 10, 10));

		JLabel lblBasicSalary = new JLabel("Basic Salary:");
		contentPane.add(lblBasicSalary);

		txtBasicSalary = new JTextField();
		contentPane.add(txtBasicSalary);
		txtBasicSalary.setColumns(10);

		JLabel lblBonus = new JLabel("Bonus:");
		contentPane.add(lblBonus);

		txtBonus = new JTextField();
		contentPane.add(txtBonus);
		txtBonus.setColumns(10);

		JLabel lblDeductions = new JLabel("Deductions:");
		contentPane.add(lblDeductions);

		txtDeductions = new JTextField();
		contentPane.add(txtDeductions);
		txtDeductions.setColumns(10);

		JLabel lblNetSalary = new JLabel("Net Salary:");
		contentPane.add(lblNetSalary);

		txtNetSalary = new JTextField();
		txtNetSalary.setEditable(false); // make non-editable
		contentPane.add(txtNetSalary);
		txtNetSalary.setColumns(10);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateNetSalary();
			}
		});
		contentPane.add(new JLabel()); // filler for grid alignment
		contentPane.add(btnCalculate);
	}

	private void calculateNetSalary() {
		try {
			double basic = Double.parseDouble(txtBasicSalary.getText());
			double bonus = Double.parseDouble(txtBonus.getText());
			double deductions = Double.parseDouble(txtDeductions.getText());

			double netSalary = basic + bonus - deductions;
			txtNetSalary.setText(String.format("%.2f", netSalary));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter valid numeric values.",
					"Input Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
