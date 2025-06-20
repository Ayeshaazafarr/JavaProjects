package Assignment1;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Assignment1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fileNameField;
	private JTextArea fileContentArea;
	private static final String DIRECTORY = "C:/SwingFiles";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Assignment1 frame = new Assignment1();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Assignment1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 480);
		setTitle("Batman File Handler");

		// Gotham-style dark theme
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("File Handling - Gotham Edition");
		lblTitle.setFont(new Font("Courier New", Font.BOLD, 20));
		lblTitle.setBounds(110, 11, 377, 30);
		lblTitle.setForeground(Color.YELLOW);
		contentPane.add(lblTitle);

		JLabel lblFileName = new JLabel("File Name:");
		lblFileName.setBounds(30, 60, 80, 20);
		lblFileName.setForeground(Color.LIGHT_GRAY);
		contentPane.add(lblFileName);

		fileNameField = new JTextField();
		fileNameField.setBounds(110, 60, 350, 25);
		fileNameField.setBackground(new Color(50, 50, 50));
		fileNameField.setForeground(Color.YELLOW);
		fileNameField.setCaretColor(Color.YELLOW);
		fileNameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		contentPane.add(fileNameField);
		fileNameField.setColumns(10);

		fileContentArea = new JTextArea();
		fileContentArea.setBackground(new Color(30, 30, 30));
		fileContentArea.setForeground(Color.YELLOW);
		fileContentArea.setCaretColor(Color.YELLOW);
		fileContentArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		fileContentArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		JScrollPane scrollPane = new JScrollPane(fileContentArea);
		scrollPane.setBounds(30, 100, 500, 200);
		contentPane.add(scrollPane);

		// Gotham yellow and Bat-gray
		Color yellow = new Color(255, 215, 0);
		Color darkGray = new Color(70, 70, 70);

		JButton Create = new JButton("Create");
		styleButton(Create, darkGray, yellow, 30, 320);
		contentPane.add(Create);

		JButton Write = new JButton("Write");
		styleButton(Write, darkGray, yellow, 130, 320);
		contentPane.add(Write);

		JButton Read = new JButton("Read");
		styleButton(Read, darkGray, yellow, 230, 320);
		contentPane.add(Read);

		JButton Update = new JButton("Update");
		styleButton(Update, darkGray, yellow, 330, 320);
		contentPane.add(Update);

		JButton Delete = new JButton("Delete");
		styleButton(Delete, Color.RED.darker(), Color.WHITE, 430, 320);
		contentPane.add(Delete);

		File dir = new File(DIRECTORY);
		if (!dir.exists()) dir.mkdirs();

		Create.addActionListener(e -> handleCreate());
		Write.addActionListener(e -> handleWrite());
		Read.addActionListener(e -> handleRead());
		Update.addActionListener(e -> handleUpdate());
		Delete.addActionListener(e -> handleDelete());
	}

	private void styleButton(JButton button, Color bg, Color fg, int x, int y) {
		button.setBounds(x, y, 90, 30);
		button.setBackground(bg);
		button.setForeground(fg);
		button.setFocusPainted(false);
		button.setFont(new Font("Courier New", Font.BOLD, 12));
		button.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}

	private File getFile() {
		String fileName = fileNameField.getText().trim();
		if (fileName.isEmpty()) {
			showMessage("Enter a file name.");
			return new File("");
		}
		return new File(DIRECTORY + "/" + fileName + ".txt");
	}

	private void handleCreate() {
		File file = getFile();
		try {
			if (file.createNewFile()) {
				showMessage("File created successfully.");
			} else {
				showMessage("File already exists.");
			}
		} catch (IOException ex) {
			showMessage("Error: " + ex.getMessage());
		}
	}

	private void handleWrite() {
		File file = getFile();
		if (file.exists()) {
			showMessage("File already exists. Use Update instead.");
			return;
		}
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(fileContentArea.getText());
			writer.close();
			showMessage("Content written to new file.");
		} catch (IOException ex) {
			showMessage("Error: " + ex.getMessage());
		}
	}

	private void handleRead() {
		File file = getFile();
		if (!file.exists()) {
			showMessage("File does not exist.");
			return;
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line, content = "";
			while ((line = reader.readLine()) != null) {
				content += line + "\n";
			}
			reader.close();
			fileContentArea.setText(content);
			showMessage("File read successfully.");
		} catch (IOException ex) {
			showMessage("Error: " + ex.getMessage());
		}
	}

	private void handleUpdate() {
		File file = getFile();
		if (!file.exists()) {
			showMessage("File does not exist. Use Write to create it.");
			return;
		}
		try {
			FileWriter writer = new FileWriter(file, true); // append mode
			writer.write("\n" + fileContentArea.getText());
			writer.close();
			showMessage("Content appended to file.");
		} catch (IOException ex) {
			showMessage("Error: " + ex.getMessage());
		}
	}

	private void handleDelete() {
		File file = getFile();
		if (file.delete()) {
			fileContentArea.setText("");
			showMessage("File deleted successfully.");
		} else {
			showMessage("Failed to delete file.");
		}
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
