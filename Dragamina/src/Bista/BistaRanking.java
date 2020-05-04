package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class BistaRanking {

	private JFrame frame;
	private JLabel lblLehenengoPuntuazio;
	private JButton btnOk;
	private JScrollPane scrollPane;
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
	public BistaRanking() {
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
		frame.getContentPane().add(getScrollPane());
		frame.setResizable(false);
	}
	private JLabel getLblLehenengoPuntuazio() {
		if (lblLehenengoPuntuazio == null) {
			lblLehenengoPuntuazio = new JLabel("Lehenengo 10 puntuazio hoberenak:");
			lblLehenengoPuntuazio.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblLehenengoPuntuazio.setBounds(81, 21, 312, 31);
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
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();	
			scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			scrollPane.setViewportView(getList());
			
		}
		return scrollPane;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setVisibleRowCount(10);			
		}
		return list;
	}
}
