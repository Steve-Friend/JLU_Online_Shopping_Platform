export default {
  //开启命名空间
  namespaced: true,
  
  //数据节点
  state:() => ({
    address: JSON.parse(uni.getStorageSync('address') || '{}'),
    token : uni.getStorageSync('token') || '{}',
    //用户的信息对象
    userInfo: JSON.parse(uni.getStorageSync('userinfo') || '{}'),
    //重定向的object对象
    redirectInfo : null
  }),
  
  //方法节点
  mutations:{
    //更新地址信息
    updateAddress(state, address){
      state.address = address || {}
      this.commit('m_user/saveAddressToStorage')
    },
    //持久化存储address
    saveAddressToStorage(state, address){
      uni.setStorageSync('address', JSON.stringify(state.address))
    },
    updateUserInfo(state, userinfo){
      state.userinfo = userinfo
      this.commit('m_user/saveUserInfoToStorage')
    },
    saveUserInfoToStorage(state){
      uni.setStorageSync('userinfo', JSON.stringify(state.userinfo))
    },
    updateToken(state, token){
      // state.token = token
      state.token = token
      this.commit('m_user/saveTokenToStorage')
    },
    saveTokenToStorage(state){
      uni.setStorageSync('token', state.token)
    },
    // 删除本地存储的 address
    removeAddressFromStorage(state) {
      state.address = {}; // 可选：清空 state 中的 address
      uni.removeStorageSync('address'); // 删除本地存储中的 address
    },
    updateRedirectInfo(state, info){
      state.redirectInfo = info
    },
  },
  
  getters:{
    addstr(state){
      if(!state.address.provinceName)return ''
      return state.address.provinceName + state.address.cityName + state.address.detailInfo
    }
  },
}