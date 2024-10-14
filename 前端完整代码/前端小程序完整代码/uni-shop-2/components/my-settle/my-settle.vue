<template>
  <view class = "my-settle-container">
    <!-- 全选 -->
    <label class="radio" @click="changeALLState">
      <radio color="#C00000" :checked="isFullCheck"></radio>
      <text>全选</text>
    </label>
    <!-- 合计 -->
    <view class="amount-box">
      合计：<text class= "amount">￥{{checkedGoodsAmount}}</text>
    </view>
    <!-- 结算按钮 -->
    <view class="btn-settle" @click="settlement">
      结算({{checkedCount}})
    </view>
    <!-- 支付状态下的支付图片和确认支付按钮 -->
    <view v-if="isPaying" class="pay-overlay">
      <image src="/static/zf.png" class="payment-image" />
      <button class="confirm-button" @click="simulatePaySuccess">点击确认支付成功</button>
    </view>
  </view>
</template>

<script>
  import { mapGetters, mapMutations, mapState } from 'vuex';
  export default {
    name:"my-settle",
    data() {
      return {
        isPaying: false,  // 控制是否显示支付图片
        paySuccess: false, // 支付成功提示
        //倒计时
        seconds : 3,
        //定时器的ID
        timer : null
      };
    },
    computed:{
      ...mapGetters('m_cart', ['checkedCount', 'total', 'checkedGoodsAmount']),
      ...mapGetters('m_user', ['addstr']),
      ...mapState('m_user', ['token']),
      ...mapState('m_cart', ['cart']),
      ...mapState('m_user', ['userinfo', 'token']),
      isFullCheck(){
        return this.total === this.checkedCount
      }
    },
    methods:{
      ...mapMutations('m_cart', ['updateAllGoodsState', 'clearCart']),
      ...mapMutations('m_user', ['updateRedirectInfo', 'updateAddress']),
      changeALLState(){
        this.updateAllGoodsState(!this.isFullCheck)
      },
      //用户点击率结算按钮
      settlement(){
        if(!this.checkedCount)return uni.$showMsg('请选择要结算的商品！')
        if(!this.addstr) return uni.$showMsg('请选择收货地址！')
        if(!this.token) return this.delayNavigate()
        this.isPaying = true;
        this.paySuccess = false;
  
        // 5秒后自动关闭支付图片并显示失败提示框
        this.timer = setTimeout(() => {
          if (!this.paySuccess) {
            this.isPaying = false;
            uni.showModal({
              title: '支付失败',
              content: '请重新支付',
              showCancel: false
            });
          }
          this.cleanUp();  // 清理定时器
        }, 5000);
        //this.payOrder()
      },
        // 模拟支付成功
        simulatePaySuccess() {
          if (this.isPaying) {
            this.paySuccess = true;
            this.isPaying = false;
            uni.showToast({
              icon: 'success',
              title: '支付成功',
              duration: 2000
            });
            this.cleanUp();
            this.clearCart() // 清空地址信息
          }
        },
    
        // 清理定时器
        cleanUp() {
          clearTimeout(this.timer);
        },
      async payOrder(){
        //1.创建订单
        //1.1组织订单的信息对象
        const orderInfo ={
          order_price:this.checkedGoodsAmount,
          consignee_addr:this.addstr,
          goods:this.cart.filter(x => x.goods_state).map(x => ({
            goods_id : x.goods_id,
            goods_number : x.goods_number,
            goods_price : x.goods_price
          }))
        }
        //1.2发起请求创建订单
        const {data : res} = await uni.$http.post('/api/public/v1/my/orders/create', orderInfo)
        if(res,meta,status !== 200) return uni.$showMsg('创建订单失败！')
        
        //1.3得到服务器的订单编号
        const orderNumber = res.message.order_number
        // 2. 订单预支付
        // 2.1 发起请求获取订单的支付信息
        const {data : res2} = await uni.$http.post('/api/public/v1/my/orders/req_unifiedorder', {order_number : orderNumber})
        // 2.2 预付订单生成失败
        if(res2.meta.status !== 200) return uni.$showMsg('预订订单生成失败！')

        // 2.3 得到订单支付相关的必要参数
        const payInfo = res2.message.pay
        
        // 3. 发起微信支付
        // 3.1 调用 uni.requestPayment() 发起微信支付
        const [err, succ] = await uni.requestPayment(payInfo)
        // 3.2 未完成支付
        if(err) return uni.$showMsg('订单未支付')
        // 3.3 完成了支付，进一步查询支付的结果
        const {data : res3} = await uni.$http.post('/api/public/v1/my/orders/chkOrder', {order_number : orderNumber})
        // 3.4 检测到订单未支付
        if(res3.meta.status !== 200) return uni.$showMsg('订单未支付')
         // 3.5 检测到订单支付完成
         uni.showToast({
           title: '订单支付完成！',
           icon : 'success'
         })
      },
      //延迟导航到my页面
      delayNavigate(){
        this.seconds = 3
        this.showTips(this.seconds)
        //定时器
        this.timer = setInterval(() => {
          this.seconds--
          if(this.seconds <= 0){
            clearInterval(this.timer)
            uni.switchTab({
                    url: '/pages/my/my',
                    // 页面跳转成功之后的回调函数
                    success: () => {
                      // 调用 vuex 的 updateRedirectInfo 方法，把跳转信息存储到 Store 中
                      this.updateRedirectInfo({
                        // 跳转的方式
                        openType: 'switchTab',
                        // 从哪个页面跳转过去的
                        from: '/pages/cart/cart'
                      })
                    }
                  })
            return
          }
          this.showTips(this.seconds)
        }, 1000)
      },
      //展示倒计时的计时消息
      showTips(n){
        uni.showToast({
          icon: 'none',
          title: '请登录后再结算！ ' + n + '秒之后自动跳转到登录页',
          mask: true,
          duration: 1500
        })
      }
    },
  }
</script>

<style lang="scss">
.my-settle-container{
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 50px;
  background-color: white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 14px;
  padding-left: 5px;
  .radio{
    display: flex;
    align-items: center;
  }
  .amount-box{
    .amount{
      color: #C00000;
      font-weight: bold;
    }
  }
  .btn-settle{
    background-color: #C00000;
    height: 50px;
    color: white;
    line-height: 50px;
    padding: 0 10px;
    min-width: 100px;
    text-align: center;
  }
  .pay-overlay {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background-color: rgba(0, 0, 0, 0.5); /* 半透明背景 */
    width: 100%;
    height: 100%;
    z-index: 1000;
  
    .payment-image {
    width: 66%; /* 图片宽度占屏幕的三分 */
    height: 70%; /* 保持图片的比例 */
    margin-bottom: 20px; /* 图片下方留一些空隙 */
    }
  
    .confirm-button {
      width: 180px;
      height: 40px;
      background-color: #28a745;
      color: white;
      border: none;
      border-radius: 20px; /* 扁平化按钮 */
      font-size: 14px;
      text-align: center;
      line-height: 40px;
    }
  }
}
</style>