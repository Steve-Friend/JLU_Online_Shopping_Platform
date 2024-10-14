<template>
  <view class="container">
    <uni-card is-full :is-shadow="false">
      <text class="uni-h6">填写账号信息</text>
    </uni-card>

    <!-- 账号输入框 -->
    <uni-section title="账号" type="line" padding>
      <uni-easyinput v-model="username" placeholder="请输入账号" />
    </uni-section>

    <!-- 密码输入框 -->
    <uni-section title="密码" type="line" padding>
      <uni-easyinput v-model="password" placeholder="请输入密码" type="password" />
    </uni-section>

    <!-- 昵称输入框 -->
    <uni-section title="昵称" type="line" padding>
      <uni-easyinput v-model="nickname" placeholder="请输入昵称" />
    </uni-section>

    <!-- 电话输入框 -->
    <uni-section title="电话号码" type="line" padding>
      <uni-easyinput v-model="phonenumber" placeholder="请输入电话号码" type="number" />
    </uni-section>

    <!-- 邮箱输入框 -->
    <uni-section title="邮箱" type="line" padding>
      <uni-easyinput v-model="email" placeholder="请输入邮箱" type="text" />
    </uni-section>

    <!-- 注册按钮 -->
    <view class="button-container">
      <button class="btn-register" @click="register">注册</button>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      nickname: '',
      phonenumber: '',
      email: ''
    };
  },
  methods: {
    register() {
      // 检查用户输入
      if (!this.username || !this.password || !this.nickname || !this.phonenumber || !this.email) {
        return uni.$showMsg('请填写所有字段！');
      }
    
      // 构建注册请求的参数
      const registerData = {
        username: this.username,
        password: this.password,
        nickname: this.nickname,
        phonenumber: this.phonenumber,
        email: this.email
      };
    
      // 调用 API 进行注册
      uni.request({
        url: 'http://192.168.43.217:5000/api/users/register', // 替换为你的局域网 IP 和端口
        method: 'POST',
        data: registerData,
        success: (response) => {
          const { data } = response;
          if (data.meta.status === 201) {
            uni.$showMsg('注册成功！');
            // 注册成功后可以进行跳转或其他操作
            uni.switchTab({
              url: '/pages/my/my' // 替换为成功后的跳转路径
            });
          } else {
            uni.$showMsg(data.meta.msg || '注册失败，请重试！');
          }
        },
        fail: (error) => {
          console.error('注册请求失败:', error);
          uni.$showMsg('注册请求失败，请稍后再试！');
        }
      });
    },

  }
}
</script>

<style lang="scss">
.container {
  padding: 20rpx;
}

.button-container {
  display: flex;
  justify-content: center;
  margin-top: 20rpx;
}

.btn-register {
  width: 90%;
  padding: 10rpx;
  background-color: #007AFF; /* 自定义按钮颜色 */
  color: white;
  border-radius: 5px;
  font-size: 16px;
}
</style>
