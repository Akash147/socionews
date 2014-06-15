package maxentclassifier;

import cc.mallet.pipe.Pipe;
import java.io.*;

import cc.mallet.types.Instance;
import cc.mallet.types.Token;
import cc.mallet.types.TokenSequence;
import java.util.regex.Pattern;

/**
 * Convert the text in each token in the token sequence in the data field to
 * lower case.
 *
 * @author Andrew McCallum <a
 * href="mailto:mccallum@cs.umass.edu">mccallum@cs.umass.edu</a>
 */

public class TokenSequenceProcess extends Pipe implements Serializable {

    private static final String negationWord
            = "([a-z]+n't)|never|nothing|nowhere|noone|none|havent|hasnt|hadnt|cant|couldnt|shouldnt|dont|wouldnt|wont|doesnt|didnt|isnt|arent|aint|rather|not|no|hardly|\\\\s*";
    private static final String clausePunctuation = "[.:;!?]";
    private static int weight = 5;
    public Instance pipe(Instance carrier) {
        TokenSequence ts = (TokenSequence) carrier.getData();
        boolean _NEG_flag = false;
        for (int i = 0; i < ts.size(); i++) {
            boolean weighted = false;
            Token t = ts.get(i);
            String each = t.getText();
            if (_NEG_flag) each += "_NEG";
            if (each.matches(negationWord)) _NEG_flag=true;
            else _NEG_flag = false;
            if (each.matches(CharSequence2CleanCharSequence.emoticon)) { each+="_EMO"; weighted=true; }
            if (each.matches(CharSequence2CleanCharSequence.Hashtag)) { each+="_TAG"; weighted=true; }
            
            if(weighted){
                for(int j=0; j<weight; j++)
                    each += each + " ";
            }
            t.setText(each);
        }

        return carrier;
    }

	// Serialization 
    private static final long serialVersionUID = 1;
    private static final int CURRENT_SERIAL_VERSION = 0;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(CURRENT_SERIAL_VERSION);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
    }

}
