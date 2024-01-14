package Exercise04;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JProgressBar;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class CopyingFileDemo extends JFrame {

	private JPanel contentPane;
	private JTextField txtFrom;
	private JTextField txtTo;

	private JProgressBar progressBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new CopyingFileDemo().setVisible(true));
	}

	/**
	 * Create the frame.
	 */
	public CopyingFileDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "FROM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		txtFrom = new JTextField();
		panel_1.add(txtFrom);
		txtFrom.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "TO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtTo = new JTextField();
		panel.add(txtTo);
		txtTo.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnCopy = new JButton("COPY");
		btnCopy.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCopy.setBounds(229, 10, 93, 27);
		btnCopy.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtFrom.setText("data/sourceFile.txt");
		txtTo.setText("data/copyFile.txt");
		
		btnCopy.addActionListener((e) -> {
			
			File fileFrom = new File(txtFrom.getText());
			File fileTo = new File(txtTo.getText());
			
			CopyFile task = new CopyFile(fileFrom, fileTo);
			task.execute();
			task.addPropertyChangeListener((evt) -> {
				if("progress".equals(evt.getPropertyName()))
				{
					progressBar.setValue((int) evt.getNewValue());
				}
			});
		});
		
		panel_2.setLayout(null);
		panel_2.add(btnCopy);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(0, 10, 556, 19);
		progressBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_3.add(progressBar);
	}
}
