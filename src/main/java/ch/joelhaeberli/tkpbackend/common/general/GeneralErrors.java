package ch.joelhaeberli.tkpbackend.common.general;

import java.lang.reflect.Field;

public class GeneralErrors {

    // String must be the same as the name
    public static final String COULD_NOT_SAVE_PICTURE = "COULD_NOT_SAVE_PICTURE";
    public static final String COULD_NOT_LOAD_PICTURE = "COULD_NOT_LOAD_PICTURE";

    public static boolean isError(String s) {
        Field[] fields = GeneralErrors.class.getFields();
        boolean isErr = false;
        for (int i = 0; i < fields.length - 1; i++) {
            if (fields[i].getName().contains(s)) {
                isErr = true;
            }
        }
        return isErr;
    }
}
