# sdk4j
Java OpenAPI Server SDK for Ximalaya

TODO
Ximalaya Server SDK 0.0.6-SNAPSHOT 版本修订记录:
1、 com.ximalaya.sdk4j.model.dto.album包中新增SubordinatedAlbum类，该类将替换原
com.ximalaya.sdk4j.model.dto.track.Track类中的 long类型的subordinated_album_id字段，
为SubordinatedAlbum类型的subordinatedAlbum对象。
       新增的Subordinated_album对象字段属性为:
  {   
	id : 所属专辑ID
    album_title:  所属专辑标题
    cover_url_small: 所属专辑封面小图
    cover_url_middle: 所属专辑封面中图
    cover_url_large: 所属专辑封面大图
   }

‎												修订日期: 2015‎年‎7‎月‎17‎日  
												修订人: Ximalaya开放平台 william