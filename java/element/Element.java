package element;

/**
 * Created by Ishaan on 3/28/2017.
 */

public class Element
{
    private int myCharge;
    private String myName;
    private int myIon;


    public Element()
    {
        myName = "H";
        myCharge = 1;
        myIon = 1;  //If cation, i = 1 , if anion, i = 0, if diatomic, i = 3, if hydrogen, i = 4
    }



    public Element(String name, int charge, int ion)
    {
        myName = name;
        myCharge = charge;
        myIon = ion;
    }

    //Accessors

    public int getCharge()
    {
        return myCharge;
    }


    public String getName()
    {
        return myName;
    }

    public int getIon()
    {
        return myIon;
    }
}

