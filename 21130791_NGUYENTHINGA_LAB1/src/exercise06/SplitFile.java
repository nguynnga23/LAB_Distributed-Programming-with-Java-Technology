package exercise06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JProgressBar;

// Dạ cô ơi, em làm chưa kịp với deadline. Em xin phép nộp trước và sẽ tiếp tục hoàn thiện bài ạ.
public class SplitFile {

	private static JButton btnInputSplit;
	private JFrame frame;
	private JTextField txtSplitInto;
	private JTextField txtInputSplit;
	private JTextField txtOutputSplit;
	private JProgressBar progressBar;
	private JButton splitButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnOutputSplit_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplitFile window = new SplitFile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SplitFile() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 450, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Spliter and Combiner");
		frame.setLocationRelativeTo(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 252);
		frame.getContentPane().add(tabbedPane);

		JPanel panelSplit = new JPanel();
		tabbedPane.addTab("Split File", null, panelSplit, null);
		panelSplit.setLayout(null);

		JPanel pnlSplit = new JPanel();
		pnlSplit.setBorder(new TitledBorder(null, "Split File", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlSplit.setBounds(0, 0, 409, 225);
		panelSplit.add(pnlSplit);
		pnlSplit.setLayout(null);

		JPanel pnlInputSplit = new JPanel();
		pnlInputSplit.setBounds(10, 26, 389, 30);
		pnlSplit.add(pnlInputSplit);
		pnlInputSplit.setLayout(null);

		JLabel lblInputSplit = new JLabel("Input File:");
		lblInputSplit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInputSplit.setBounds(10, 0, 90, 30);
		pnlInputSplit.add(lblInputSplit);

		txtInputSplit = new JTextField();
		txtInputSplit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtInputSplit.setBounds(95, 5, 244, 20);
		pnlInputSplit.add(txtInputSplit);
		txtInputSplit.setColumns(10);

		btnInputSplit = new JButton("...");
		btnInputSplit.setBackground(new Color(154, 205, 50));
		btnInputSplit.setForeground(new Color(255, 255, 255));
		btnInputSplit.setBorder(null);
		btnInputSplit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFileChooser();
			}
		});
		btnInputSplit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInputSplit.setBounds(349, 5, 30, 20);
		pnlInputSplit.add(btnInputSplit);

		JPanel pnlOutputSplit = new JPanel();
		pnlOutputSplit.setBounds(10, 67, 389, 30);
		pnlSplit.add(pnlOutputSplit);
		pnlOutputSplit.setLayout(null);

		JLabel lblOutputSplit = new JLabel("Output Folder:");
		lblOutputSplit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOutputSplit.setBounds(10, 0, 90, 30);
		pnlOutputSplit.add(lblOutputSplit);

		txtOutputSplit = new JTextField();
		txtOutputSplit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtOutputSplit.setColumns(10);
		txtOutputSplit.setBounds(95, 5, 244, 20);
		pnlOutputSplit.add(txtOutputSplit);

		JButton btnOutputSplit = new JButton("...");
		btnOutputSplit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFolderChooser(frame);
			}
		});
		btnOutputSplit.setForeground(new Color(255, 255, 255));
		btnOutputSplit.setBackground(new Color(154, 205, 50));
		btnOutputSplit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOutputSplit.setBounds(349, 5, 30, 20);
		btnOutputSplit.setBorder(null);
		pnlOutputSplit.add(btnOutputSplit);

		JPanel pnlSplitInto = new JPanel();
		pnlSplitInto.setBounds(10, 108, 389, 20);
		pnlSplit.add(pnlSplitInto);
		pnlSplitInto.setLayout(null);

		JLabel llbSplitInto = new JLabel("Enter number of files to split into:");
		llbSplitInto.setFont(new Font("Tahoma", Font.BOLD, 11));
		llbSplitInto.setBounds(10, 0, 207, 20);
		pnlSplitInto.add(llbSplitInto);

		txtSplitInto = new JTextField();
		txtSplitInto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtSplitInto.setBounds(214, 0, 165, 20);
		pnlSplitInto.add(txtSplitInto);
		txtSplitInto.setColumns(10);

		progressBar = new JProgressBar();
		progressBar.setBounds(10, 195, 389, 20);
		pnlSplit.add(progressBar);

		splitButton = new JButton("Split Its");
		splitButton.setBounds(154, 164, 85, 21);
		pnlSplit.add(splitButton);
		splitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputFile = txtInputSplit.getText();
				String outputFolder = txtOutputSplit.getText();
				int numberOfFiles = Integer.parseInt(txtSplitInto.getText());

				splitFile(inputFile, outputFolder, numberOfFiles);
				JOptionPane.showMessageDialog(null, "File has been split successfully!");
			}
		});

		JPanel panelMerge = new JPanel();
		panelMerge.setBorder(new TitledBorder(null, "Combine File", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Merge File", null, panelMerge, null);
		panelMerge.setLayout(null);
		
		JPanel pnlOutputSplit_1 = new JPanel();
		pnlOutputSplit_1.setLayout(null);
		pnlOutputSplit_1.setBounds(10, 121, 389, 30);
		panelMerge.add(pnlOutputSplit_1);
		
		JLabel lblOutputSplit_1 = new JLabel("Output Folder:");
		lblOutputSplit_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOutputSplit_1.setBounds(10, 0, 90, 30);
		pnlOutputSplit_1.add(lblOutputSplit_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField.setColumns(10);
		textField.setBounds(95, 5, 244, 20);
		pnlOutputSplit_1.add(textField);
		
		btnOutputSplit_1 = new JButton("...");
		btnOutputSplit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFolderChooser(frame);
			}
		});
		
		btnOutputSplit_1.setForeground(Color.WHITE);
		btnOutputSplit_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOutputSplit_1.setBorder(null);
		btnOutputSplit_1.setBackground(new Color(154, 205, 50));
		btnOutputSplit_1.setBounds(349, 5, 30, 20);
		pnlOutputSplit_1.add(btnOutputSplit_1);
		
		JPanel pnlInputSplit_1 = new JPanel();
		pnlInputSplit_1.setLayout(null);
		pnlInputSplit_1.setBounds(10, 20, 389, 30);
		panelMerge.add(pnlInputSplit_1);
		
		JLabel lblInputSplit_1 = new JLabel("Input File:");
		lblInputSplit_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInputSplit_1.setBounds(10, 0, 90, 30);
		pnlInputSplit_1.add(lblInputSplit_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_1.setColumns(10);
		textField_1.setBounds(95, 5, 244, 20);
		pnlInputSplit_1.add(textField_1);
		
		JButton btnInputSplit_1 = new JButton("...");
		btnInputSplit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInputSplit_1.setForeground(Color.WHITE);
		btnInputSplit_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInputSplit_1.setBorder(null);
		btnInputSplit_1.setBackground(new Color(154, 205, 50));
		btnInputSplit_1.setBounds(349, 5, 30, 20);
		pnlInputSplit_1.add(btnInputSplit_1);
		
		JButton mergeButton = new JButton("Merge Its");
		mergeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				
//				combineFiles(outputFile, inputFile1, inputFile2, inputFile3);
//		        System.out.println("Files have been combined successfully!");
			}
		});
		mergeButton.setBounds(153, 161, 85, 21);
		panelMerge.add(mergeButton);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(10, 192, 389, 20);
		panelMerge.add(progressBar_1);
		
		JPanel pnlInputSplit_1_1 = new JPanel();
		pnlInputSplit_1_1.setLayout(null);
		pnlInputSplit_1_1.setBounds(10, 53, 389, 30);
		panelMerge.add(pnlInputSplit_1_1);
		
		JLabel lblInputSplit_1_1 = new JLabel("Input File:");
		lblInputSplit_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInputSplit_1_1.setBounds(10, 0, 90, 30);
		pnlInputSplit_1_1.add(lblInputSplit_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_2.setColumns(10);
		textField_2.setBounds(95, 5, 244, 20);
		pnlInputSplit_1_1.add(textField_2);
		
		JButton btnInputSplit_1_1 = new JButton("...");
		btnInputSplit_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFileChooser();
			}
		});
		btnInputSplit_1_1.setForeground(Color.WHITE);
		btnInputSplit_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInputSplit_1_1.setBorder(null);
		btnInputSplit_1_1.setBackground(new Color(154, 205, 50));
		btnInputSplit_1_1.setBounds(349, 5, 30, 20);
		pnlInputSplit_1_1.add(btnInputSplit_1_1);
		
		JPanel pnlInputSplit_1_1_1 = new JPanel();
		pnlInputSplit_1_1_1.setLayout(null);
		pnlInputSplit_1_1_1.setBounds(10, 86, 389, 30);
		panelMerge.add(pnlInputSplit_1_1_1);
		
		JLabel lblInputSplit_1_1_1 = new JLabel("Input File:");
		lblInputSplit_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInputSplit_1_1_1.setBounds(10, 0, 90, 30);
		pnlInputSplit_1_1_1.add(lblInputSplit_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_3.setColumns(10);
		textField_3.setBounds(95, 5, 244, 20);
		pnlInputSplit_1_1_1.add(textField_3);
		
		JButton btnInputSplit_1_1_1 = new JButton("...");
		btnInputSplit_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFileChooser();
			}
		});
		btnInputSplit_1_1_1.setForeground(Color.WHITE);
		btnInputSplit_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInputSplit_1_1_1.setBorder(null);
		btnInputSplit_1_1_1.setBackground(new Color(154, 205, 50));
		btnInputSplit_1_1_1.setBounds(349, 5, 30, 20);
		pnlInputSplit_1_1_1.add(btnInputSplit_1_1_1);
	}

	// Chọn file
	private void showFileChooser() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getAbsolutePath();
			txtInputSplit.setText(filePath);
		}
	}
	
	
	//Chọn folder lưu file
	private void showFolderChooser(JFrame frame) {
		JFileChooser folderChooser = new JFileChooser();
		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int result = folderChooser.showOpenDialog(frame);

		if (result == JFileChooser.APPROVE_OPTION) {
			String selectedFolder = folderChooser.getSelectedFile().getAbsolutePath();
			txtOutputSplit.setText(selectedFolder);

		} else {
			JOptionPane.showMessageDialog(frame, "Folder selection canceled.");
		}
	}

	// Chia file
	private void splitFile(String inputFileName, String outputFolder, int numberOfFiles) {
		try (FileInputStream fis = new FileInputStream(inputFileName);
				BufferedInputStream bis = new BufferedInputStream(fis)) {

			File outputDir = new File(outputFolder);
			if (!outputDir.exists()) {
				outputDir.mkdirs();
			}

			long fileSize = new File(inputFileName).length();
			long chunkSize = fileSize / numberOfFiles;
			byte[] buffer = new byte[(int) chunkSize];

			int bytesRead;
			int index = 1;

			while ((bytesRead = bis.read(buffer)) > 0 && index <= numberOfFiles) {
				String outputFileName = outputFolder + File.separator + "part" + index + ".dat";
				try (FileOutputStream fos = new FileOutputStream(outputFileName);
						BufferedOutputStream bos = new BufferedOutputStream(fos)) {
					bos.write(buffer, 0, bytesRead);
				}
				index++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Gộp file
	private void combineFiles(String outputFile, String... inputFiles) {
		try (FileOutputStream fos = new FileOutputStream(outputFile);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {

			for (String inputFile : inputFiles) {
				try (FileInputStream fis = new FileInputStream(inputFile);
						BufferedInputStream bis = new BufferedInputStream(fis)) {

					byte[] buffer = new byte[1024];
					int bytesRead;

					while ((bytesRead = bis.read(buffer)) != -1) {
						bos.write(buffer, 0, bytesRead);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
