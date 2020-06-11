
class multi extends Thread
{
        int n1,n2;
		int sum=0;
		
        multi(int a, int b)
        {
                n1=a;
                n2=b;
        }
        public void run()
        {
			try
			{ 
				
				System.out.println("Thread " + Thread.currentThread().getId() + " is running"); 
				for (int i=n1;i<=n2;i++)
                {
                    sum+=i;
                }
                System.out.println("\nSum of "+n1+" to "+n2+" is "+sum);
				
			} 
			catch (Exception e) 
			{ 
				System.out.println("Exception is caught " + e); 
			} 
                
        }
		public int getSum()
		{
			return sum;
		}
        public static void main(String args[])
        {
                System.out.println("\nHello\n");
				try
				{

					multi m1 = new multi(1,5);
					multi m2 = new multi(5,10);
					multi m3 = new multi(11,15);
					// multi m4 = new multi(301,400);
					// multi m5 = new multi(401,500);
					// multi m6 = new multi(501,600);
					// multi m7 = new multi(601,700);
					// multi m8 = new multi(701,800);
					// multi m9 = new multi(801,900);
					// multi m10 = new multi(901,1000);
					m1.start();
					m2.start();
					m3.start();
					m1.join();
					m2.join();
					m3.join();
					int total = m1.getSum()+m2.getSum()+m3.getSum();
					System.out.println("Total = " + total);
					// m4.start();
					
					// m4.wait();
					// m3.displayTotal();
					// m3.wait();
					// m3.displayTotal();
					
					// m1.join();
					// m2.join();	
					// m3.join();
					// m2.start();
					// m3.start();
					// m4.start();
					// m5.start();
					// m6.start();
					// m7.start();
					// m8.start();
					// m9.start();
					// m10.start();
				} 
				catch (Exception e) 
				{ 
					System.out.println ("Exception is caught" + e); 
				} 
        }
}

