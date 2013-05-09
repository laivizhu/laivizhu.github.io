package com.laivi.validation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.nutz.lang.Mirror;
import org.nutz.lang.Strings;

public class AnnotationValidation implements Validation {

	@Override
	public void validate(Object target)throws Exception {
		if (null == target) {
			return;
		}
		// 遍历对象的所有字段
		Mirror<?> mirror = Mirror.me(target.getClass());
		Field[] fields = mirror.getFields(Validations.class);
		for (Field field : fields) {
			// 检查该字段是否声明了需要验证
			Validations vals = field.getAnnotation(Validations.class);
			String errMsg = vals.errorMsg();
			try {
				Method getMethod = mirror.getGetter(field);

				Object value = getMethod.invoke(target, new Object[]{}); // 这个对象字段get方法的值
				
				// 验证该字段是否必须
				if (vals.required() && !ValidationUtil.required(field.getName(), value, errMsg)) {
					continue;
				}
				
				// 账号验证
				if (vals.account() && !ValidationUtil.account(field.getName(), value, errMsg)) {
					continue;
				}
				
				// 验证是否为 email
				if (vals.email() && !ValidationUtil.email(field.getName(), value, errMsg)) {
					continue;
				}
				
				// 必须为中文效验
				if (vals.chinese() && !ValidationUtil.chinese(field.getName(), value, errMsg)) {
					continue;
				}
				
				// 验证正则表达式
				if (!Strings.isBlank(vals.regex())
					&& !ValidationUtil.regex(field.getName(), value, vals.regex(), errMsg)) {
					continue;
				}
				
				// 验证该字段长度
				if (vals.strLen().length > 0
					&& !ValidationUtil.stringLength(field.getName(), value, vals.strLen(), errMsg)) {
					continue;
				}
				
				// 判断指定值是否在某个区间
				if (vals.limit().length > 0
					&& !ValidationUtil.limit(field.getName(), value, vals.limit(), errMsg)) {
					continue;
				}
				
			}catch(Exception e){
				throw new Exception(e.getMessage());
			}
			
		}
	}

}
