package Bista;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Eredua.Bandera;
import Eredua.DragaminaGestorea;
import Eredua.Estalita;
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
	private JLabel label_7;
// si ves esto es que esta cambiado
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

	
	/**
	 * Create the application.
	 */
	public BistaDiagrama() {
		
	    DragaminaGestorea.getNireDragaminaGestorea(-1).addObserver(this);
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
		if(DragaminaGestorea.getNireDragaminaGestorea(-1).getErrenkada()== 7) {
			frame.setBounds(100, 100, 450, 300);
			getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n1.gif")));
			getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
		}
		else if(DragaminaGestorea.getNireDragaminaGestorea(-1).getErrenkada()== 10) {
			frame.setBounds(100, 100, 475, 350);
			getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n3.gif")));
			getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
		}
		else if(DragaminaGestorea.getNireDragaminaGestorea(-1).getErrenkada()== 12) {
			frame.setBounds(100, 100, 600, 400);
			getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n7.gif")));
			getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n5.gif")));
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(getPanel_1(), BorderLayout.CENTER);
		this.hasieratu(DragaminaGestorea.getNireDragaminaGestorea(-1).getErrenkada(), DragaminaGestorea.getNireDragaminaGestorea(-1).getZutabea());
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
	
	public JLabel[][] getLista(){
		
		if(lista==null) {
			
			return this.lista=new JLabel[DragaminaGestorea.getNireDragaminaGestorea(-1).getErrenkada()][DragaminaGestorea.getNireDragaminaGestorea(-1).getZutabea()];
		}
		
		else {
			
			return lista;
		}
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
	
	
	private class Controlador extends MouseAdapter{
		
		@Override
		
		public void mouseClicked(MouseEvent e) {
			if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
				JLabel gelaxka=(JLabel) e.getSource();
				if(e.getSource().equals(getLabel_7())) {
					System.exit(0);
				}
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
								DragaminaGestorea.getNireDragaminaGestorea(-1).aktibatutakoaKudeatu(xemaitza,yemaitza);
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
			else if((e.getModifiers() & InputEvent.BUTTON1_MASK) == 0) {
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
							DragaminaGestorea.getNireDragaminaGestorea(-1).markatu(xemaitza,yemaitza);
							//lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("mina-r.gif")));
						}
					}
			  }
			}
		}
	}
	
	
    @Override
    public void update(Observable arg0, Object arg1) {
    	
    	this.kudeatu((DragaminaGestorea)arg0);   
    }
    private void banderaKop() {
    	int bandera=DragaminaGestorea.getNireDragaminaGestorea(-1).getUnekoMinak();
    	int erdikoa= bandera%10;
    	//System.out.println(bizutabea);
    	//getLabel_5().setIcon(new ImageIcon(this.getClass().getResource("n1.gif")));
    	int eskumakoa=bandera/10;
    	eskumakoa = eskumakoa%10;
    	//System.out.println(batzutabe);
    	this.diplayAldatu(erdikoa, eskumakoa);
    	//System.out.println(erdikoa);
    	//System.out.println(eskumakoa);
    		
    }
    
 private void diplayAldatu(int z1, int z2){
    	
    	//erdiko zutabea aldatu
    	
    	if (z1==0){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
    	}
    	
    	if (z1==1){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n1.gif")));
    	}
    	
    	if (z1==2){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n2.gif")));
    	}
    	
    	if (z1==3){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n3.gif")));
    	}
    	
    	if (z1==4){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n4.gif")));
    	}
    	
    	if (z1==5){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n5.gif")));
    	}
    	
    	if (z1==6){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n6.gif")));
    	}
    	
    	if (z1==7){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n7.gif")));
    	}
    	
    	if (z1==8){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n8.gif")));
    	}
    	
    	if (z1==9){
    		
    		getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n9.gif")));
    	}
    	
    	
    	//orain eskumako zutabea aldatu
    	
    	
    	if (z2==0){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
    	}
    	
    	if (z2==1){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n1.gif")));
    	}
    	
    	if (z2==2){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n2.gif")));
    	}
    	
    	if (z2==3){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n3.gif")));
    	}
    	
    	if (z2==4){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n4.gif")));
    	}
    	
    	if (z2==5){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n5.gif")));
    	}
    	
    	if (z2==6){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n6.gif")));
    	}
    	
    	if (z2==7){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n7.gif")));
    	}
    	
    	if (z2==8){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n8.gif")));
    	}
    	
    	if (z2==9){
    		
    		getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n9.gif")));
    	}
    }
    

    private void kudeatu(DragaminaGestorea drag) {
    	int x;
    	int y;
    	int xe;
    	int ye;
    	for (x = 0; x < drag.getErrenkada(); x++) {
    		
			for (y = 0; y < drag.getZutabea(); y++) {
				
				Kasilla kas=drag.lortuKasilla(x, y);
				Estaltzea est=kas.getEstaltzea();
				xe=x;
				ye=y;
				
				if( est instanceof Bandera) {
					lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("bandera.gif")));
					this.banderaKop();
				       
				}
				else if(est instanceof Estalita) {
					lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("tablero.gif")));
					if (drag.getUnekoMinak()== 10){
						getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n1.gif")));
						getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
					}
					
					else if (drag.getUnekoMinak()== 30){
						getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n3.gif")));
						getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n0.gif")));
					}
					
					else if (drag.getUnekoMinak()== 75){
						getLabel_2().setIcon(new ImageIcon(this.getClass().getResource("n7.gif")));
						getLabel_3().setIcon(new ImageIcon(this.getClass().getResource("n5.gif")));
					}
					
				}
				else if(est instanceof EzEstalita  ) {
                    
				  	if(kas instanceof Mina) {
				  		
				  	  for (x = 0; x < drag.getErrenkada(); x++) {
				  		  
                          for (y = 0; y < drag.getZutabea(); y++) {
                        	  
                              lista[x][y].removeMouseListener(lista[x][y].getMouseListeners()[0]);
                              
                                  if(drag.lortuKasilla(x, y) instanceof Mina) {
                                	  
                                      lista[x][y].setIcon(new ImageIcon(this.getClass().getResource("mina-n.gif")));
                              }
                          }
                          
				  	  }
                      lista[xe][ye].setIcon(new ImageIcon(this.getClass().getResource("mina-r.gif")));
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
    	
        if(drag.irabaziDu()){
        	
          for (x = 0; x < drag.getErrenkada(); x++) {
        	  
              for (y = 0; y < drag.getZutabea(); y++) {
            	  
                  lista[x][y].removeMouseListener(lista[x][y].getMouseListeners()[0]);
              }
          }
          
          System.out.println("\nIrabazi duzu!!!");
          
        }
    	
    }

	
	private JPanel getPanel() {
		
		if (panel == null) {
			
			panel = new JPanel();
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getLabel_7());
			panel.add(getBtnCarita());
			panel.add(getLabel_6());
			panel.add(getLabel_5());
			panel.add(getLabel_4());
		}
		
		return panel;
	}
	
	
	private JPanel getPanel_1() {
		
		if (panel_1 == null) {
			
			panel_1 = new JPanel();
			panel_1.setLayout(new GridBagLayout());
		
		}
		
		return panel_1;
	}
	
	
	private JLabel getBtnCarita() {
		
		if (btnCarita == null) {
			
			btnCarita = new JLabel("");
			btnCarita.setIcon(new ImageIcon(this.getClass().getResource("cara1.gif")));
		}
		
		return btnCarita;
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
	
	
	private JLabel getLabel_7() {
		
		if (label_7 == null) {
			
			label_7 = new JLabel("");
			label_7.setIcon(new ImageIcon(this.getClass().getResource("push-button-red-clip-art-button-png.jpg")));
			label_7.addMouseListener(new Controlador());
		}
		
		return label_7;
	}
}

