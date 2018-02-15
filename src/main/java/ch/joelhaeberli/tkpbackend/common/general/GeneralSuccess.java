package ch.joelhaeberli.tkpbackend.common.general;

import java.lang.reflect.Field;

public class GeneralSuccess {

    public static final String PICTURE_SAVED_SUCCESSFUL = "PICTURE_SAVED_SUCCESSFUL";
    public static final String DELETING_PICTURE_SUCCESSFUL = "DELETING_PICTURE_SUCCESSFUL";

    public static boolean isSuccess(String s) {
        Field[] fields = GeneralErrors.class.getFields();
        boolean isSuccess = false;
        for (int i = 0; i < fields.length - 1; i++) {
            if (fields[i].getName().contains(s)) {
                isSuccess = true;
            }
        }
        return isSuccess;
    }
}
