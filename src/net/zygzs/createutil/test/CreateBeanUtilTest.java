package net.zygzs.createutil.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.zygzs.createutil.createBean.CreateBeanUtil;
import net.zygzs.createutil.createBean.bean.BeanData;

public class CreateBeanUtilTest {

	public static void main( String[] args ) {
		String className = "BeanData";
		List<BeanData> datas = new ArrayList<BeanData>();
		datas.add( new BeanData( "field", "String", "字段" ) );
		datas.add( new BeanData( "type", "String", "字段的数据类型" ) );
		datas.add( new BeanData( "remarks", "String", "字段的含义" ) );
		datas.add( new BeanData( "hello", "String", null ) );
		CreateBeanUtil.printBean( className, datas );
	}

	public void aa() throws IOException {
		String str = "";
		File file = new File( "C://hygl.txt" );
		FileInputStream in;
		in = new FileInputStream( file );
		// size 为字串的长度 ，这里一次性读完
		int size = in.available();
		byte[] buffer = new byte[size];
		in.read( buffer );
		in.close();
		str = new String( buffer, "GB2312" );
		String[] userCodes = str.split( "," );
		System.out.println( userCodes.length );
	}
}
