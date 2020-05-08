package id.d3ti.oopl.ketujuh.jdbc;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Form extends Frame implements WindowListener{
	 String nim;  
	 String nama;  
	 String jk;  
	 String alamat;  
	 String tmp_lahir;  
	 String tgl_lahir;    
	 TextField cnim,cnama,ctmp_lahir,ctgl_lahir;  
	 Choice cjk1;  
	 TextArea calamat;  
	 Button b;  
	 
	 public Form()  {   
		 super("Data Diri");   
		 Panel p = new Panel();   
		 add(p);   
		 p.setLayout(new GridLayout(7, 2));     
		 p.add( new Label("nim"));  
		 p.add(cnim = new TextField()); 
		 
		 p.add( new Label("nama"));   
		 p.add(cnama = new TextField());  
		 
		 p.add( new Label("Jenis Kelamin"));   
		 cjk1 = new Choice();   
		 cjk1.add("Laki-laki");   
		 cjk1.add("Perempuan");   
		 p.add(cjk1); 
		 
		 p.add( new Label("Tempat Lahir"));   
		 p.add(ctmp_lahir = new TextField()); 
		 
		 p.add( new Label("Tanggal Lahir"));   
		 p.add(ctgl_lahir = new TextField());    
		 
		 p.add( new Label("Alamat"));   
		 p.add(calamat = new TextArea());      
		 
		 p.add( new Label(""));   
		 p.add(b=new Button("save"));   
		 //p.add(arg0);   
		 //p.add(cjk2 = new Checkbox("Perempuan"));   
		 setSize(250,300);  
		 setVisible(true);   
		 addWindowListener(this);
	 }
	 public boolean action (Event e, Object what) {
		 if(what.equals("save")) {
			 nim = cnim.getText();  
			 nama = cnama.getText();   
			 jk = cjk1.getSelectedItem().toString();    
			 tmp_lahir = ctmp_lahir.getText();   
			 tgl_lahir = ctgl_lahir.getText();
			 alamat = calamat.getText();  
			 DBBiodata biodata = new DBBiodata();
			 biodata.insertBiodata(nim, nama, jk, tmp_lahir, tgl_lahir, alamat);
		 }
		return true; 
	 }
	 public static void main(String args[]){   
		 new Form();  
	 }
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(1);
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	} 
	 
	 
}