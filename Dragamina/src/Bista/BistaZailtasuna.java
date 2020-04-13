package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;


import Eredua.DragaminaGestorea;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Dimension;

public class BistaZailtasuna {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblJokoarenZailtasunMaila;
	private JComboBox comboBox;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BistaZailtasuna window = new BistaZailtasuna();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public BistaZailtasuna() {
		initialize();
		this.frame.setVisible(true);
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 429, 268);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPanel(), BorderLayout.CENTER);
		frame.getContentPane().add(getPanel_1(), BorderLayout.SOUTH);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(55, 100, 55, 100));
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			panel.add(getLblNewLabel());
			panel.add(getTextField());
			panel.add(getLblJokoarenZailtasunMaila());
			panel.add(getComboBox());
		}
		return panel;
	}
	private JPanel getPanel_1() { 
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getBtnOk());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sartu zure izena:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setMaximumSize(new Dimension(20, 20));
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblJokoarenZailtasunMaila() {
		if (lblJokoarenZailtasunMaila == null) {
			lblJokoarenZailtasunMaila = new JLabel("Jokoaren zailtasun maila esleitu:");
			lblJokoarenZailtasunMaila.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblJokoarenZailtasunMaila;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		}
		return comboBox;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String izena= textField.getText();
					int zailtasuna= comboBox.getSelectedIndex()+1;
					frame.setVisible(false);
					DragaminaGestorea gestorea = DragaminaGestorea.getNireDragaminaGestorea(zailtasuna);
					new BistaDiagrama();
					gestorea.sartuJokalaria(izena);
					
				}
			});
		}
		return btnOk;
	}
}
