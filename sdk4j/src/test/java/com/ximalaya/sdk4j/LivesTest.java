package com.ximalaya.sdk4j;

import java.util.List;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.live.Program;
import com.ximalaya.sdk4j.model.dto.live.Province;
import com.ximalaya.sdk4j.model.dto.live.RadioList;
import com.ximalaya.sdk4j.model.dto.live.ThreeDaySchedules;

public class LivesTest {
	
	Lives lives = new Lives();
	
	@Test
	public void testGetProvinces() throws XimalayaException {
		List<Province> provinces = lives.getProvinces();
		System.out.println(provinces);
	}
	
	@Test
	public void testGetRadioList() throws XimalayaException {
		RadioList radioList = lives.getRadioList(2, "110000", new Paging());
		System.out.println(radioList);
	}
	
	@Test
	public void testGetSchedules() throws XimalayaException {
		ThreeDaySchedules threeDaySchedules = lives.getSchedules(75);
		System.out.println(threeDaySchedules);
	}
	
	@Test
	public void testGetProgram() throws XimalayaException {
		Program program = lives.getProgram(99999);
		System.out.println(program);
	}

}
