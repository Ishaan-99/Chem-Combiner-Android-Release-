package singlereplacement;


import java.util.ArrayList;

import element.Element;

/* 12/26/16
 * Single Replacement Reactions
 * ChemCalc by Matthew William and Ishaan Patel
 */

public class SingleRep
{

    //MAKE REACTIVITY TABLE
    // Note: "elementName-symbol-charge-reactivity "
    private static	String cations[] = {  "H - Hydrogen(1+)|H|1|11" ,  "Na - Sodium(1+)|Na|1|3"	, "K - Potassium(1+)|K|1|1"	, "Ag - Silver(1+)|Ag|1|13",

            "Ca - Calcium(2+)|Ca|2|2" ,  "Mg - Magnesium(2+)|Mg|2|4" ,  "Zn - Zinc(2+)|Zn|2|6" ,

            "Al - Aluminum(3+)|Al|3|5" ,



            //Transition metals

            "Pb - Lead(2+)|Pb|2|10" , "Pb - Lead(4+)|Pb|4|10" ,
            "Sn - Tin(2+)|Sn|2|9" , "Sn - Tin(4+)|Sn|4|9" ,
            "Cu - Copper(1+)|Cu|1|12" ,  "Cu - Copper(2+)|Cu|2|12" ,
            "Fe - Iron(2+)|Fe|2|7" ,  "Fe - Iron(3+)|Fe|3|7",

            "Au - Gold(1+)|Au|1|15" ,  "Au - Gold(3+)|Au|3|15" ,
            "Ni - Nickel(2+)|Ni|2|8" ,  "Ni - Nickel(3+)|Ni|3|8"


    };

    private static	String anions[] = { "Cl - Chlorine(1-)|Cl|1|3" , "Br - Bromine(1-)|Br|1|3", "F - Fluorine(1-)|F|1|3", "I - Iodine(1-)|I|1|3", "O - Oxygen(2-)|O|2|3" , "S - Sulfur(2-)|S|2|0" ,
            "Se - Selenium(2-)|Se|2|0" , "N - Nitrogen(3-)|N|3|3" , "P - Phosphorus(3-)|P|3|0" , "NO3 - nitrate(1-)|(NO3)|1|0",
            "NO2 - Nitrite(1-)|(NO2)|1|0" ,"C2H3O2 - Acetate(1-)|(C2H3O2)|1|0", "OH - Hydroxide(1-)|(OH)|1|3", "CO3 - Carbonate(2-)|(CO3)|2|0",
            "CrO4 - Chromate(2-)|(CrO4)|2|0", "Cr2O7 - Dichromate(2-)|(Cr2O7)|2|0", "SO4 - Sulfate(2-)|(SO4)|2|0" , "SO3 - Sulfite(2-)|(SO3)|2|0" ,
            "PO4 - Phosphate(3-)|(PO4)|3|0" , "PO3 - Phosphite(3-)|(PO3)|3|0"
    };


    private static Element element1 = null;
    private static Element element2 = null;
    private static Element element3 = null;


    private static String[] element = new String[cations.length];
    private static String[] elements = new String[anions.length];

    private static String fin = " ";
    private static String redoxResult;



    public static void setRedoxResult()
    {
        redoxResult = null;
    }
    public static void startSingleRep(String inputValue, String inputValue2, String inputValue3)
    {
        check(inputValue, inputValue2, inputValue3);
        SingleReplacement();
    }

    public static String getFinalResult()
    {

        return fin;
    }

    public static String getRedoxResult()
    {
        return redoxResult;
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


    public static void check(String inputValue, String inputValue2, String inputValue3)  //Uses input for 3 different elements in single replacement
    {
        /*

        //JOptionPane for synthesis, gives options.
        String inputValue = (String) JOptionPane.showInputDialog(null, "Enter Lone Metal: (ex: sodium)",
                "Chemistry Calculator",
                JOptionPane.PLAIN_MESSAGE,
                null, d, "");

        String inputValue2 = (String) JOptionPane.showInputDialog(null, "Enter Element 1 of Compound: (ex: silver)",
                "Chemistry Calculator",
                JOptionPane.PLAIN_MESSAGE,
                null, d, "");

        String inputValue3 = (String) JOptionPane.showInputDialog(null, "Enter Element 2 of Compound: (ex: chlorine)",
                "Chemistry Calculator",
                JOptionPane.PLAIN_MESSAGE,
                null, elements, "");

*/

        //Instantiates element1, element2, and d 3 with user selected elements
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

        for(int y = 0; y < element.length; y++){
            if(inputValue2.equals(element[y]))
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
                element2 = new Element( symbol , charge , ionization);
                break;
            }
        }

        for(int y = 0; y < elements.length; y++){
            if(inputValue3.equals(elements[y]))
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
                element3 = new Element( symbol , charge , ionization);
                break;
            }
        }
    }




        public static void SingleReplacement()
        {

            ArrayList<String> equations = new ArrayList<String>();

            if(element1.getIon() > element2.getIon())
            {
                fin = "No Reaction - " + element1.getName() + " Less Reactive Than " + element2.getName();
                return;
                /*
                System.out.println("No Reaction - " + element1.getName() + " Less Reactive Than " + element2.getName() );
                JOptionPane.showMessageDialog(null, fin, "Chemistry Calculator", JOptionPane.PLAIN_MESSAGE);
                */
            }
            else
            {

                String left = element1.getName() + " + " +  element2.getName() + element3.getCharge() + element3.getName() + element2.getCharge() + " ";
                String right = element2.getName() + " + " +  element1.getName() + element3.getCharge()  + element3.getName() + element1.getCharge();


                if(element1.getCharge() == 1)
                {
                    right = element2.getName() + " + " +  element1.getName() + element3.getCharge()  + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);
                }

                if(element2.getCharge() == 1)
                {
                    left = element1.getName() + " + " +  element2.getName() + element3.getCharge() + element3.getName()  + " ";
                    equations.add(left + " -->" + " " +  right);
                }

                if(element3.getCharge() == 1)
                {
                    right = element2.getName() + " + " +  element1.getName() + element3.getName() + element1.getCharge();
                    left = element1.getName() + " + " +  element2.getName() + element3.getName() + element2.getCharge() + " ";
                    equations.add(left + " -->" + " " +  right);
                }

                if(element1.getCharge() ==1 && element2.getCharge() ==1)
                {
                    left = element1.getName() + " + " +  element2.getName() + element3.getCharge() + element3.getName() + " ";
                    right = element2.getName() + " + " +  element1.getName() + element3.getCharge()  + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);


                }

                if(element1.getCharge() ==1 && element3.getCharge() ==1)
                {

                    left = element1.getName() + " + " +  element2.getName()  + element3.getName() + element2.getCharge() + " ";
                    right = element2.getName() + " + " +  element1.getName()  + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }

                if(element2.getCharge() ==1 && element3.getCharge() ==1)
                {
                    left = element1.getName() + " + " +  element2.getName()  + element3.getName() + " ";
                    right = element2.getName() + " + " +  element1.getName()   + element3.getName() + element1.getCharge();
                    equations.add(left + " -->" + " " +  right);
                }


                if(element2.getCharge() ==1 && element3.getCharge() ==1 && element1.getCharge() ==1)  //This equation does NOT require balancing since all charges are equal.
                {
                    left = element1.getName() + " + " +  element2.getName()  + element3.getName() + " ";
                    right = element2.getName() + " + " +  element1.getName()  + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);
                }


                //Note to self: A quick  observation - if two metallic elements have the same charge AND have the greatest charge in the equation, the equation does not require any balancing. (there must be even division in unequal charges then).


                if(element1.getCharge() == element2.getCharge() && element2.getCharge() % element3.getCharge() == 0 )
                {

                    equations.add(left + " -->" + " " +  right);


                }

                //If they all have the same charge
                if(element1.getCharge() == element2.getCharge() && element1.getCharge() == element3.getCharge())
                {
                    left = element1.getName() + " + " + element2.getName() +element3.getName();
                    right = element2.getName() + " + " + element1.getName() + element3.getName();

                    equations.add(left + " -->" + " " +  right);
                }


                if(element1.getCharge() == element2.getCharge() && element2.getCharge() < element3.getCharge()  )
                {

                    equations.add(element3.getCharge() + left + " -->" + " " +  element3.getCharge() + right);


                }

                //if d 2 and 3 have the same charge

                if(element2.getCharge() == element3.getCharge() && element1.getCharge() != element2.getCharge())
                {
                    left = element3.getCharge() +  element1.getName() + " + " + element1.getCharge() + element2.getName() + element3.getName();
                    right= element1.getCharge() + element2.getName() + " + " + element1.getName() + element3.getCharge() + element3.getName() + element1.getCharge();

                    if(element2.getCharge() == 1)
                    {
                        left =   element1.getName() + " + "	+ element1.getCharge() + element2.getName() + element3.getName();
                        right= element1.getCharge() + element2.getName() + " + " + element1.getName() +  element3.getName() + element1.getCharge();
                    }




                    equations.add(left + " -->" + " " +  right);



                }


                //If d 2 and 3 have charges that can be reduced - d 2 has the greater charge

                if(element2.getCharge() % element3.getCharge() == 0 && element2.getCharge() > element3.getCharge() && element1.getCharge() != element2.getCharge())
                {
                    left = element2.getCharge() + element1.getName() + " + " + element2.getName() + element3.getName() + (element2.getCharge() / element3.getCharge());
                    right = element2.getName() +" + " + element2.getCharge() + element1.getName() +   element3.getName(); //if 1 and 3 both have charge of 1
                    equations.add(left + " -->" + " " +  right);

                }


                //1-2-3
                if(element1.getCharge() ==1 && element2.getCharge() == 2 && element3.getCharge() ==3)
                {
                    left = 6 + element1.getName() + " + " +  element2.getName() + element3.getCharge() + element3.getName() + element2.getCharge();
                    right = 3 + element2.getName() + " + "+ 2 + element1.getName() + 3 + element3.getName();
                    equations.add(left + " -->" + " " +  right);

                }


                //1-3-2
                if(element1.getCharge() ==1 && element2.getCharge() == 3 && element3.getCharge() ==2  )
                {
                    left = 6 + element1.getName() + " + " +  element2.getName() + element3.getCharge() + element3.getName() + element2.getCharge();
                    right = 2 + element2.getName() + " + "+ 3 + element1.getName() + 2 + element3.getName();
                    equations.add(left + " -->" + " " +  right);

                }


                //2-1-3
                if(element1.getCharge() ==2 && element2.getCharge() == 1 && element3.getCharge() ==3)
                {
                    left =  3+ element1.getName() + " + " + 2 + element2.getName() + element3.getCharge() + element3.getName();
                    right = 6 + element2.getName() + " + "  + element1.getName() + 3 + element3.getName() + 2;
                    equations.add(left + " -->" + " " +  right);

                }

                //2-3-1
                if(element1.getCharge() ==2 && element2.getCharge() == 3 && element3.getCharge() ==1)
                {
                    left =  3+ element1.getName() + " + " + 2 + element2.getName()  + element3.getName() + 3;
                    right = 2 + element2.getName() + " + "  + 3 + element1.getName()  + element3.getName() + 2;
                    equations.add(left + " -->" + " " +  right);

                }

                // 3-2-1
                if(element1.getCharge() ==3 && element2.getCharge() == 2 && element3.getCharge() ==1)
                {
                    left =  2+ element1.getName() + " + " + 3 + element2.getName()  + element3.getName() + 2;
                    right = 3 + element2.getName() + " + "  + 2 + element1.getName() + element3.getName() + 3;
                    equations.add(left + " -->" + " " +  right);

                }

                //3-1-2
                if(element1.getCharge() ==3 && element2.getCharge() == 1 && element3.getCharge() ==2)
                {
                    left =  2+ element1.getName() + " + " + 3 + element2.getName()  + 2 + element3.getName() ;
                    right = 6 + element2.getName() + " + "   + element1.getName() + 2 + element3.getName() + 3;
                    equations.add(left + " -->" + " " +  right);

                }

                //1-2-2
                if(element1.getCharge() ==1 && element2.getCharge() == 2 && element3.getCharge() ==2)
                {
                    left =  2+ element1.getName() + " + " + element2.getName()  + element3.getName() ;
                    right = element2.getName() + " + "   +  element1.getName() + "2" + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }
                //1-2-4
                if(element1.getCharge() ==1 && element2.getCharge() == 2 && element3.getCharge() ==4)
                {
                    left =  4+ element1.getName() + " + " + element2.getName()  + "2"+ element3.getName() ;
                    right = "2" + element2.getName() + " + "   +  element1.getName() + "4" + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }
                //1-3-3
                if(element1.getCharge() ==1 && element2.getCharge() == 3 && element3.getCharge() ==3)
                {
                    left =  3 + element1.getName() + " + " + element2.getName()  + element3.getName() ;
                    right = element2.getName() + " + "   +  element1.getName() + "3" + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }

                //1-3-4
                if(element1.getCharge() ==1 && element2.getCharge() == 2 && element3.getCharge() ==2)
                {
                    left =  2+ element1.getName() + " + " + element2.getName()  + element3.getName() ;
                    right = element2.getName() + " + "   +  element1.getName() + "2" + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }
                //1-4-2
                if(element1.getCharge() ==1 && element2.getCharge() == 4 && element3.getCharge() ==2)
                {
                    left =  4+ element1.getName() + " + " + element2.getName()  + element3.getName() + "2" ;
                    right = element2.getName() + " + "   + "2" +  element1.getName() + "2" + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }

                //1-4-3
                if(element1.getCharge() ==1 && element2.getCharge() == 4 && element3.getCharge() ==3)
                {
                    left =  12 + element1.getName()  + " + " + element2.getName() +3 + element3.getName() + "4" ;
                    right = 3 + element2.getName() + " + "   + "4" +  element1.getName() + "3" + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }

                //2-1-2
                if(element1.getCharge() ==2 && element2.getCharge() == 1 && element3.getCharge() ==2)
                {
                    left =   element1.getName()  + " + " + element2.getName() +2 + element3.getName() ;
                    right = 2 + element2.getName() + " + "   +   element1.getName() + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }

                //2-3-2
                if(element1.getCharge() ==2 && element2.getCharge() == 3 && element3.getCharge() ==2)
                {
                    left =  3 + element1.getName()  + " + " + element2.getName() +2 + element3.getName() + "3" ;
                    right = 2 + element2.getName() + " + "   + "3" +  element1.getName() +  element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }
                if(element1.getCharge() ==2 && element2.getCharge() == 4 && element3.getCharge() ==1)
                {
                    left =  2 + element1.getName()  + " + " + element2.getName()  + element3.getName() + "4" ;
                    right =  element2.getName() + " + "   + "2" +  element1.getName() +  element3.getName() + 2;
                    equations.add(left + " -->" + " " +  right);

                }
                if(element1.getCharge() ==2 && element2.getCharge() == 4 && element3.getCharge() ==2)
                {
                    left =  2 + element1.getName()  + " + " + element2.getName()  + element3.getName() + "2" ;
                    right =  element2.getName() + " + "   +  2 +  element1.getName() + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }

                //2-4-3
                if(element1.getCharge() ==2 && element2.getCharge() == 4 && element3.getCharge() ==3)
                {
                    left =  6 + element1.getName()  + " + " + element2.getName() +3 + element3.getName() + "4" ;
                    right = 3 + element2.getName() + " + "   + "2" +  element1.getName() + "3" + element3.getName() + 2 ;
                    equations.add(left + " -->" + " " +  right);

                }
                //3-1-3
                if(element1.getCharge() ==3 && element2.getCharge() == 1 && element3.getCharge() ==3)
                {
                    left =   element1.getName()  + " + " + element2.getName() +3 + element3.getName()  ;
                    right = 3 + element2.getName() + " + "   +   element1.getName() +  element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }
                //3-2-3
                if(element1.getCharge() ==3 && element2.getCharge() == 2 && element3.getCharge() ==3)
                {
                    left =  2 + element1.getName()  + " + " + element2.getName() +3 + element3.getName() + "2" ;
                    right = 3 + element2.getName() + " + "   + "2" +  element1.getName() +  element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }
                //3-3-2
                if(element1.getCharge() ==3 && element2.getCharge() == 3 && element3.getCharge() ==2)
                {
                    left =  2 + element1.getName()  + " + " + element2.getName() +2 + element3.getName() + "3" ;
                    right = 2 + element2.getName() + " + "   +   element1.getName() + "2" + element3.getName() + 3 ;
                    equations.add(left + " -->" + " " +  right);

                }
                //3-4-1
                if(element1.getCharge() ==3 && element2.getCharge() == 4 && element3.getCharge() ==1)
                {
                    left =  4 + element1.getName()  + " + " + 3 +  element2.getName()  + element3.getName() + "4" ;
                    right = 3 + element2.getName() + " + "   + "4" +  element1.getName()  + element3.getName() + 3;
                    equations.add(left + " -->" + " " +  right);

                }

                //3-4-2

                if(element1.getCharge() ==3 && element2.getCharge() == 4 && element3.getCharge() ==2)
                {
                    left =  4 + element1.getName()  + " + " + 3 +  element2.getName()  + element3.getName() + "2" ;
                    right = 3 + element2.getName() + " + "   + "2" +  element1.getName() + 2 + element3.getName() + 3;
                    equations.add(left + " -->" + " " +  right);

                }

                //3-4-3
                if(element1.getCharge() ==3 && element2.getCharge() == 4 && element3.getCharge() ==3)
                {
                    left =  4 + element1.getName()  + " + " +   element2.getName()  + 3 + element3.getName() + "4" ;
                    right = 3 + element2.getName() + " + "   + "4" +  element1.getName()  + element3.getName() ;
                    equations.add(left + " -->" + " " +  right);

                }

                //4-1-2

                if(element1.getCharge() ==4 && element2.getCharge() == 1 && element3.getCharge() ==2)
                {
                    left =   element1.getName()  + " + " + 2 +  element2.getName()  + 2 + element3.getName() ;
                    right = 4 + element2.getName() + " + "   +   element1.getName()  + element3.getName() + 2;
                    equations.add(left + " -->" + " " +  right);

                }
                //4-1-3
                if(element1.getCharge() ==4 && element2.getCharge() == 1 && element3.getCharge() ==3)
                {
                    left =  3 + element1.getName()  + " + " + 4 +  element2.getName()  + 3 + element3.getName() ;
                    right = 12 + element2.getName() + " + "   +   element1.getName()  + 3 + element3.getName() + 4;
                    equations.add(left + " -->" + " " +  right);

                }
                //4-2-1
                if(element1.getCharge() ==4 && element2.getCharge() == 2 && element3.getCharge() ==1)
                {
                    left =   element1.getName()  + " + " + 2 +  element2.getName()  +  element3.getName() + 2 ;
                    right = 2 + element2.getName() + " + "   +   element1.getName()  + element3.getName() + 4;
                    equations.add(left + " -->" + " " +  right);

                }
                //4-2-2
                if(element1.getCharge() ==4 && element2.getCharge() == 2 && element3.getCharge() ==2)
                {
                    left =   element1.getName()  + " + " + 2 +  element2.getName()  + element3.getName() ;
                    right = 2 + element2.getName() + " + "   +   element1.getName()  + element3.getName() + 2;
                    equations.add(left + " -->" + " " +  right);

                }

                //4-2-3
                if(element1.getCharge() ==4 && element2.getCharge() == 2 && element3.getCharge() ==3)
                {
                    left =   3 + element1.getName()  + " + " + 2 +  element2.getName()  + 3 + element3.getName() + 2 ;
                    right = 6 + element2.getName() + " + "   +   element1.getName()  + 3 + element3.getName() + 4;
                    equations.add(left + " -->" + " " +  right);

                }
                //4-3-1
                if(element1.getCharge() ==4 && element2.getCharge() == 3 && element3.getCharge() ==1)
                {
                    left =  3 + element1.getName()  + " + " + 4 +  element2.getName()  +  element3.getName() + 3 ;
                    right = 4 + element2.getName() + " + "   + 3 + element1.getName()  + element3.getName() + 4;
                    equations.add(left + " -->" + " " +  right);

                }
                //4-3-2
                if(element1.getCharge() ==4 && element2.getCharge() == 3 && element3.getCharge() ==2)
                {
                    left =  3 + element1.getName()  + " + " + 2 +  element2.getName()  + 2 + element3.getName() + 3 ;
                    right = 4 + element2.getName() + " + "   + 3 + element1.getName()  + element3.getName() + 2;
                    equations.add(left + " -->" + " " +  right);

                }
                //4-3-3
                if(element1.getCharge() ==4 && element2.getCharge() == 3 && element3.getCharge() ==3)
                {
                    left =  3 + element1.getName()  + " + " + 4 +  element2.getName()  +  element3.getName() ;
                    right = 4 + element2.getName() + " + "   + element1.getName() + 3 + element3.getName() + 4;
                    equations.add(left + " -->" + " " +  right);

                }
                //4-4-2
                if(element1.getCharge() ==4 && element2.getCharge() == 4 && element3.getCharge() ==2)
                {
                    left =   element1.getName()  + " + " +   element2.getName()  +  element3.getName() + 2;
                    right = element2.getName() + " + "   +  element1.getName()  + element3.getName() + 2;
                    equations.add(left + " -->" + " " +  right);

                }
                //4-4-3
                if(element1.getCharge() ==4 && element2.getCharge() == 4 && element3.getCharge() ==3)
                {
                    left =   3 + element1.getName()  + " + " +   element2.getName()  + 3 + element3.getName() + 4;
                    right = 3 + element2.getName() + " + "   +  element1.getName()  + 3 + element3.getName() + 4;
                    equations.add(left + " -->" + " " +  right);

                }


                //ISHAAN, REPLACE ALL CODE FROM HERE UNTIL THE NEXT COMMENT WHERE I TELL TO STOP. I HAVE FIXED ALL BUGS IN HYDROGEN. THERE WERE ALOT

                if(element1.getName().equals("H"))
                {

                    if( element2.getCharge() == 1 && element3.getCharge() == 1)
                    {
                        left =  "H2" + " + " + 2+ element2.getName() + element3.getName();
                        right =  2 + element2.getName() + " + "+ "2H" + element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 1 && element3.getCharge() == 2)
                    {
                        left =  "H2" + " + " +  element2.getName() + 2 + element3.getName();
                        right =  2 + element2.getName() + " + "+ "H2"  +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 1 && element3.getCharge() == 3)
                    {
                        left =  "3H2" + " + " + 2+ element2.getName() + 3 + element3.getName();
                        right =  6 + element2.getName() + " + "+ "2H3" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 2 && element3.getCharge() == 1)
                    {
                        left =  "H2" + " + " +  element2.getName()  + element3.getName() + 2;
                        right =  element2.getName() + " + "+ "2H" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 2 && element3.getCharge() == 2)
                    {
                        left =  "H2" + " + " +  element2.getName()  + element3.getName() ;
                        right =  element2.getName() + " + "+ "H2" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 2 && element3.getCharge() == 3)
                    {
                        left =  "3H2" + " + " +  element2.getName() +3 + element3.getName() + 2;
                        right =  3+ element2.getName() + " + "+ "2H3" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 3 && element3.getCharge() == 1)
                    {
                        left =  "3H2" + " + " +  2 + element2.getName()  + element3.getName() + 3;
                        right =   2 + element2.getName() + " + "+ "6H" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 3 && element3.getCharge() == 2)
                    {
                        left =  "3H2" + " + " +  element2.getName() +2  + element3.getName() + 3;
                        right =  2 + element2.getName() + " + "+ "3H2" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 3 && element3.getCharge() == 3)
                    {
                        left =  "3H2" + " + " + 2 + element2.getName()  + element3.getName();
                        right = 2+ element2.getName() + " + "+ "2H3" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 4 && element3.getCharge() == 1)
                    {
                        left =  "2H2" + " + " +  element2.getName()  + element3.getName() + 4 ;
                        right =  element2.getName() + " + "+ "4H" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element2.getCharge() == 4 && element3.getCharge() == 2)
                    {
                        left =  "2H2" + " + " +  element2.getName()  + element3.getName() + 2;
                        right =  element2.getName() + " + "+ "2H2" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }


                    if( element2.getCharge() == 4 && element3.getCharge() == 3)
                    {
                        left =  "6H2" + " + " +  element2.getName()  + 3 + element3.getName() + 4  ;
                        right =  3 + element2.getName() + " + "+ "4H3" +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                }

                if(element2.getName().equals("H")&& !element3.getName().equals("OH"))
                {
                    if( element1.getCharge() == 1 && element3.getCharge() == 1)
                    {
                        left =  2+element1.getName() + " + " + "2H" + element3.getName();
                        right =  "H2" + " + "+ 2+ element1.getName() +element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element1.getCharge() == 1 && element3.getCharge() == 2)
                    {
                        left =  2+element1.getName() + " + " + "H2" + element3.getName();
                        right =  "H2" + " + "+  element1.getName() +2+element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element1.getCharge() == 1 && element3.getCharge() == 3)
                    {
                        left =  6+element1.getName() + " + " + "2H3" + element3.getName();
                        right =  "3H2" + " + "+  2+element1.getName() +3+element3.getName() ;
                        equations.add(left + " -->" + " " +  right);

                    }


                    if( element1.getCharge() == 2 && element3.getCharge() == 1)
                    {
                        left =  element1.getName() + " + " + "2H" + element3.getName();
                        right =  "H2" + " + "+ element1.getName() +element3.getName() +2 ;
                        equations.add(left + " -->" + " " +  right);

                    }


                    if( element1.getCharge() == 2 && element3.getCharge() == 2)
                    {
                        left =  element1.getName() + " + " + "H2" + element3.getName();
                        right =  "H2" + " + "+ element1.getName() +element3.getName()  ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element1.getCharge() == 2 && element3.getCharge() == 3)
                    {
                        left =  3 + element1.getName() +" + " + "2H3" + element3.getName();
                        right =  "3H2" + " + "+ element1.getName() + 3 +element3.getName() +2 ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element1.getCharge() == 3 && element3.getCharge() == 1)
                    {
                        left =  2 + element1.getName() +" + " + "6H" + element3.getName();
                        right =  "3H2" + " + "+ 2 + element1.getName() +element3.getName() +3 ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element1.getCharge() == 3 && element3.getCharge() == 2)
                    {
                        left =  2 + element1.getName() +" + " + "3H2" + element3.getName();
                        right =  "6H2" + " + "  + element1.getName() +2 +element3.getName() +3 ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element1.getCharge() == 3 && element3.getCharge() == 3)
                    {
                        left =  2 + element1.getName() + " + " +"2H3" + element3.getName();
                        right =  "3H2" + " + "  + 2 + element1.getName()  +element3.getName()  ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element1.getCharge() == 4 && element3.getCharge() == 1)
                    {
                        left =   element1.getName() + " + " +"4H" + element3.getName();
                        right =  "2H2" + " + "  + element1.getName() + element3.getName() + 4 ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element1.getCharge() == 4 && element3.getCharge() == 2)
                    {
                        left =   element1.getName() +" + " + "2H2" + element3.getName();
                        right =  "2H2" + " + "  + element1.getName() + element3.getName() + 2 ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( element1.getCharge() == 4 && element3.getCharge() == 3)
                    {
                        left =   3+element1.getName() + " + " +"4H3" + element3.getName();
                        right =  "6H2" + " + "  + element1.getName() + 3 + element3.getName() + 4 ;
                        equations.add(left + " -->" + " " +  right);

                    }

                    if( ((element3.getName().equals("O") || element3.getName().equals("(OH)"))&& element2.getName().equals("H") )  ) {
                        if (element1.getCharge() == 1) {
                            equations.add(2 + element1.getName() + " + " + "2H2O" + " -->" + 2 + element1.getName() + "(OH)" + " + " + "H2");
                        }
                        if (element1.getCharge() == 2) {
                            equations.add(element1.getName() + " + " + "2H2O" + " -->" + element1.getName() + "(OH)2" + " + " + "H2");
                        }
                        if (element1.getCharge() == 3) {
                            equations.add(2 + element1.getName() + " + " + "6H2O" + " -->" + 2 + element1.getName() + "(OH)3" + " + " + "3H2");
                        }
                        if (element1.getCharge() == 4) {
                            equations.add(element1.getName() + " + " + "4H2O" + " -->" + element1.getName() + "(OH)4" + " + " + "2H2");
                        }


                    }


                }

                if(element1.getName().equals("H") && element2.getName().equals("H")  )
                {
                    equations.add("No Reaction - Both Cations are Hydrogen");
                }


                // end of Single rep
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







                //THIS IS WHERE CHANGES FOR REDOX WERE MADE

                if(! fin.equals(" "))
                {
                    String ox = element1.getName() + " (Reducing Agent): " + 0 +" to " + "+"+element1.getCharge() + ", Oxidized";		//oxidation
                    String red = element2.getName() + " (Oxidizing Agent): " + "+" + element2.getCharge() + " to " + 0 + ", Reduced";	//reduction
                    String t = " ";														//electrons transferred
                    try{
                        String h = fin.substring(0,1);											// String that represents the first character in fin (the first coefficient)
                        int i = Integer.parseInt(h);											//turns h into an int

                        /*System.out.println(fin);
                        System.out.println("Oxidation States:");

                        System.out.println(ox);
                        System.out.println(red);
                        */
                        if(element1.getCharge() ==1 && element2.getCharge() == 4 && element3.getCharge() == 3)
                        {
                            //System.out.println("12 Electron(s) Transferred");
                            t = "12 Electron(s) Transferred";
                        }

                        if(element1.getName().equals("H"))
                        {
                            t = 2 * i + " Electron(s) Transferred";
                           // System.out.println( 2* i + " Electron(s) Transferred");
                        }

                        else
                        {
                            //System.out.println(i * element1.getCharge() + " Electron(s) Transferred");
                            t = i * element1.getCharge() + " Electron(s) Transferred";
                        }
                    }
                    catch(NumberFormatException InputString)
                    {

                        /*
                        System.out.println(fin);
                        System.out.println("Oxidation States:");
                        System.out.println(ox);
                        System.out.println(red);
*/
                        if(element1.getName().equals("H") && !(element2.getCharge() == 2))
                        {
                            t = 2 * element2.getCharge() + " Electron(s) Transferred";
                           // System.out.println( 2* element2.getCharge() + " Electron(s) Transferred");
                        }
                        else if(element1.getName().equals("H") && element2.getCharge() == 2)
                        {
                            t = 2 + " Electron(s) Transferred";
                           // System.out.println( 2 + " Electron(s) Transferred");


                        }

                        else
                        {
                           // System.out.println(element1.getCharge() + " Electron(s) Transferred");
                            t = element1.getCharge() + " Electron(s) Transferred";
                        }
                    }


                  redoxResult = "Oxidation States:" + " \n" + ox + "\n" + red + "\n" + t;
                }

            }


        }

    }

