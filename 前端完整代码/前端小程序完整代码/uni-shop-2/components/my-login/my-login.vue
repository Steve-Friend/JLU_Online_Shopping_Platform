<template>
  <view class="login-container">
    <!-- 头像和昵称区域 -->
    <view class="top-box">
      <image src="/static/kunkun.png" class="avatar"></image>
    </view>
    
    <!-- 输入账号 -->
    <view class="input-container">
      <text class="input-label">账号:</text>
      <input class="input-field" type="text" v-model="username" placeholder="请输入账号" />
    </view>
    
    <!-- 输入密码 -->
    <view class="input-container">
      <text class="input-label">密码:</text>
      <input class="input-field" type="password" v-model="password" placeholder="请输入密码" />
    </view>
    
    <!-- 登录和注册按钮 -->
    <view class="button-container">
      <button class="btn-login" @click="login">登录</button>
      <button class="btn-register" @click="register">注册</button>
    </view>
    
    <!-- 微信登录按钮 -->
    <button type="primary" class="btn-wechat-login" open-type="getUserInfo" @getuserinfo="getUserInfo">微信登录</button> 
    <text class="tips-text">登陆后尽享更多权益</text>
  </view>
</template>

<script>
  import { mapMutations, mapState } from 'vuex';
  export default {
    name: "my-login",
    data() {
      return {
        username: '', // 用户名
        password: '', // 密码
      };
    },
    methods: {
      ...mapMutations('m_user', ['updateUserInfo', 'updateToken', 'updateRedirectInfo']),
      ...mapState('m_user', ['redirectInfo']),
      
      // 用户授权之后，获取用户的基本信息
      getUserInfo(e) {
        console.log(e);
        if (e.detail.errMsg === 'getUserInfo:fail auth deny') return uni.$showMsg('您取消了登录授权！');
        console.log(e.detail.userInfo);
        this.updateUserInfo(e.detail.userInfo);
        this.getToken(e.detail);
      },
      
      async getToken(info) {
        try {
          const res = await uni.login(); 
          if (res.errMsg !== 'login:ok') return uni.$showMsg('登录失败！');
          console.log(res); 
          const query = {
            code: res.code,
            encryptedData: info.encryptedData,
            iv: info.iv,
            rawData: info.rawData,
            signature: info.signature
          };
          const { data: loginResult } = await uni.$http.post('/api/public/v1/users/wxlogin', query);
          
          // 登录成功直接把token保存在vuex中
          this.updateToken('wad');
          this.navigateBack();
        } catch (err) {
          console.error('Login failed:', err);
        }
      },
      
      login() {
        // 检查用户输入
        if (!this.username || !this.password) {
          return uni.$showMsg('请输入账号和密码！');
        }
      
        // 构建登录请求的参数
        const loginData = {
          username: this.username,
          password: this.password,
        };
      
        // 调用 API 进行登录验证
        uni.request({
          url: 'http://192.168.43.217:5000/api/users/login', // 替换为你的局域网 IP 和端口
          method: 'POST',
          data: loginData,
          success: (response) => {
            const { data } = response;
      
            // 检查返回的状态码，判断登录是否成功
            if (data.meta.status === 200) {
              console.log('登录成功，处理后续逻辑...');
              
              // 更新 Vuex 中的 token 值
              this.updateToken('wad');
      
              // 显示登录成功的提示
              uni.showToast({
                title: '登录成功',
                icon: 'success',
                duration: 1000 // 显示 1 秒钟
              });
      
              // 登录成功后导航到目标页面
              setTimeout(() => {
                this.navigateBack(); // 或者 uni.switchTab 跳转到主页等页面
              }, 1000); // 等待 1 秒后跳转
            } else {
              // 登录失败，显示服务器返回的错误信息
              uni.$showMsg(data.meta.msg || '登录失败，请重试！');
            }
          },
          fail: (error) => {
            // 网络请求失败，显示错误提示
            console.error('登录请求失败:', error);
            uni.$showMsg('登录请求失败，请稍后再试！');
          }
        });
      },





      
      register() {
        // 实现注册逻辑
        console.log("注册账号:", this.username, "密码:", this.password);
        
        // 在这里可以调用 API 进行注册
        // 例如：调用注册 API（可选，如果注册逻辑需要先调用 API 再跳转）
        
        // 跳转到注册页面
        uni.navigateTo({
          url: '/subpkg/amount_register/amount_register' // 根据实际路径调整
        });
      },

      
      navigateBack() {
        if (this.redirectInfo && this.redirectInfo.openType === 'switchTab') {
          uni.switchTab({
            url: this.redirectInfo.from,
            complete: () => {
              this.updateRedirectInfo(null);
            }
          });
        }
      },
    },
  }
</script>

<style lang="scss">
  
  
.login-container {
  height: 1000rpx;
  background-color: #F8F8F8;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  overflow: hidden;
  
  &::after {
    content: ' ';
    display: block;
    width: 100%;
    height: 40px;
    background-color: white;
    position: absolute;
    bottom: 0;
    left: 0;
    border-radius: 100%;
    transform: translateY(50%);
  }

 .input-container {
     width: 90%;
     margin: 10px 0;
     display: flex;
     align-items: center; /* 垂直居中对齐 */
   }
 
   .input-label {
     font-size: 14px;
     color: #333;
     margin-right: 10px; /* 标签和输入框间距 */
   }
 
   .input-field {
     flex: 1; /* 输入框占用剩余空间 */
     padding: 10rpx;
     border: 1px solid #ccc;
     border-radius: 20px; /* 圆润的边框 */
   }

  .button-container {
    width: 90%;
    display: flex;
    justify-content: space-between;
    margin: 15px 0;
  }

  .btn-login, .btn-register, .btn-wechat-login {
    width: 48%;
    border-radius: 100px;
  }

  .btn-login {
    background-color: #C00000;
  }

  .btn-register {
    background-color: #007BFF; // 你可以根据需要修改颜色
  }

  .tips-text {
    font-size: 12px;
    color: gray;
  }
  .top-box{
    height: 400rpx;
    justify-content: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    .avatar{
      width: 90px;
      height: 90px;
      border-radius: 45px;
      border: 2px solid #FFF;
      box-shadow: 0 1px 5px black;
    }
    }
  
}
</style>
