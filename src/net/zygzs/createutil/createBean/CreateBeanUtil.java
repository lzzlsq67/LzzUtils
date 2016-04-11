package net.zygzs.createutil.createBean;

import java.util.ArrayList;
import java.util.List;

import net.zygzs.createutil.createBean.bean.BeanData;
import net.zygzs.createutil.createBean.utils.StringUtils_camel;

/**
 * 创建实体对象工具类
 *
 * @author 刘泽中
 *
 */
public class CreateBeanUtil {

	private static String empty = "";

	/** 测试 */
	public static void main( String[] args ){
		String field = "field";
		String type = "String";
		String remarks = "字段名";
		BeanData data = new BeanData( field, type, remarks );
		// printData( field, type, remarks );
		// printGet( field, type, remarks );
		// printSet( field, type, remarks );
		// printOne( field, type, remarks );
		List<BeanData> datas = new ArrayList<BeanData>();
		datas.add( data );
		datas.add( new BeanData( "id", "Long", "ID" ) );
		datas.add( new BeanData( "name", "String" ) );
		// printList( datas );
		// printBean( datas );
		printToString( datas );
	}

	/** 打印数据 */
	public static void printData( BeanData data ){
		printData( data.getField(), data.getType(), data.getRemarks() );
	}

	/** 打印数据 */
	public static void printData( String field, String type, String remarks ){
		if (remarks != null) println( "/**" + remarks + "*/" );
		println( "private " + addSpace( type ) + field + ";" );
		println( empty );
	}

	/** 打印Get */
	public static void printGet( BeanData data ){
		printGet( data.getField(), data.getType(), data.getRemarks() );
	}

	/** 打印Get */
	public static void printGet( String field, String type, String remarks ){
		if (remarks != null) println( "/** 获取" + remarks + "*/" );
		println( "public " + addSpace( type ) + "get" + StringUtils_camel.underLine2Camel( StringUtils_camel.UNDERLINE + field ) + "( ){" );
		println( "    return " + field + ";" );
		println( "}" );
		println( empty );
	}

	/** 打印Set */
	public static void printSet( BeanData data ){
		printSet( data.getField(), data.getType(), data.getRemarks() );
	}

	/** 打印Set */
	public static void printSet( String field, String type, String remarks ){
		if (remarks != null) println( "/** 设置" + remarks + "*/" );
		println( "public " + "void " + "set" + StringUtils_camel.underLine2Camel( StringUtils_camel.UNDERLINE + field ) + "(" + addSpace( type ) + field + " ){" );
		println( "    this." + field + " = " + field + ";" );
		println( "}" );
		println( empty );
	}

	/** 打印ToString */
	public static void printToString( List<BeanData> datas ){
		printToString( datas, null );
	}

	/** 打印ToString */
	public static void printToString( List<BeanData> datas, String className ){
		if (className == null) className = "Class";
		println( "@Override" );
		println( "public String toString(){" );
		print( "    return \"" + className + " [\"+" );
		for (int i = 0; i < datas.size(); i++) {
			print( getToString( datas.get( i ) ) );
			if (datas.size() - i > 1) print( "+\",\"+" );
			if (datas.size() - i == 1) println( "+\"]\";" );
		}
		println( "}" );
		println( empty );
	}

	/** 打印ToString */
	private static String getToString( BeanData data ){
		return getToString( data.getField(), data.getType(), data.getRemarks() );
	}

	/** 打印ToString */
	private static String getToString( String fieldName, String type, String remarks ){
		if (remarks == null) remarks = fieldName;
		return ("\"" + remarks + "=\"" + fieldName).toString();
	}

	/** 打印 数据集合 */
	public static void printDatas( List<BeanData> datas ){
		for (BeanData data : datas) {
			printData( data );
		}
	}

	public static void printGetS( List<BeanData> datas ){
		for (BeanData data : datas) {
			printGet( data );
		}
	}

	/** 打印Sets */
	public static void printSets( List<BeanData> datas ){
		for (BeanData data : datas) {
			printSet( data );
		}
	}

	/** 打印BeanBody部分 （包括 数据 get set) */
	public static void printBody( List<BeanData> datas, String className ){
		printDatas( datas );
		printToString( datas, className );
		printGetS( datas );
		printSets( datas );
	}

	/** 打印一个（包括 数据 get set) */
	public static void printOne( String field, String type, String remarks ){
		printData( field, type, remarks );
		printGet( field, type, remarks );
		printSet( field, type, remarks );
	}

	/** 打印一个（包括 数据 get set) */
	public static void printOne( BeanData data ){
		printOne( data.getField(), data.getType(), data.getRemarks() );
	}

	public static void printBean( String className, String packageName, BeanData data ){
		className = className != null ? className : "ClassName";
		if (packageName != null) print( "package " + packageName + " ;" );
		println( "public class " + className + " {" );
		printOne( data );
		println( "}" );
	}

	public static void printBean( String beanName, BeanData data ){
		printBean( beanName, null, data );
	}

	public static void printBean( BeanData data ){
		printBean( null, null, data );
	}

	/**
	 * 打印一个实体类
	 * 
	 * @param className 类名
	 * @param packageName 包名
	 * @param datas 数据集
	 */
	public static void printBean( String className, String packageName, List<BeanData> datas ){
		className = className != null ? className : "ClassName";
		if (packageName != null) print( "package " + packageName + " ;" );
		println( "public class " + className + " {" );
		printBody( datas, className );
		println( "}" );
	}

	/**
	 * 打印一个实体类（无包名）
	 * 
	 * @param className 类名
	 * @param datas 数据集
	 */
	public static void printBean( String className, List<BeanData> datas ){
		printBean( className, null, datas );
	}

	/**
	 * 打印一个实体类（Class）无包名
	 * 
	 * @param datas 数据集
	 */
	public static void printBean( List<BeanData> datas ){
		printBean( null, null, datas );
	}

	/** 在字符串后面加一个空格 */
	private static String addSpace( String str ){
		return str + " ";
	}

	/** 打印不换行 */
	private static void print( Object obj ){
		System.out.print( obj );
	}

	/** 打印并换行 */
	private static void println( Object obj ){
		System.out.println( obj );
	}
}