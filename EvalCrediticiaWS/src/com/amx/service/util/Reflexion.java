package com.amx.service.util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reflexion {

    static public int GETTER = 1;
    static public int SETTER = 2;

    static public List<Object> getObjetos(Object source) {

        Class clazz = source.getClass();

        Field[] fields = clazz.getDeclaredFields();

        List list = new ArrayList();

        for (Field f : fields) {

            if (f.getType() != Object.class && !f.getType().isPrimitive() && f.getType() != String.class) {

                Object obj = getValue(source, f);

                if (obj != null) {
                    list.add(obj);
                }
            }
        }

        return list;
    }

    public static Object getValue(Object parent, String strField) {

        return getValue(parent, strField, new Class[0], new Object[0]);
    }

    public static Object getValue(Object parent, Field f) {

        return getValue(parent, f.getName(), new Class[0], new Object[0]);
    }

    public static Object getValue(Object parent, String fieldName, Class[] parameterClazz, Object... args) {

        return invoke(parent, fieldName, GETTER, (parameterClazz.length == 0) ? new Class[0] : new Class[]{parameterClazz[0]}, args);
    }

    public static Method getMethod(Object source, String strName, int tipo, Class... param) {
        Method metodo = null;

        if (tipo == GETTER) {

            String nombMetodo = "get" + strName.substring(0, 1).toUpperCase() + strName.substring(1);

            metodo = getMetodo_(source.getClass(), nombMetodo, param);

            if (metodo == null) {

                nombMetodo = "is" + strName.substring(0, 1).toUpperCase() + strName.substring(1);
                metodo = getMetodo_(source.getClass(), nombMetodo, param);
            }

            if (metodo == null) {

                nombMetodo = strName;
                metodo = getMetodo_(source.getClass(), nombMetodo, param);
            }
        } else {

            String nombMetodo = "set" + strName.substring(0, 1).toUpperCase() + strName.substring(1);
            metodo = getMetodo_(source.getClass(), nombMetodo, param);
        }

        return metodo;
    }

    public static Method getMethod(Object source, Field field, int tipo, Class... param) {

        return getMethod(source, field.getName(), tipo, param);
    }

    private static Method getMetodo_(Class clase, String nombre, Class... param) {

        Method m = null;

        try {

            m = clase.getMethod(nombre, param);
        } catch (Exception ex) {
            //ex.printStackTrace();
            m = null;
        }

        try {

            if (m == null) {

                Method[] metodos = clase.getDeclaredMethods();

                for (Method method : metodos) {

                    if (method.getName().equals(nombre) && method.getParameterTypes().length == param.length) {

                        m = method;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            m = null;
        }

        return m;
    }

    public static void setValue(Object target, String strField, Object[] paramValue) {
        setValue(target, strField, (paramValue.length > 0) ? new Class[]{paramValue[0].getClass()} : new Class[0], paramValue);
    }

    public static void setValue(Object target, String strField, Class[] clazz, Object... paramValue) {
        Object invoke = invoke(target, strField, SETTER, clazz, paramValue);
    }

    public static Object invoke(Object parent, String strField, int tipo, Class[] parameterClass, Object... args) {
        Field field = null;
        Method obj = null;
        Object retorno = null;

        try {
            if (strField.indexOf(".") != -1) {

                String strField_ = strField.substring(0, strField.indexOf("."));

                obj = getMethod(parent, strField_, GETTER, new Class[0]);

                retorno = invoke(obj.invoke(parent, new Object[0]), strField.substring(strField.indexOf(".") + 1, strField.length()), tipo, parameterClass, args);

            } else {

                obj = getMethod(parent, strField, tipo, parameterClass);
                retorno = obj.invoke(parent, args);
            }
        } catch (Exception ex) {
            Logger.getLogger(Reflexion.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

        return retorno;
    }

    static public Field getField(Object obj, String field) throws Exception {

        Field f = null;

        if (!field.contains(".")) {

            try {
                f = obj.getClass().getDeclaredField(field);
            } catch (Exception ex) {
            }

            if (f == null) {
                f = obj.getClass().getSuperclass().getDeclaredField(field);
            }

        } else {

            String[] spl = field.split("\\.");

            for (int a = 0; a < spl.length; a++) {

                try {
                    f = obj.getClass().getDeclaredField(spl[a]);
                } catch (Exception ex) {
                }

                if (f == null) {
                    f = obj.getClass().getSuperclass().getDeclaredField(spl[a]);
                }

                if (a < spl.length - 1) {
                    obj = f.getType().newInstance();
                    f = null;
                }
            }
        }

        return f;
    }
}
