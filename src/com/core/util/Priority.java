package com.core.util;

/** 
* 定义优先级的枚举类
* @ClassName: Priority 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author qiaojiafei 
* @date 2016年2月29日 上午11:59:58 
*  
*/
public enum Priority {
	P1(){
		@Override
        public String toString() {
            return "P1";
        }
	},
	P2(){
		@Override
        public String toString() {
            return "P2";
        }
	},
	P3(){
		@Override
        public String toString() {
            return "P3";
        }
	},
	ALL(){
		@Override
        public String toString() {
            return "ALL";
        }
	};
    Priority() {
    }
	
    
}
