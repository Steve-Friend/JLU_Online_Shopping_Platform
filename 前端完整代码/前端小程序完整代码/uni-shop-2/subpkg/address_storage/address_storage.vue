<template>
	<view class="container">
		<uni-card is-full :is-shadow="false">
			<text class="uni-h6">填写个人信息</text>
		</uni-card>

		<!-- 姓名输入框 -->
		<uni-section title="姓名" type="line" padding>
			<uni-easyinput v-model="name" placeholder="请输入姓名" />
		</uni-section>

		<!-- 性别选择 -->
		<uni-section title="性别" type="line" padding>
			<uni-data-picker placeholder="请选择性别" popup-title="选择性别" :localdata="genderOptions" v-model="gender" />
		</uni-section>

		<!-- 电话输入框 -->
		<uni-section title="电话" type="line" padding>
			<uni-easyinput v-model="phone" placeholder="请输入电话号码" type="number" />
		</uni-section>

		<!-- 选择省市 -->
		<uni-section title="省市" type="line" padding>
			<uni-data-picker placeholder="请选择省市" popup-title="请选择省市" :localdata="dataTree" v-model="selectedRegion"
				@change="onChange" @nodeclick="onNodeClick" @popupopened="onPopupOpened" @popupclosed="onPopupClosed">
			</uni-data-picker>
		</uni-section>

		<!-- 详细地址输入框 -->
		<uni-section title="详细地址" type="line" padding>
			<uni-easyinput v-model="addressDetail" placeholder="请输入详细地址" />
		</uni-section>

		<!-- 确定和取消按钮 -->
		<view class="button-container">
			<button class="confirm-btn" @click="submitAddress">确定</button>
			<button class="cancel-btn" @click="cancelAddress">取消</button>
		</view>
	</view>
</template>

<script>
  import { mapState, mapMutations, mapGetters } from 'vuex';
	export default {
		data() {
			return {
				name: '',  // 姓名
				gender: '',  // 性别
				phone: '',  // 电话号码
				selectedRegion: '',  // 省市选择
				addressDetail: '',  // 详细地址
				// 性别选项数据
				genderOptions: [
					{ text: "男", value: "male" },
					{ text: "女", value: "female" }
				],
				// 省市数据（删除了区级数据）
				dataTree: 
        [
            {
                "text": "北京市",
                "value": "110000",
                "children": [
                    {
                        "text": "市辖区",
                        "value": "110100"
                    }
                ]
            },
            {
                "text": "天津市",
                "value": "120000",
                "children": [
                    {
                        "text": "市辖区",
                        "value": "120100"
                    }
                ]
            },
            {
                "text": "河北省",
                "value": "130000",
                "children": [
                    {
                        "text": "石家庄市",
                        "value": "130100"
                    },
                    {
                        "text": "唐山市",
                        "value": "130200"
                    },
                    {
                        "text": "秦皇岛市",
                        "value": "130300"
                    },
                    {
                        "text": "邯郸市",
                        "value": "130400"
                    },
                    {
                        "text": "邢台市",
                        "value": "130500"
                    },
                    {
                        "text": "保定市",
                        "value": "130600"
                    },
                    {
                        "text": "张家口市",
                        "value": "130700"
                    },
                    {
                        "text": "承德市",
                        "value": "130800"
                    },
                    {
                        "text": "沧州市",
                        "value": "130900"
                    },
                    {
                        "text": "廊坊市",
                        "value": "131000"
                    },
                    {
                        "text": "衡水市",
                        "value": "131100"
                    }
                ]
            },
            {
                "text": "山西省",
                "value": "140000",
                "children": [
                    {
                        "text": "太原市",
                        "value": "140100"
                    },
                    {
                        "text": "大同市",
                        "value": "140200"
                    },
                    {
                        "text": "阳泉市",
                        "value": "140300"
                    },
                    {
                        "text": "长治市",
                        "value": "140400"
                    },
                    {
                        "text": "晋城市",
                        "value": "140500"
                    },
                    {
                        "text": "朔州市",
                        "value": "140600"
                    },
                    {
                        "text": "晋中市",
                        "value": "140700"
                    },
                    {
                        "text": "运城市",
                        "value": "140800"
                    },
                    {
                        "text": "忻州市",
                        "value": "140900"
                    },
                    {
                        "text": "临汾市",
                        "value": "141000"
                    },
                    {
                        "text": "吕梁市",
                        "value": "141100"
                    }
                ]
            },
            {
                "text": "内蒙古自治区",
                "value": "150000",
                "children": [
                    {
                        "text": "呼和浩特市",
                        "value": "150100"
                    },
                    {
                        "text": "包头市",
                        "value": "150200"
                    },
                    {
                        "text": "乌海市",
                        "value": "150300"
                    },
                    {
                        "text": "赤峰市",
                        "value": "150400"
                    },
                    {
                        "text": "通辽市",
                        "value": "150500"
                    },
                    {
                        "text": "鄂尔多斯市",
                        "value": "150600"
                    },
                    {
                        "text": "呼伦贝尔市",
                        "value": "150700"
                    },
                    {
                        "text": "巴彦淖尔市",
                        "value": "150800"
                    },
                    {
                        "text": "乌兰察布市",
                        "value": "150900"
                    }
                ]
            },
            {
                "text": "辽宁省",
                "value": "210000",
                "children": [
                    {
                        "text": "沈阳市",
                        "value": "210100"
                    },
                    {
                        "text": "大连市",
                        "value": "210200"
                    },
                    {
                        "text": "鞍山市",
                        "value": "210300"
                    },
                    {
                        "text": "抚顺市",
                        "value": "210400"
                    },
                    {
                        "text": "本溪市",
                        "value": "210500"
                    },
                    {
                        "text": "丹东市",
                        "value": "210600"
                    },
                    {
                        "text": "锦州市",
                        "value": "210700"
                    },
                    {
                        "text": "营口市",
                        "value": "210800"
                    },
                    {
                        "text": "阜新市",
                        "value": "210900"
                    },
                    {
                        "text": "辽阳市",
                        "value": "211000"
                    }
                ]
            },
            {
                "text": "吉林省",
                "value": "220000",
                "children": [
                    {
                        "text": "长春市",
                        "value": "220100"
                    },
                    {
                        "text": "吉林市",
                        "value": "220200"
                    },
                    {
                        "text": "四平市",
                        "value": "220300"
                    }
                ]
            },
            {
                "text": "黑龙江省",
                "value": "230000",
                "children": [
                    {
                        "text": "哈尔滨市",
                        "value": "230100"
                    },
                    {
                        "text": "齐齐哈尔市",
                        "value": "230200"
                    }
                ]
            },
            {
                "text": "上海市",
                "value": "310000",
                "children": [
                    {
                        "text": "市辖区",
                        "value": "310100"
                    }
                ]
            },
            {
                "text": "江苏省",
                "value": "320000",
                "children": [
                    {
                        "text": "南京市",
                        "value": "320100"
                    },
                    {
                        "text": "无锡市",
                        "value": "320200"
                    }
                ]
            },
            {
                "text": "浙江省",
                "value": "330000",
                "children": [
                    {
                        "text": "杭州市",
                        "value": "330100"
                    },
                    {
                        "text": "宁波市",
                        "value": "330200"
                    }
                ]
            },
            {
                "text": "安徽省",
                "value": "340000",
                "children": [
                    {
                        "text": "合肥市",
                        "value": "340100"
                    },
                    {
                        "text": "芜湖市",
                        "value": "340200"
                    }
                ]
            },
            {
                "text": "福建省",
                "value": "350000",
                "children": [
                    {
                        "text": "福州市",
                        "value": "350100"
                    },
                    {
                        "text": "厦门市",
                        "value": "350200"
                    }
                ]
            },
            {
                "text": "江西省",
                "value": "360000",
                "children": [
                    {
                        "text": "南昌市",
                        "value": "360100"
                    },
                    {
                        "text": "景德镇市",
                        "value": "360200"
                    }
                ]
            },
            {
                "text": "山东省",
                "value": "370000",
                "children": [
                    {
                        "text": "济南市",
                        "value": "370100"
                    },
                    {
                        "text": "青岛市",
                        "value": "370200"
                    }
                ]
            },
            {
                "text": "河南省",
                "value": "410000",
                "children": [
                    {
                        "text": "郑州市",
                        "value": "410100"
                    },
                    {
                        "text": "开封市",
                        "value": "410200"
                    }
                ]
            },
            {
                "text": "湖北省",
                "value": "420000",
                "children": [
                    {
                        "text": "武汉市",
                        "value": "420100"
                    },
                    {
                        "text": "黄石市",
                        "value": "420200"
                    }
                ]
            },
            {
                "text": "湖南省",
                "value": "430000",
                "children": [
                    {
                        "text": "长沙市",
                        "value": "430100"
                    },
                    {
                        "text": "株洲市",
                        "value": "430200"
                    }
                ]
            },
            {
                "text": "广东省",
                "value": "440000",
                "children": [
                    {
                        "text": "广州市",
                        "value": "440100"
                    },
                    {
                        "text": "深圳市",
                        "value": "440300"
                    }
                ]
            },
            {
                "text": "广西壮族自治区",
                "value": "450000",
                "children": [
                    {
                        "text": "南宁市",
                        "value": "450100"
                    },
                    {
                        "text": "柳州市",
                        "value": "450200"
                    }
                ]
            },
            {
                "text": "海南省",
                "value": "460000",
                "children": [
                    {
                        "text": "海口市",
                        "value": "460100"
                    },
                    {
                        "text": "三亚市",
                        "value": "460200"
                    }
                ]
            },
            {
                "text": "重庆市",
                "value": "500000",
                "children": [
                    {
                        "text": "市辖区",
                        "value": "500100"
                    }
                ]
            },
            {
                "text": "四川省",
                "value": "510000",
                "children": [
                    {
                        "text": "成都市",
                        "value": "510100"
                    },
                    {
                        "text": "自贡市",
                        "value": "510300"
                    }
                ]
            },
            {
                "text": "贵州省",
                "value": "520000",
                "children": [
                    {
                        "text": "贵阳市",
                        "value": "520100"
                    },
                    {
                        "text": "六盘水市",
                        "value": "520200"
                    }
                ]
            },
            {
                "text": "云南省",
                "value": "530000",
                "children": [
                    {
                        "text": "昆明市",
                        "value": "530100"
                    },
                    {
                        "text": "曲靖市",
                        "value": "530300"
                    }
                ]
            },
            {
                "text": "西藏自治区",
                "value": "540000",
                "children": [
                    {
                        "text": "拉萨市",
                        "value": "540100"
                    }
                ]
            },
            {
                "text": "陕西省",
                "value": "610000",
                "children": [
                    {
                        "text": "西安市",
                        "value": "610100"
                    },
                    {
                        "text": "铜川市",
                        "value": "610200"
                    }
                ]
            },
            {
                "text": "甘肃省",
                "value": "620000",
                "children": [
                    {
                        "text": "兰州市",
                        "value": "620100"
                    },
                    {
                        "text": "嘉峪关市",
                        "value": "620200"
                    }
                ]
            },
            {
                "text": "青海省",
                "value": "630000",
                "children": [
                    {
                        "text": "西宁市",
                        "value": "630100"
                    }
                ]
            },
            {
                "text": "宁夏回族自治区",
                "value": "640000",
                "children": [
                    {
                        "text": "银川市",
                        "value": "640100"
                    }
                ]
            },
            {
                "text": "新疆维吾尔自治区",
                "value": "650000",
                "children": [
                    {
                        "text": "乌鲁木齐市",
                        "value": "650100"
                    },
                    {
                        "text": "克拉玛依市",
                        "value": "650200"
                    }
                ]
            }
        ]

			}
		},
		methods: {
      ...mapMutations('m_user', ['updateAddress', 'removeAddressFromStorage']),
			// 选择省市发生变化时触发
			onChange(e) {
				console.log('Selected region:', e);
			},
			onNodeClick(e) {
				console.log('Node clicked:', e);
			},
			onPopupOpened() {
				console.log('Popup opened');
			},
			onPopupClosed() {
				console.log('Popup closed');
			},
			// 点击取消
			cancelAddress() {
				// 清空所有输入框
				this.name = '';
				this.gender = '';
				this.phone = '';
				this.selectedRegion = '';
				this.addressDetail = '';
				uni.$showMsg('您取消了操作');
			},
			// 点击确定
			submitAddress() {
				// 提交数据时，将表单数据整理成类似 succ 的格式
				const [provinceName, cityName] = this.selectedRegion.split('/');

				const addressData = {
					userName: this.name,
					gender: this.gender,
					telNumber: this.phone,
					provinceName: provinceName || '',
					cityName: cityName || '',
					detailInfo: this.addressDetail
				};
        this.updateAddress(addressData)
				// 模拟打印返回的数据
				console.log('返回的地址数据:', addressData);

				// 处理后续逻辑，例如保存到数据库或继续处理
				this.updateAddress(addressData);
			},
			updateAddress(data) {
				// 可以根据需要在这里处理地址数据
				this.address = data;
				uni.$showMsg('地址信息已更新');
			}
		}
	}
</script>

<style>
	.title {
		font-size: 14px;
		font-weight: bold;
		margin: 20px 0 5px 0;
	}

	.data-pickerview {
		height: 400px;
		border: 1px #e5e5e5 solid;
	}

	.popper__arrow {
		top: -6px;
		left: 50%;
		margin-right: 3px;
		border-top-width: 0;
		border-bottom-color: #EBEEF5;
	}

.button-container {
	display: flex;
	justify-content: space-between;
	background-color: white;
	padding: 10px;
	height: 100%;
}

.confirm-btn, .cancel-btn {
	width: 45%;
	padding: 6px 0; /* 调整按钮内边距，减少高度 */
	border-radius: 3px; /* 减小圆角，让按钮更扁平 */
	font-size: 14px; /* 缩小字体大小 */
	border: none;
}

.confirm-btn {
	background-color: #4caf50;
	color: white;
}

.cancel-btn {
	background-color: white;
	color: #333;
	border: 1px solid #ddd;
}

.button-container {
	margin-bottom: 20px;
}

</style>
