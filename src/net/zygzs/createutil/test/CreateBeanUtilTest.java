package net.zygzs.createutil.test;

import java.util.ArrayList;
import java.util.List;

import net.zygzs.createutil.createBean.CreateBeanUtil;
import net.zygzs.createutil.createBean.bean.BeanData;

public class CreateBeanUtilTest {

	public static void main( String[] args ){
		String className = "BeanData";
		List<BeanData> datas = new ArrayList<BeanData>();
		datas.add( new BeanData( "field", "String", "字段" ) );
		datas.add( new BeanData( "type", "String", "字段的数据类型" ) );
		datas.add( new BeanData( "remarks", "String", "字段的含义" ) );
		CreateBeanUtil.printBean( className, datas );
	}
}
