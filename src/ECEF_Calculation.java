import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

//Calculations for LLH to ECEF
public class ECEF_Calculation {
    private double Xresult;
    private double Yresult;
    private double Zresult;
    
    DecimalFormat df = new DecimalFormat("#.#####");
	
	public ECEF_Calculation() {
		
	}
	
	private double radsToDeg(double rad) {
		return rad * (Math.PI / 180);
	}
	
	public void calculateXYZ(double lat, double lon, double ht) {
		final double f = 1 / 298.257223560;
		final int a = 6378137;
		double e = Math.sqrt(2 * f - Math.pow(f, 2));
		
	    double latCos = Math.cos(radsToDeg(lat));
		double latSin = Math.sin(radsToDeg(lat));
		double lonCos = Math.cos(radsToDeg(lon));
		double lonSin = Math.sin(radsToDeg(lon));
		
		double R_n = a / ((1 - Math.pow(e, 2) * Math.pow(latSin, 2)));
		
		Xresult = (R_n + ht) * latCos * lonCos;
		Yresult = (R_n + ht) * latCos * lonSin;
		Zresult = ((1 - Math.pow(e, 2)) * R_n + ht) * latSin;
	}
	
	public String getXResult() {
		return df.format(Xresult);
	}
	
	public String getYResult() {
		return df.format(Yresult);
	}
	
	public String getZResult() {
		return df.format(Zresult);
	}
	
}
