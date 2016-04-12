package net.zygzs.lzz.test;

import java.util.ArrayList;

public class Create {

	public static void main( String[] args ) {
		String string = "	base_area.metadata.json	base_interface_extra.metadata.json	base_sales.metadata.json	branchCounter.metadata.json	branches.metadata.json	carModel.metadata.json	carPremium.metadata.jsonclients.metadata.json	combTotal.metadata.json	commercial.metadata.json	customer.metadata.json	czs.metadata.json	extUser.metadata.json	intdetails.metadata.json	kernelSales.metadata.json	lifeHolder.metadata.json	lifeInsure.metadata.json	lifeInsureType.metadata.json	lifeTypeBranch.metadata.json	menus.metadata.json	orderInfos.metadata.json	payment.metadata.json	payTool.metadata.json	userinfos.metadata.json	users.metadata.json	tmpusers.metadata.json 	statistical.metadata.json	roles.metadata.json	refereeIntDetails.metadata.json	recommendedInfo.metadata.json	rateInfos.metadata.json	provinces.metadata.json	proposals.metadata.json	posts.metadata.json";
		String[] strings = str2Array( string, ".metadata.json" );
		ArrayList<String> strings2 = new ArrayList<String>();
		for (String string2 : strings) {
			string2 = string2.trim();
			strings2.add( string2 );
		}
		for (String string2 : strings2) {
			System.out.println( "mongoimport -d test -c " + string2 + " --drop E:\\b2bDB\\" + string2 + ".metadata.json" );
		}
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
	public static String[] str2Array( String string, String str ) {
		if (string != null && string.length() > 0) {
			return string.split( str );
		} else {
			return null;
		}
	}
}
