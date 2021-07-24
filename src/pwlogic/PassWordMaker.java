package pwlogic;

import java.util.concurrent.ThreadLocalRandom;

public class PassWordMaker {
    //all chars non first
    private char[] acnf =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','!','(',')','?','[',']','_','`','~',';',':','@','#','$','%','^','&','*','+','=','-','.'};

    //all chars first
    private char[] acf =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','!','(',')','?','[',']','_','`','~',';',':','@','#','$','%','^','&','*','+','='};

    //non special characters
    private char[] nsc =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

    //non special non num chars
    private char[] nsnnc  = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    //allCharsNonAmbNonFirst
    private char[] acnanf =  {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9','!','(',')','?','[',']','_','`','~',';',':','@','#','$','%','^','&','*','+','=','-','.'};

    //allCharsNonAmbFirst
    private char[] acnaf =  {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9','!','(',')','?','[',']','_','`','~',';',':','@','#','$','%','^','&','*','+','='};

    //nonSpecNonAmbChars
    private char[] nsnac =  {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9'};

    //nonSpecNonNumNoneAmbChars
    private char[] nsnnnac  = {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z'};

    //all chars non first length
    private int acnflength = acnf.length;

    //all chars first length
    private int acflength = acf.length;

    //no chars length
    private int nsclength = nsc.length;

    //nonSpecNonNumLength
    private int nsnnclength = nsnnc.length;

    //allCharsNonAmbNonFirstlength
    private int acnanflength = acnanf.length;

    //allCharsNonAmbFirstLength
    private int acnaflength = acnaf.length;

    //nonSpecNonAmbCHarsLength
    private int nsnaclength = nsnac.length;

    //nonSpecialNonNumberNonAmbLength
    private int nsnnaclength = nsnnnac.length;

    //checks if passwordlength is >8
    private boolean acceptableLength(int passwordlength)throws IllegalArgumentException{
        boolean result = true;
        if(passwordlength<8){
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }
        return result;
    }


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

    public String allCharactersPW(int length)throws
            IllegalArgumentException{
        char[] output = allCharPassword(length);
        return new String(output);
    }

    public String nonCharPasswordPW(int length)throws
            IllegalArgumentException{
        char[] output = allCharPassword(length);
        return new String(output);
    }

    public String nonCharNonNumPasswordPW(int length)throws
            IllegalArgumentException{
        char[] output = nonCharNonNumPassword(length);
        return new String(output);
    }

    public String allCharsNonAmbPW(int length)throws
            IllegalArgumentException{
        char[] output = allCharsNonAmbPassword(length);
        return new String(output);
    }

    public String nonCharNonAmbPW(int length)throws
            IllegalArgumentException{
        char[] output = nonCharNonAmbPassword(length);
        return new String(output);
    }

    public String nonCharNonNumNonAmbPW(int length)throws
            IllegalArgumentException{
        char[] output = nonCharNonNumNonAmbPassword(length);
        return new String(output);
    }

}
