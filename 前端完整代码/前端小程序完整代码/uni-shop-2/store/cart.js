export default {
  //开启命名空间
  namespaced: true,
  state: () => ({
    // 购物车的数组，用来存储购物车中每个商品的信息对象
    // 每个商品的信息对象，都包含如下 6 个属性：
    // { goods_id, goods_name, goods_price, goods_count, goods_small_logo, goods_state }
    cart: JSON.parse(uni.getStorageSync('cart') || '[]')
  }),
  mutations: {
    addToCart(state, goods){
      const findResult = state.cart.find((x) => x.goods_id === goods.goods_id)
      console.log(findResult)
      if(!findResult){
        state.cart.push(goods)
      }
      else{
        findResult.goods_count++
      }
      console.log(state.cart)
      this.commit('m_cart/saveToStorage')
    },
    saveToStorage(state){
      uni.setStorageSync('cart', JSON.stringify(state.cart))
    },
    //更新购物车中商品的勾选状态
    updateGoodsState(state, goods){
      const findResult = state.cart.find(x => x.goods_id === goods.goods_id)
      if(findResult){
        findResult.goods_state = goods.goods_state
        this.commit('m_cart/saveToStorage')
      }
    },
    // 更新购物车中商品的数量
    updateGoodsCount(state, goods) {
      // 根据 goods_id 查询购物车中对应商品的信息对象
      const findResult = state.cart.find(x => x.goods_id === goods.goods_id)
    
      if(findResult) {
        // 更新对应商品的数量
        findResult.goods_count = goods.goods_count
        // 持久化存储到本地
        this.commit('m_cart/saveToStorage')
      }
    },
    removeGoodsById(state, goods_id) {
      // 调用数组的 filter 方法进行过滤
      state.cart = state.cart.filter(x => x.goods_id !== goods_id)
      // 持久化存储到本地
      this.commit('m_cart/saveToStorage')
    },
    //更新购物车中所有的勾选状态
    updateAllGoodsState(state, newState){
      state.cart.forEach(x => x.goods_state = newState)
      this.commit('m_cart/saveToStorage')
    },
    // 新增的清空购物车方法
    clearCart(state) {
      state.cart = []  // 将购物车清空
      this.commit('m_cart/saveToStorage')  // 持久化存储到本地
    }
  },
  getters:{
    total(state){
      // let c =0
      // state.cart.forEach(x => c+= x.goods_count)
      // return c
      return state.cart.reduce((total, item) => {return total += item.goods_count}, 0)
    },
    checkedCount(state){
      return state.cart.filter(x => x.goods_state).reduce((total, item) => {return total += item.goods_count}, 0)
    },
    //已勾选商品的总价格
    checkedGoodsAmount(state){
      return state.cart.filter(x => x.goods_state).reduce((total, item) => { return total += item.goods_price * item.goods_count}, 0).toFixed(2)
    },
  }
}