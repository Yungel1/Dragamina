package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Eredua.DragaminaGestorea;
import Eredua.Jokalaria;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Rectangle;
import javax.swing.AbstractListModel;
import javax.swing.border.EmptyBorder;

public class BistaRanking {

	private JFrame frame;
	private JLabel lblLehenengoPuntuazio;
	private JButton btnOk;
	private JList list;
	private static BistaRanking nireRanking;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BistaRanking window = new BistaRanking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
    
	public static BistaRanking getNireRanking(){
	     if(nireRanking==null){
	    	 nireRanking=new BistaRanking();
	     }
	     return nireRanking;
	    }

	/**
	 * Create the application.
	 */
	private BistaRanking() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblLehenengoPuntuazio());
		frame.getContentPane().add(getBtnOk());
		frame.getContentPane().add(getList());
		frame.setResizable(false);
	}
	private JLabel getLblLehenengoPuntuazio() {
		if (lblLehenengoPuntuazio == null) {
			lblLehenengoPuntuazio = new JLabel("Lehenengo 10 puntuazio hoberenak:");
			lblLehenengoPuntuazio.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblLehenengoPuntuazio.setBounds(81, 11, 312, 31);
		}
		return lblLehenengoPuntuazio;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					 System.exit(0);
				}
			});
			btnOk.setBounds(164, 237, 89, 23);
		}
		return btnOk;
	}
	private JList<String> getList() {
		if (list == null) {
			list = new JList<String>();
			list.setBounds(69, 41, 290, 185);
            DefaultListModel<String> mod=new DefaultListModel<String>();
            ArrayList<Jokalaria> zerrenda = DragaminaGestorea.getNireDragaminaGestorea(-1).getZerrenda();
			int kont = 0;
			Iterator<Jokalaria> itr = zerrenda.iterator();
			while (itr.hasNext() && kont<10) {
				
				Jokalaria jokalaria = itr.next();
				mod.add(kont, jokalaria.getIzena() +" "+ jokalaria.getPuntuak());				
				kont++;
								
			}				
           
            list.setModel(mod);
            list.setVisibleRowCount(10);			
			
		}
		return list;
	}
}
