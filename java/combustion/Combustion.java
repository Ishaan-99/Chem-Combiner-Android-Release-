package combustion;

import java.util.ArrayList;

/**
 * Created by Ishaan and Matthew  on 4/14/2017.
 */

public class Combustion
{
    public static String finalResult;
    // Note: "CompoundName-type-carbon-Formula for Compound"
    public static String hydrocarbons[] =
            {
                    //Alkanes - type 1
                    "Methane: CH4|1|1|CH4", "Ethane: C2H6|1|2|C2H6" , "Propane: C3H8|1|3|C3H8" , "Butane: C4H10|1|4|C4H10", "Pentane: C5H12|1|5|C5H12", "Hexane: C6H14|1|6|C6H14", "Heptane: C7H16|1|7|C7H16", "Octane: C8H18|1|8|C8H18", "Nonane: C9H20|1|9|C9H20", "Decane: C10H22|1|10|C10H22",

                    //Alkenes - type 2 (Methene does not exist)
                    "Ethene: C2H4|2|2|C2H4", "Propene: C3H6|2|3|C3H6", "Butene: C4H8|2|4|C4H8", "Pentene: C5H10|2|5|C5H10", "Hexene: C6H12|2|6|C6H12", "Heptene: C7H14|2|7|C7H14", "Octene: C8H16|2|8|C8H16", "Nonene: C9H18|2|9|C9H18", "Decene: C10H20|2|10|C10H20",

                    //Alkynes - type 3 (Methyne does not exist)
                    "Ethyne: C2H2|3|2|C2H2" , "Propyne: C3H4|3|3|C3H4" , "Butyne: C4H6|3|4|C4H6", "Pentyne: C5H8|3|5|C5H8", "Hexyne: C6H10|3|6|C6H10", "Heptyne: C7H12|3|7|C7H12", "Octyne: C8H14|3|8|C8H14", "Nonyne: C9H16|3|9|C9H16", "Decyne: C10H18|3|10|C10H18"

            };

    public static  String organics[] = new String[hydrocarbons.length];


    public static Hydrocarbon hydrocarbon1;


    public static void startCombustion(String inputValue)
    {

        check(inputValue);
        Combustion();
    }

    public static String[] shortenHydrocarbons()
    {


        //Sets d and element3 with shortened version of cations and anions
        //Ex: hydrogen-H-1-4 -> hydrogen
        for(int x = 0; x < organics.length; x++)
        {
            organics[x] = hydrocarbons[x].substring(0, hydrocarbons[x].indexOf("|"));
        }
     return organics;
    }
    public static void check(String inputValue)  //Uses input for 3 different elements in single replacement
    {


        /*
        //JOptionPane for synthesis, gives options.
        String inputValue = (String) JOptionPane.showInputDialog(null, "Enter Hydrocarbon: (ex: Methane)",
                "Chemistry Calculator",
                JOptionPane.PLAIN_MESSAGE,
                null, organics, "");
        */


        //Instantiates element1 with user selected elements
        for(int y = 0; y < organics.length; y++){
            if(inputValue.equals(organics[y]))
            {

                int[] location = new int[3];
                String value = "|";
                int index = hydrocarbons[y].indexOf(value);
                int x = 0;
                while(index >= 0 && x < location.length )
                {
                    location[x] = index;
                    x++;
                    index = hydrocarbons[y].indexOf(value, index + 1);
                }
                int type = Integer.parseInt(hydrocarbons[y].substring(location[0] + 1 , location[1]));
                double c = Integer.parseInt(hydrocarbons[y].substring(location[1] + 1 , location[2]));
                String name = hydrocarbons[y].substring(0, location[0]);
                String form = hydrocarbons[y].substring(location[2] + 1, hydrocarbons[y].length());
                hydrocarbon1 = new Hydrocarbon(name , type , c , form);
                break;
            }
        }


    }



    public static void Combustion()
    {
        ArrayList<String> equation = new ArrayList<String>();
        String fin = " ";

        // Alkanes with even numbers of carbons
        if(hydrocarbon1.getMyType() == 1 && (((int)hydrocarbon1.getMyC() % 2) == 0 ))
        {
            equation.add("2" + hydrocarbon1.getMyFormula() + " + " + " " + (int)(1 + (3 * hydrocarbon1.getMyC())) + "O2" + " --> " + (((int)hydrocarbon1.getMyC() *2) + 2) + "H2O" + " + " + (int)(hydrocarbon1.getMyC() * 2) + "CO2");

        }
        // Alkanes with odd numbers of carbons
        if(hydrocarbon1.getMyType() == 1 && ((hydrocarbon1.getMyC() % 2) != 0 ))
        {
            equation.add(hydrocarbon1.getMyFormula() + " + " + " " + (int)(0.5 + (1.5 * hydrocarbon1.getMyC())) + "O2" + " --> " + ((int)hydrocarbon1.getMyC() +1) + "H2O" + " + " + (int)(hydrocarbon1.getMyC()) + "CO2");

            if(hydrocarbon1.getMyC() == 1.0)
            {
                equation.add(hydrocarbon1.getMyFormula() + " + " + " " + (int)(0.5 + (1.5 * hydrocarbon1.getMyC())) + "O2" + " --> " + ((int)hydrocarbon1.getMyC() +1) + "H2O" + " + "  + "CO2");

            }
        }
        // Alkenes with even numbers of carbons
        if(hydrocarbon1.getMyType() == 2 && ((hydrocarbon1.getMyC() % 2) == 0 ))
        {
            equation.add(hydrocarbon1.getMyFormula() + " + " + " " + (int)((1.5 * hydrocarbon1.getMyC())) + "O2" + " --> " + ((int)hydrocarbon1.getMyC())  + "H2O" + " + " + (int)(hydrocarbon1.getMyC()) + "CO2");

        }
        // Alkenes with odd numbers of carbons
        if(hydrocarbon1.getMyType() == 2 && ((hydrocarbon1.getMyC() % 2) != 0 ))
        {
            equation.add("2" + hydrocarbon1.getMyFormula() + " + " + " " + (int)((3 * hydrocarbon1.getMyC())) + "O2" + " --> " + ((int)hydrocarbon1.getMyC() * 2)  + "H2O" + " + " + (int)(hydrocarbon1.getMyC() * 2) + "CO2");

        }
        // Alkynes with even numbers of carbons
        if(hydrocarbon1.getMyType() == 3 && ((hydrocarbon1.getMyC() % 2) == 0 ))
        {
            equation.add("2" + hydrocarbon1.getMyFormula() + " + " + " " + (int)((3 * hydrocarbon1.getMyC())-1) + "O2" + " --> " + ((int) (2* hydrocarbon1.getMyC())-2)  + "H2O" + " + " + (int)(2 * hydrocarbon1.getMyC()) + "CO2");

        }
        // Alkynes with odd numbers of carbons
        if(hydrocarbon1.getMyType() == 3 && ((hydrocarbon1.getMyC() % 2) != 0 ))
        {
            equation.add(hydrocarbon1.getMyFormula() + " + " + " " + (int)((1.5 * hydrocarbon1.getMyC())-0.5) + "O2" + " --> " + ((int)(hydrocarbon1.getMyC() - 1))  + "H2O" + " + " + (int)(hydrocarbon1.getMyC()) + "CO2");

        }

        for(int x = 0 ; x < equation.size(); x++)
        {

            fin = equation.get(equation.size() - 1);
        }



        if(!fin.equals(" "))
        {
            finalResult = fin;
            //System.out.println(fin);
            //JOptionPane.showMessageDialog(null, fin, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
