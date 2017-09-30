package disparo;

public class DisparoRun implements Runnable{
     private Disparo d;
     private Thread t;
     private boolean moviendo=false;
     public DisparoRun(Disparo d){
    	 this.d=d;    	 
    	 t=new Thread(this);
    	 t.start();
     }
     
     public void run(){
    	 
    	 boolean isRunnable=d.getIsRunning();
    	 while(isRunnable){
    		 
          isRunnable=d.getIsRunning();
          
          if(isRunnable)
	          if (!moviendo){
	        	  
	        	  d.mover();
	        	  try{
	        		  Thread.sleep(20);  
		          }
	  		      catch (Exception e){;}
	          }
	          else
	        	  t.interrupt();
    	 }
    	 
     }
}
