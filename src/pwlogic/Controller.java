package pwlogic;

public class Controller {

    //atributes
    private PassWordMaker passWordMaker = new PassWordMaker();

    private String getPW(int pwLngth, boolean noSpec, boolean noNum, boolean noAmb){
        String answer = "";
        /////no special characters, no numbers and no ambigious chars
        if(noSpec && noNum && noAmb){
            return passWordMaker.nonCharNonNumNonAmbPW(pwLngth);
        }
        /////no Numbers, no ambigious, includes special characters
        if(!noSpec && noNum && noAmb){
            return passWordMaker.allCharNoNumNoAmbPW(pwLngth);
        }
        /////No ambigious characters
        if(!noSpec && !noNum && noAmb){
            return passWordMaker.allCharsNonAmbPW(pwLngth);
        }
        ///////All characters
        if(!noSpec && !noNum && !noAmb){
            return passWordMaker.allCharactersPW(pwLngth);
        }
        ///////no special characters, no ambigious characters, inlcudes numbers
        if(noSpec && !noNum && noAmb){
            return passWordMaker.nonCharNonAmbPW(pwLngth);

        }
        ///////no special characters
        if(noSpec && !noNum && !noAmb){
            return passWordMaker.nonCharPasswordPW(pwLngth);
        }
        ///////no special characters, no numbers, includes ambigious characters
        if(noSpec && noNum && !noAmb){
            return passWordMaker.nonCharNonNumPasswordPW(pwLngth);
        }
        ///////no numbers
        if(!noSpec && noNum && !noAmb){
            return passWordMaker.noNumberPW(pwLngth);
        }

        return answer;
    };

    public String getPassword(int pwLngth, boolean noSpec, boolean noNum, boolean noAmb){
        return getPW(pwLngth,noSpec,noNum,noAmb);
    }

}
