# sdk4j

Java OpenAPI Server SDK for Ximalaya


### 2015/07/17 william 0.0.6-SNAPSHOT更新:

* 新增SubordinatedAlbum DTO，并将Track DTO中的subordinated_album_id字段替换为SubordinatedAlbum。新增的SubordinatedAlbum属性如下:

```html
id : 所属专辑ID
album_title:  所属专辑标题
cover_url_small: 所属专辑封面小图
cover_url_middle: 所属专辑封面中图
cover_url_large: 所属专辑封面大图
```

* 增加getAllCopyrightAlbumList获取带版权的专辑全量接口

* 增加了搜索热词接口和搜索联想词接口

* 增加《开放平台API接口文档》