package combustion;

/*
 * Chemistry Calculator
 * By: Matthew William and Ishaan Patel
 * 2/24/17
 */
public class Hydrocarbon
{
    private int myType; //1 for alkane , 2 for alkene, 3 for alkyne ..... for other hydrocarbons like ketones, esters. alcohols, etc.
    private double myC;
    private String myName;
    private String myFormula;

    public Hydrocarbon()
    {
        myType = 1;
        myC = 1;
        myName = "Methane";   // 1 and 1 makes methane (alkane, 1 carbon)
        myFormula = "CH4";
    }

    public Hydrocarbon( String name , int type, double c, String formula )
    {
        myType = type;
        myC = c;
        myName = name;
        myFormula = formula;

    }

    //Accessors

    public int getMyType()
    {
        return myType;
    }


    public double getMyC()
    {
        return myC;
    }


    public String getMyName()
    {
        return myName;
    }

    public String getMyFormula()
    {
        return myFormula;
    }


}
