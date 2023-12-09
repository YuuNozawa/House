package smartrc.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private final MessageSource ms;

    @Autowired
    public MessageService(MessageSource ms) {
        this.ms = ms;
        LocaleContextHolder.setLocale(Locale.JAPAN);
    }

    public void setMessage() {
        if( LocaleContextHolder.getLocale() == Locale.JAPAN ) {
            LocaleContextHolder.setLocale(Locale.ENGLISH);
            return;
        }
        LocaleContextHolder.setLocale(Locale.JAPAN);
    }

    public String getMessage(String code, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return ms.getMessage(code, args, locale);
    }
    
}
