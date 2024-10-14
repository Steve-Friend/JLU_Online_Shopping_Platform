<template>
  <view class="backgroundxkj">
    <view class="search-box">
      <my-search @searchClicked="gotoSearch"></my-search>
    </view>
    <!-- 轮播图的区域 -->
    <swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" :circular="true">
      <swiper-item v-for="(item, i) in swiperList" :key="i">
        <navigator class="swiper-item" :url="'/subpkg/goods_detail/goods_detail?goods_id=' + item.goods_id">
          <image :src="item.image_src"></image>
        </navigator>
      </swiper-item>
    </swiper>
    
    <!-- 分类导航区域 -->
    <view class="nav-list">
      <view class="nav-item" v-for="(item, i) in navList" :key="i" @click="navClickHandler(item)">
        <image :src="item.image_src" class = "nav-img"></image>
      </view>
    </view>
    
    <!-- 楼层区域 -->
    <!-- 楼层的容器 -->
    <view class="floor-list">
      <!-- 每一个楼层的item项 -->
      <view class="floor-item" v-for="(item, i) in floorList" :key="i">
        <!-- 楼层的标题 -->
        <image :src="item.floor_title.image_src" class="floor-title"></image>
        <view class="floor-img-box">
          <!-- 左侧大图片的盒子 -->
          <navigator class="left-img-box" :url="item.product_list[0].url">
            <image :src="item.product_list[0].image_src"  :style="{ width : item.product_list[0].image_width + 'rpx'}" mode= "widthFix"></image>
          </navigator>
          <!-- 右侧小图片盒子 -->
        <view class="right-img-box">
          <navigator class="right-img-item" v-for="(item2, i2) in item.product_list" :key="i2" v-show="i2 !== 0" :url="item2.url">
            <image :src="item2.image_src" :style="{ width : item2.image_width + 'rpx'}" mode="widthFix"></image>
          </navigator>
        </view>
          </view>
        </view>
      </view>
      
      <view class="jldx">
        <image src="/static/jldx.jpg" class="jldx-pic"></image>
      </view>
    
  </view>
</template>

<script>
  import badgeMix from '@/mixins/tabbar-badge.js'
  export default {
    mixins : [badgeMix],
    data() {
      return {
        //这是轮播图的数据列表
        swiperList : [],
        navList : [],
        floorList : []
      };
    },
    onLoad() {
      //调用方法，获取轮播图数据
      this.getSwiperList(),
      this.getNavList(),
      this.getFloorList()
    },
    methods :{
      async getSwiperList(){
        const { data: res } = await uni.request({
            url: `${this.$httpsctl}/api/swiperdata`, // 后端服务地址
            method: 'GET',
        });
        //请求失败
        if(res.meta.status !== 200) 
          return uni.$showMsg()
          console.log('swiperdata', res.message)
        //请求成功
        this.swiperList = res.message
      },
      async getNavList() {
          try {
              const { data: res } = await uni.request({
                  url: `${this.$httpsctl}/api/catitems`, // 后端服务地址
                  method: 'GET',
              });
              
              console.log(res.meta.status);
      
              if (res && res.meta.status === 200) {
                  console.log('catitems', res.message);
                  this.navList = res.message;  // 这里是获取到的分类数据
              } else {
                  uni.$showMsg('获取分类数据失败');
              }
          } catch (error) {
              console.error('请求失败:', error);
              uni.$showMsg('请求失败，请检查网络或后端服务');
          }
      },

      navClickHandler(item){
        if(item.name === "分类"){
          uni.switchTab({
            url : '/pages/cate/cate'
          })
        }
      },
      async getFloorList(){
        const { data: res } = await uni.request({
            url: `${this.$httpsctl}/api/floordata`, // 后端服务地址
            method: 'GET',
        });
        if(res.meta.status !== 200) return uni.$showMsg()
        //对数据进行处理，因为作为分包，不可以套用navigatorurl
        res.message.forEach(floor =>{
          floor.product_list.forEach(prod =>{
            prod.url = '/subpkg/goods_list/goods_list?' + prod.navigator_url.split('?')[1]
          })
        })
        this.floorList = res.message
      },
      gotoSearch(){
        uni.navigateTo({
          url: '/subpkg/search/search'
        })
      }
    }
  }
</script>

<style lang="scss">
  .backgroundxkj{
    background-color: #add8e6;
  }
swiper {
  height: 330rpx;
  .swiper-item,
  image {
    width: 100%;
    height: 100%;
  }
}
  .nav-list{
    display: flex;
    justify-content: space-around;
    margin: 15px 0;
    .nav-img{
      width: 128rpx;
      height: 140rpx;
    }
  }
  
  .floor-title{
    width: 100%;
    height: 60rpx;
  }
  
  .right-img-box{
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
  }
  
  .floor-img-box{
    display: flex;
    padding-left: 10rpx;
  }
  
  .search-box{
    position: sticky;
    top: 0;
    z-index: 999;
  }
  
.jldx {
  padding-top: 10rpx;
  padding-left: 10rpx;
  padding-right: 10rpx;
}

.jldx-pic {
  width: 100%;
  height: 180px; /* 你可以根据需要调整高度 */
}

  
</style>
