package doublereplacement;
import java.util.ArrayList;

import element.Element;


public class DoubleRep
{
    // Note: "elementName-symbol-charge-reactivity "
    private static	String cations[] = { /*"hydrogen(1+)|H|1|4" , */ "Li - Lithium(1+)|Li|1|1" , "Na - Sodium(1+)|Na|1|1"	, "K - Potassium(1+)|K|1|1"	, "Cs - Cesium(1+)|Cs|1|1"	, "Rb - Rubidium(1+)|Rb|1|1"	,

            "Be - Beryllium(2+)|Be|2|1" , "Ca - Calcium(2+)|Ca|2|1" , "Ba - Barium(2+)|Ba|2|1" , "Mg - Magnesium(2+)|Mg|2|1" , "Sr - Strontium(2+)|Sr|2|1" , "Zn - Zinc(2+)|Zn|2|1" , "Cd - Cadmium(2+)|Cd|2|1" ,

            "Al - Aluminum(3+)|Al|3|1" , "Ga - Gallium(3+)|Ga|3|1" ,



//Transition metals

            "Pb - Lead(2+)|Pb|2|1" , "Pb - Lead(4+)|Pb|4|1" ,
            "Cu - Copper(1+)|Cu|1|1" ,  "Cu - Copper(2+)|Cu|2|1" ,
            "Fe - Iron(2+)|Fe|2|1" ,  "Fe - Iron(3+)|Fe|3|1",
            "Cr - Chromium(2+)|Cr|2|1" ,  "Cr - Chromium(3+)|Cr|3|1" ,
            "Au - Gold(1+)|Au|1|1" ,  "Au - Gold(3+)|Au|3|1" ,
            "Ni - Nickel(2+)|Ni|2|1" ,  "Ni - Nickel(3+)|Ni|3|1"
    };

    private static	String anions[] = { "Cl - Chlorine(1-)|Cl|1|3" , "Br - Bromine(1-)|Br|1|3", "F - Fluorine(1-)|F|1|3", "I - Iodine(1-)|I|1|3", "O - Oxygen(2-)|O|2|3" , "S - Sulfur(2-)|S|2|0" ,
            "Se - Selenium(2-)|Se|2|0" , "N - Nitrogen(3-)|N|3|3" , "P - Phosphorus(3-)|P|3|0" , "NO3 - Nitrate(1-)|(NO3)|1|0",
            "NO2 - Nitrite(1-)|(NO2)|1|0" ,"C2H3O2 - Acetate(1-)|(C2H3O2)|1|0", "OH - Hydroxide(1-)|(OH)|1|3", "CO3 - Carbonate(2-)|(CO3)|2|0",
            "CrO4 - Chromate(2-)|(CrO4)|2|0", "Cr2O7 - Dichromate(2-)|(Cr2O7)|2|0", "SO4 - Sulfate(2-)|(SO4)|2|0" , "SO3 - Sulfite(2-)|(SO3)|2|0" ,
            "PO4 - Phosphate(3-)|(PO4)|3|0" , "PO3 - Phosphite(3-)|(PO3)|3|0"
    };


   private static Element element1 = null;
    private static Element element2 = null;
   private static Element element3 = null;
    private static Element element4 = null;


    private static String element[] = new String[cations.length];

    private static String elements[] = new String[anions.length];

    private static String fin = " ";

    public static void startDoubleRep(String inputValue, String inputValue2, String inputValue3, String inputValue4)
    {
        check(inputValue, inputValue2, inputValue3, inputValue4);
        DoubleReplacement();
    }

    public static String[] shortenCations()
    {
        //Sets d and element3 with shortened version of cations and anions
        //Ex: hydrogen-H-1-4 -> hydrogen
        for(int x = 0; x < element.length; x++)
        {
            element[x] = cations[x].substring(0, cations[x].indexOf("|"));
        }
        return element;
    }

    public static String[] shortenAnions()
    {
        for(int x = 0; x < elements.length; x++)
        {
            elements[x] = anions[x].substring(0, anions[x].indexOf("|"));
        }

        return elements;

    }

    public static String getResult()
    {
        return fin;
    }

    public static void check(String inputValue,String inputValue2,String inputValue3,String inputValue4)
    {

        /*
        //JOptionPane for synthesis, gives options.
        String inputValue = (String) JOptionPane.showInputDialog(null, "Enter Cation of Compound 1: (ex: potassium)",
                "Chemistry Calculator",
                JOptionPane.PLAIN_MESSAGE,
                null, d, "");

        String inputValue2 = (String) JOptionPane.showInputDialog(null, "Enter Anion of Compound1: (ex: iodine)",
                "Chemistry Calculator",
                JOptionPane.PLAIN_MESSAGE,
                null, elements, "");

        String inputValue3 = (String) JOptionPane.showInputDialog(null, "Enter Cation of Compound 2: (ex: sodium)",
                "Chemistry Calculator",
                JOptionPane.PLAIN_MESSAGE,
                null, d, "");

        String inputValue4 = (String) JOptionPane.showInputDialog(null, "Enter Anion of Compound 2: (ex: chlorine)",
                "Chemistry Calculator",
                JOptionPane.PLAIN_MESSAGE,
                null, elements, "");

*/

        //Instantiates element1, element2, , element3, and d 4 with user selected elements
        for(int y = 0; y < element.length; y++){
            if(inputValue.equals(element[y]))
            {
                int[] location = new int[3];
                String value = "|";
                int index = cations[y].indexOf(value);
                int x = 0;
                while(index >= 0 && x < location.length )
                {
                    location[x] = index;
                    x++;
                    index = cations[y].indexOf(value, index + 1);
                }
                int charge = Integer.parseInt(cations[y].substring(location[1] + 1 , location[2]));
                int ionization = Integer.parseInt(cations[y].substring(location[2] + 1 , cations[y].length()));
                String symbol = cations[y].substring(location[0] + 1, location[1]);
                element1 = new Element(symbol , charge , ionization);
                break;
            }
        }

        for(int y = 0; y < elements.length; y++){
            if(inputValue2.equals(elements[y]))
            {
                int[] location = new int[3];
                String value = "|";
                int index = anions[y].indexOf(value);
                int x = 0;
                while(index >= 0 && x < location.length )
                {
                    location[x] = index;
                    x++;
                    index = anions[y].indexOf(value, index + 1);
                }
                int charge = Integer.parseInt(anions[y].substring(location[1] + 1 , location[2]));
                int ionization = Integer.parseInt(anions[y].substring(location[2] + 1 , anions[y].length()));
                String symbol = anions[y].substring(location[0] + 1, location[1]);
                element2 = new Element( symbol , charge , ionization);
                break;


            }
        }

        for(int y = 0; y < element.length; y++){
            if(inputValue3.equals(element[y]))
            {
                int[] location = new int[3];
                String value = "|";
                int index = cations[y].indexOf(value);
                int x = 0;
                while(index >= 0 && x < location.length )
                {
                    location[x] = index;
                    x++;
                    index = cations[y].indexOf(value, index + 1);
                }
                int charge = Integer.parseInt(cations[y].substring(location[1] + 1 , location[2]));
                int ionization = Integer.parseInt(cations[y].substring(location[2] + 1 , cations[y].length()));
                String symbol = cations[y].substring(location[0] + 1, location[1]);
                element3 = new Element(symbol , charge , ionization);
                break;
            }
        }

        for(int y = 0; y < elements.length; y++){
            if(inputValue4.equals(elements[y]))
            {
                int[] location = new int[3];
                String value = "|";
                int index = anions[y].indexOf(value);
                int x = 0;
                while(index >= 0 && x < location.length )
                {
                    location[x] = index;
                    x++;
                    index = anions[y].indexOf(value, index + 1);
                }
                int charge = Integer.parseInt(anions[y].substring(location[1] + 1 , location[2]));
                int ionization = Integer.parseInt(anions[y].substring(location[2] + 1 , anions[y].length()));
                String symbol = anions[y].substring(location[0] + 1, location[1]);
                element4 = new Element( symbol , charge , ionization);
                break;


            }
        }
    }


    public static String one(int x)
    {
        if( x != 1)
        {
            return ""+x ;
        }
        else
        {
            return "";
        }
    }

    public static void DoubleReplacement()
    {



        // 1-1
        ArrayList<String> equations = new ArrayList<String>();


        if(element1.getCharge() ==1 && element2.getCharge() == 1)
        {
            fin =	(  one(element3.getCharge() * element4.getCharge())) + element1.getName() + element2.getName() + " + " + (element3.getName()) + one(element4.getCharge()) + element4.getName() + one(element3.getCharge()) + " --> "
                    +  one(element3.getCharge()) + element1.getName() + one(element4.getCharge()) + element4.getName() + " + "  + one(element4.getCharge()) + element3.getName() + element2.getName() + one(element3.getCharge());
            if(element3.getCharge() == 4 && element4.getCharge()==2)
            {
                fin = 4+element1.getName() + element2.getName() + " + " + element3.getName() + element4.getName() + 2 + " --> " + 2 + element1.getName() + 2+element4.getName() + " + " + element3.getName() + element2.getName() + 4;
            }
            if(element3.getCharge() == 2 && element4.getCharge() ==2)
            {
                fin = 2 + element1.getName() + element2.getName() + " + " + element3.getName() + element4.getName()  + " -->"
                        +  element1.getName() + 2 + element4.getName() +" + " + element3.getName() + element2.getName() + 2;
            }
            if(element3.getCharge() == 3 && element4.getCharge() ==3)
            {
                fin = 3 + element1.getName() + element2.getName() + " + " + element3.getName() + element4.getName()  + " -->"
                        +  element1.getName() + 3 + element4.getName() +" + " + element3.getName() + element2.getName() +3;
            }

        }
        // 1-2
        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 1 && element4.getCharge() == 1)
            {
                fin = (element1.getName() + 2 + element2.getName() + " + " + 2 + element3.getName() + element4.getName() + " --> "
                        +2 + element1.getName() + element4.getName() + " + " + element3.getName() + 2 + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 1 && element4.getCharge() == 2)
            {
                fin = (element1.getName() + 2 + element2.getName() + " + " +  element3.getName() + 2 + element4.getName() + " --> "
                        + element1.getName() + 2 + element4.getName() + " + " + element3.getName() + 2 + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 1 && element4.getCharge() == 3)
            {
                fin = (3+element1.getName() + 2 + element2.getName() + " + " + 2 + element3.getName() +3+ element4.getName() + " --> "
                        +2 + element1.getName() +3+ element4.getName() + " + " + 3+element3.getName() + 2 + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 2 && element4.getCharge() == 1)
            {
                fin = (element1.getName() + 2 + element2.getName() + " + " + element3.getName() + element4.getName() + 2+ " --> "
                        +2 + element1.getName() + element4.getName() + " + " + element3.getName()  + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 2 && element4.getCharge() == 2)
            {
                fin = (element1.getName() + 2 + element2.getName() + " + " + element3.getName() + element4.getName() + " --> "
                        + element1.getName() + 2+ element4.getName() + " + " + element3.getName()  + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 2 && element4.getCharge() == 3)
            {
                fin = (3 + element1.getName() + 2 + element2.getName() + " + " + element3.getName() + 3 + element4.getName() + 2+ " --> "
                        +2 + element1.getName() +3+ element4.getName() + " + " + 3 + element3.getName()  + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 3 && element4.getCharge() == 1)
            {
                fin = (3+element1.getName() + 2 + element2.getName() + " + " + 2+element3.getName() + element4.getName() + 3+ " --> "
                        +6 + element1.getName() + element4.getName() + " + " + element3.getName() +2 + element2.getName() + 3 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 3 && element4.getCharge() == 2)
            {
                fin = (3+element1.getName() + 2 + element2.getName() + " + " + element3.getName() +2 + element4.getName() +3+ " --> "
                        +3+ element1.getName() +2+ element4.getName() + " + " + element3.getName() +2 + element2.getName()+3 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 3 && element4.getCharge() == 3)
            {
                fin = (3+element1.getName() + 2 + element2.getName() + " + " + 2+ element3.getName() + element4.getName() +  " --> "
                        +2 + element1.getName() +3+ element4.getName() + " + " + element3.getName() +2 + element2.getName() +3 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 4 && element4.getCharge() == 1)
            {
                fin = (2+element1.getName() + 2 + element2.getName() + " + " + element3.getName() + element4.getName() + 4+ " --> "
                        +4 + element1.getName() + element4.getName() + " + " + element3.getName()  + element2.getName() +2 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 4 && element4.getCharge() == 2)
            {
                fin = (2+element1.getName() + 2 + element2.getName() + " + " + element3.getName() + element4.getName() +2+ " --> "
                        +2 + element1.getName() +2+ element4.getName() + " + " + element3.getName()  + element2.getName() +2 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 4 && element4.getCharge() == 3)
            {
                fin = (6+element1.getName() + 2 + element2.getName() + " + " + element3.getName() +3+ element4.getName() + 4+ " --> "
                        +4 + element1.getName() +3+ element4.getName() + " + " + 3+ element3.getName()  + element2.getName()+2 );
            }
        }


        //1-3



        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 1 && element4.getCharge() == 1)
            {
                fin = (element1.getName() + 3 + element2.getName() + " + " + 3+element3.getName() + element4.getName() + " --> "
                        + 3+element1.getName() + element4.getName() + " + " + element3.getName() + 3 + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 1 && element4.getCharge() == 2)
            {
                fin = (2+element1.getName() + 3 + element2.getName() + " + " + 3+ element3.getName() + 2 + element4.getName() + " --> "
                        +3+ element1.getName() + 2 + element4.getName() + " + " +2+ element3.getName() + 3 + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 1 && element4.getCharge() == 3)
            {
                fin = (element1.getName() + 3 + element2.getName() + " + " +  element3.getName() +3+ element4.getName() + " --> "
                        + element1.getName() +3+ element4.getName() + " + " + element3.getName() + 3 + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 2 && element4.getCharge() == 1)
            {
                fin = (2+element1.getName() + 3 + element2.getName() + " + " +3+ element3.getName() + element4.getName() + 2+ " --> "
                        +6 + element1.getName() + element4.getName() + " + " + element3.getName()  +3+ element2.getName() +2 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 2 && element4.getCharge() == 2)
            {
                fin = (2+element1.getName() + 3 + element2.getName() + " + " + 3+element3.getName() + element4.getName() + " --> "
                        + 3+element1.getName() + 2+ element4.getName() + " + " + element3.getName() +3 + element2.getName() +2 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 2 && element4.getCharge() == 3)
            {
                fin = (2 + element1.getName() + 3 + element2.getName() + " + " + element3.getName() + 3 + element4.getName() + 2+ " --> "
                        +2 + element1.getName() +3+ element4.getName() + " + "  + element3.getName() +3 + element2.getName() +2 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 3 && element4.getCharge() == 1)
            {
                fin = (element1.getName() + 3 + element2.getName() + " + " + element3.getName() + element4.getName() + 3+ " --> "
                        +3 + element1.getName() + element4.getName() + " + " + element3.getName() + element2.getName()  );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 3 && element4.getCharge() == 2)
            {
                fin = (2+element1.getName() + 3 + element2.getName() + " + " + element3.getName() +2 + element4.getName() +3+ " --> "
                        +3+ element1.getName() +2+ element4.getName() + " + " + 2+element3.getName()  + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 3 && element4.getCharge() == 3)
            {
                fin = (element1.getName() + 3 + element2.getName() + " + " +  element3.getName() + element4.getName() +  " --> "
                        + element1.getName() +3+ element4.getName() + " + " +  element3.getName()  + element2.getName() );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 4 && element4.getCharge() == 1)
            {
                fin = (4+element1.getName() + 3 + element2.getName() + " + " +3+ element3.getName() + element4.getName() + 4 + " --> "
                        +12 + element1.getName() + element4.getName() + " + " + element3.getName() +3 + element2.getName() +4 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 4 && element4.getCharge() == 2)
            {
                fin = (4+element1.getName() + 3 + element2.getName() + " + " + 3+ element3.getName() + element4.getName() +2+ " --> "
                        +6 + element1.getName() +2+ element4.getName() + " + " + element3.getName() +3+  element2.getName() +4 );
            }
        }

        if(element1.getCharge() == 1 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 4 && element4.getCharge() == 3)
            {
                fin = (4+element1.getName() + 3 + element2.getName() + " + " + element3.getName() +3+ element4.getName() + 4+ " --> "
                        +4 + element1.getName() +3+ element4.getName() + " + " + element3.getName() +3 + element2.getName()+4 );
            }
        }

        // 2-1
        if(element1.getCharge() == 2 && element2.getCharge() ==1)
        {
            if(element3.getCharge() == 1 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName() +2+ " + " + 2 + element3.getName() + element4.getName() + " --> "
                        + element1.getName() + element4.getName() + 2 + " + " +2+ element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==2)
            {
                fin = element1.getName() + element2.getName() +2+ " + " +  element3.getName()+2 + element4.getName() + " --> "
                        + element1.getName() + element4.getName() +  " + " +2+ element3.getName()  + element2.getName();

            }

            if(element3.getCharge() == 1 && element4.getCharge() ==3)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " + 2 + element3.getName()+3 + element4.getName() + " --> "
                        + element1.getName() +3+ element4.getName() + 2 + " + " +6+ element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName() +2+ " + " + element3.getName() + element4.getName() +2+ " --> "
                        + element1.getName() + element4.getName() + 2 + " + " + element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==2)
            {
                fin = element1.getName() + element2.getName() +2+ " + " + element3.getName() + element4.getName() + " --> "
                        + element1.getName() + element4.getName()  + " + " + element3.getName()  + element2.getName() +2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==3)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " + element3.getName() +3+ element4.getName() +2+ " --> "
                        + element1.getName() +3+ element4.getName() + 2 + " + " + 3+element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==1)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " + 2+element3.getName() + element4.getName() +3+ " --> "
                        +3+ element1.getName() + element4.getName() + 2 + " + " +2+ element3.getName() + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==2)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " + element3.getName() +2+ element4.getName() +3+ " --> "
                        +3+ element1.getName() + element4.getName() +  " + " +2+ element3.getName() + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==3)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " +2+ element3.getName() + element4.getName() + " --> "
                        + element1.getName()+3 + element4.getName()+2 +  " + " +2+ element3.getName() + element2.getName()+3;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==1)
            {
                fin = 2+element1.getName() + element2.getName() +2+ " + " + element3.getName() + element4.getName() +4+ " --> "
                        +2+ element1.getName() + element4.getName()+2 +  " + " + element3.getName() + element2.getName()+4;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==2)
            {
                fin = 2+element1.getName() + element2.getName() +2+ " + " + element3.getName() + element4.getName() +2+ " --> "
                        +2+ element1.getName() + element4.getName() +  " + " + element3.getName() + element2.getName()+4;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==3)
            {
                fin = 6+element1.getName() + element2.getName() +2+ " + " + element3.getName()+3 + element4.getName() +4+ " --> "
                        +2+ element1.getName()+3 + element4.getName() +2+  " + " + 3+element3.getName() + element2.getName()+4;

            }

        }


        //2-2
        if(element1.getCharge() == 2 && element2.getCharge() ==2)
        {
            if(element3.getCharge() == 1 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName() + " + " + 2 + element3.getName() + element4.getName() + " --> "
                        + element1.getName() + element4.getName() + 2 + " + " + element3.getName() + 2 + element2.getName();

            }

            if(element3.getCharge() == 1 && element4.getCharge() ==2)
            {
                fin = element1.getName() + element2.getName() + " + " +  element3.getName() +2+ element4.getName() + " --> "
                        + element1.getName() + element4.getName() + " + " + element3.getName() + 2 + element2.getName();

            }

            if(element3.getCharge() == 1 && element4.getCharge() ==3)
            {
                fin = 3+element1.getName() + element2.getName() + " + " + 2+ element3.getName() +3+ element4.getName() + " --> "
                        + element1.getName() +3+ element4.getName() +2+ " + " + 3+element3.getName() + 2 + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName() + " + " +element3.getName() + element4.getName() +2+ " --> "
                        + element1.getName() + element4.getName() +2+ " + " +element3.getName() +  element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==2)
            {
                fin = element1.getName() + element2.getName() + " + " +element3.getName() + element4.getName() + " --> "
                        + element1.getName() + element4.getName() + " + " +element3.getName() +  element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==3)
            {
                fin = 3+element1.getName() + element2.getName() + " + " +element3.getName() +3 + element4.getName() + 2+" --> "
                        + element1.getName() +3+ element4.getName()+2 + " + " +3+element3.getName() +  element2.getName();

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==1)
            {
                fin = 3+element1.getName() + element2.getName() + " + " +2+element3.getName()  + element4.getName() + 3+" --> "
                        + 3+element1.getName() + element4.getName()+2 + " + " +element3.getName()+2 +  element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==2)
            {
                fin = 3+element1.getName() + element2.getName() + " + " +element3.getName() +2 + element4.getName() + 3+" --> "
                        + 3+element1.getName() + element4.getName() + " + " +element3.getName()+2 +  element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==3)
            {
                fin = 3+element1.getName() + element2.getName() + " + " +2+element3.getName()  + element4.getName() + " --> "
                        + element1.getName()+3 + element4.getName()+2 + " + " +element3.getName()+2 +  element2.getName()+3;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==1)
            {
                fin = 2+element1.getName() + element2.getName() + " + " +element3.getName()  + element4.getName() + 4+" --> "
                        + 2+element1.getName() + element4.getName() +2+ " + " +element3.getName() +  element2.getName()+2;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==2)
            {
                fin = 2+element1.getName() + element2.getName() + " + " +element3.getName()  + element4.getName() + 2+" --> "
                        + 2+element1.getName() + element4.getName() + " + " +element3.getName() +  element2.getName()+2;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==3)
            {
                fin = 6+element1.getName() + element2.getName() + " + " +element3.getName()+3  + element4.getName() + 4+" --> "
                        + 2+element1.getName() +3+ element4.getName()+2 + " + " + 3+element3.getName() +  element2.getName()+2;

            }
        }

        //2-3
        if(element1.getCharge() == 2 && element2.getCharge() ==3)
        {
            if(element3.getCharge() == 1 && element4.getCharge() ==1)
            {
                fin = element1.getName() +3+ element2.getName()+2 + " + " + 6 + element3.getName() + element4.getName() + " --> "
                        + 3+element1.getName() + element4.getName() + 2 + " + " +2+ element3.getName() + 3 + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==2)
            {
                fin = element1.getName() +3+ element2.getName()+2 + " + " + 3 + element3.getName() +2+ element4.getName() + " --> "
                        + 3+element1.getName() + element4.getName() +  " + " +2+ element3.getName() + 3 + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==3)
            {
                fin = element1.getName() +3+ element2.getName()+2 + " + " + 2 + element3.getName() +3+ element4.getName() + " --> "
                        + element1.getName()+3 + element4.getName()+2 +  " + " +2+ element3.getName() + 3 + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==1)
            {
                fin = element1.getName() +3+ element2.getName()+2 + " + " + 3 + element3.getName() + element4.getName() +2+ " --> "
                        + 3+element1.getName() + element4.getName()+2 +  " + " + element3.getName() + 3 + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==2)
            {
                fin = element1.getName() +3+ element2.getName()+2 + " + " + 3 + element3.getName() + element4.getName() + " --> "
                        + 3+element1.getName() + element4.getName() +  " + " + element3.getName() + 3 + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==3)
            {
                fin = element1.getName() +3+ element2.getName()+2 + " + " + element3.getName() +3+ element4.getName() +2+ " --> "
                        + element1.getName() +3+ element4.getName()+2 +  " + " + element3.getName() + 3 + element2.getName()+2;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==1)
            {
                fin = element1.getName() +3+ element2.getName()+2 + " + " + 2 + element3.getName() + element4.getName() +3+ " --> "
                        + 3+element1.getName() + element4.getName()+2 +  " + " +2+ element3.getName() +  element2.getName();

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==2)
            {
                fin = element1.getName() +3+ element2.getName()+2 + " + " +  element3.getName()+2 + element4.getName() +3+ " --> "
                        + 3+element1.getName() + element4.getName() +  " + " +2+ element3.getName() +  element2.getName();

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==3)
            {
                fin = element1.getName() +3+ element2.getName()+2 + " + " +  2+element3.getName() + element4.getName() + " --> "
                        + element1.getName() +3+ element4.getName() +2+  " + " +2+ element3.getName() +  element2.getName();

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==1)
            {
                fin = 2+element1.getName() +3+ element2.getName()+2 + " + " +  3+element3.getName() + element4.getName() +4+ " --> "
                        + 6+element1.getName() + element4.getName() +2+  " + " + element3.getName() +3+  element2.getName()+4;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==2)
            {
                fin = 2+element1.getName() +3+ element2.getName()+2 + " + " +  3+element3.getName() + element4.getName() +2+ " --> "
                        + 6+element1.getName() + element4.getName() +  " + " + element3.getName() +3+  element2.getName()+4;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==3)
            {
                fin = 2+element1.getName() +3+ element2.getName()+2 + " + " +  element3.getName()+3 + element4.getName() +4+ " --> "
                        + 2+element1.getName()+3 + element4.getName() +2+  " + " + element3.getName() +3+  element2.getName()+4;

            }
        }
        //3-1
        if(element1.getCharge() == 3 && element2.getCharge() ==1)
        {
            if(element3.getCharge() == 1 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName()+3 + " + " + 3 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() + element4.getName() + 3 + " + " +3+ element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==2)
            {
                fin = 2+element1.getName() + element2.getName()+3 + " + " + 3 + element3.getName() + 2+element4.getName() + " --> "
                        +element1.getName() +2+ element4.getName() + 3 + " + " +6+ element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==3)
            {
                fin = element1.getName() + element2.getName()+3 + " + "  + element3.getName() + 3+element4.getName() + " --> "
                        +element1.getName() + element4.getName() +  " + " +3+ element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==1)
            {
                fin = 2+element1.getName() + element2.getName()+3 + " + "  +3+ element3.getName() +element4.getName() +2+ " --> "
                        +2+element1.getName() + element4.getName()+3 +  " + " +3+ element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==2)
            {
                fin = 2+element1.getName() + element2.getName()+3 + " + "  +3+ element3.getName() +element4.getName() + " --> "
                        +element1.getName() +2+ element4.getName()+3 +  " + " +3+ element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==3)
            {
                fin = 2+element1.getName() + element2.getName()+3 + " + "  + element3.getName()+3 +element4.getName()+2 + " --> "
                        +2+element1.getName() + element4.getName() +  " + " +3+ element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName()+3 + " + "  + element3.getName() +element4.getName()+3 + " --> "
                        +element1.getName() + element4.getName()+3 +  " + " + element3.getName()  + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==2)
            {
                fin = 2+element1.getName() + element2.getName()+3 + " + "  + element3.getName()+2 +element4.getName()+3 + " --> "
                        +element1.getName()+2 + element4.getName()+3 +  " + " +2+ element3.getName()  + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==3)
            {
                fin = element1.getName() + element2.getName()+3 + " + "  + element3.getName() +element4.getName() + " --> "
                        +element1.getName() + element4.getName() +  " + " + element3.getName()  + element2.getName()+3;

            }
            if(element3.getCharge() ==4 && element4.getCharge() ==1)
            {
                fin = 4+element1.getName() + element2.getName()+3 + " + "  + 3+element3.getName() +element4.getName()+4 + " --> "
                        +4+element1.getName() + element4.getName()+3 +  " + " + 3+element3.getName()  + element2.getName()+4;

            }
            if(element3.getCharge() ==4 && element4.getCharge() ==2)
            {
                fin = 4+element1.getName() + element2.getName()+3 + " + "  + 3+element3.getName() +element4.getName()+2 + " --> "
                        +2+element1.getName() +2+ element4.getName()+3 +  " + " + 3+element3.getName()  + element2.getName()+4;

            }
            if(element3.getCharge() ==4 && element4.getCharge() ==3)
            {
                fin = 4+element1.getName() + element2.getName()+3 + " + "  + element3.getName() +3+element4.getName()+4 + " --> "
                        +4+element1.getName() + element4.getName()+  " + " + 3+element3.getName()  + element2.getName()+4;

            }


        }
        //3-2
        if(element1.getCharge() == 3 && element2.getCharge() ==2)
        {
            if(element3.getCharge() == 1 && element4.getCharge() ==1)
            {
                fin = element1.getName() +2+ element2.getName()+3 + " + " + 6 + element3.getName() + element4.getName() + " --> "
                        +2+element1.getName() + element4.getName() + 3 + " + " +3+ element3.getName() +2 + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==2)
            {
                fin = element1.getName() +2+ element2.getName()+3 + " + " + 3 + element3.getName() +2+ element4.getName() + " --> "
                        +element1.getName()+2 + element4.getName() + 3 + " + " +3+ element3.getName() +2 + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==3)
            {
                fin = element1.getName() +2+ element2.getName()+3 + " + " +2 + element3.getName() +3+ element4.getName() + " --> "
                        +2+element1.getName() + element4.getName() + " + " +3+ element3.getName() +2 + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==1)
            {
                fin = element1.getName() +2+ element2.getName()+3 + " + " +3 + element3.getName() + element4.getName() +2+ " --> "
                        +2+element1.getName() + element4.getName()+3 + " + " +3+ element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==2)
            {
                fin = element1.getName() +2+ element2.getName()+3 + " + " +3 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() +2+ element4.getName()+3 + " + " +3+ element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==3)
            {
                fin = element1.getName() +2+ element2.getName()+3 + " + "  + element3.getName()+3 + element4.getName()+2 + " --> "
                        +2+element1.getName() + element4.getName() + " + " +3+ element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==1)
            {
                fin = element1.getName() +2+ element2.getName()+3 + " + "  + 2+element3.getName() + element4.getName()+3 + " --> "
                        +2+element1.getName() + element4.getName()+3 + " + " + element3.getName() +2 + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==2)
            {
                fin = element1.getName() +2+ element2.getName()+3 + " + "  + element3.getName() +2+ element4.getName()+3 + " --> "
                        +element1.getName() +2+ element4.getName()+3 + " + " + element3.getName() +2 + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==3)
            {
                fin = element1.getName() +2+ element2.getName()+3 + " + "  + 2+element3.getName() + element4.getName() + " --> "
                        +2+element1.getName() + element4.getName() + " + " + element3.getName() +2 + element2.getName()+3;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==1)
            {
                fin = 2+element1.getName() +2+ element2.getName()+3 + " + "  + 3+element3.getName() + element4.getName()+4 + " --> "
                        +4+element1.getName() + element4.getName()+3 + " + " + 3+element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==2)
            {
                fin = 2+element1.getName() +2+ element2.getName()+3 + " + "  + 3+element3.getName() + element4.getName()+2 + " --> "
                        +2+element1.getName() +2+ element4.getName()+3 + " + " + 3+element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==3)
            {
                fin = 2+element1.getName() +2+ element2.getName()+3 + " + "  + element3.getName()+3 + element4.getName()+4 + " --> "
                        +4+element1.getName() + element4.getName() + " + " + 3+element3.getName()  + element2.getName()+2;

            }


        }


        //3-3

        if(element1.getCharge() == 3 && element2.getCharge() ==3)
        {
            if(element3.getCharge() == 1 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName() + " + " + 3 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() + element4.getName() + 3 + " + " + element3.getName() +3 + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==2)
            {
                fin =2+ element1.getName() + element2.getName() + " + " + 3 + element3.getName()+2 + element4.getName() + " --> "
                        +element1.getName() +2+ element4.getName() + 3 + " + " +2+ element3.getName() +3 + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==3)
            {
                fin = element1.getName() + element2.getName() + " + " + element3.getName() +3+ element4.getName() + " --> "
                        +element1.getName() + element4.getName() + " + " + element3.getName() +3 + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==1)
            {
                fin = 2+element1.getName() + element2.getName() + " + " + 3 + element3.getName() + element4.getName() +2+ " --> "
                        +2+element1.getName() + element4.getName() + 3 + " + " + element3.getName() +3 + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==2)
            {
                fin = 2+element1.getName() + element2.getName() + " + " + 3 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() +2+ element4.getName() + 3 + " + " + element3.getName() +3 + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==3)
            {
                fin = 2+element1.getName() + element2.getName() + " + " +  element3.getName() +3+ element4.getName() +2+ " --> "
                        +2+element1.getName() + element4.getName()  + " + " + element3.getName() +3 + element2.getName()+2;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName() + " + " +  element3.getName() + element4.getName() +3+ " --> "
                        +element1.getName() + element4.getName() + 3 + " + " + element3.getName() + element2.getName();

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==2)
            {
                fin = 2+element1.getName() + element2.getName() + " + " +  element3.getName() +2+ element4.getName() +3+ " --> "
                        +element1.getName() + 2+element4.getName() + 3 + " + " + 2+element3.getName() + element2.getName();

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==3)
            {
                fin = element1.getName() + element2.getName() + " + " +  element3.getName() + element4.getName() + " --> "
                        +element1.getName() + element4.getName()  + " + " + element3.getName() + element2.getName();

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==1)
            {
                fin = 4+element1.getName() + element2.getName() + " + " +  3+element3.getName() + element4.getName() +4+ " --> "
                        +4+element1.getName() + element4.getName() +3 + " + " + element3.getName() +3+ element2.getName()+4;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==2)
            {
                fin = 4+element1.getName() + element2.getName() + " + " +  3+element3.getName() + element4.getName() +2+ " --> "
                        +2+element1.getName() +2+ element4.getName() +3 + " + " + element3.getName() +3+ element2.getName()+4;

            }
            if(element3.getCharge() == 4 && element4.getCharge() ==3)
            {
                fin = 4+element1.getName() + element2.getName() + " + " +  element3.getName() +3+ element4.getName() +4+ " --> "
                        +4+element1.getName() + element4.getName()  + " + " + element3.getName() +3+ element2.getName()+4;

            }
        }
        //4-1
        if(element1.getCharge() == 4 && element2.getCharge() == 1)
        {
            if(element3.getCharge() == 1 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName() +4+ " + " + 4 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() + element4.getName() + 4 + " + " + 4+element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==2)
            {
                fin = element1.getName() + element2.getName() +4+ " + " + 2 + element3.getName() +2+ element4.getName() + " --> "
                        +element1.getName() + element4.getName() + 2 + " + " + 4+element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==3)
            {
                fin = 3+element1.getName() + element2.getName() +4+ " + " + 4 + element3.getName() +3+ element4.getName() + " --> "
                        +element1.getName() +3+ element4.getName() + 4 + " + " + 12+element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() == 1)
            {
                fin = element1.getName() + element2.getName() +4+ " + " + 2 + element3.getName() + element4.getName() + 2+" --> "
                        +element1.getName() + element4.getName() + 4 + " + " + 2+element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() == 2)
            {
                fin = element1.getName() + element2.getName() +4+ " + " + 2 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() + element4.getName() + 2 + " + " + 2+element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() == 3)
            {
                fin = 3+element1.getName() + element2.getName() +4+ " + " + 2 + element3.getName() +3+ element4.getName() +2+ " --> "
                        +element1.getName() +3+ element4.getName() + 4 + " + " + 6+element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 3 && element4.getCharge() == 1)
            {
                fin = 3+element1.getName() + element2.getName() +4+ " + " + 4 + element3.getName() + element4.getName() +3+ " --> "
                        +3+element1.getName() + element4.getName() + 4 + " + " + 4+element3.getName()  + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() == 2)
            {
                fin = 3+element1.getName() + element2.getName() +4+ " + " + 2 + element3.getName() +2+ element4.getName() +3+ " --> "
                        +3+element1.getName() + element4.getName() + 2 + " + " + 4+element3.getName()  + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() == 3)
            {
                fin = 3+element1.getName() + element2.getName() +4+ " + " + 4 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() +3+ element4.getName() + 4 + " + " + 4+element3.getName()  + element2.getName()+3;

            }
            if(element3.getCharge() == 4 && element4.getCharge() == 1)
            {
                fin = element1.getName() + element2.getName() +4+ " + " +  element3.getName() + element4.getName() +4+ " --> "
                        +element1.getName() + element4.getName() + 4 + " + " + element3.getName()  + element2.getName()+4;

            }
            if(element3.getCharge() == 4 && element4.getCharge() == 2)
            {
                fin = element1.getName() + element2.getName() +4+ " + " +  element3.getName() + element4.getName() +2+ " --> "
                        +element1.getName() + element4.getName() + 2 + " + " + element3.getName()  + element2.getName()+4;

            }
            if(element3.getCharge() == 4 && element4.getCharge() == 3)
            {
                fin = 3+element1.getName() + element2.getName() +4+ " + " +  element3.getName() + 3+element4.getName() +4+ " --> "
                        +element1.getName() + 3+element4.getName() + 4 + " + " +3+ element3.getName()  + element2.getName()+4;

            }





        }
        //4-2
        if(element1.getCharge() == 4 && element2.getCharge() == 2)
        {
            if(element3.getCharge() == 1 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName() +2+ " + " + 4 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() + element4.getName() + 4 + " + " +2+element3.getName()  +2+ element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==2)
            {
                fin = element1.getName() + element2.getName() +2+ " + " + 2 + element3.getName() +2+ element4.getName() + " --> "
                        +element1.getName() + element4.getName() + 2 + " + " +2+element3.getName()  +2+ element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==3)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " + 4 + element3.getName() +3+ element4.getName() + " --> "
                        +element1.getName() +3+ element4.getName() + 4 + " + " +6+element3.getName()  +2+ element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==1)
            {
                fin = element1.getName() + element2.getName() +2+ " + " + 2 + element3.getName() + element4.getName() +2+ " --> "
                        +element1.getName() + element4.getName() + 4 + " + " +2+element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() == 2)
            {
                fin = element1.getName() + element2.getName() +2+ " + " + 2 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() + element4.getName() + 2 + " + " +2+element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() == 3)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " + 2 + element3.getName() +3+ element4.getName() +2+ " --> "
                        +element1.getName()+3 + element4.getName() + 4 + " + " +6+element3.getName()  + element2.getName();

            }
            if(element3.getCharge() == 3 && element4.getCharge() == 1)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " + 4 + element3.getName() + element4.getName() +3+ " --> "
                        +3+element1.getName() + element4.getName() + 4 + " + " +2+element3.getName()+2  + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() == 2)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " +2 + element3.getName()+2 + element4.getName() +3+ " --> "
                        +3+element1.getName() + element4.getName() + 2 + " + " +2+element3.getName()+2  + element2.getName()+3;

            }
            if(element3.getCharge() == 3 && element4.getCharge() == 3)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + " +4 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() +3+ element4.getName() + 4 + " + " +2+element3.getName()+2  + element2.getName()+3;

            }
            if(element3.getCharge() == 4 && element4.getCharge() == 1)
            {
                fin =element1.getName() + element2.getName() +2+ " + "  + element3.getName() + element4.getName() +4+ " --> "
                        +element1.getName() + element4.getName() + 4 + " + " +element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 4 && element4.getCharge() == 2)
            {
                fin =element1.getName() + element2.getName() +2+ " + "  + element3.getName() + element4.getName() +2+ " --> "
                        +element1.getName() + element4.getName() + 2 + " + " +element3.getName()  + element2.getName()+2;

            }
            if(element3.getCharge() == 4 && element4.getCharge() == 3)
            {
                fin = 3+element1.getName() + element2.getName() +2+ " + "  + element3.getName() +3+ element4.getName() +4+ " --> "
                        +element1.getName() +3+ element4.getName() + 4 + " + " +3+element3.getName()  + element2.getName()+2;

            }
        }
        //4-3
        if(element1.getCharge() == 4 && element2.getCharge() == 3)
        {
            if(element3.getCharge() == 1 && element4.getCharge() ==1)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 12 + element3.getName() + element4.getName() + " --> "
                        +3+element1.getName() + element4.getName() + 4 + " + " + 4+element3.getName() +3 + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==2)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 6 + element3.getName() + 2+ element4.getName() + " --> "
                        +3+element1.getName() + element4.getName() + 2 + " + " + 4+element3.getName() +3 + element2.getName();

            }
            if(element3.getCharge() == 1 && element4.getCharge() ==3)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 4 + element3.getName() + 3+ element4.getName() + " --> "
                        +element1.getName() +3+ element4.getName() + 4 + " + " + 4+element3.getName() +3 + element2.getName();

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==1)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 6 + element3.getName() + element4.getName() + 2+" --> "
                        +3+element1.getName() + element4.getName() + 4 + " + " + 2+element3.getName() +3 + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==2)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 6 + element3.getName() + element4.getName() + " --> "
                        +3+element1.getName() + element4.getName() + 2 + " + " + 2+element3.getName() +3 + element2.getName()+2;

            }
            if(element3.getCharge() == 2 && element4.getCharge() ==3)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 2 + element3.getName() + 3+ element4.getName() +2+ " --> "
                        +element1.getName() +3+ element4.getName() + 4 + " + " + 2+element3.getName() +3 + element2.getName()+2;

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==1)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 4 + element3.getName() + element4.getName() +3+ " --> "
                        +3+element1.getName() + element4.getName() + 4 + " + " + 4+element3.getName() + element2.getName();

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==2)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 2 + element3.getName() +2+ element4.getName() +3+ " --> "
                        +3+element1.getName() + element4.getName() + 2 + " + " + 4+element3.getName() + element2.getName();

            }
            if(element3.getCharge() == 3 && element4.getCharge() ==3)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 4 + element3.getName() + element4.getName() + " --> "
                        +element1.getName() +3+ element4.getName() + 4 + " + " + 4+element3.getName() + element2.getName();

            }
            if(element3.getCharge() ==4 && element4.getCharge() ==1)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 3 + element3.getName() + element4.getName() +4+ " --> "
                        +3+element1.getName() + element4.getName() + 4 + " + " + element3.getName() +3+ element2.getName()+4;

            }
            if(element3.getCharge() ==4 && element4.getCharge() ==2)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " + 3 + element3.getName() + element4.getName() +2+ " --> "
                        +3+element1.getName() + element4.getName() + 2 + " + " + element3.getName() +3+ element2.getName()+4;

            }
            if(element3.getCharge() ==4 && element4.getCharge() ==3)
            {
                fin = element1.getName() +3+ element2.getName() +4+ " + " +  element3.getName()+3 + element4.getName() +4+ " --> "
                        +element1.getName()+3 + element4.getName() + 4 + " + " + element3.getName() +3+ element2.getName()+4;

            }



        }




        //end
        for(int x = 0 ; x < equations.size(); x++)
        {

            fin = equations.get(equations.size() - 1);
        }

        if(! fin.equals(" "))
        {
            /*
            System.out.println(fin);
            JOptionPane.showMessageDialog(null, fin, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);
            */
        }
    }












}