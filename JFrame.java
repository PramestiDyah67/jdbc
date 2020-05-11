package id.d3ti.oopl.ketujuh.jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTable table;
	DBBiodata biodata; 
	private final JButton button = new JButton("Update");

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
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);//menginisiasi JScrollPane dan Heading Column
		table.setBounds(10, 0, 457, 103);  
		scrollPane.setColumnHeaderView(table);
		JScrollPane jp=new JScrollPane(table);
		jp.setBounds(10, 0, 457, 103);
		jp.setVisible(true);
		getContentPane().add(jp);
		getContentPane();
		contentPane.add(button, BorderLayout.SOUTH);
	}
	public void pickUp (java.awt.event.MouseEvent evt)
	{
		int row = table.rowAtPoint(evt.getPoint());
		String nim = table.getValueAt(row, 1).toString();
		String nama = table.getValueAt(row, 2).toString();
		String jk = table.getValueAt(row, 3).toString();
		String tmp_lahir = table.getValueAt(row, 4).toString();
		String tgl_lahir = table.getValueAt(row, 5).toString();
		String alamat = table.getValueAt(row, 5).toString();
	}

}
