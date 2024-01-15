package Exercise06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.Color;

public class App {

	private static JButton btnInputSplit;
	private JFrame frame;
	private JTextField txtSplitInto;
	private JTextField txtInputSplit;
	private JTextField txtOutputSplit;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public App() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Spliter and Combiner");
		frame.setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelSplit = new JPanel();
		tabbedPane.addTab("Split File", null, panelSplit, null);
		panelSplit.setLayout(null);
		
		JPanel pnlSplit = new JPanel();
		pnlSplit.setBorder(new TitledBorder(null, "Split File", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlSplit.setBounds(0, 11, 409, 200);
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
		
		JPanel panelMerge = new JPanel();
		tabbedPane.addTab("Merge File", null, panelMerge, null);
		panelMerge.setLayout(null);
	}
	
	private void showFileChooser() {
		JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            txtInputSplit.setText(filePath);
        }
    }
}

