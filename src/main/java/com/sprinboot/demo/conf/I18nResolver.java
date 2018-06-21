package com.sprinboot.demo.conf;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class I18nResolver implements LocaleResolver{

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String locale = httpServletRequest.getParameter("l");
        Locale localeobj=Locale.getDefault();
       if (!StringUtils.isEmpty(locale)){
           String[] split = locale.split("_");
           localeobj = new Locale(split[0],split[1]);
       }

        return localeobj;

    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
