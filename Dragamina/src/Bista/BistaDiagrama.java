package Bista;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Eredua.DragaminaGestorea;
import Eredua.Estaltzea;
import Eredua.EzEstalita;
import Eredua.Hutsa;
import Eredua.Kasilla;
import Eredua.Mina;
import Eredua.Zenbakizkoa;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class BistaDiagrama implements Observer {

    private DragaminaGestorea dragamina;
    
	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel btnCarita;
	private JLabel lista[][];
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BistaDiagrama window = new BistaDiagrama();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

    @Override
    public void update(Observable arg0, Object arg1) {
    	this.kudeatu((DragaminaGestorea)arg0);   
    }
    private void kudeatu(DragaminaGestorea drag) {
    	
    	int x;
    	int y;
    	for (x = 0; x < drag.getErrenkada(); x++) {
			for (y = 0; y < drag.getZutabea(); y++) {
				
				Kasilla kas=drag.lortuKasilla(x, y);
				Estaltzea est=kas.getEstaltzea();
				
				if(est instanceof EzEstalita ) {
				  	if(kas instanceof Mina) {
				  		lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("mina-r.gif")));
				  	
				  	}
				  	else if(kas instanceof Hutsa) {
				  		lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("c0.gif")));
				  		
				  	}
				  	else if(kas instanceof Zenbakizkoa) {
				  		int emaitza= ((Zenbakizkoa)kas).getZenb();
				  		switch(emaitza) {
				  		case 1:
				  			
				  			
				  			lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("c1.gif")));
				  			break;
				  		case 2:
				  			
				  			
				  			lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("c2.gif")));
				  			break;
				  		case 3:
				  			
				  			
				  			lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("c3.gif")));
				  			break;
				  		case 4:
				  			
				  			
				  			lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("c4.gif")));
				  			break;
				  		case 5:
				  			
				  			
				  			lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("c5.gif")));
				  			break;
				  		case 6:
				  			
				  			
				  			lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("c6.gif")));
				  			break;
				  		case 7:
				  			
				  			
				  			lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("c7.gif")));
				  			break;
				  		case 8:
				  			
				  			
				  			lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("c8.gif")));
				  			break;
				  	}
				  		
				  		}
				}
    	 
			}
    	}
    }
	/**
	 * Create the application.
	 */
	public BistaDiagrama(Observable pDragaminaGestorea) {
	    this.dragamina=(DragaminaGestorea)pDragaminaGestorea;
	    this.dragamina.addObserver(this);
		initialize();
		this.frame.setVisible(true);
	}
	public JFrame getFrame(){
	    return this.frame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(getPanel_1(), BorderLayout.CENTER);
		this.hasieratu(dragamina.getErrenkada(), dragamina.getZutabea());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getBtnCarita());
			panel.add(getLabel_6());
			panel.add(getLabel_5());
			panel.add(getLabel_4());
		}
		return panel;
	}
	private JLabel gelaxkaSortu() {
		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createLoweredBevelBorder());
		label.setIcon(new ImageIcon(this.getClass().getResource("tablero.gif")));
		label.setMaximumSize(new Dimension(20, 20));
		label.setMinimumSize(new Dimension(18, 18));
		label.setSize(new Dimension(18, 18));
		label.addMouseListener(new Controlador());
		return label;

	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridBagLayout());
		
		}
		return panel_1;
	}
	public JLabel[][] getLista(){
		if(lista==null) {
			return this.lista=new JLabel[dragamina.getErrenkada()][dragamina.getZutabea()];
		}
		else {
			return lista;
		}
	}
	private void hasieratu(int nLerro,int nZutabe) {
		int y;
		int x;
		JLabel gelaxkaBerri;
		this.lista=getLista();
		  for (x = 0; x < nLerro; x++) {
				for (y = 0; y < nZutabe; y++) {
					gelaxkaBerri = gelaxkaSortu();
					this.lista[x][y]=gelaxkaBerri;
					getPanel_1().add(gelaxkaBerri,new GridBagConstraints(y, x, 1, 1, 0.0, 0.0,GridBagConstraints.CENTER,
									     	GridBagConstraints.NONE,new Insets(0, 0, 0, 0), 0, 0));
				}
			  }

	}

	
	
	private JLabel getBtnCarita() {
		if (btnCarita == null) {
			
			btnCarita = new JLabel("");
			btnCarita.setIcon(new ImageIcon(this.getClass().getResource("cara1.gif")));
		}
		return btnCarita;
	}
	
	
	
	
	private class Controlador extends MouseAdapter{
		//Botoia sakatzu gero, ereduko "estaBerde" aldatuko du
	
		@Override
		public void mouseClicked(MouseEvent e) {
			if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
				JLabel gelaxka=(JLabel) e.getSource();
				int y;
				int x;
				int xemaitza;
				int yemaitza;
				lista=getLista();
				  for (x = 0; x < lista.length; x++) {
						for (y = 0; y < lista[0].length; y++) {
							if(lista[x][y].equals(gelaxka)) {
								xemaitza=x;
								yemaitza=y;
								dragamina.aktibatutakoaKudeatu(xemaitza,yemaitza);
								//lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("mina-r.gif")));
							}
						}
					  }
				  

				//lista[1][1].setIcon(new ImageIcon(this.getClass().getResource("34ed1783bb2ddd660686ac6a685270bf.jpg")));
				//System.out.println(e.getPoint());
				//getLabel().setText(String.format(%d", e.getXOnScreen(), e.getYOnScreen()));
				//getLabel().setText(String.format("X: %d Y:%d", e.getXOnScreen(), e.getYOnScreen()));
				//gelaxka.setIcon(new ImageIcon(this.getClass().getResource("34ed1783bb2ddd660686ac6a685270bf.jpg")));
				//getLabel().setIcon(new ImageIcon(this.getClass().getResource("34ed1783bb2ddd660686ac6a685270bf.jpg")));
				//getLista().get().setIcon(new ImageIcon(this.getClass().getResource("34ed1783bb2ddd660686ac6a685270bf.jpg")));
			}
		}
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
		}
		return label_6;
	}
}

