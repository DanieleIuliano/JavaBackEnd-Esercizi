package ListaIterable;

public class MiaStringa implements Iterabile{
    String miastring = "";
    static int contatore = 0;

    public MiaStringa(String miastring) {
        this.miastring = miastring;
    }

    @Override
    public Character next() {
        for (int i = 0; i < miastring.length(); i++) {
            if (contatore == i) {
                contatore++;
                return miastring.charAt(i);
            }
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        for (int i = 0; i < miastring.length(); i++){
            if(contatore < miastring.length()-1){
                return true;
            }
        }
        return false;
    }

    @Override
    public void reset() {
        contatore = 0;
    }
}
