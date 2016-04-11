package net.zygzs.lzz.controller;

import net.zygzs.lzz.utils.XML_Data_Util;

public class PrintXML {

	public static void main(String[] args){
		// 订单利润OP
		// private static String str =
		// " id, order_id, mer_sys_id_v1, mer_sys_profit_v1, mer_sys_rate_v1, mer_sys_hight_fee_v1, mer_sys_id_v2, mer_sys_profit_v2, mer_sys_rate_v2, mer_sys_hight_fee_v2, agent_id_v1, agent_profit_v1, agent_rate_v1, agent_hight_fee_v1, agent_id_v2, agent_profit_v2, agent_rate_v2, agent_hight_fee_v2, agent_id_v3, agent_profit_v3, agent_rate_v3, agent_hight_fee_v3, agent_id_v4, agent_profit_v4, agent_rate_v4, agent_hight_fee_v4, agent_id_v5, agent_profit_v5, agent_rate_v5, agent_hight_fee_v5, mer_id_v1, mer_profit_v1, mer_rate_v1, mer_hight_fee_v1, tract_fee, tract_bybay_profit, tract_acqback_profit, tract_cost, create_time";
		// 订单结算OS
		 String str = "id ,order_id ,mer_id ,trans_amt ,trans_fee ,trans_type ,settle_batch_no ,settle_amt ,settle_type ,settle_tract ,settle_time  ";//,agent3_profit
		// 平台利润统计BPS
		//String str = "id ,settle_date ,sum_amt ,sum_fee ,sum_order_count ,sum_camt ,sum_cfee ,sum_order_ccount,sum_ramt ,sum_rfee ,sum_order_rcount,sum_tract_fee ,bypay_profit ,tract_bypay_profit ,create_date ,reserved1 ,reserved2 ,reserved3";
		XML_Data_Util.setStr( str );
		// 打印头
		// 打印数据
		XML_Data_Util.printXML();
		// 打印方法
		// 打印结束
	}
}
