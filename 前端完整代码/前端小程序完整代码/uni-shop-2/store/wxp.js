// wxp.js
const wxp = {}

const wxFunctions = ['request', 'chooseAddress']; // 你需要的 API
wxFunctions.forEach(fn => {
  wxp[fn] = (options = {}) => {
    return new Promise((resolve, reject) => {
      options.success = resolve;
      options.fail = reject;
      wx[fn](options); // 调用微信 API
    });
  };
});

// 导出 wxp 模块
export default wxp;
