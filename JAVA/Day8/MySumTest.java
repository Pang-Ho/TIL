package day7;

class MySumTest {
    public static void main(String args[]){
        int i = 10;
        int j = 20;
        
        MySum ms1 = new MySum(i, j);
        MySum ms2 = new MySum(j, i);

        System.out.println(ms1/*.toString()자동호출*/);//30 toString이 오버라이딩이 안돼있으면 day7.Mysum@16진수주소값이 나옴
        System.out.println(ms2);//30

        if(ms1.equals(ms2)) { //오버라이딩 이전이라면 주소를 비교 / 오버라이딩 이후라면 원하는 거 비교
            System.out.println("ms1과 ms2의 합계는 동일합니다.");
	}
        String s1 = new String("30");
        
    }
}

class MySum /*extends Object*/{
    int first;
    int second;
    //int result;
    
    MySum (int first, int second){
        this.first = first;
        this.second = second;
    }

    /* 조건1 */
    //이렇게 오버라이딩 해야 ms1 값이 이상한 내용이 아닌 값으로 나올 수 있음.
   public String toString() {
	  return String.valueOf(first + second); //30을 리턴함
	   // result = first + second;
	  // return String.valueOf( result );
   }
    /* 조건2 */
   //ms1.equals(ms2)
   //ms1.equals(s1) 호출중
   public boolean equals(Object obj) { //equals 오버라이딩
	   //ms1.equals(ms2)  ms1 의 toString = me /ms2의 toString = obj
	   if(obj instanceof MySum) {
		   String me = this.toString(); //그냥 toString 써도 바로 위 toString을 알고 있음
		   String other = obj.toString();
		   if (me.equals(other)) {
			   return true;
		   } 
		   else {
		   return false;
		   }
	   }
	   else {
		   return false;
	   }
	   
   }
   }