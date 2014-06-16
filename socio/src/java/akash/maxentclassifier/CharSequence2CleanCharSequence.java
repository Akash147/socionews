/* Copyright (C) 2002 Univ. of Massachusetts Amherst, Computer Science Dept.
 This file is part of "MALLET" (MAchine Learning for LanguagE Toolkit).
 http://www.cs.umass.edu/~mccallum/mallet
 This software is provided under the terms of the Common Public License,
 version 1.0, as published by http://www.opensource.org.  For further
 information, see the file `LICENSE' included with this distribution. */
package akash.maxentclassifier;

import cc.mallet.pipe.Pipe;
import java.io.*;

import cc.mallet.types.Instance;
import cc.mallet.types.Token;
import cc.mallet.types.TokenSequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Convert the text in each token in the token sequence in the data field to
 * lower case.
 *
 * @author Andrew McCallum <a
 * href="mailto:mccallum@cs.umass.edu">mccallum@cs.umass.edu</a>
 */

public class CharSequence2CleanCharSequence extends Pipe implements Serializable {

    public Instance pipe(Instance carrier) {
        CharSequence string = (CharSequence) carrier.getData();
        String cleanString = "";
        List<String> tokens = tokenize(string.toString());
        for(String token : tokens)
            cleanString += token + " ";
        cleanString = cleanString.substring(0, cleanString.length()-1);
        carrier.setData(cleanString);
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

    static Pattern Contractions = Pattern.compile("(?i)(\\w+)(n['’′]t|['’′]ve|['’′]ll|['’′]d|['’′]re|['’′]s|['’′]m)$");
    static Pattern Whitespace = Pattern.compile("[\\s\\p{Zs}]+");

    static String punctChars = "['\"“”‘’.?!…,:;]";
    static String punctSeq = "['\"“”‘’]+|[.?!,…]+|[:;]+";
    static String entity = "&(?:amp|lt|gt|quot);";

    //  URLs
    static String urlStart1 = "(?:https?://|\\bwww\\.)";
    static String commonTLDs = "(?:com|org|edu|gov|net|mil|aero|asia|biz|cat|coop|info|int|jobs|mobi|museum|name|pro|tel|travel|xxx)";
    static String ccTLDs = "(?:ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|"
            + "bv|bw|by|bz|ca|cc|cd|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cs|cu|cv|cx|cy|cz|dd|de|dj|dk|dm|do|dz|ec|ee|eg|eh|"
            + "er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gg|gh|gi|gl|gm|gn|gp|gq|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|"
            + "hu|id|ie|il|im|in|io|iq|ir|is|it|je|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|"
            + "lu|lv|ly|ma|mc|md|me|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|"
            + "nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|"
            + "sl|sm|sn|so|sr|ss|st|su|sv|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|us|uy|uz|"
            + "va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|za|zm|zw)";	//TODO: remove obscure country domains?
    static String urlStart2 = "\\b(?:[A-Za-z\\d-])+(?:\\.[A-Za-z0-9]+){0,3}\\." + "(?:" + commonTLDs + "|" + ccTLDs + ")" + "(?:\\." + ccTLDs + ")?(?=\\W|$)";
    static String urlBody = "(?:[^\\.\\s<>][^\\s<>]*?)?";
    static String urlExtraCrapBeforeEnd = "(?:" + punctChars + "|" + entity + ")+?";
    static String urlEnd = "(?:\\.\\.+|[<>]|\\s|$)";
    public static String url = "(?:" + urlStart1 + "|" + urlStart2 + ")" + urlBody + "(?=(?:" + urlExtraCrapBeforeEnd + ")?" + urlEnd + ")";

    // Numeric
    static String timeLike = "\\d+(?::\\d+){1,2}";
    static String numberWithCommas = "(?:(?<!\\d)\\d{1,3},)+?\\d{3}" + "(?=(?:[^,\\d]|$))";
    static String numComb = "\\p{Sc}?\\d+(?:\\.\\d+)+%?";

    // Abbreviations
    static String boundaryNotDot = "(?:$|\\s|[“\\u0022?!,:;]|" + entity + ")";
    static String aa1 = "(?:[A-Za-z]\\.){2,}(?=" + boundaryNotDot + ")";
    static String aa2 = "[^A-Za-z](?:[A-Za-z]\\.){1,}[A-Za-z](?=" + boundaryNotDot + ")";
    static String standardAbbreviations = "\\b(?:[Mm]r|[Mm]rs|[Mm]s|[Dd]r|[Ss]r|[Jj]r|[Rr]ep|[Ss]en|[Ss]t)\\.";
    static String arbitraryAbbrev = "(?:" + aa1 + "|" + aa2 + "|" + standardAbbreviations + ")";
    static String separators = "(?:--+|―|—|~|–|=)";
    static String decorations = "(?:[♫♪]+|[★☆]+|[♥❤♡]+|[\\u2639-\\u263b]+|[\\ue001-\\uebbb]+)";
    static String thingsThatSplitWords = "[^\\s\\.,?\"]";
    static String embeddedApostrophe = thingsThatSplitWords + "+['’′]" + thingsThatSplitWords + "*";

    public static String OR(String... parts) {
        String prefix = "(?:";
        StringBuilder sb = new StringBuilder();
        for (String s : parts) {
            sb.append(prefix);
            prefix = "|";
            sb.append(s);
        }
        sb.append(")");
        return sb.toString();
    }

    //  Emoticons
    static String normalEyes = "(?iu)[:=]"; // 8 and x are eyes but cause problems
    static String wink = "[;]";
    static String noseArea = "(?:|-|[^a-zA-Z0-9 ])"; // doesn't get :'-(
    static String happyMouths = "[D\\)\\]\\}]+";
    static String sadMouths = "[\\(\\[\\{]+";
    static String tongue = "[pPd3]+";
    static String otherMouths = "(?:[oO]+|[/\\\\]+|[vV]+|[Ss]+|[|]+)"; // remove forward slash if http://'s aren't cleaned

    static String bfLeft = "(♥|0|o|°|v|\\$|t|x|;|\\u0CA0|@|ʘ|•|・|◕|\\^|¬|\\*)";
    static String bfCenter = "(?:[\\.]|[_-]+)";
    static String bfRight = "\\2";
    static String s3 = "(?:--['\"])";
    static String s4 = "(?:<|&lt;|>|&gt;)[\\._-]+(?:<|&lt;|>|&gt;)";
    static String s5 = "(?:[.][_]+[.])";
    static String basicface = "(?:(?i)" + bfLeft + bfCenter + bfRight + ")|" + s3 + "|" + s4 + "|" + s5;

    static String eeLeft = "[＼\\\\ƪԄ\\(（<>;ヽ\\-=~\\*]+";
    static String eeRight = "[\\-=\\);'\\u0022<>ʃ）/／ノﾉ丿╯σっµ~\\*]+";
    static String eeSymbol = "[^A-Za-z0-9\\s\\(\\)\\*:=-]";
    static String eastEmote = eeLeft + "(?:" + basicface + "|" + eeSymbol + ")+" + eeRight;

    public static String emoticon = OR(
            // Standard version  :) :( :] :D :P
            "(?:>|&gt;)?" + OR(normalEyes, wink) + OR(noseArea, "[Oo]")
            + OR(tongue + "(?=\\W|$|RT|rt|Rt)", otherMouths + "(?=\\W|$|RT|rt|Rt)", sadMouths, happyMouths),
            // reversed version (: D:  use positive lookbehind to remove "(word):"
            // because eyes on the right side is more ambiguous with the standard usage of : ;
            "(?<=(?: |^))" + OR(sadMouths, happyMouths, otherMouths) + noseArea + OR(normalEyes, wink) + "(?:<|&lt;)?",
            eastEmote.replaceFirst("2", "1"), basicface
    );

    static String Hearts = "(?:<+/?3+)+"; //the other hearts are in decorations

    static String Arrows = "(?:<*[-―—=]*>+|<+[-―—=]*>*)|\\p{InArrows}+";

    // If you want good hashtag identification, use a different regex.
    static String Hashtag = "#[a-zA-Z0-9_]+";  //optional: lookbehind for \b
    static Pattern HashtagPattern = Pattern.compile(Hashtag);

//optional: lookbehind for \b, max length 15
    static String AtMention = "[@＠][a-zA-Z0-9_]+";

    // I was worried this would conflict with at-mentions
    // but seems ok in sample of 5800: 7 changes all email fixes
    // http://www.regular-expressions.info/email.html
    static String Bound = "(?:\\W|^|$)";
    public static String Email = "(?<=" + Bound + ")[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}(?=" + Bound + ")";

    // Additionally, these things are "protected", meaning they shouldn't be further split themselves.
    static Pattern Protected = Pattern.compile(
            OR(
                    Hearts,
                    url,
                    Email,
                    timeLike,
                    //numNum,
                    numberWithCommas,
                    numComb,
                    emoticon,
                    Arrows,
                    entity,
                    punctSeq,
                    arbitraryAbbrev,
                    separators,
                    decorations,
                    embeddedApostrophe,
                    Hashtag,
                    AtMention
            ));

    // Note the 'smart quotes' (http://en.wikipedia.org/wiki/Smart_quotes)
    static String edgePunctChars = "'\"“”‘’«»{}\\(\\)\\[\\]\\*&"; //add \\p{So}? (symbols)
    static String edgePunct = "[" + edgePunctChars + "]";
    static String notEdgePunct = "[a-zA-Z0-9]"; // content characters
    static String offEdge = "(^|$|:|;|\\s|\\.|,)";  // colon here gets "(hello):" ==> "( hello ):"
    static Pattern EdgePunctLeft = Pattern.compile(offEdge + "(" + edgePunct + "+)(" + notEdgePunct + ")");
    static Pattern EdgePunctRight = Pattern.compile("(" + notEdgePunct + ")(" + edgePunct + "+)" + offEdge);

    public static String splitEdgePunct(String input) {
        Matcher m1 = EdgePunctLeft.matcher(input);
        input = m1.replaceAll("$1$2 $3");
        m1 = EdgePunctRight.matcher(input);
        input = m1.replaceAll("$1 $2$3");
        return input;
    }

    /* Some Extras */
    public static String removeLinks(String text) {
        return text.replaceAll(url, "");
    }

    public static String removeAtMentions(String text) {
        return text.replaceAll(AtMention, "");
    }

    public static String removeRT(String text) {
        return text.replaceAll("rt", "");
    }
    /* End of Some Extras*/

    private static class Pair<T1, T2> {

        public T1 first;
        public T2 second;

        public Pair(T1 x, T2 y) {
            first = x;
            second = y;
        }
    }

    // The main work of tokenizing a tweet.
    private static List<String> simpleTokenize(String text) {

        // Do the no-brainers first
        String splitPunctText = splitEdgePunct(text);

        int textLength = splitPunctText.length();

        Matcher matches = Protected.matcher(splitPunctText);

        List<List<String>> bads = new ArrayList<List<String>>();	//linked list?
        List<Pair<Integer, Integer>> badSpans = new ArrayList<Pair<Integer, Integer>>();
        while (matches.find()) {
            // The spans of the "bads" should not be split.
            if (matches.start() != matches.end()) { //unnecessary?
                List<String> bad = new ArrayList<String>(1);
                bad.add(splitPunctText.substring(matches.start(), matches.end()));
                bads.add(bad);
                badSpans.add(new Pair<Integer, Integer>(matches.start(), matches.end()));
            }
        }

        // Create a list of indices to create the "goods", which can be
        // split. We are taking "bad" spans like 
        //     List((2,5), (8,10)) 
        // to create 
        ///    List(0, 2, 5, 8, 10, 12)
        // where, e.g., "12" here would be the textLength
        // has an even length and no indices are the same
        List<Integer> indices = new ArrayList<Integer>(2 + 2 * badSpans.size());
        indices.add(0);
        for (Pair<Integer, Integer> p : badSpans) {
            indices.add(p.first);
            indices.add(p.second);
        }
        indices.add(textLength);

        // Group the indices and map them to their respective portion of the string
        List<List<String>> splitGoods = new ArrayList<List<String>>(indices.size() / 2);
        for (int i = 0; i < indices.size(); i += 2) {
            String goodstr = splitPunctText.substring(indices.get(i), indices.get(i + 1));
            List<String> splitstr = Arrays.asList(goodstr.trim().split(" "));
            splitGoods.add(splitstr);
        }

        //  Reinterpolate the 'good' and 'bad' Lists, ensuring that
        //  additonal tokens from last good item get included
        List<String> zippedStr = new ArrayList<String>();
        int i;
        for (i = 0; i < bads.size(); i++) {
            zippedStr = addAllnonempty(zippedStr, splitGoods.get(i));
            zippedStr = addAllnonempty(zippedStr, bads.get(i));
        }
        zippedStr = addAllnonempty(zippedStr, splitGoods.get(i));

        // BTO: our POS tagger wants "ur" and "you're" to both be one token.
        // Uncomment to get "you 're"
        /*ArrayList<String> splitStr = new ArrayList<String>(zippedStr.size());
         for(String tok:zippedStr)
         splitStr.addAll(splitToken(tok));
         zippedStr=splitStr;*/
        return zippedStr;
    }

    private static List<String> addAllnonempty(List<String> master, List<String> smaller) {
        for (String s : smaller) {
            String strim = s.trim();
            if (strim.length() > 0) {
                master.add(strim);
            }
        }
        return master;
    }

    /**
     * "foo bar " => "foo bar"
     */
    public static String squeezeWhitespace(String input) {
        return Whitespace.matcher(input).replaceAll(" ").trim();
    }

    // Final pass tokenization based on special patterns
    private static List<String> splitToken(String token) {

        Matcher m = Contractions.matcher(token);
        if (m.find()) {
            String[] contract = {m.group(1), m.group(2)};
            return Arrays.asList(contract);
        }
        String[] contract = {token};
        return Arrays.asList(contract);
    }

    /**
     * Assume 'text' has no HTML escaping. *
     */
    public static List<String> tokenize(String text) {
        return simpleTokenize(squeezeWhitespace(text));
    }

    /**
     * Negation Context Things are below Check n't not etc
     */
    private static final Pattern negationWord
            = Pattern.compile("([a-z]+n't)|never|nothing|nowhere|noone|none|havent|hasnt|hadnt|cant|couldnt|shouldnt|dont|wouldnt|wont|doesnt|didnt|isnt|arent|aint|rather|not|no|hardly|\\\\s*",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    private static final Pattern clausePunctuation = Pattern.compile("[.:;!?]");

    public static boolean isNegationWord(String text) {
        return negationWord.matcher(text).matches();
    }

    public static boolean isClauseLevelPunctuation(String text) {
        return clausePunctuation.matcher(text).matches();
    }

    // This function is called while tokenizing from the tokenization function
    // To add _NEG to the tokens which are effected by negationWords
    public static List<String> negateContext(String[] sentenceToken) {
        List<String> result = new ArrayList<String>();
        boolean _NEG_flag = false;
        for (String word : sentenceToken) {
            if (_NEG_flag) {
                result.add("_NEG");
            } else {
                result.add("");
            }

            if (isNegationWord(word)) {
                _NEG_flag = true;
            } else if (isClauseLevelPunctuation(word)) {
                _NEG_flag = false;
            }
        }
        return result;
    }

    // This function is called while tokenizing from the tokenization function
    // To add _EMO to tokens which are emoticons
    public static List<String> emoticonContext(String[] sentenceToken) {
        List<String> result = new ArrayList<String>();
        for (String word : sentenceToken) {
            if (word.matches(emoticon)) {
                result.add("_EMO");
            } else {
                result.add("");
            }
        }
        return result;
    }

    public static boolean isEmoticonContext(String text) {
        return text.endsWith("_EMO");
    }

    // This function is called while tokenizing from the tokenization function
    // To add _TAG to tokens which are hastags
    public static List<String> hashtagContext(String[] sentenceToken) {
        List<String> result = new ArrayList<String>();
        for (String word : sentenceToken) {
            if (word.matches(Hashtag)) {
                result.add("_TAG");
            } else {
                result.add("");
            }
        }
        return result;
    }

    public static boolean isHashtagContext(String text) {
        return text.endsWith("_TAG");
    }

}
