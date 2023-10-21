package application;
import java.util.regex.Pattern;
public class ValidaSenha{
    public static final String PASSWORD_REGEX =
            "^(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{4,8}$";
 
    public static final String COMPLEX_PASSWORD_REGEX =
            "^(?:(?=.\\d)(?=.[A-Z])(?=.*[a-z])|" +
            "(?=.\\d)(?=.[^A-Za-z0-9])(?=.*[a-z])|" +
            "(?=.[^A-Za-z0-9])(?=.[A-Z])(?=.*[a-z])|" +
            "(?=.\\d)(?=.[A-Z])(?=.[^A-Za-z0-9]))(?!.(.)\\1{2,})" +
            "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
            "{8,32}$";
 
    public static final Pattern PASSWORD_PATTERN =
                                    Pattern.compile(COMPLEX_PASSWORD_REGEX);
}