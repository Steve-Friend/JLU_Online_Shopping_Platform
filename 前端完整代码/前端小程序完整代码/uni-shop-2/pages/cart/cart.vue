<template>
  <view class="cart-container" v-show="cart.length !== 0">
    
  
    <!-- 收获地址组件 -->
    <my-address></my-address>
    <!-- 购物车商品列表的标题区域 -->
    <view class="cart-title">
      <!-- 左侧的图标 -->
      <uni-icons type="shop" size="18"></uni-icons>
      <!-- 右侧的文本 -->
      <text class = "cart-title-text">购物车</text>
    </view>
    <uni-swipe-action>
      <block v-for="(goods, i) in cart" :key="i">
        <!-- uni-swipe-action-item 可以为其子节点提供滑动操作的效果。需要通过 options 属性来指定操作按钮的配置信息 -->
        <uni-swipe-action-item :right-options="options" @click="swipeActionClickHandler(goods)">
          <my-goods :goods="goods" :show-radio="true" :show-num="true" @radio-change="radioChangeHandler" @num-change="numberChangeHandler"></my-goods>
        </uni-swipe-action-item>
      </block>
    </uni-swipe-action>
    
    <!-- 使用自定义的结算组件 -->
    <my-settle></my-settle>
  </view>
  <!-- 这是空白购物车的区域 -->
  <view class="empty-cart" >
    <image src="/static/cart_empty@2x.png" class="empty-img"></image>
    <text class="tip-text">空空如也</text>
  </view>
</template>

<script>
  import { mapState, mapMutations } from 'vuex';
  import badgeMix from '@/mixins/tabbar-badge.js'
  export default {
    mixins : [badgeMix],
    computed:{
      ...mapState('m_cart', ['cart'])
    },
    data() {
      return {
        options: [{
          text: '删除', // 显示的文本内容
          style: {
            backgroundColor: '#C00000' // 按钮的背景颜色
          }
        }]
      };
    },
    methods:{
      ...mapMutations('m_cart', ['updateGoodsState', 'updateGoodsCount', 'removeGoodsById']),
      radioChangeHandler(e){
        this.updateGoodsState(e)
      },
      numberChangeHandler(e){
        this.updateGoodsCount(e)
      },
      swipeActionClickHandler(goods){
        this.removeGoodsById(goods.goods_id)
      }
    }
  }
</script>

<style lang="scss">
  .cart-container{
    padding-bottom: 50px;
  }
.cart-title{
  height: 40px;
  display: flex;
  align-items: center;
  padding-left: 5px;
  border-bottom: 1px solid #efefef;
  .cart-title-text{
    font-size: 14px;
    margin-left: 10px;
  }
}
.empty-cart{
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 150px;
  .empty-img{
    width: 90px;
    height: 90px;
  }
  .tip-text{
    font-size: 12px;
    color: gray;
    margin-top: 15px;
  }
}
</style>
