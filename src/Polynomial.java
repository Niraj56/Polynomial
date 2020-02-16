import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Polynomial {


	public List<Double> coefn ;
	
	public Polynomial()
	{
		this.coefn = new ArrayList<Double>();
		
	}
	
	public Polynomial( List<Double> an)
	{
		this.coefn = an;

		
	}
	
	public String toString() { 
	    String str ="Coefficients are : ";
	    for (int i = 0; i < this.coefn.size(); ++i) 
	    {
	    	str+=this.coefn.get(i) + ",";
	    }
	    
	    return str;
	} 
	
	public Polynomial Add(Polynomial poly)
	{
		int n = this.coefn.size();
		if (n<poly.coefn.size())
		{
			n = poly.coefn.size();
		}
		
		List<Double> an = new ArrayList<Double>();
		for (int i = 0; i < n; ++i) {
			   
			 double a_val = 0.0;
			 
			 if (i < this.coefn.size())
			 {
				 a_val += this.coefn.get(i);
			 }
			 
			 if (i < poly.coefn.size())
			 {
				 a_val += poly.coefn.get(i);
			 }
			 
			 an.add(a_val);
			}
		return new Polynomial(an);
	}
	
	
	public Polynomial Substract(Polynomial poly)
	{

		int n = this.coefn.size();
		if (n<poly.coefn.size())
		{
			n = poly.coefn.size();
		}
		
		List<Double> an = new ArrayList<Double>();
		for (int i = 0; i < n; ++i) {
			   
			 double a_val = 0.0;
			 
			 if (i < this.coefn.size())
			 {
				 a_val += this.coefn.get(i);
			 }
			 
			 if (i < poly.coefn.size())
			 {
				 a_val -= poly.coefn.get(i);
			 }
			 
			 an.add(a_val);
			}
		return new Polynomial(an);
	}
	
	public Polynomial Multiply(Polynomial poly)
	{


		
		List<Double> an = new ArrayList<Double>();
		int n = (this.coefn.size()-1)+(poly.coefn.size()-1);
		for (int i = 0; i <=n; ++i)
		{
			an.add(0.0);
		}
		for (int i = 0; i <this.coefn.size(); ++i) {
			for (int j = 0; j <poly.coefn.size(); ++j) {
				double val =an.get(i+j)+ this.coefn.get(i)*poly.coefn.get(j);
				an.set(i+j,val );
			}
			}
		return new Polynomial(an);
	}
	
	
	public Polynomial(String txtfile)
	{
		this.coefn = new ArrayList<Double>();
		
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(txtfile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            String line = null;
            
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                
                if (line != "")
                {
                	String[] lines = line.split(",");
                	if(lines.length >=2) 
                	{

                		for (int i = 0; i < lines.length; ++i) {
                			   this.coefn.add(Double.parseDouble(lines[i]));
                			}
                	}
                }
                
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                		txtfile + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + txtfile + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
}
