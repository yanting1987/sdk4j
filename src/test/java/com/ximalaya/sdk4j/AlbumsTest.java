package com.ximalaya.sdk4j;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.album.AlbumTracks;
import com.ximalaya.sdk4j.model.dto.album.UpdatedAlbum;

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
		List<Album> albums = albumsService.batchGetAlbums(new long[] {269483, 414117, 239463});
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
		Assert.assertTrue(albumTracks != null && albumTracks.getTracks() == null);
	}
	
	@Test
	public void testetAllCopyrightAlbumList() throws XimalayaException{
		AlbumList albumList = albumsService.getAllCopyrightAlbumList(0, null);
		Assert.assertTrue(albumList != null);
		List<Album> albums = albumList.getAlbums();
		Assert.assertTrue(albums!= null && albums.size() > 0);
	}

	@Test
	public void testGetUpdatedAlbums() throws XimalayaException{
		List<UpdatedAlbum> albums = albumsService.getUpdatedAlbums(new long[]{85120,87338,85753});
		Assert.assertTrue(albums!= null && albums.size() > 0);
	}
}