package com.ximalaya.sdk4j;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.live.Program;
import com.ximalaya.sdk4j.model.dto.live.Province;
import com.ximalaya.sdk4j.model.dto.live.RadioList;
import com.ximalaya.sdk4j.model.dto.live.ScheduleList;

public class LivesTest {
	
	Lives lives = new Lives();
	
	@Test
	public void testGetProvinces() throws XimalayaException {
		List<Province> provinces = lives.getProvinces();
		Assert.assertTrue(provinces != null && !provinces.isEmpty());
	}
	
	@Test
	public void testGetRadioList() throws XimalayaException {
		RadioList radioList = lives.getRadioList(1, "110000", new Paging());
		Assert.assertTrue(radioList != null && radioList.getRadios() != null
				&& !radioList.getRadios().isEmpty());
	}
	
	@Test
	public void testGetSchedules() throws XimalayaException {
		ScheduleList threeDaySchedules = lives.getSchedules(75);
		Assert.assertTrue(threeDaySchedules != null && threeDaySchedules.getSchedules() != null
				&& !threeDaySchedules.getSchedules().isEmpty());
	}
	
	@Test
	public void testGetProgram() throws XimalayaException {
		Program program = lives.getProgram(75);
		Assert.assertNotNull(program != null && program.getProgramName() != null);
	}

}
