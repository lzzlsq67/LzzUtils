package net.zygzs.createutil.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.zygzs.createutil.createBean.CreateBeanUtil;
import net.zygzs.createutil.createBean.bean.BeanData;

public class CreateBeanUtilTest {

	public static void main( String[] args ) {
		String className = "BeanData";
		List<BeanData> datas = new ArrayList<BeanData>();
		datas.add( new BeanData( "id", "Long", "ID" ) );
		datas.add( new BeanData( "trans_date_time", "String", "交易时间" ) );
		datas.add( new BeanData( "channel", "String", "通道" ) );
		datas.add( new BeanData( "channel_type", "String", "通道类型" ) );
		datas.add( new BeanData( "channel_sum_fee", "Long", "通道总费用" ) );
		datas.add( new BeanData( "trans_sum_profit", "Long", "交易总利润" ) );
		datas.add( new BeanData( "trans_sum_amt", "Long", "交易总额" ) );
		datas.add( new BeanData( "trans_sum_fee", "Long", "交易总手续费" ) );
		datas.add( new BeanData( "trans_sum_cnt", "Long", "交易总笔数" ) );
		datas.add( new BeanData( "create_time", "Date", "创建时间" ) );
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
