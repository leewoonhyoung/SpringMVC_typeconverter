package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {

    @Override
    public Number parse(String text, Locale locale) throws ParseException { //Number == integer double같은것.
        log.info("text={}, locale={}", text, locale);
        Number format  = NumberFormat.getInstance(locale).parse(text);
        //"1,000" = > 숫자 1000으로
        return format;
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}", object, locale);
        String result = NumberFormat.getInstance(locale).format(object);

        return result;
    }
}
