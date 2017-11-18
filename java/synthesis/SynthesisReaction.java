package synthesis;

import java.util.ArrayList;

import element.Element;

/**
 * Created by Ishaan and Matthew on 3/28/2017.
 *
 */

public class SynthesisReaction{

    private static String redoxResult;


    //Final
    public static String finalResult;

    //elements
    static Element element1 = null;
    static Element element2 = null;

// Note: "elementName-symbol-charge-ionization charge"
private static String cations[] = {"H - Hydrogen(1+)|H|1|4" ,  "Li - Lithium(1+)|Li|1|1" , "Na - Sodium(1+)|Na|1|1"	, "K - Potassium(1+)|K|1|1", "Cs - Cesium(1+)|Cs|1|1"	, "Rb - Rubidium(1+)|Rb|1|1"	,

        "Be - Beryllium(2+)|Be|2|1" , "Ca - Calcium(2+)|Ca|2|1" , "Ba - Barium(2+)|Ba|2|1" , "Mg - Magnesium(2+)|Mg|2|1" , "Sr - Strontium(2+)|Sr|2|1" , "Zn - Zinc(2+)|Zn|2|1" , "Cd - Cadmium(2+)|Cd|2|1" ,

        "Al - Aluminum(3+)|Al|3|1" , "Ga - Gallium(3+)|ga|3|1" , "In - Indium(3+)|In|3|1" , "Tl - Thallium(3+)|Tl|3|1"

        ,"C - Carbon(4+)|C|4|1",

//Transition metals

        "Pb - Lead(2+)|Pb|2|1" , "Pb - Lead(4+)|Pb|4|1" ,
        "Cu - Copper(1+)|Cu|1|1" ,  "Cu - Copper(2+)|Cu|2|1" ,
        "Fe - Iron(2+)|Fe|2|1" ,  "Fe - Iron(3+)|Fe|3|1",
        "Cr - Chromium(2+)|Cr|2|1" ,  "Cr - Chromium(3+)|Cr|3|1" ,
        "Au - Gold(1+)|Au|1|1" ,  "Au - Gold(3+)|Au|3|1" ,
        "Ni - Nickel(2+)|Ni|2|1" ,  "Ni - Nickel(3+)|Ni|3|1"


};

    private static String anions[] = { "Cl - Chlorine(1-)|Cl|1|3" , "Br - Bromine(1-)|Br|1|3", "F - Fluorine(1-)|F|1|3", "I - Iodine(1-)|I|1|3",

            "O - Oxygen(2-)|O|2|3" , "S - Sulfur(2-)|S|2|0" , "Se - Selenium(2-)|Se|2|0" ,
            "N - Nitrogen(3-)|N|3|3" , "P - Phosphorus(3-)|P|3|0"
    };


        //Shortened Version of Cations and Anions
        static String element[] = new String[cations.length];

        static String element3[] = new String[anions.length];


    //Methods-------------------------------------------------------------------------
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

    public static String[] shortenAnions() {
        for(int x = 0; x < element3.length; x++)
        {
            element3[x] = anions[x].substring(0, anions[x].indexOf("|"));
        }
        return element3;
    }

    public static String getRedoxResult()
    {
        return redoxResult;
    }

    public static void setRedoxResult(){ redoxResult = null;}

    //Database registry
    public static void check(String inputValue, String inputValue2)
    {

/*
    //JOptionPane for synthesis, gives options.
    String inputValue = (String) JOptionPane.showInputDialog(null, "Enter Element 1:(ex: sodium)",
            "Chemistry Calculator",
            JOptionPane.PLAIN_MESSAGE,
            null, d, "");

    String inputValue2 = (String) JOptionPane.showInputDialog(null, "Enter Element 2:(ex: chlorine)",
            "Chemistry Calculator",
            JOptionPane.PLAIN_MESSAGE,
            null, element3, "");
*/
    //Instantiates element1 and element2 with user selected elements
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
        String capitalizedSymbol = symbol.substring(0, 1).toUpperCase() + symbol.substring(1);
        element1 = new Element(capitalizedSymbol , charge , ionization);
        break;
    }
}

		for(int y = 0; y < element3.length; y++){
    if(inputValue2.equals(element3[y]))
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
        String capitalizedSymbol = symbol.substring(0, 1).toUpperCase() + symbol.substring(1);
        element2 = new Element( capitalizedSymbol , charge , ionization);
        break;
    }
}
}

    public static void synthesis()
    {
        ArrayList<String> equation = new ArrayList<String>();
        String fin = " ";
        //If both elements are cations with ion =1, reply with error since 2 cations can't be reacted.
        boolean state = true;
        if (element1.getIon() ==1 && element2.getIon() ==1)
        {
           //System.out.println("Error - Cannot synthesize two cations");
            state = false;
        }

        if (state == true)
        {
            if ( element2.getIon() != 3 && element1.getIon() != 3 && element2.getIon() != 4 && element1.getIon() != 4)
            {
                //If Equation DOES NOT match any criteria in if statements below, print out equations without changing anything.
                if (!((element1.getCharge() * element2.getCharge())/ element1.getCharge() == (element1.getCharge() * element2.getCharge())/ element2.getCharge()) || !((element1.getCharge() * element2.getCharge())/ element1.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element2.getCharge() > 1) || !((element2.getCharge() * element1.getCharge())/ element2.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element1.getCharge() > 1) )
                {
                    equation.add( (element2.getCharge() * element1.getCharge())/ element1.getCharge() +element1.getName() + " + " + (element1.getCharge() * element2.getCharge())/ element2.getCharge() +element2.getName() + " --> " + element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                            (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                }

                // This makes Products reduced - CaS instead of Ca2S2
                if (  ((element1.getCharge() * element2.getCharge())/ element1.getCharge() == (element1.getCharge() * element2.getCharge())/ element2.getCharge()))
                {
                    equation.add(element1.getName() + " + " + element2.getName() + " --> " + element1.getName() + element2.getName());
                }
                //If a subscript of one d = 1, prints out the product without the subscript since 1 is not needed as a subscript.
                if (  ((element1.getCharge() * element2.getCharge())/ element1.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element2.getCharge() > 1))
                {
                    equation.add( (element2.getCharge() * element1.getCharge())/ element1.getCharge()+element1.getName() + " + " + (element2.getCharge() * element1.getCharge())/element2.getCharge()+element2.getName() + " --> " + element1.getName() + element2.getName() + (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                }
                //If a subscript of OTHER d = 1, prints out the product without the subscript since 1 is not needed as a subscript.
                if (  ((element2.getCharge() * element1.getCharge())/ element2.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element1.getCharge() > 1))
                {
                    equation.add((element1.getCharge() * element2.getCharge())/ element1.getCharge()+element1.getName() + " + " + element2.getName() + " --> " + element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge() + element2.getName()  );
                }
                //if all divisible by 2
                if (  ((((element2.getCharge() * element1.getCharge())/ element2.getCharge())%2) == 0) && (((element1.getCharge() * element2.getCharge())/ element1.getCharge())%2) ==0 && element1.getCharge() != element2.getCharge())
                {
                    equation.add((((element1.getCharge() * element2.getCharge())/ element1.getCharge())/2)+element1.getName() + " + " + (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2)+element2.getName() + " --> " + element1.getName() + (((element1.getCharge() * element2.getCharge())/ element1.getCharge())/2) + element2.getName() + (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2)  );
                    if(((((element2.getCharge() * element1.getCharge())/ element1.getCharge())/2) == 1))
                    {
                        equation.add(element1.getName() + " + " + (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2)+element2.getName() + " --> " + element1.getName()  + element2.getName() + (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2)  );
                    }
                    if(((((element2.getCharge() * element1.getCharge())/ element2.getCharge())/2) == 1))
                    {
                        equation.add((((element1.getCharge() * element2.getCharge())/ element1.getCharge())/2)+element1.getName() + " + " + element2.getName() + " --> " + element1.getName() + (((element1.getCharge() * element2.getCharge())/ element1.getCharge())/2) + element2.getName()  );
                    }



                }

            }
        }

        for(int x = 0 ; x < equation.size(); x++)
        {

            fin = equation.get(equation.size() - 1);
        }





        if(! fin.equals(" "))
        {
            SynthesisReaction.finalResult = fin;
            //JOptionPane.showMessageDialog(null, fin, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);
        }

        if(! fin.equals(" "))
        {
            String ox = element1.getName() + " (Reducing Agent): " + 0 +" to " + "+"+element1.getCharge()+ ", Oxidized";	//oxidation String
            String red = element2.getName() + " (Oxidizing Agent): " + 0 +" to " + "-"+element2.getCharge()+ ", Reduced";	//Reduction String
            String t = " ";													// electrons transferred
            try{
                String h = fin.substring(0,1);	// String that represents the first character in fin (the first coefficient)
                int i = Integer.parseInt(h);	//turns h into an int

              /*  System.out.println(fin);
                System.out.println("Oxidation States:");
                System.out.println(ox );
                System.out.println(red );
                System.out.println(i * element1.getCharge() + " Electron(s) Transferred");
                */
                t = i * element1.getCharge() + " Electron(s) Transferred";
            }
            catch(NumberFormatException InputString)
            {
               /* System.out.println(fin);
                System.out.println("Oxidation States:");
                System.out.println(ox );
                System.out.println(red );
                System.out.println(element1.getCharge() + " Electron(s) Transferred");
                */
                t = element1.getCharge() + " Electron(s) Transferred";
            }
            //JOptionPane.showMessageDialog(null, fin + "\n" + "\n" + "Oxidation States:" + "\n" + ox + "\n" + red + "\n" + t, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);
    redoxResult = "\n" + "\n" + "Oxidation States:" + "\n" + ox + "\n" + red + "\n" + t;

        }




    }




    public static void diatomic()
    {
        ArrayList<String> equation = new ArrayList<String>();
        String fin = " ";
        if ( (element2.getIon() == 3 && element1.getIon() != 4 )|| (element1.getIon() == 3 && element1.getIon() != 4) )
        {
            if(    element1.getCharge()/element2.getCharge() == 2 || element1.getCharge()/element2.getCharge() ==4 || (element1.getCharge()%element2.getCharge() != 0 && element1.getCharge() > element2.getCharge()))
            {
                equation.add((element2.getCharge() * element1.getCharge())/ element1.getCharge() +element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 +element2.getName()+ 2 + " --> " + element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                        (element1.getCharge() * element2.getCharge())/ element2.getCharge());

                //If a subscript of one d = 1, prints out the product without the subscript since 1 is not needed as a subscript.
                if (  ((element1.getCharge() * element2.getCharge())/ element1.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element2.getCharge() > 1))
                {
                    equation.add( element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 +element2.getName()+ 2 + " --> " + element1.getName() + element2.getName() +
                            (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                }

                //If a subscript of OTHER d = 1, prints out the product without the subscript since 1 is not needed as a subscript.
                if (  ((element2.getCharge() * element1.getCharge())/ element2.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element1.getCharge() > 1))
                {
                    equation.add((element2.getCharge() * element1.getCharge())/ element1.getCharge() +element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 +element2.getName()+ 2 + " --> " + element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                            (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                }
                //If 2nd term equals 1, exclude the coefficient
                if(((element1.getCharge() * element2.getCharge())/ element1.getCharge() == 1) && (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2) ==1  )
                {
                    equation.add( element1.getName() + " + " + element2.getName()+ 2 + " --> " + element1.getName() + element2.getName() +
                            (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                }
                //If 2nd term equals 1, exclude the coefficient (and they don't evenly divide into each other)
                if(((element1.getCharge() * element2.getCharge())/ element1.getCharge() != 1) && (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2) ==1  )
                {
                    equation.add( (element1.getCharge() * element2.getCharge())/ element1.getCharge()+element1.getName() + " + " + element2.getName()+ 2 + " --> " + element1.getName() +((element1.getCharge() * element2.getCharge())/ element1.getCharge() + element2.getName() +
                            (element1.getCharge() * element2.getCharge())/ element2.getCharge()) );
                }

                if(((element1.getCharge() * element2.getCharge())/ element1.getCharge())%2 == 0 && ((element1.getCharge() * element2.getCharge())/ element2.getCharge())%2 == 0)
                {
                    equation.add((element2.getCharge() * element1.getCharge())/ element1.getCharge() +element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 +element2.getName()+ 2 + " --> " + element1.getName() + (((element1.getCharge() * element2.getCharge())/ element1.getCharge())/2)+ element2.getName() +
                            (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2));

                    if(((element2.getCharge() * element1.getCharge())/ element1.getCharge())/2 == 1)
                    {
                        equation.add( element1.getName() + " + " + element2.getName()+ 2 + " --> " + element1.getName() +  element2.getName() +
                                (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2));
                    }

                    if((((element1.getCharge() * element2.getCharge())/ element1.getCharge())) % 2 == 0 && ((element1.getCharge() * element2.getCharge())/ element2.getCharge()) % 2 == 0 && ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 % 2 == 0 && (((element2.getCharge() * element1.getCharge())/ element1.getCharge())/2) > 1)
                    {
                        equation.add((((element2.getCharge() * element1.getCharge())/ element1.getCharge())/2) +element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge()) +element2.getName()+ 2 + " --> " +(((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2)+ element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                                (element1.getCharge() * element2.getCharge())/ element2.getCharge()  );
                    }
                }
            }
            if( element1.getCharge()/element2.getCharge() ==0    || (element1.getCharge()/element2.getCharge())%2 !=0  && element1.getCharge() != 4|| (element1.getCharge() > element2.getCharge() && element1.getCharge()%element2.getCharge() !=0) && element1.getCharge() != 4)
            {
                {
                    equation.add(2*(element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element1.getName() + " + " +(element1.getCharge() * element2.getCharge())/ element2.getCharge() +element2.getName()+2 + " --> " + 2+ element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge() + element2.getName()+ (element1.getCharge() * element2.getCharge())/ element2.getCharge());

                    //If other subscript is one
                    if (  ((element1.getCharge() * element2.getCharge())/ element1.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element2.getCharge() > 1))
                    {
                        equation.add( 2*(element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element1.getName() + " + " + (element1.getCharge() * element2.getCharge())/ element2.getCharge() +element2.getName()+2 + " --> " + 2+ element1.getName()+ element2.getName()+ (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                    }

                    //If one subscript is one
                    if (  ((element2.getCharge() * element1.getCharge())/ element2.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element1.getCharge() > 1))
                    {
                        equation.add(2*(element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element1.getName() + " + " + element2.getName()+2 + " --> " + 2*(element1.getCharge() * element2.getCharge())/ element2.getCharge()+ element1.getName()+ (element1.getCharge() * element2.getCharge())/ element1.getCharge() + element2.getName() );
                    }

                    if((((element1.getCharge() * element2.getCharge())/ element1.getCharge())*2) % 2 == 0 && (((element1.getCharge() * element2.getCharge())/ element2.getCharge())*2) % 2 == 0 && ((element1.getCharge() * element2.getCharge())/ element2.getCharge()) % 2 == 0 )
                    {
                        equation.add((((element2.getCharge() * element1.getCharge())/ element1.getCharge())) +element1.getName() + " + " + (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2) +element2.getName()+ 2 + " --> " +(((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2)+ element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                                (element1.getCharge() * element2.getCharge())/ element2.getCharge()  );

                        if((((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2) == 1 )
                        {
                            equation.add((((element2.getCharge() * element1.getCharge())/ element1.getCharge())) +element1.getName() + " + " + element2.getName()+ 2 + " --> " + element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                                    (element1.getCharge() * element2.getCharge())/ element2.getCharge()  );
                        }
                    }
                }
                // This makes Products reduced - CaS instead of Ca2S2
                if (  ((element1.getCharge() * element2.getCharge())/ element1.getCharge() == (element1.getCharge() * element2.getCharge())/ element2.getCharge()))
                {
                    equation.add(2 + element1.getName() + " + " + element2.getName()+2 + " --> " + 2+ element1.getName() + element2.getName());
                }
            }
        }

        for(int x = 0 ; x < equation.size(); x++)
        {

            fin = equation.get(equation.size() - 1);
        }

        if(! fin.equals(" "))
        {
            SynthesisReaction.finalResult = fin;
            //JOptionPane.showMessageDialog(null, fin, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);
        }

        if(! fin.equals(" "))
        {
            String ox1 = element1.getName() + " (Reducing Agent): " + 0 +" to " + "+"+element1.getCharge()+ ", Oxidized";	//Oxidation
            String red1 = element2.getName() + " (Oxidizing Agent): " + 0 +" to " + "-"+element2.getCharge()+ ", Reduced";	//Reduction
            String t1 = " ";												//Electrons Transferred
            try{
                String h = fin.substring(0,1);			// String that represents the first character in fin (the first coefficient)
                int i = Integer.parseInt(h);			//turns h into an int

               /* System.out.println(fin);
                System.out.println("Oxidation States:");
                System.out.println(ox1 );
                System.out.println(red1 );
                System.out.println(i * element1.getCharge() + " Electron(s) Transferred");*/
                t1 = i * element1.getCharge() + " Electron(s) Transferred";
            }
            catch(NumberFormatException InputString)
            {
              /*  System.out.println(fin);
                System.out.println("Oxidation States:");
                System.out.println(ox1);
                System.out.println(red1 );
                System.out.println(element1.getCharge() + " Electron(s) Transferred");
                */
                t1 = element1.getCharge() + " Electron(s) Transferred";
            }
           // JOptionPane.showMessageDialog(null, fin + "\n" + "\n"+ "Oxidation States:" + "\n" + ox1 + "\n" + red1 + "\n" + t1, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);
        redoxResult =  "\n" + "\n"+ "Oxidation States:" + "\n" + ox1 + "\n" + red1 + "\n" + t1;

        }
    }

    //Adding Hydrogen as a cation
    public static void hydrogen()
    {
        ArrayList<String> equation = new ArrayList<String>();
        String fin = " ";
        if(element1.getIon() == 4)
        {
            if(element2.getCharge() == 2 && element2.getIon() != 3)
            {
                equation.add(element1.getName() + 2 + " + " +  element2.getName() + " --> " + element1.getName() + 2 + element2.getName());
            }

            if(element2.getCharge() == 3 && element2.getIon() != 3)
            {
                equation.add(3 + element1.getName() + 2 + " + " + 2 + element2.getName() + " --> " + 2 + element1.getName() + 3 + element2.getName());
            }
            if (element2.getIon() == 3)
            {
                equation.add(element2.getCharge() + element1.getName() + 2 + " + " + element2.getName() + 2 + " --> " + 2 + element1.getName() + (element1.getCharge() * element2.getCharge()/element1.getCharge()) + element2.getName() );
                if((element2.getCharge()) == 1)
                {
                    equation.add(element1.getName() + 2 + " + " + element2.getName() + 2+ " --> "+ 2 + element1.getName() + element2.getName() );
                }
            }

            if(element2.getName().equals("N"))
            {
                equation.add("3H2 + N2 --> 2NH3");
            }

        }

        for(int x = 0 ; x < equation.size(); x++)
        {

            fin = equation.get(equation.size() - 1);
        }

        if(! fin.equals(" "))
        {
            SynthesisReaction.finalResult = fin;
            //JOptionPane.showMessageDialog(null, fin, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);
        }


        if(! fin.equals(" "))
        {
            String ox2 = element1.getName() + " (Reducing Agent): " + 0 +" to " + "+"+element1.getCharge()+ ", Oxidized" ;	//oxidation
            String red2 = element2.getName() + " (Oxidizing Agent): " + 0 +" to " + "-"+element2.getCharge()+ ", Reduced" ;	//reduction
            String t2 = " ";												//electrons transferred
            try{
                String h = fin.substring(0,1);				// String that represents the first character in fin (the first coefficient)
                int i = Integer.parseInt(h);				// turns h into an int

              /*  System.out.println(fin);
                System.out.println("Oxidation States:");
                System.out.println(ox2);
                System.out.println(red2);
                System.out.println(2*i * element1.getCharge() + " Electron(s) Transferred");
                */
                t2 = 2*i * element1.getCharge() + " Electron(s) Transferred";
            }
            catch(NumberFormatException InputString)
            {
                /*System.out.println(fin);
                System.out.println("Oxidation States:");
                System.out.println(ox2);
                System.out.println(red2 );
                System.out.println(2*element1.getCharge() + " Electron(s) Transferred");
                */
                t2 = 2*element1.getCharge() + " Electron(s) Transferred";
            }
           // JOptionPane.showMessageDialog(null, fin + "\n" + "\n" + "Oxidation States:" + "\n" + ox2 + "\n" + red2 + "\n" + t2, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);

        redoxResult =  "\n" + "\n" + "Oxidation States:" + "\n" + ox2 + "\n" + red2 + "\n" + t2;
        }


    }


    //Adding hydrogen as an anion
    public static void hydride()
    {
        ArrayList<String> equation = new ArrayList<String>();
        String fin = " ";
        if(element2.getIon() == 4)
        {
            if(    element1.getCharge()/element2.getCharge() == 2 || element1.getCharge()/element2.getCharge() ==4 || (element1.getCharge()%element2.getCharge() != 0 && element1.getCharge() > element2.getCharge()))
            {
                equation.add((element2.getCharge() * element1.getCharge())/ element1.getCharge() +element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 +element2.getName()+ 2 + " --> " + element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                        (element1.getCharge() * element2.getCharge())/ element2.getCharge());

                //If a subscript of one d = 1, prints out the product without the subscript since 1 is not needed as a subscript.
                if (  ((element1.getCharge() * element2.getCharge())/ element1.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element2.getCharge() > 1))
                {
                    equation.add( element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 +element2.getName()+ 2 + " --> " + element1.getName() + element2.getName() +
                            (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                }

                //If a subscript of OTHER d = 1, prints out the product without the subscript since 1 is not needed as a subscript.
                if (  ((element2.getCharge() * element1.getCharge())/ element2.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element1.getCharge() > 1))
                {
                    equation.add((element2.getCharge() * element1.getCharge())/ element1.getCharge() +element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 +element2.getName()+ 2 + " --> " + element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                            (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                }
                //If 2nd term equals 1, exclude the coefficient
                if(((element1.getCharge() * element2.getCharge())/ element1.getCharge() == 1) && (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2) ==1  )
                {
                    equation.add( element1.getName() + " + " + element2.getName()+ 2 + " --> " + element1.getName() + element2.getName() +
                            (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                }
                //If 2nd term equals 1, exclude the coefficient (and they don't evenly divide into each other)
                if(((element1.getCharge() * element2.getCharge())/ element1.getCharge() != 1) && (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2) ==1  )
                {
                    equation.add( (element1.getCharge() * element2.getCharge())/ element1.getCharge()+element1.getName() + " + " + element2.getName()+ 2 + " --> " + element1.getName() +((element1.getCharge() * element2.getCharge())/ element1.getCharge() + element2.getName() +
                            (element1.getCharge() * element2.getCharge())/ element2.getCharge()) );
                }

                if(((element1.getCharge() * element2.getCharge())/ element1.getCharge())%2 == 0 && ((element1.getCharge() * element2.getCharge())/ element2.getCharge())%2 == 0)
                {
                    equation.add((element2.getCharge() * element1.getCharge())/ element1.getCharge() +element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 +element2.getName()+ 2 + " --> " + element1.getName() + (((element1.getCharge() * element2.getCharge())/ element1.getCharge())/2)+ element2.getName() +
                            (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2));

                    if(((element2.getCharge() * element1.getCharge())/ element1.getCharge())/2 == 1)
                    {
                        equation.add( element1.getName() + " + " + element2.getName()+ 2 + " --> " + element1.getName() +  element2.getName() +
                                (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2));
                    }

                    if((((element1.getCharge() * element2.getCharge())/ element1.getCharge())) % 2 == 0 && ((element1.getCharge() * element2.getCharge())/ element2.getCharge()) % 2 == 0 && ((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2 % 2 == 0 && (((element2.getCharge() * element1.getCharge())/ element1.getCharge())/2) > 1)
                    {
                        equation.add((((element2.getCharge() * element1.getCharge())/ element1.getCharge())/2) +element1.getName() + " + " + ((element1.getCharge() * element2.getCharge())/ element2.getCharge()) +element2.getName()+ 2 + " --> " +(((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2)+ element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                                (element1.getCharge() * element2.getCharge())/ element2.getCharge()  );
                    }
                }
            }
            if( element1.getCharge()/element2.getCharge() ==0    || (element1.getCharge()/element2.getCharge())%2 !=0  && element1.getCharge() != 4|| (element1.getCharge() > element2.getCharge() && element1.getCharge()%element2.getCharge() !=0) && element1.getCharge() != 4)
            {
                {
                    equation.add(2*(element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element1.getName() + " + " +(element1.getCharge() * element2.getCharge())/ element2.getCharge() +element2.getName()+2 + " --> " + 2+ element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge() + element2.getName()+ (element1.getCharge() * element2.getCharge())/ element2.getCharge());

                    //If other subscript is one
                    if (  ((element1.getCharge() * element2.getCharge())/ element1.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element2.getCharge() > 1))
                    {
                        equation.add( 2*(element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element1.getName() + " + " + (element1.getCharge() * element2.getCharge())/ element2.getCharge() +element2.getName()+2 + " --> " + 2+ element1.getName()+ element2.getName()+ (element1.getCharge() * element2.getCharge())/ element2.getCharge() );
                    }

                    //If one subscript is one
                    if (  ((element2.getCharge() * element1.getCharge())/ element2.getCharge() == 1) && ((element1.getCharge() * element2.getCharge())/ element1.getCharge() > 1))
                    {
                        equation.add(2*(element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element1.getName() + " + " + element2.getName()+2 + " --> " + 2*(element1.getCharge() * element2.getCharge())/ element2.getCharge()+ element1.getName()+ (element1.getCharge() * element2.getCharge())/ element1.getCharge() + element2.getName() );
                    }

                    if((((element1.getCharge() * element2.getCharge())/ element1.getCharge())*2) % 2 == 0 && (((element1.getCharge() * element2.getCharge())/ element2.getCharge())*2) % 2 == 0 && ((element1.getCharge() * element2.getCharge())/ element2.getCharge()) % 2 == 0 )
                    {
                        equation.add((((element2.getCharge() * element1.getCharge())/ element1.getCharge())) +element1.getName() + " + " + (((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2) +element2.getName()+ 2 + " --> " +(((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2)+ element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                                (element1.getCharge() * element2.getCharge())/ element2.getCharge()  );

                        if((((element1.getCharge() * element2.getCharge())/ element2.getCharge())/2) == 1 )
                        {
                            equation.add((((element2.getCharge() * element1.getCharge())/ element1.getCharge())) +element1.getName() + " + " + element2.getName()+ 2 + " --> " + element1.getName() + (element1.getCharge() * element2.getCharge())/ element1.getCharge()+ element2.getName() +
                                    (element1.getCharge() * element2.getCharge())/ element2.getCharge()  );
                        }
                    }
                }
                // This makes Products reduced - CaS instead of Ca2S2
                if (  ((element1.getCharge() * element2.getCharge())/ element1.getCharge() == (element1.getCharge() * element2.getCharge())/ element2.getCharge()))
                {
                    equation.add(2 + element1.getName() + " + " + element2.getName()+2 + " --> " + 2+ element1.getName() + element2.getName());
                }
            }


            if(element1.getIon() == 4 )
            {
                equation.add("H2 + H2 --> 2H2");
            }
        }

        for(int x = 0 ; x < equation.size(); x++)
        {

            fin = equation.get(equation.size() - 1);
        }

        if(! fin.equals(" "))
        {
            SynthesisReaction.finalResult = fin;
            //JOptionPane.showMessageDialog(null, fin, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);
        }


        if(! fin.equals(" "))
        {
            String ox3 = element1.getName() + " (Reducing Agent): " + 0 +" to " + "+"+element1.getCharge()+ ", Oxidized";	//oxidation
            String red3 = element2.getName() + " (Oxidizing Agent): " + 0 +" to " + "-"+element2.getCharge()+ ", Reduced";	//reduction
            String t3 = " ";												//electrons transferred
            try
            {
                String h = fin.substring(0,1);			// String that represents the first character in fin (the first coefficient)
                int i = Integer.parseInt(h);			//turns h into an int
/*
                System.out.println(fin);
                System.out.println("Oxidation States:");
                System.out.println(ox3);
                System.out.println(red3);

*/

                System.out.println(i * element1.getCharge() + " Electron(s) Transferred");
                t3 = i * element1.getCharge() + " Electron(s) Transferred";

            }

            catch(NumberFormatException InputString)
            {
               /* System.out.println(fin);
                System.out.println("Oxidation States:");
                System.out.println(ox3);
                System.out.println(red3);
                System.out.println(element1.getCharge() + " Electron(s) Transferred");
                */
                t3 = element1.getCharge() + " Electron(s) Transferred";
            }
           // JOptionPane.showMessageDialog(null, fin + "\n" + "\n" + "Oxidation States:" + "\n" + ox3 + "\n" + red3 + "\n" + t3, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);

            redoxResult ="\n" + "\n" + "Oxidation States:" + "\n" + ox3 + "\n" + red3 + "\n" + t3;
        }
    }


}
