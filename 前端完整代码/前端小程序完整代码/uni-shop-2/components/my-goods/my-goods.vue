<template>
  <view class="goods-item">
    <!-- 左侧的盒子 -->
    <view class="goods-item-left">
      <radio :checked= "goods.goods_state" color = "#C00000" v-show="showRadio" @click="radioClickHandler"></radio>
      <image :src="goods.goods_small_logo || defaultPic" class="goods-pic"></image>
    </view>
    <!-- 右侧的盒子 -->
    <view class="goods-item-right">
      <!-- 商品的名字 -->
      <view class="goods-name">{{goods.goods_name}}</view>
      <view class="goods-info-box">
        <view class="goods-price">￥{{ tofixed(goods.goods_price)}}</view>
        <uni-number-box :min="1" :value="goods.goods_count" v-show="showNum" @change="numChangeHandler"></uni-number-box>
      </view>
    </view>
  </view>
</template>

<script>
  export default {
    props: {
      goods: {
        type: Object,
        default: {}
      },
      showRadio:{
        type: Boolean,
        default: false
      },
      showNum:{
        type : Boolean,
        default: false
      }
    },
    data() {
      return {
        // 默认的图片
        defaultPic: 'https://ts1.cn.mm.bing.net/th/id/R-C.f11833c2125d4076754e94e7f98ee185?rik=oOtymNcL5BjKwA&riu=http%3a%2f%2fonline-tangshan.com%2fstatic%2fmoren.jpg&ehk=YhjBmOdrCnDX6Xp37IL1nx9qCwTcqRWk62IHo%2bjU4ZI%3d&risl=&pid=ImgRaw&r=0'
      };
    },
    methods: {
      tofixed(num) {
        return Number(num).toFixed(2)
      },
      //radio点击事件
      radioClickHandler(){
        //发送给外界信号并传参
        this.$emit('radio-change', {
          goods_id : this.goods.goods_id,
          goods_state: !this.goods.goods_state
          
        })
      },
        // NumberBox 组件的 change 事件处理函数
        numChangeHandler(val) {
          // 通过 this.$emit() 触发外界通过 @ 绑定的 num-change 事件
          this.$emit('num-change', {
            // 商品的 Id
            goods_id: this.goods.goods_id,
            // 商品的最新数量
            goods_count: +val
          })
        }
    }
  }
</script>

<style lang="scss">
  .goods-item{
    width: 750rpx;
    box-sizing: border-box;
    display: flex;
    padding: 10px 5px;
    border-bottom: 1px solid #f0f0f0;
    .goods-item-left{
      margin-right: 5px;
      display: flex;
      justify-content: space-around;
      align-items: center;
      .goods-pic{
        width: 100px;
        height: 100px;
        display: block;
      }
    }
    .goods-item-right{
      flex: 1;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      .goods-name{
        font-size: 13px;
      }
      .goods-info-box{
        display: flex;
        justify-content: space-between;
        align-items: center;
        .goods-price{
          color: #C00000;
          font-size: 16px;
        }
      }
    }
  }
</style>