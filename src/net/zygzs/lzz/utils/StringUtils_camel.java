package net.zygzs.lzz.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils_camel {

	/** 下划线_ */
	public static final char UNDERLINE = '_';

/*	public static void main( String[] args ){
		System.out.println( "驼峰转非驼峰： " + camelToUnderline( "StringStrStr1" ) );
		System.out.println( "驼峰转非驼峰： " + camel2Underline( "StringStrStr2" ) );
		System.out.println( "驼峰转非驼峰： " + camel2UnderLine( "StringStrStr3" ) );
		System.out.println( "转驼峰： " + underLine2Camel( "atring_str_str4" ) );
		System.out.println( "转驼峰： " + underline2Camel( "atring_str_str5" ) );
		System.out.println( "驼峰转非驼峰： " + camelToUnderline( "stringStrStr1" ) );
		System.out.println( "驼峰转非驼峰： " + camel2Underline( "stringStrStr2" ) );
		System.out.println( "驼峰转非驼峰： " + camel2UnderLine( "stringStrStr3" ) );
		System.out.println( "转驼峰： " + underLine2Camel( "_atring_str_str4" ) );
		System.out.println( "转驼峰： " + underline2Camel( "_atring_str_str5" ) );
	}*/

	/**
	 * 驼峰转非驼峰(所有的大写转成"_"+"小写")
	 * 
	 * @example 【StrIng】 返回【_str_ing】
	 * @param param
	 * @return
	 */
	public static String camelToUnderline( String strIng ){
		if (strIng == null || "".equals( strIng.trim() )) { return ""; }
		int len = strIng.length();
		StringBuilder sb = new StringBuilder( len );
		for (int i = 0; i < len; i++) {
			char c = strIng.charAt( i );
			if (Character.isUpperCase( c )) {
				sb.append( UNDERLINE );
				sb.append( Character.toLowerCase( c ) );
			} else {
				sb.append( c );
			}
		}
		return sb.toString();
	}

	/**
	 * 驼峰转下划线（正则）
	 * 
	 * @example 【strIng】 返回【str_ing】
	 * @param str
	 * @return
	 */
	public static String camel2Underline( String strIng ){
		String regexStr = "[A-Z]";
		Matcher matcher = Pattern.compile( regexStr ).matcher( strIng );
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String g = matcher.group();
			matcher.appendReplacement( sb, "_" + g.toLowerCase() );
		}
		matcher.appendTail( sb );
		if (sb.charAt( 0 ) == '_') {
			sb.delete( 0, 1 );
		}
		return sb.toString();
	}

	/**
	 * 驼峰转下划线
	 * 
	 * @example 【strIng】 返回【str_ing】
	 * @设计思路 
	 *       首先，进行一遍遍历，记录下每个大写字母的位置，第一个大写字母除外；然后，将字符串转换成为字符数组，将对应位置上的字母前加上下划线；最后，
	 *       将字符串数组进行拼接，大写字母位置的字符串替换成第二步中的字符串，完成。
	 * @param str
	 * @return
	 */
	public static String camel2UnderLine( String strIng ){
		List<Integer> record = new ArrayList<Integer>();
		for (int i = 0; i < strIng.length(); i++) {
			char tmp = strIng.charAt( i );
			if ((tmp <= 'Z') && (tmp >= 'A')) {
				record.add( i );// 记录每个大写字母的位置
			}
		}
		record.remove( 0 );// 第一个不需加下划线
		strIng = strIng.toLowerCase();
		char[] charofstr = strIng.toCharArray();
		String[] t = new String[record.size()];
		for (int i = 0; i < record.size(); i++) {
			t[i] = "_" + charofstr[(Integer) record.get( i )];// 加“_”
		}
		String result = "";
		int flag = 0;
		for (int i = 0; i < strIng.length(); i++) {
			if ((flag < record.size()) && (i == (Integer) record.get( flag ))) {
				result += t[flag];
				flag++;
			} else result += charofstr[i];
		}
		return result;
	}

	/**
	 * 下划线转驼峰
	 * 
	 * @example 【str_ing】 返回【 strIng】
	 * @example 【_str_ing】 返回【 StrIng】
	 * @param param
	 * @return
	 */
	public static String underLine2Camel( String str_ing ){
		if (str_ing == null || "".equals( str_ing.trim() )) { return ""; }
		int len = str_ing.length();
		StringBuilder sb = new StringBuilder( len );
		for (int i = 0; i < len; i++) {
			char c = str_ing.charAt( i );
			if (c == UNDERLINE) {
				if (++i < len) {
					sb.append( Character.toUpperCase( str_ing.charAt( i ) ) );
				}
			} else {
				sb.append( c );
			}
		}
		return sb.toString();
	}

	/**
	 * 下划线转驼峰
	 * 
	 * @example 【str_ing】 返回【 strIng】
	 * @example 【_str_ing】 返回【 StrIng】
	 * @param param
	 * @return
	 */
	public static String underline2Camel( String str_ing ){
		if (str_ing == null || "".equals( str_ing.trim() )) { return ""; }
		StringBuilder sb = new StringBuilder( str_ing );
		Matcher mc = Pattern.compile( "_" ).matcher( str_ing );
		int i = 0;
		while (mc.find()) {
			int position = mc.end() - (i++);
			sb.replace( position - 1, position + 1, sb.substring( position, position + 1 ).toUpperCase() );
		}
		return sb.toString();
	}

	/**
	 * 
	 * 方法作用：将字符串分割成数组(默认分割条件",")
	 * 
	 * @param string 需要被分割的字符串
	 * @return 分割后的数组
	 * @Author: 刘泽中
	 * @Date: 2015年12月16日 下午12:58:07
	 */
	public static String[] str2Array( String string ){
		return str2Array( string, "," );
	}

	/**
	 * 
	 * 方法作用：将字符串分割成数组
	 * 
	 * @param string 需要被分割的字符串
	 * @param str 分割条件
	 * @return 分割后的数组
	 * @Author: 刘泽中
	 * @Date: 2015年12月16日 下午12:54:58
	 */
	public static String[] str2Array( String string, String str ){
		if (string != null && string.length() > 0) {
			return string.split( str );
		} else {
			return null;
		}
	}
}
