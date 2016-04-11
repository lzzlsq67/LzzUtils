package net.zygzs.createutil.createXML;

import java.util.ArrayList;
import java.util.List;

import net.zygzs.createutil.createBean.bean.BeanData;

/**
 * 创建XML工具类
 *
 * @author 刘泽中
 *
 */
public class CreateXMLUtil {

	public static String SQL = "sql";

	public static String INSERT = "insert";

	public static String SELECT = "select";

	public static String UPDATE = "update";

	public static String DELETE = "delete";

	public static void main( String[] args ){
		List<BeanData> datas = new ArrayList<BeanData>();
		datas.add( new BeanData( "field", "String", "字段" ) );
		datas.add( new BeanData( "type", "String", "字段的数据类型" ) );
		datas.add( new BeanData( "remarks", "String", "字段的含义" ) );
		// printCols( datas );
		printInsert( "datasebaseName", datas );
		// printHead( "sql", "id", "aa.bb.cc.aa" );
	}

	/** 打印列 */
	public static void printCols( List<BeanData> datas ){
		printHead( SQL, "cols" );
		// 打印数据
		printColsOnly( datas );
		printEnd( SQL );
	}

	/** 仅打印列中数据 */
	public static void printColsOnly( List<BeanData> datas ){
		print( "    " );
		for (int i = 0; i < datas.size(); i++) {
			BeanData data = datas.get( i );
			print( data.getField() );
			if (datas.size() - i > 1) print( ", " );
			if (datas.size() - i == 1) println( "" );
		}
	}

	/** 打印Insert SQL */
	public static void printInsert( String databaseName, List<BeanData> datas ){
		// 打印头
		printHead( INSERT, "insert" );
		// 打印数据
		println( "    INSERT INTO " + databaseName );
		println( "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">" );
		printTab();
		printColsOnly( datas );
		println( "    </trim>" );
		print( "    values (" );
		for (int i = 0; i < datas.size(); i++) {
			BeanData data = datas.get( i );
			print( "#{" + data.getField() + "}" );// #{ id}
			if (datas.size() - i > 1) print( ", " );
			if (datas.size() - i == 1) println( ")" );
		}
		// 打印尾
		printEnd( INSERT );
	}

	/**
	 * 打印头
	 * 
	 * @param sqlType SQL类型 如“SQL insert delete update select”
	 * @param id id
	 * @param resultType 返回类型
	 */
	public static void printHead( String sqlType, String id, String resultType ){
		print( "<" + sqlType + " id=\"" + id );
		if (resultType != null) print( "\" resultType=\"" + resultType );
		println( "\">" );
	}

	/**
	 * 打印头
	 * 
	 * @param sqlType SQL类型 如“SQL insert delete update select”
	 * @param id id
	 */
	public static void printHead( String sqlType, String id ){
		printHead( sqlType, id, null );
	}

	/**
	 * 打印尾
	 * 
	 * @param sqlType sql类型 如“sql insert delete update select”
	 */
	public static void printEnd( String sqlType ){
		println( "</" + sqlType + ">" );
	}

	/** 在字符串后面加一个空格 */
	// private static String addSpace( String str ){
	// return str + " ";
	// }
	/** 打印不换行 */
	private static void print( Object obj ){
		System.out.print( obj );
	}

	/** 打印并换行 */
	private static void println( Object obj ){
		System.out.println( obj );
	}

	private static void printTab(){
		System.out.print( "    " );
	}
}
