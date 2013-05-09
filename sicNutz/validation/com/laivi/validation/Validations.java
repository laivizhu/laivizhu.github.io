package com.laivi.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.PARAMETER, ElementType.FIELD })
public @interface Validations {

	/**
	 * 必填字段验证规则
	 */
	public boolean required() default false;
	
	/**
	 * Email 验证规则
	 */
	public boolean email() default false;
	
	/**
	 * 帐号验证规则(字母开头，允许字母数字下划线)，常与字串长度验证规则混合使用
	 */
	public boolean account() default false;

	/**
	 * 字串必须为中文验证规则
	 */
	public boolean chinese() default false;
	
	/**
	 * 正则表达式验证规则
	 */
	public String regex() default "";
	
	/**
	 * 字符串最大、最小长度验证规则
	 */
	public int[] strLen() default {};
	
	/**
	 * 数值型数据取值范围区间验证规则，兼容 int、long、float、double
	 */
	public double[] limit() default {};
	
	/**
	 * 错误提示语
	 */
	public String errorMsg();
}
