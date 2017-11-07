package com.neptune.itcenter.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private static final String DEFAULT_ISO8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";

    private final ObjectMapper MAPPER;

    public ObjectMapperContextResolver() {
        final SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_ISO8601_FORMAT);
        MAPPER = new ObjectMapper();
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        MAPPER.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        MAPPER.setDateFormat(sdf);
        MAPPER.setTimeZone(TimeZone.getTimeZone("UTC"));
        MAPPER.findAndRegisterModules();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return MAPPER;
    }
}