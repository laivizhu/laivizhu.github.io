package com.laivi.basic.mirror;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class Mirrors {

	public static Field[] getFields(Class<?> klass,boolean noStatic, boolean noMember, boolean noFinal, boolean noInner){
		Class<?> cc=klass;
		Map<String, Field> map = new LinkedHashMap<String, Field>();
        while (null != cc && cc != Object.class) {
            Field[] fs = cc.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                int m = f.getModifiers();
                if (noStatic && Modifier.isStatic(m))
                    continue;
                if (noFinal && Modifier.isFinal(m))
                    continue;
                if (noInner && f.getName().startsWith("this$"))
                    continue;
                if (noMember && !Modifier.isStatic(m))
                    continue;
                if (map.containsKey(fs[i].getName()))
                    continue;

                map.put(fs[i].getName(), fs[i]);
            }
            cc = cc.getSuperclass();
        }
        return map.values().toArray(new Field[map.size()]);
	}
	
	public static Field[] getFields(Class<?> klass){
		return Mirrors.getFields(klass, true, false, true, true);
	}
}
