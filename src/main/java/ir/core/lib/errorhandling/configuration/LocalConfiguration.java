package ir.core.lib.errorhandling.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class LocalConfiguration {


    @Value("${error-handling.locale}")
    private String locale;

    @Bean
    LocaleResolver localeResolver() {
        return new FixedLocaleResolver(locale == null ? Locale.forLanguageTag("en") : Locale.forLanguageTag(locale));
    }
}
