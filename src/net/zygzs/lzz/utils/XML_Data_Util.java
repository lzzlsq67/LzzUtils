package net.zygzs.lzz.utils;
/**
 * 打印XML工具类
 * @author 刘泽中
 *
 */
public class XML_Data_Util {

	private static String str;

	// 订单利润OP
	// private static String str =
	// " id, order_id, mer_sys_id_v1, mer_sys_profit_v1, mer_sys_rate_v1, mer_sys_hight_fee_v1, mer_sys_id_v2, mer_sys_profit_v2, mer_sys_rate_v2, mer_sys_hight_fee_v2, agent_id_v1, agent_profit_v1, agent_rate_v1, agent_hight_fee_v1, agent_id_v2, agent_profit_v2, agent_rate_v2, agent_hight_fee_v2, agent_id_v3, agent_profit_v3, agent_rate_v3, agent_hight_fee_v3, agent_id_v4, agent_profit_v4, agent_rate_v4, agent_hight_fee_v4, agent_id_v5, agent_profit_v5, agent_rate_v5, agent_hight_fee_v5, mer_id_v1, mer_profit_v1, mer_rate_v1, mer_hight_fee_v1, tract_fee, tract_bybay_profit, tract_acqback_profit, tract_cost, create_time";
	// 订单结算OS
	// private static String str =
	// "id ,order_id ,mer_id ,trans_amt ,trans_fee ,trans_type ,settle_batch_no ,settle_amt ,settle_type ,settle_tract ,settle_time  ";//,agent3_profit
	// 平台利润统计BPS
	//private static String str =	 "id ,settle_date ,sum_amt ,sum_fee ,sum_order_count ,sum_camt ,sum_cfee ,sum_order_ccount,sum_ramt ,sum_rfee ,sum_order_rcount,sum_tract_fee ,bypay_profit ,tract_bypay_profit ,create_date ,reserved1 ,reserved2 ,reserved3";
	public static String getStr(){
		return str;
	}
	/**设置参数：数据集合*/
	public static void setStr( String str ){
		XML_Data_Util.str = str;
	}

/*	public static void main( String[] args ){
		String[] strs = StringUtils_camel.str2Array( str );// 将Str转数组
		printXML( strs );// 打印XML
		printStrings( strs, "转换成字符串：" );// 将对象转换成字符串
	}*/
	/** 打印XML */
	public static void printXML(){
		String[] strs = StringUtils_camel.str2Array( str );// 将Str转数组
		printInsertList( strs );// 插入列
		printInsertValueList( strs );// 插入内容
		printSelectCols();// 查询的列
		printSelectList( strs );// 查询条件
	}

	/** 将对象转换成字符串-- TODO */
	public static void printStrings( String[] strs, String name ){
		System.out.print( "\"" + name + "【\"+" );
		int i = 0;
		for (String string : strs) {
			i++;
			if (i % 5 == 0) System.out.println();
			printString( string );
		}
		System.out.print( "\"】\"" );
	}

	/** 打印一条-- */
	private static void printString( String str ){
		// "str=" + obj.getStr() +
		System.out.print( "\"," + str + "=\"+obj." + underlineToCamel( getGit_Str( str ) ) + "()+" );
	}

	private static String getGit_Str( String str ){
		str = "get_" + str;
		str = str.replaceAll( " +", "" );
		return str;
	}

	/** 查询的列TODO */
	private static void printSelectCols(){
		System.out.println( "<!-- 查询的列 -->" );
		System.out.println( "<sql id=\"select_cols\">" );
		System.out.println( str );
		System.out.println( "</sql>" );
	}

	/** 打印多条--查询条件 */
	private static void printSelectList( String[] strs ){
		System.out.println( "<!-- 查询条件  查询条件、删除条件、修改条件-->" );
		System.out.println( "<sql id=\"select_param\">" );
		System.out.println( "where 1=1" );
		for (String string : strs) {
			printSelect( string );
		}
		System.out.println( "</sql>" );
	}

	/** 打印1条--查询条件 */
	private static void printSelect( String str ){
		// <if test="orderId != null and '' != orderId" > AND order_id =
		// #{orderId}</if>
		String tuoFeng = underlineToCamel( str );
		System.out.println( "<if test=\"" + tuoFeng + "!= null and " + tuoFeng + " !=''\"> AND  " + str + " = #{" + tuoFeng + "}</if>" );
	}

	/** 打印多条--插入列 */
	private static void printInsertList( String[] strs ){
		System.out.println( "<!-- 插入列 -->" );
		System.out.println( "<sql id=\"sava_cols\">" );
		for (String string : strs) {
			printInsert( string );
		}
		System.out.println( "</sql>" );
	}

	/** 打印一条--插入列 */
	private static void printInsert( String str ){
		// <if test=" orderId!= null and  orderId !=''"> order_id,</if>
		System.out.println( "<if test=\"" + underlineToCamel( str ) + "!= null and " + underlineToCamel( str ) + " !=''\">" + str + ",</if>" );
	}

	/** 打印多条--插入内容TODO */
	private static void printInsertValueList( String[] strs ){
		System.out.println( "<!-- 插入值 -->" );
		System.out.println( "<sql id=\"insert_value\">" );
		for (String string : strs) {
			printInsertValue( string );
		}
		System.out.println( "</sql>" );
	}

	/** 打印一条--插入内容 */
	private static void printInsertValue( String str ){
		// <if test="strIng != null and strIng !=''"> #{strIng}, </if>
		System.out.println( "<if test=\"" + underlineToCamel( str ) + "!= null and " + underlineToCamel( str ) + " !=''\"> #{" + underlineToCamel( str ) + "},  </if>" );
	}

	/**
	 * 下划线转驼峰
	 * 
	 * @param str
	 * @return
	 */
	private static String underlineToCamel( String str_ing ){
		return StringUtils_camel.underline2Camel( str_ing );
	}
}
