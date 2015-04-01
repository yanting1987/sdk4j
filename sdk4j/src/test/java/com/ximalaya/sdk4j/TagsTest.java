package com.ximalaya.sdk4j;

import java.util.List;

import org.junit.Test;

import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.tag.Tag;

public class TagsTest {
	
	Tags tagsService = new Tags();
	
	@Test
	public void testGetAlbumTags() throws XimalayaException {
		List<Tag> tags = tagsService.getAlbumTags(0);
		System.out.println(tags);
	}

}
