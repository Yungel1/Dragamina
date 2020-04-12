package Eredua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class ListaJokalariakTest {

	Jokalaria joka1, joka2, joka21,joka3,joka4,joka5,joka6,joka61,joka62,joka7;
	Jokalaria jokaRandomBat;
	ListaJokalariak zerre;
	
	@Before
	public void setUp() throws Exception {
		
		joka1 = new Jokalaria("1. Jokalaria", 100);
		joka2 = new Jokalaria("2. Jokalaria", 90);		
		joka21 = new Jokalaria("3. Jokalaria", 90);
		joka3 = new Jokalaria("4. Jokalaria", 80);
		joka4 = new Jokalaria("5. Jokalaria", 70);
		joka5 = new Jokalaria("6. Jokalaria", 60);
		joka6 = new Jokalaria("7. Jokalaria", 50);
		joka61 = new Jokalaria("8. Jokalaria", 50);
		joka62 = new Jokalaria("9. Jokalaria", 50);
		joka7 = new Jokalaria("10. Jokalaria", 40);
	
		zerre = ListaJokalariak.getNireListaJokalariak();
		
		/*zerre.jokalariaSartuProba(joka1);
		zerre.jokalariaSartuProba(joka2);
		zerre.jokalariaSartuProba(joka21);
		zerre.jokalariaSartuProba(joka3);
		zerre.jokalariaSartuProba(joka4);
		zerre.jokalariaSartuProba(joka5);
		zerre.jokalariaSartuProba(joka6);
		zerre.jokalariaSartuProba(joka61);
		zerre.jokalariaSartuProba(joka62);
		zerre.jokalariaSartuProba(joka7);
		*/
	}

	@After
	public void tearDown() throws Exception {
		
		zerre.zerrendaNulleraProba();
		joka1 	= null;
		joka2 	= null;		
		joka21	= null;
		joka3 	= null;
		joka4 	= null;
		joka5 	= null;
		joka6 	= null;
		joka61 	= null;
		joka62 	= null;
		joka7 	= null;
		
		jokaRandomBat = null;
	}
	
	


	@Test
	public void testZerrendanSartu1() { //lehenengo posizioan sartu
		
		
		
		
		
		//0. Proba: Zerrenda hutsik --> 1. Posizioan sartu
		
			System.out.println("0. PROBA: ZERRENDA HUTSIK\n");
			System.out.println("Jokalaria zerrendan sartu baino lehen");
			zerre.jokalariakInprimatuProba();
			
			
			Jokalaria jokaRandom0 = new Jokalaria("JOKARANDOM", 10);
			
			zerre.unekoJokalariaAldatuProba(jokaRandom0);
			zerre.zerrendanSartu();
			
			System.out.println("Jokalaria zerrendan sartu eta gero");
			zerre.jokalariakInprimatuProba();
			System.out.println("\n\n\n");
			
			
			zerre.zerrendaResetProba();
			
			
		//1.1. Proba: Elementu bakarreko zerrenda, jokaRandom handiagoa da --> 1. Posizioan sartu
			
			zerre.jokalariaSartuProba(joka7); //40 puntu ditu
			System.out.println("1.1. PROBA: ELEMENTU BAKARREKO ZERRENDA, JOKARANDOM HANDIAGOA\n");
			System.out.println("Jokalaria zerrendan sartu baino lehen");
			zerre.jokalariakInprimatuProba();
			
			Jokalaria jokaRandom11 = new Jokalaria("JOKARANDOM", 50);
			
			zerre.unekoJokalariaAldatuProba(jokaRandom11);
			zerre.zerrendanSartu();
			
			System.out.println("Jokalaria zerrendan sartu eta gero");
			zerre.jokalariakInprimatuProba();
			System.out.println("\n\n\n");
			
			
			zerre.zerrendaResetProba();
			
			
		//1.2. Proba: Elementu bakarreko zerrenda, jokaRandom txikiagoa da --> 2. Posizioan sartu
			
			zerre.jokalariaSartuProba(joka7); //40 puntu ditu
			System.out.println("1.2. PROBA: ELEMENTU BAKARREKO ZERRENDA, JOKARANDOM TXIKIAGOA\n");
			System.out.println("Jokalaria zerrendan sartu baino lehen");
			zerre.jokalariakInprimatuProba();
			
			Jokalaria jokaRandom12 = new Jokalaria("JOKARANDOM", 30);
			
			zerre.unekoJokalariaAldatuProba(jokaRandom12);
			zerre.zerrendanSartu();
			
			System.out.println("Jokalaria zerrendan sartu eta gero");
			zerre.jokalariakInprimatuProba();
			System.out.println("\n\n\n");
			
			
			zerre.zerrendaResetProba();
			
			
		//2.1. Proba: Bi elementuko zerrenda, jokaRandom biak baino handiagoa --> 1. Posizioan sartu
			
			zerre.jokalariaSartuProba(joka1); //100 puntu ditu
			zerre.jokalariaSartuProba(joka2); //90 puntu ditu
			System.out.println("2.1. PROBA: BI ELEMENTUKO ZERRENDA, JOKARANDOM HANDIENA\n");
			System.out.println("Jokalaria zerrendan sartu baino lehen");
			zerre.jokalariakInprimatuProba();
			
			Jokalaria jokaRandom21 = new Jokalaria("JOKARANDOM", 110);
			
			zerre.unekoJokalariaAldatuProba(jokaRandom21);
			zerre.zerrendanSartu();
			
			System.out.println("Jokalaria zerrendan sartu eta gero");
			zerre.jokalariakInprimatuProba();
			System.out.println("\n\n\n");
			
			
			zerre.zerrendaResetProba();
			
			
		//2.2. Proba: Bi elementuko zerrenda, jokaRandom bien artean egongo da --> 2. Posizioan sartu
			
			zerre.jokalariaSartuProba(joka1); //100 puntu ditu
			zerre.jokalariaSartuProba(joka2); //90 puntu ditu
			System.out.println("2.2. PROBA: BI ELEMENTUKO ZERRENDA, JOKARANDOM ERDIKOA\n");
			System.out.println("Jokalaria zerrendan sartu baino lehen");
			zerre.jokalariakInprimatuProba();
			
			Jokalaria jokaRandom22 = new Jokalaria("JOKARANDOM", 95);
			
			zerre.unekoJokalariaAldatuProba(jokaRandom22);
			zerre.zerrendanSartu();
			
			System.out.println("Jokalaria zerrendan sartu eta gero");
			zerre.jokalariakInprimatuProba();
			System.out.println("\n\n\n");
			
			
			zerre.zerrendaResetProba();
			
			
		//2.3. Proba: Bi elementuko zerrenda, jokaRandom biak baino txikiagoa --> 3. Posizioan sartu
			
			zerre.jokalariaSartuProba(joka1); //100 puntu ditu
			zerre.jokalariaSartuProba(joka2); //90 puntu ditu
			System.out.println("2.3. PROBA: BI ELEMENTUKO ZERRENDA, JOKARANDOM AZKENENGOA\n");
			System.out.println("Jokalaria zerrendan sartu baino lehen");
			zerre.jokalariakInprimatuProba();
			
			Jokalaria jokaRandom23 = new Jokalaria("JOKARANDOM", 80);
			
			zerre.unekoJokalariaAldatuProba(jokaRandom23);
			zerre.zerrendanSartu();
			
			System.out.println("Jokalaria zerrendan sartu eta gero");
			zerre.jokalariakInprimatuProba();
			System.out.println("\n\n\n");
			
			
			zerre.zerrendaResetProba();
			
			
		//3.1. Proba: Elementu anitzeko zerrenda, handiena --> 1. Posizioan sartu
			
			zerre.jokalariaSartuProba(joka1);//100 puntu ditu
			zerre.jokalariaSartuProba(joka2);
			zerre.jokalariaSartuProba(joka21);
			zerre.jokalariaSartuProba(joka3);
			zerre.jokalariaSartuProba(joka4); 
			zerre.jokalariaSartuProba(joka5);
			zerre.jokalariaSartuProba(joka6);
			zerre.jokalariaSartuProba(joka61);
			zerre.jokalariaSartuProba(joka62);
			zerre.jokalariaSartuProba(joka7);
			System.out.println("3.1. PROBA: ELEMENTU ANITZEKO ZERRENDA, JOKARANDOM LEHENENGOA\n");
			System.out.println("Jokalaria zerrendan sartu baino lehen");
			zerre.jokalariakInprimatuProba();
			
			Jokalaria jokaRandom31 = new Jokalaria("JOKARANDOM", 110);
			
			zerre.unekoJokalariaAldatuProba(jokaRandom31);
			zerre.zerrendanSartu();
			
			System.out.println("Jokalaria zerrendan sartu eta gero");
			zerre.jokalariakInprimatuProba();
			System.out.println("\n\n\n");
			
			
			zerre.zerrendaResetProba();
			

		//3.2. Proba: Elementu anitzeko zerrenda, bostgarrena baino handiagoa eta 
													//laugarrena baino txikiagoa --> 5. Posizioan sartu
			
			zerre.jokalariaSartuProba(joka1);
			zerre.jokalariaSartuProba(joka2);
			zerre.jokalariaSartuProba(joka21);
			zerre.jokalariaSartuProba(joka3);
			zerre.jokalariaSartuProba(joka4); //70 puntu ditu
			zerre.jokalariaSartuProba(joka5);
			zerre.jokalariaSartuProba(joka6);
			zerre.jokalariaSartuProba(joka61);
			zerre.jokalariaSartuProba(joka62);
			zerre.jokalariaSartuProba(joka7);
			System.out.println("3.2. PROBA: ELEMENTU ANITZEKO ZERRENDA, JOKARANDOM BOSTGARRENA\n");
			System.out.println("Jokalaria zerrendan sartu baino lehen");
			zerre.jokalariakInprimatuProba();
			
			Jokalaria jokaRandom32 = new Jokalaria("JOKARANDOM", 75);
			
			zerre.unekoJokalariaAldatuProba(jokaRandom32);
			zerre.zerrendanSartu();
			
			System.out.println("Jokalaria zerrendan sartu eta gero");
			zerre.jokalariakInprimatuProba();
			System.out.println("\n\n\n");
			
			
			zerre.zerrendaResetProba();
			
			
		//3.3. Proba: Elementu anitzeko zerrenda, txikiena --> Azkenengo posizioan sartu
		
			
			zerre.jokalariaSartuProba(joka1);
			zerre.jokalariaSartuProba(joka2);
			zerre.jokalariaSartuProba(joka21);
			zerre.jokalariaSartuProba(joka3);
			zerre.jokalariaSartuProba(joka4); 
			zerre.jokalariaSartuProba(joka5);
			zerre.jokalariaSartuProba(joka6);
			zerre.jokalariaSartuProba(joka61);
			zerre.jokalariaSartuProba(joka62);
			zerre.jokalariaSartuProba(joka7); //40
			System.out.println("3.3. PROBA: ELEMENTU ANITZEKO ZERRENDA, JOKARANDOM AZKENENGOA\n");
			System.out.println("Jokalaria zerrendan sartu baino lehen");
			zerre.jokalariakInprimatuProba();
			
			Jokalaria jokaRandom33 = new Jokalaria("JOKARANDOM", 39);
			
			zerre.unekoJokalariaAldatuProba(jokaRandom33);
			zerre.zerrendanSartu();
			
			System.out.println("Jokalaria zerrendan sartu eta gero");
			zerre.jokalariakInprimatuProba();
			System.out.println("\n\n\n");
			
			
			zerre.zerrendaResetProba();
	}
	
	


	

}
