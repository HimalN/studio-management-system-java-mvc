package lk.ijse.shadowStudio.RegExPatterns;

import lombok.Getter;

import java.util.regex.Pattern;

public class RegExPatterns {
    @Getter
    public static final Pattern validName = Pattern.compile("([a-z]|[A-Z]){3,}");
    @Getter
    public static final Pattern validPassword = Pattern.compile("(.*?[0-9]){4,}");
    @Getter
    public static final Pattern validPhoneNumber = Pattern.compile("07\\d{8}");
    @Getter
    public static final Pattern validNic = Pattern.compile("^\\d{10,12}|\\d+[V]");
    @Getter
    public static final Pattern validAddress = Pattern.compile("([A-Z]|[a-z][0-9]){4,}");

    // @Getter
    //public static final Pattern validTime = Pattern.compile("(0?[1-9]|1[0-2]).[0-5][0-9](AM|PM|Am|Pm|am|pm)");
    //@Getter
    //public static final Pattern validDescriptions = Pattern.compile("([a-z]|[A-Z]){10,}");
    //@Getter
    //public static final Pattern validPackageType = Pattern.compile("(photography|Photography|videography|Videography)");
    //@Getter
    //public static final Pattern validPrice = Pattern.compile("([^-][\\d+]){4,}");
    //@Getter
    //public static final Pattern validDayCount = Pattern.compile("[0-9]");
    //@Getter
    //public static final Pattern validItemType = Pattern.compile("(Camera|camera|Lence|lence)");
}
