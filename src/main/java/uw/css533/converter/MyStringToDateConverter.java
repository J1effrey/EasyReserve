package uw.css533.converter;

import org.apache.shiro.util.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yifei yang
 */
public class MyStringToDateConverter implements Converter<String, Date> {
    private static final String DATE_FORMAT_HYPHEN = "yyyy-MM-dd";
    private static final String DATE_FORMAT_SLASH = "yyyy/MM/dd";
    private static final String TIME_FORMAT = "HH:mm:ss";

    @Override
    public Date convert(String source) {
        if ("".equals(source)) {
            return null;
        }
        source = source.trim();
        try {
            SimpleDateFormat format = null;
            if (source.contains("-")) {
                format = new SimpleDateFormat(DATE_FORMAT_HYPHEN);
            } else if (source.contains("/")) {
                format = new SimpleDateFormat(DATE_FORMAT_SLASH);
            } else if (source.contains(":")) {
                format = new SimpleDateFormat(TIME_FORMAT);
            }
            if (format != null) {
                format.parse(source);
            }
        } catch (ParseException e) {
            throw new RuntimeException(String.format(("Parser %s to Date fail"), source));
        }

        throw new RuntimeException(String.format(("Parser %s to Date fail"), source));
    }
}
