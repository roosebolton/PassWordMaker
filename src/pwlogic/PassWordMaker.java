package pwlogic;

import java.util.concurrent.ThreadLocalRandom;
/**
*A class that generates random passwords of minimal length 8. With on/off options for: Special characters, numbers, ambigious characters.
* @author roosebolton github.com/roosebolton
 **/

public class PassWordMaker {

    /////////////////////////Attributes///////////////////////

    //Char array that excludes special characters that are better not used as first characters
    private char[] acnf =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','!','(',')','?','[',']','_','`','~',';',':','@','#','$','%','^','&','*','+','=','-','.'};

    //Char array that includes special characters
    private char[] acf =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','!','(',')','?','[',']','_','`','~',';',':','@','#','$','%','^','&','*','+','='};

    //Char array that does not include special characters
    private char[] nsc =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

    //Char array that does not include special characters and numbers
    private char[] nsnnc  = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    //Char array that excludes special characters that are better not used as first characters and exludes ambigious characters
    private char[] acnanf =  {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9','!','(',')','?','[',']','_','`','~',';',':','@','#','$','%','^','&','*','+','=','-','.'};

    //Char array that includes special character and excludes special characters
    private char[] acnaf =  {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9','!','(',')','?','[',']','_','`','~',';',':','@','#','$','%','^','&','*','+','='};

    //Char array that excludes spcecial characters and ambigious characters
    private char[] nsnac =  {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9'};

    //Char array that excludes special characters and numbers and ambigious characters
    private char[] nsnnnac  = {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z'};

    //Length of the acnf array
    private int acnflength = acnf.length;

    //aLength of the acf array
    private int acflength = acf.length;

    //Length of the nsc array
    private int nsclength = nsc.length;

    //Length of the nsnnc array
    private int nsnnclength = nsnnc.length;

    ///Length of the acnanf array
    private int acnanflength = acnanf.length;

    ///Length of the acnaf array
    private int acnaflength = acnaf.length;

    ///Length of the nsnac array
    private int nsnaclength = nsnac.length;

    ///Length of the nsnnnac array
    private int nsnnaclength = nsnnnac.length;
    /////////////////////////End of attributes///////////////////////



    /////////////////////////Constructors///////////////////////

    /**
     *Empty constructor
     **/
    public PassWordMaker(){
    }
    //checks if passwordlength is >8
    private boolean acceptableLength(int passwordlength)throws IllegalArgumentException{
        boolean result = true;
        if(passwordlength<8){
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }
        return result;
    }
    /////////////////////////End of Constructors///////////////////////


    /**
     * @param pwlength
     * @return Returns a char array for a password String that consists includes special characters
     * @throws IllegalArgumentException
     */
    private char[] allCharPassword(int pwlength)throws IllegalArgumentException{
        acceptableLength(pwlength);
        char[] output = new char[pwlength];
        int index1 = ThreadLocalRandom.current().nextInt(0,acflength);
        char firstChar = acf[index1];
        output[0] = firstChar;
        for(int i = 1; i<pwlength; i++){
            int index2 = ThreadLocalRandom.current().nextInt(0,acnflength);
            char nextChar = acnf[index2];
            output[i] = nextChar;
        }
        return output;
    }

    /**
     * @param pwlength
     * @return Returns a char array for a password String that consists excludes special characters
     * @throws IllegalArgumentException
     */
    private char[] nonCharPassword(int pwlength)throws IllegalArgumentException{
        acceptableLength(pwlength);
        char[] output = new char[pwlength];
        int index1 = ThreadLocalRandom.current().nextInt(0,nsclength);
        char firstChar = nsc[index1];
        output[0] = firstChar;
        for(int i = 1; i<pwlength; i++){
            int index2 = ThreadLocalRandom.current().nextInt(0,nsclength);
            char nextChar = nsc[index2];
            output[i] = nextChar;
        }
        return output;
    }

    /**
     * @param pwlength
     * @return Returns a char array for a password String that excludes special characters and numbers
     * @throws IllegalArgumentException
     */
    private char[] nonCharNonNumPassword(int pwlength)throws IllegalArgumentException{
        acceptableLength(pwlength);
        char[] output = new char[pwlength];
        int index1 = ThreadLocalRandom.current().nextInt(0,nsnnclength);
        char firstChar = nsnnc[index1];
        output[0] = firstChar;
        for(int i = 1; i<pwlength; i++){
            int index2 = ThreadLocalRandom.current().nextInt(0,nsnnclength);
            char nextChar = nsnnc[index2];
            output[i] = nextChar;
        }
        return output;
    }

    /**
     * @param pwlength
     * @return Returns a char array for a password String that excludes ambigious characters
     * @throws IllegalArgumentException
     */
    private char[] allCharsNonAmbPassword(int pwlength)throws IllegalArgumentException{
        acceptableLength(pwlength);
        char[] output = new char[pwlength];
        int index1 = ThreadLocalRandom.current().nextInt(0,acnaflength);
        char firstChar = acnaf[index1];
        output[0] = firstChar;
        for(int i = 1; i<pwlength; i++){
            int index2 = ThreadLocalRandom.current().nextInt(0,acnanflength);
            char nextChar = acnanf[index2];
            output[i] = nextChar;
        }
        return output;
    }

    /**
     * @param pwlength
     * @return Returns a char array for a password String that excludes ambigious characters and special characters
     * @throws IllegalArgumentException
     */
    private char[] nonCharNonAmbPassword(int pwlength)throws IllegalArgumentException{
        acceptableLength(pwlength);
        char[] output = new char[pwlength];
        int index1 = ThreadLocalRandom.current().nextInt(0,nsnaclength);
        char firstChar = nsnac[index1];
        output[0] = firstChar;
        for(int i = 1; i<pwlength; i++){
            int index2 = ThreadLocalRandom.current().nextInt(0,nsnaclength);
            char nextChar = nsnac[index2];
            output[i] = nextChar;
        }
        return output;
    }

    /**
     * @param pwlength
     * @return Returns a char array for a password String that excludes amnigious characters, special characters and numbers
     * @throws IllegalArgumentException
     */
    private char[] nonCharNonNumNonAmbPassword(int pwlength)throws IllegalArgumentException{
        acceptableLength(pwlength);
        char[] output = new char[pwlength];
        int index1 = ThreadLocalRandom.current().nextInt(0,nsnnaclength);
        char firstChar = nsnnnac[index1];
        output[0] = firstChar;
        for(int i = 1; i<pwlength; i++){
            int index2 = ThreadLocalRandom.current().nextInt(0,nsnnaclength);
            char nextChar = nsnnnac[index2];
            output[i] = nextChar;
        }
        return output;
    }

    /**
     * @param length
     * @return Returns a password String of given length >8 that includes special characters
     * @throws IllegalArgumentException
     */
    public String allCharactersPW(int length)throws
            IllegalArgumentException{
        char[] output = allCharPassword(length);
        return new String(output);
    }

    /**
     * @param length
     * @return Returns a password String of given length >8 that ecxludes special characters
     * @throws IllegalArgumentException
     */
    public String nonCharPasswordPW(int length)throws
            IllegalArgumentException{
        char[] output = allCharPassword(length);
        return new String(output);
    }

    /**
     * @param length
     * @return Returns a password String of given length >8 that excludes special characters and numbers
     * @throws IllegalArgumentException
     */
    public String nonCharNonNumPasswordPW(int length)throws
            IllegalArgumentException{
        char[] output = nonCharNonNumPassword(length);
        return new String(output);
    }

    /**
     * @param length
     * @return Returns a password String of given length >8 that excludes ambigious characters
     * @throws IllegalArgumentException
     */
    public String allCharsNonAmbPW(int length)throws
            IllegalArgumentException{
        char[] output = allCharsNonAmbPassword(length);
        return new String(output);
    }

    /**
     * @param length
     * @return Returns a password String of given length >8 that excludes special and ambigious characters
     * @throws IllegalArgumentException
     */
    public String nonCharNonAmbPW(int length)throws
            IllegalArgumentException{
        char[] output = nonCharNonAmbPassword(length);
        return new String(output);
    }

    /**
     * @param length
     * @return Returns a password String of given length >8 that excludes special characters, numbers and ambigious characters
     * @throws IllegalArgumentException
     */
    public String nonCharNonNumNonAmbPW(int length)throws
            IllegalArgumentException{
        char[] output = nonCharNonNumNonAmbPassword(length);
        return new String(output);
    }

}
