package id.d3ti.oopl.ketujuh.jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFrame extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTable table;
	DBBiodata biodata; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
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
	public JFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		biodata = new DBBiodata();
		Vector columnNames = new Vector();
		columnNames.addElement("NIM");
		columnNames.addElement("Nama");
		columnNames.addElement("Jenis Kelamin");
		columnNames.addElement("Tempat Lahir");
		columnNames.addElement("Tanggal Lahir");
		columnNames.addElement("Alamat");
		table = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(biodata.data(), columnNames);
		table.setModel(dtm);
		scrollPane.setColumnHeaderView(table);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		 table.setBounds(10, 0, 457, 103);   

		    JScrollPane jp=new JScrollPane(table);
		    jp.setBounds(10, 0, 457, 103);
		    jp.setVisible(true);
		    add(jp);
		 getContentPane();
	}

}
