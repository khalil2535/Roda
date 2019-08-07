package util;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import static util.Statics.PROGRAM_FILES;
import static util.Statics.PROGRAM_FOLIDERS;

public class PreRun {

    public static void CheckAndPrepare() throws IOException {
        if (!isPrepared()) {
            if (JOptionPane.showConfirmDialog(
                    null, "هل تريد تثبيت البرنامج حقاً ؟") == JOptionPane.YES_OPTION) {
                prepare();
            } else {
                JOptionPane.showMessageDialog(null,
                        "آسف ولكن عليك أن تنصب البرنامج لتتمكن من استخدامه..");
                System.exit(0);
            }
        }
    }

    public static boolean isPrepared() {
        // check program foilders existance
        for (File file : PROGRAM_FOLIDERS) {
            if (!file.exists()) {
                return false;
            }
        }
        // check program files existance
        for (File file : PROGRAM_FILES) {
            if (!file.exists()) {
                return false;
            }
        }
        return true;
    }

    public static void prepare() throws IOException {
        // create non-exsisted foilders
        for (File file : PROGRAM_FOLIDERS) {
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        // create non-exsisted files
        for (File file : PROGRAM_FILES) {
            if (!file.exists()) {
                file.createNewFile();
            }
        }
        // TODO create first sheet in each of STUDENTS_FILE , ITEMS_FILE , COURSES_FILE
    }

    private PreRun() {
    }

}
