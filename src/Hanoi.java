
import java.util.Scanner;

public class Hanoi {

    public static boolean setLocation_x[] = {true, false, false};
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int x, y, z, move,j,k,h;
        int numberOfDisks =5;
        MyStack stack[] = new MyStack[3];
       for(int i=0;i<stack.length;i++){
              stack[i]=new MyStack(10);
       }
        for (int i = 5; i >=1; i--) {
            stack[0].push(i);
          
        }
        if (numberOfDisks % 2 == 0) {
            stack[1].push(stack[0].pop());
            System.out.println("Move Disk 1 from Tower(1) to Tower(2) ");
        } else {
            stack[2].push(stack[0].pop());
            System.out.println("Move Disk 1 from Tower(1) to Tower(3)");
        }
        //******************************************************************************
        for (int i = 2; i <=31; i++) {
            if (i % 2 != 0) {
                for( h=0;h<stack.length;h++){
                    if(stack[h].peek()==1)break;}//end of for
                int findlocatDisk_1=setLocationDisk_1(stack);
                System.out.println("Move Disk 1 from Tower("+(h+1)+") to Tower("+(findlocatDisk_1+1)+")");
                stack[findlocatDisk_1].push(stack[h].pop());
            }
            else{
            x = stack[0].peek();
            y = stack[1].peek();
            z = stack[2].peek();
           
            move = findSecondMax(x, y, z);
            for ( j = 0; j < stack.length; j++) {
                  if(move==stack[j].peek())break;}//end of for
            for(k=0;k<stack.length;k++){
              if(k!=j&&stack[k].peek()!=1)break;}//end of for
            System.out.println("Move Disk "+ move+" from Tower("+(j+1)+") to Tower("+(k+1)+")");
            stack[k].push(stack[j].pop());
            }
        }
    }//end of main method

    public static int findSecondMax(int x, int y, int z) {
        if (x == -1) {
            if (z > y) {
                return z;
            } else {
                return y;
            }
        }
        if (y == -1) {
            if (x > z) {
                return x;
            } else {
                return z;
            }
        }
        if (z == -1) {
            if (y > x) {
                return y;
            } else {
                return x;
            }
        }
        if (x > y && x < z) {
            return x;
        }
        if (y > x && y < z) {
            return y;
        }
        return z;
    }public static int setLocationDisk_1(MyStack[] stacks){
     if(setLocation_x[0]&&stacks[1].peek()==1){setLocation_x[0]=false;setLocation_x[1]=true;return 2;}
     if(setLocation_x[0]&&stacks[2].peek()==1){setLocation_x[0]=false;setLocation_x[2]=true;return 1;}
      if(setLocation_x[1]&&stacks[0].peek()==1){setLocation_x[1]=false;setLocation_x[0]=true;return 2;}
     if(setLocation_x[1]&&stacks[2].peek()==1){setLocation_x[1]=false;setLocation_x[2]=true;return 0;}
      if(setLocation_x[2]&&stacks[1].peek()==1){setLocation_x[2]=false;setLocation_x[1]=true;return 0;}
        setLocation_x[2]=false; setLocation_x[0]=true;     return 1;
    }
}//end of class
