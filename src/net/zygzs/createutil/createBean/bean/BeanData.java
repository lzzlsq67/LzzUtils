package net.zygzs.createutil.createBean.bean;

public class BeanData {

	/** 字段 */
	private String field;

	/** 字段的数据类型 */
	private String type;

	/** 字段的含义 */
	private String remarks;

	public BeanData() {
		super();
	}

	public BeanData( String field, String type ) {
		super();
		this.field = field;
		this.type = type;
	}

	@Override
	public String toString(){
		return "BeanData [field=" + field + ", type=" + type + ", remarks=" + remarks + "]";
	}

	/**
	 * 
	 * @param field 字段
	 * @param type 字段的数据类型
	 * @param remarks 含义
	 */
	public BeanData( String field, String type, String remarks ) {
		super();
		this.field = field;
		this.type = type;
		this.remarks = remarks;
	}

	/** 获取字段 */
	public String getField(){
		return field;
	}

	/** 获取字段的数据类型 */
	public String getType(){
		return type;
	}

	/** 获取字段的含义 */
	public String getRemarks(){
		return remarks;
	}

	/** 设置字段 */
	public void setField( String field ){
		this.field = field;
	}

	/** 设置字段的数据类型 */
	public void setType( String type ){
		this.type = type;
	}

	/** 设置字段的含义 */
	public void setRemarks( String remarks ){
		this.remarks = remarks;
	}
}
