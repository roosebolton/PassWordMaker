package pwlogic;

/**
 * Controller class for implementing MVC pattern with Passwordmaker(model) and App(view)
 * @author roosebolton github.com/roosebolton
 **/
public class Controller {

    //////////////////////////Attributes/////////////////////////////////////////////
    private PassWordMaker passWordMaker;
    //////////////////////////End of attributes//////////////////////////////////////


    //////////////////////////Controller//////////////////////////////////////////////
    public Controller(PassWordMaker passWordMaker){
      this.passWordMaker = passWordMaker;
    }
    //////////////////////////End of controller///////////////////////////////////////

    //////////////////////////Private methods/////////////////////////////////////////
    /**
     *
     * @param pwLngth
     * @param noSpec
     * @param noNum
     * @param noAmb
     * @return Returns a string with a password of requested length and with or without special characters, numbers, ambiguous characters
     */
    private String getPW(int pwLngth, boolean noSpec, boolean noNum, boolean noAmb){
        String answer = "";
        /////no special characters, no numbers and no ambiguous chars
        if(noSpec && noNum && noAmb){
            return passWordMaker.nonCharNonNumNonAmbPW(pwLngth);
        }
        /////no Numbers, no ambiguous, includes special characters
        if(!noSpec && noNum && noAmb){
            return passWordMaker.allCharNoNumNoAmbPW(pwLngth);
        }
        /////No ambiguous characters
        if(!noSpec && !noNum && noAmb){
            return passWordMaker.allCharsNonAmbPW(pwLngth);
        }
        ///////All characters
        if(!noSpec && !noNum && !noAmb){
            return passWordMaker.allCharactersPW(pwLngth);
        }
        ///////no special characters, no ambiguous characters, includes numbers
        if(noSpec && !noNum && noAmb){
            return passWordMaker.nonCharNonAmbPW(pwLngth);
        }
        ///////no special characters
        if(noSpec && !noNum && !noAmb){
            return passWordMaker.nonCharPasswordPW(pwLngth);
        }
        ///////no special characters, no numbers, includes ambiguous characters
        if(noSpec && noNum && !noAmb){
            return passWordMaker.nonCharNonNumPasswordPW(pwLngth);
        }
        ///////no numbers
        if(!noSpec && noNum && !noAmb){
            return passWordMaker.noNumberPW(pwLngth);
        }

        return answer;
    };
    //////////////////////////End of private methods/////////////////////////////////

    //////////////////////////Public methods/////////////////////////////////////////
    /**
     *
     * @param pwLngth Length of password
     * @param noSpec No special characters
     * @param noNum No numbers
     * @param noAmb No ambiguous characters
     * @return Returns a string with a password of requested length and with or without special characters, numbers, ambiguous characters
     */
    public String getPassword(int pwLngth, boolean noSpec, boolean noNum, boolean noAmb){
        return getPW(pwLngth,noSpec,noNum,noAmb);
    }
    //////////////////////////End of public methods/////////////////////////////////////////

}
