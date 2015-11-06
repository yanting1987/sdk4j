package com.ximalaya.sdk4j;

import static org.junit.Assert.assertTrue;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.*;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;

public class AlbumsTest {
	
	Albums albumsService = new Albums();
	
	@Test
	public void testGetHotAlbumList() throws XimalayaException {
		AlbumList albumList = albumsService.getHotAlbumList(0L, null, new Paging());
		List<Album> albums = albumList.getAlbums();
		Assert.assertTrue(albums != null && !albums.isEmpty());
	}
	
	@Test
	public void testBatchGetAlbums() throws XimalayaException {
		List<Album> albums = albumsService.batchGetAlbums(new long[]{88065, 414117, 239463});
		Assert.assertTrue(albums != null && albums.size() > 0);
	}
	
	@Test  
	public void testBrowseAlbumTracks() throws XimalayaException {
		/*
		 * 有版权
		 */
		AlbumTracks albumTracks = albumsService.browseAlbumTracks(269483, new Paging(1, 5));
		Assert.assertTrue(albumTracks != null && albumTracks.getTracks() != null
				&& !albumTracks.getTracks().isEmpty());
		
		/*
		 * 无版权
		 */
		albumTracks = albumsService.browseAlbumTracks(84364, new Paging(1, 5));
		Assert.assertFalse(albumTracks != null && albumTracks.getTracks() == null);
	}
	
	@Test
	public void testetAllCopyrightAlbumList() throws XimalayaException{
		AlbumList albumList = albumsService.getAllCopyrightAlbumList(0, null, null);
		Assert.assertTrue(albumList != null);
		List<Album> albums = albumList.getAlbums();
		Assert.assertTrue(albums!= null && albums.size() > 0);
	}

	@Test
	public void testAllCopyrightAlbumListll() throws XimalayaException {
		//AlbumList albumList =	albumsService.getAllCopyrightAlbumList(3,"浪漫言情",new Paging(1,3)); //正网
		//AlbumList albumList =	albumsService.getAllCopyrightAlbumList(3,"言情",new Paging(1,3)); //测试  标签不一致
		AlbumList albumList =	albumsService.getAllCopyrightAlbumList(3, null, new Paging(1, 3));
		Assert.assertTrue(albumList != null);
	}

	@Test
	public void testGetUpdatedAlbums() throws XimalayaException{
		List<UpdatedAlbum> albums = albumsService.getUpdatedAlbums(new long[]{294573, 331403, 232829});
		Assert.assertTrue(albums!= null && albums.size() > 0);
	}

	@Test
	public void testReletiveAlbum() throws XimalayaException {
		RelativeAlbumList reletiveAlbumList=  albumsService.getRelativeAlbums(462375L);  //线上
		//ReletiveAlbumList reletiveAlbumList=  albumsService.getReletiveAlbums(85646L);    //测试
		Assert.assertTrue(reletiveAlbumList!= null && reletiveAlbumList.getReletiveAlbum().size()> 0);
	}
	
	@Test
	public void testGetHumanRecommendAlbumList() throws XimalayaException {
		List<HumanRecommendAlbumList> humanRecommendAlbumLists = albumsService.getHumanRecommendAlbumList(3);
		assertTrue(humanRecommendAlbumLists != null && humanRecommendAlbumLists.size() > 0);
	}

	@Test
	public void testGetHumanRecommendDownloadAlbums() throws XimalayaException {
		AlbumList recommendDownloadAlbumLists = albumsService.getRecommendDownloadAlbumList(0, new Paging());
		assertTrue(recommendDownloadAlbumLists != null && recommendDownloadAlbumLists.getAlbums().size() > 0);
	}
	
	@Test
	public void testHotAggregation() throws XimalayaException {
	    List<AlbumList> albumLists = albumsService.getHotAggregation(3L, 4, 3);
		assertTrue(albumLists.size() > 0);
	}

	@Test
	public void testRecommondCollection() throws XimalayaException {
		List<Album> reletiveAlbumList=	albumsService.getRecommondCollection(2);
		assertTrue(reletiveAlbumList.size() > 0);
	}
	
	@Test
	public void testGuessYouLikeAlbumList() throws XimalayaException {
		List<PerferedAlbum> reletiveAlbumList =	albumsService.getGuessYouLikeAlbumList(2, "device_id", 3);
		assertTrue(reletiveAlbumList.size() > 0);
	}
}