package com.ximalaya.sdk4j.model.dto.live;

import java.io.Serializable;
import java.util.List;

import com.ximalaya.sdk4j.model.dto.AbstractPageResult;

public class RadioList extends AbstractPageResult implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3894839919178264063L;
	
	private List<Radio> radios;
	
	public List<Radio> getRadios() {
		return radios;
	}
	public void setRadios(List<Radio> radios) {
		this.radios = radios;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("RadioList {totalCount: ");
		strBuilder.append(totalCount);
		strBuilder.append(", totalPage: ");
		strBuilder.append(totalPage);
		strBuilder.append(", radios: [");
		if(radios != null && !radios.isEmpty()) {
			for(Radio radio: radios) {
				strBuilder.append(radio.toString());
				strBuilder.append(", ");
			}
			strBuilder.deleteCharAt(strBuilder.lastIndexOf(","));
		}
		strBuilder.append("]}");
		return strBuilder.toString();
	}

}
