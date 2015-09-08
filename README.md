# sdk4j

Java OpenAPI Server SDK for Ximalaya

##**使用说明：**

> 1、使用git克隆喜马拉雅sdk4j项目
```
git clone https://github.com/jxqlovejava/sdk4j.git
```
> 2、使用maven将项目编译成.jar文件 (跳过测试)
```bash
mvn clean package -Dmaven.test.skip=true
```
> 3、在引用.jar文件的项目的classpath下配置conf.properties
```bash
ximalaya.openapi.appKey=[需要申请]
ximalaya.openapi.appSecret=[需要申请]
ximalaya.openapi.serverAuthenticateStaticKey=[需要申请]
ximalaya.openapi.baseURL=http://api.ximalaya.com/openapi-gateway-app
```
> 附：喜马拉雅sdk4j项目为maven项目，此说明方式仅供参考

##**版本更新说明：**

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

* 增加了《开放平台API接口文档》

### 2015/08/17 william 0.0.7-SNAPSHOT更新:

* 新增人工推荐专辑分类接口

* 新增相关专辑接口

* 新增搜索直播电台接口

* 新增搜索全部（专辑、声音、电台一起搜）接口

* 新增榜单焦点图接口

* 新增获取首页榜单列表接口

* 新增专辑榜单接口

* 新增声音榜单接口

* 新增直播电台榜单接口

* 新增精品听单列表接口

* 新增听单详情接口

* 声音model增加m4a格式播放地址

* 声音model增加order_num排序值

### 2015/08/17 william 0.0.8-SNAPSHOT更新:

* 删除上版本的榜单焦点图接口和之前的焦点图相关接口

### 2015/08/27 william 0.0.9-SNAPSHOT更新:

* 增加榜单焦点图接口

* 增加发现页焦点图接口

* 增加分类下推荐标签的焦点图接口

### 2015/09/08 william 0.0.10-SNAPSHOT更新:

* 修改Albums接口中返回的AlbumList中，albums字段为空的bug

* 修改Tracks接口中返回的TrackList中，tracks字段为空的bug

* 修改Tracks接口中返回的IncrementTrackList中，tracks字段为空的bug

* 修改Columns接口中返回的ColumnList中，columns字段为空的bug