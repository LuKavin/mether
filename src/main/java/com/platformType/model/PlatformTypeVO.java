package com.platformType.model;

import java.io.Serializable;

public class PlatformTypeVO implements Serializable{
	
	private Integer platform_typenum;
	private String platform_typename;
	@Override
	public String toString() {
		return "PlatformTypeVO [platform_typenum=" + platform_typenum + ", platform_typename=" + platform_typename
				+ "]";
	}
	public Integer getPlatform_typenum() {
		return platform_typenum;
	}
	public void setPlatform_typenum(Integer platform_typenum) {
		this.platform_typenum = platform_typenum;
	}
	public String getPlatform_typename() {
		return platform_typename;
	}
	public void setPlatform_typename(String platform_typename) {
		this.platform_typename = platform_typename;
	}
	

}
