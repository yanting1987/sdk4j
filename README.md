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
> 3、在引用.jar文件的项目的classpath下配置config.properties
```bash
ximalaya.openapi.appKey=[需要申请]
ximalaya.openapi.appSecret=[需要申请]
ximalaya.openapi.serverAuthenticateStaticKey=[需要申请]
ximalaya.openapi.baseURL=http://api.ximalaya.com/openapi-gateway-app
```
> 附：喜马拉雅sdk4j项目为maven项目，此说明方式仅供参考

##**版本更新说明：**

### 2016/6/1 william 0.1.12-SNAPSHOT更新：

* 更新获取热门专辑接口getHotAlbumList，采用从getAlbumListV2中获取

* 更新获取专辑或声音的标签（v2版本标签）

* 更新根据分类和标签获取某个分类某个标签下的热门专辑列表/最新专辑列表/最多播放专辑列表（v2版本）

### 2016/5/24 william 0.1.11-SNAPSHOT更新：

* bug修复，修复批量上传直播和点播播放数据字段错误的bug

### 2016/5/11 william 0.1.10-SNAPSHOT更新：

* 移除获取专辑或声音的标签（v1版本标签）

* 移除根据分类和标签获取某个分类某个标签下的热门专辑列表/最新专辑列表/最多播放专辑列表（v1版本）

### 2016/4/20 william 0.1.9-SNAPSHOT更新：

* 新增获取专辑或声音的标签（v2版本标签）

* 新增根据分类和标签获取某个分类某个标签下的热门专辑列表/最新专辑列表/最多播放专辑列表（v2版本）

* 修改了一个bug

### 2016/3/4 william 0.1.8-SNAPSHOT更新：

* 修改了一个bug

### 2016/3/4 william 0.1.7-SNAPSHOT更新：

* 新增播放数据上传接口。包括上传单条直播播放数据，批量上传直播播放数据，上传单条声音播放数据和批量上传声音播放数据

### 2015/12/11 william 0.1.6-SNAPSHOT更新：

* 更新获取喜马拉雅猜你喜欢的专辑列表接口，增加相关字段

### 2015/12/11 william 0.1.5-SNAPSHOT更新：

* 新增获取喜马拉雅主播分类和获取某个分类下的主播列表接口

* 新增根据分类和标签获取某个分类某个标签下的最新专辑列表接口

### 2015/12/3 william 0.1.4-SNAPSHOT更新：

* 新增冷启动相关接口，包括：获取冷启动一级分类、二级分类、根据冷启动一级分类和冷启动二级分类获取相应类别下的冷启动标签列表、
提交用户感兴趣的冷启动标签和获取用户提交的冷启动标签详情等接口

* 为专辑DTO包下的Album增加isFinished字段

### 2015/11/30 william 0.1.3-SNAPSHOT更新：

* 新增根据主播id获取该主播下的专辑列表接口

### 2015/11/11 william 0.1.2-SNAPSHOT更新：

* 修改根据上一次所听声音的id，搜索给定数量的声音接口

### 2015/11/6 william 0.1.1-SNAPSHOT更新：

* 新增获取猜你喜欢的专辑接口

### 2015/10/19 will 0.1.0-SNAPSHOT更新：

* 新增根据电台ID批量获取电台详情接口

### 2015/09/16 william 0.0.11-SNAPSHOT更新:

* 新增根据省分代码获取某省份城市列表接口

* 新增根据城市代码获取某个城市下的电台列表接口

### 2015/09/08 william 0.0.10-SNAPSHOT更新:

* 修改Albums接口中返回的AlbumList中，albums字段为空的bug

* 修改Tracks接口中返回的TrackList中，tracks字段为空的bug

* 修改Tracks接口中返回的IncrementTrackList中，tracks字段为空的bug

* 修改Columns接口中返回的ColumnList中，columns字段为空的bug

### 2015/08/27 william 0.0.9-SNAPSHOT更新:

* 新增榜单焦点图接口

* 新增发现页焦点图接口

* 新增分类下推荐标签的焦点图接口

### 2015/08/17 william 0.0.8-SNAPSHOT更新:

* 删除上版本的榜单焦点图接口和之前的焦点图相关接口

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

### 2015/07/17 william 0.0.6-SNAPSHOT更新:

* 新增SubordinatedAlbum DTO，并将Track DTO中的subordinated_album_id字段替换为SubordinatedAlbum。新增的SubordinatedAlbum属性如下:

```html
id : 所属专辑ID
album_title:  所属专辑标题
cover_url_small: 所属专辑封面小图
cover_url_middle: 所属专辑封面中图
cover_url_large: 所属专辑封面大图
```

* 新增getAllCopyrightAlbumList获取带版权的专辑全量接口

* 新增了搜索热词接口和搜索联想词接口

* 新增了《开放平台API接口文档》
