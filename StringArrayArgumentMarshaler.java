import static ArgsException.ErrorCode.*;

import java.util.Iterator;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler { 
private String stringValue = "";
    
    public void set(Iterator<String> currentArgument) throws ArgsException { 
        String parameter = null;
    try {
        stringValue = currentArgument.next();
    } catch (NoSuchElementException e) {
        throw new ArgsException(INVALID_ARGUMENT_NAME);
    } catch (NumberFormatException e) {
        throw new ArgsException(INVALID_ARGUMENT_FORMAT, parameter); }
    }
    public static String getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArrayArgumentMarshaler) {
            return ((StringArrayArgumentMarshaler) am).stringValue;
        } else {
            return "";
        }
    }
}