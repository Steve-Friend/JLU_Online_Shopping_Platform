<template>
  <view>
    <view class="goods-list">
      <view v-for="(goods, i) in goodList" :key="i" @click="gotoDetail(goods)">
        <my-goods :goods="goods"></my-goods>
      </view>
    </view>
  </view>
</template>

<script>
  export default {
    data() {
      return {
        //请求参数对象
        queryObj:{
          query: '',
          cid : '',
          pagenum : 1,
          pagesize : 10
        },
        goodList : [],
        total : 0
      };
    },
    onLoad(options) {
      this.queryObj.query = options.query || ''
      this.queryObj.cid = options.cid || ''
      this.getGoodsList()
    },
    methods :{
      async getGoodsList(cb){
        const {data : res} = await uni.$http.get('/api/public/v1/goods/search', this.queryObj)
        cb && cb()
        if(res.meta.status !== 200) return uni.$showMsg()
        this.goodList = [...this.goodList, ...res.message.goods]
        this.total = res.message.total
      },
      gotoDetail(goods) {
        uni.navigateTo({
          url: '/subpkg/goods_detail/goods_detail?goods_id=' + goods.goods_id
        })
      }
    },
    onReachBottom(){
      if(this.queryObj.pagenum * this.queryObj.pagesize >= this.total) return uni.$showMsg('数据加载完毕！')
      //让页码值加1
      this.queryObj.pagenum++
      this.getGoodsList()
      
    },
    onPullDownRefresh() {
      console.log('下拉刷新了没')
      //重置关键数据
      this.queryObj.pagenum = 1
      this.total = 0
      this.goodList = []
      //重新发起数据请求
      this.getGoodsList(() => uni.stopPullDownRefresh())
    }
  }
</script>

<style lang="scss">

</style>
