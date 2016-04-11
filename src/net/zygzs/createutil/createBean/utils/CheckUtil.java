package net.zygzs.createutil.createBean.utils;

import java.util.regex.Pattern;

public class CheckUtil {

	/**
	 * 
	 * TODO 方法作用： 格式验证 str：需要验证的字符串 format ：正则表达式
	 * 
	 * @param str
	 *            需要验证的字符串
	 * @param format
	 *            正则表达式
	 * @return
	 * @Author: 刘泽中
	 * @Date: 2015-5-28 下午04:31:12
	 */
	public static boolean checkStr(String str, String format) {
		boolean res = false;
		try {
			res = Pattern.compile(format).matcher(str).matches();
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	/**
	 * 用户名 验证用户名 （可用数字、字母、下划线）
	 */
	public static final String username = "^\\w+$";

	/**
	 * 数字、字母、下划线
	 */
	public static final String password = "^[a-zA-Z_]\\w+$";

	/**
	 * 验证手机号 13XX 15XX 17XX 18XX 0XX-XXXXXXXX 0XXX-XXXXXXX
	 */
	public static final String mobile = "^(((13[0-9])|(14([0-9]))|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8})$";

	/**
	 * 验证坐机 0XX-XXXXXXXX 0XXX-XXXXXXX
	 */
	public static final String telephone = "^(((13[0-9])|(15([0-3]|[5-9]))|(17([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";

	/**
	 * 验证手机和坐机 13XX 15XX 17XX 18XX 0XX-XXXXXXXX 0XXX-XXXXXXX
	 */
	public static final String mobileAndTelephone = "^(((13[0-9])|(15([0-3]|[5-9]))|(17([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";

	/**
	 * 验证邮箱XXX@XX.XX
	 */
	public static final String email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

	/**
	 * 验证身份证号 (15位，或18位)
	 */
	public static final String idNumber = "^\\d{15}|\\d{18}$";

	/**
	 * 验证银行卡号 (16位，18位，19位)
	 */
	public static final String bankCard = "^\\d{15}|\\d{17}|\\d{18}|\\d{19}$";

	/**
	 * 年份 year 4位数字
	 */
	public static final String year = "^\\d{4}$";

	/**
	 * 验证一年的12个月
	 */
	public static final String month = "^(0?[1-9]|1[0-2])$";

	/**
	 * 验证一个月的31天
	 */
	public static final String day = "^((0?[1-9])|((1|2)[0-9])|30|31)$";

	/**
	 * 日期格式 年-月-日year_month_day
	 */
	public static final String year_month_day = "^\\d{4}-(0?[1-9]|1[0-2])-((0?[1-9])|((1|2)[0-9])|30|31)$";

	/**
	 * 长度 6-20 length6_20
	 */
	public static final String length6_20 = "^{6,20}$";

	/**
	 * 数字 无小数 number
	 */
	public static final String number = "^\\-[1-9][]0-9*$";
	/**
	 * 数字 无小数 number-l5 5位
	 */
	public static final String number_l5 = "^[0-9]{0,5}$";
	/**
	 * 数字 可以有小数 decimal
	 */
	public static final String decimal = "^[0-9]+\\.{0,1}[0-9]{0,2}$";

	/**
	 * 数字 可保留0-2位小数float_two
	 */
	public static final String float_two = "^[0-9]+\\.{0,1}[0-9]{0,2}$";

	/**
	 * 英文 english
	 */
	public static final String english = "^[a-zA-Z]+$";

	/**
	 * 英文+数字 englishAndNumber
	 */
	public static final String englishAndNumber = "^[a-zA-Z0-9]+$";

	/**
	 * 只能输入中文汉字
	 */
	public static final String chinese = "^[\u4e00-\u9fa5]{0,}$";
}
// public static final String Email =
// "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

// public static final String checkmobile =
// "^(((13[0-9])|(15([0-3]|[5-9]))|(17([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
// public static final String Username = "^[a-zA-Z_]\\w+$";
// public static final String Number1 = "^[a-zA-Z_]\\w+$";
// 只能输入数字
// public static final String Shuzi = "^\\-[1-9][]0-9*$";
// 验证金额 格式为数字（正整数，保留两位小数）
// public static final String Account = "^[0-9]+\\.{0,1}[0-9]{0,2}$";
// 位数验证（6-20位）
// public static final String Weishu = "^{6,20}$";
// 验证身份证 (15位，或18位)
// // public static final String IdNumber = "^\\d{15}|\\d{18}$";
// // 验证银行卡号 (16位，18位，19位)
// // public static final String BankNumber =
// "^\\d{15}|\\d{17}|\\d{18}|\\d{19}$";
// // 验证日期
// //public static final String Riqi = "";
// // 验证汉字 只能输入汉字
// public static final String Hanzi = "^[\u4e00-\u9fa5]{0,}$";
// // 验证年
// public static final String Year = "";
// // 验证一年的12个月
// public static final String Month = "^(0?[1-9]|1[0-2])$";
// // 验证一个月的31天
// public static final String Day = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
// // 只能输入字母
// public static final String Zifu = "^\\w+$";
// /**
// * 整数或者小数： 只能输入数字："^[0-9]*$"。 只能输入n位的数字："^\d{n}$"。 只能输入至少n位的数字："^\d{n,}$"。
// * 只能输入m~n位的数字：。"^\d{m,n}$" 只能输入零和非零开头的数字："^(0|[1-9][0-9]*)$"。
// * 只能输入有两位小数的正实数："^[0-9]+(.[0-9]{2})?$"。
// * 只能输入有1~3位小数的正实数："^[0-9]+(.[0-9]{1,3})?$"。 只能输入非零的正整数："^\+?[1-9][0-9]*$"。
// * 只能输入非零的负整数："^\-[1-9][]0-9"*$。 只能输入长度为3的字符："^.{3}$"。
// * 只能输入由26个英文字母组成的字符串："^[A-Za-z]+$"。 只能输入由26个大写英文字母组成的字符串："^[A-Z]+$"。
// * 只能输入由26个小写英文字母组成的字符串："^[a-z]+$"。 只能输入由数字和26个英文字母组成的字符串："^[A-Za-z0-9]+$"。
// * 只能输入由数字、26个英文字母或者下划线组成的字符串："^\w+$"。
// * 验证用户密码："^[a-zA-Z]\w{5,17}$"正确格式为：以字母开头，长度在6~18之间，只能包含字符、数字和下划线。
// * 验证是否含有^%&',;=?$\"等字符："[^%&',;=?$\x22]+"。 只能输入汉字："^[\u4e00-\u9fa5]{0,}$"
// * 验证Email地址："^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"。
// * 验证InternetURL："^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]
// * *)?$"。 验证电话号码："^(\(\d
// * {3,4}-)|\d{3.4}-)?\d{7,8}$"正确格式为："XXX-XXXXXXX"、"XXXX-
// * XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX" 。
// * 验证身份证号（15位或18位数字）："^\d{15}|\d{18}$"。
// * 验证一年的12个月："^(0?[1-9]|1[0-2])$"正确格式为："01"～"09"和"1"～"12"。
// * 验证一个月的31天："^((0?[1-9])|((1|2)[0-9])|30|31)$"正确格式为；"01"～"09"和"1"～"31"。
// */
// }

