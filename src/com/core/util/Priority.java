package com.core.util;

/** 
* �������ȼ���ö����
* @ClassName: Priority 
* @Description: TODO(������һ�仰��������������) 
* @author qiaojiafei 
* @date 2016��2��29�� ����11:59:58 
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
