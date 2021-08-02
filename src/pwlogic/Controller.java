package pwlogic;

public class Controller {

    //atributes
    private PassWordMaker passWordMaker = new PassWordMaker();

    public String getPassword(int pwLngth, boolean noSpec, boolean noNum, boolean noAmb){
        String answer = "";
        /////
        if(noSpec && noNum && noAmb){
            return passWordMaker.---(pwLngth);
        }
        /////
        if(!noSpec && noNum && noAmb){
            return passWordMaker.---(pwLngth);
        }
        //////
        if(!noSpec && !noNum && noAmb){
            return passWordMaker.---(pwLngth);
        }
        ///////
        if(!noSpec && !noNum && !noAmb){
            return passWordMaker.---(pwLngth);
        }
        ///////
        if(noSpec && !noNum && noAmb){
            return passWordMaker.---(pwLngth);

        }
        ///////
        if(noSpec && !noNum && !noAmb){
            return passWordMaker.---(pwLngth);
        }
        ///////
        if(noSpec && noNum && !noAmb){
            return passWordMaker.---(pwLngth);
        }
        ///////
        if(!noSpec && noNum && !noAmb){
            return passWordMaker.---(pwLngth);
        }

        return answer;
    };

}
