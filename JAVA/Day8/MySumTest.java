package day7;

class MySumTest {
    public static void main(String args[]){
        int i = 10;
        int j = 20;
        
        MySum ms1 = new MySum(i, j);
        MySum ms2 = new MySum(j, i);

        System.out.println(ms1/*.toString()�ڵ�ȣ��*/);//30 toString�� �������̵��� �ȵ������� day7.Mysum@16�����ּҰ��� ����
        System.out.println(ms2);//30

        if(ms1.equals(ms2)) { //�������̵� �����̶�� �ּҸ� �� / �������̵� ���Ķ�� ���ϴ� �� ��
            System.out.println("ms1�� ms2�� �հ�� �����մϴ�.");
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

    /* ����1 */
    //�̷��� �������̵� �ؾ� ms1 ���� �̻��� ������ �ƴ� ������ ���� �� ����.
   public String toString() {
	  return String.valueOf(first + second); //30�� ������
	   // result = first + second;
	  // return String.valueOf( result );
   }
    /* ����2 */
   //ms1.equals(ms2)
   //ms1.equals(s1) ȣ����
   public boolean equals(Object obj) { //equals �������̵�
	   //ms1.equals(ms2)  ms1 �� toString = me /ms2�� toString = obj
	   if(obj instanceof MySum) {
		   String me = this.toString(); //�׳� toString �ᵵ �ٷ� �� toString�� �˰� ����
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