package com.uam.microservices.books.utils;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZoneId;
import java.util.Locale;

public class Constantes implements Serializable {

    @Serial
    private static final long serialVersionUID = 450523432343613423L;
    public static final Locale LOCALE_MX = new Locale("es", "MX");
    public static final ZoneId TIME_ZONE_MX = ZoneId.of("UTC-06:00");
    public static final String MENSAJE_ERROR_REQUIRED = "Se requiere el campo:%s";
    public static final String MENSAJE_ERROR_EXIST = "Ya existe un registro para el id:%s";
    public static final String MENSAJE_ERROR_NOT_EXIST = "No existe un registro %s";
    public static final String MENSAJE_ERROR_NOT_SAVE = "No se pudo guardar el registro";
    public static final String MENSAJE_ERROR_NOT_UPDATE = "No se puede actualizar el registro";
    public static final String MENSAJE_ERROR_NOT_DELETE = "No se puede eliminar el registro";
    public static final String MENSAJE_ERROR_NO_MORE_BOOKS = "No hay más libros que prestar";



}
