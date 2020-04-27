package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Eredua.DragaminaGestorea;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BistaBerriro {
	
	private static BistaBerriro nireBerriro;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BistaBerriro window = new BistaBerriro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public BistaBerriro() {
		initialize();
		this.frame.setVisible(true);
	}
	
	public static BistaBerriro getNireBerriro(){
	     if(nireBerriro==null){
	    	 nireBerriro=new BistaBerriro();
	     }
	     return nireBerriro;
	    }

	
	private void setVisible(boolean pF){
		frame.setVisible(pF);
		nireBerriro=null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("BAI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BistaDiagrama.getNireDiagrama().berrabiarazi();
				BistaDiagrama.getNireDiagrama().gelaxkaSortu();
				BistaBerriro.getNireBerriro().setVisible(false);
				
			}
		});
		btnNewButton.setBounds(114, 172, 89, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EZ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(241, 172, 89, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblBerriroJolastuNahi = new JLabel("Berriro jolastu nahi duzu?");
		lblBerriroJolastuNahi.setBounds(149, 86, 172, 38);
		frame.getContentPane().add(lblBerriroJolastuNahi);
	}
}
