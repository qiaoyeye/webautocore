package com.core.util;
/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2016��1��20�� ����10:38:16 
 * ��˵�� 
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
