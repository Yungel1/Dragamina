package Eredua;

public class Kronometroa {

	 private final long hasi;


	    public Kronometroa() {
	        hasi = System.currentTimeMillis();
	    } 

	   /**
	     * Return elapsed time (in seconds) since this object was created.
	     */
	    public double pasatutakoDenbora() {
	    	
	        long now = System.currentTimeMillis();
	        return (now - hasi) / 1000.0;
	    }
}
