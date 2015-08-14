package com.ximalaya.sdk4j.model.dto.column;

import java.util.List;

import com.ximalaya.sdk4j.model.XimalayaResponse;
import com.ximalaya.sdk4j.model.dto.profile.Editor;

public class Column extends XimalayaResponse{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String kind;
	private String column_title;
	private String column_sub_title;
	private String column_intro;
	private String column_foot_note;
	private String cover_url_small;
	private String cover_url_large;
	private String logo_small;
	private Integer column_content_type;
	private Long released_at;
	private Boolean is_hot;
	private Editor column_editor;
	private List column_items;
	
	public Column() {
	}
}
