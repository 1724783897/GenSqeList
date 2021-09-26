import java.util.*;
public class Test {
    public static void main(String[] args) {
        getType<Integer> ot = new getType<>();
        GenSeqList<Integer> l1 = new GenSeqList<>();
        l1.insert(1,10);
        l1.insert(2,20);
        l1.insert(3,30);
        l1.insert(4,40);
        Scanner scan = new Scanner(System.in);
        int ch;
        int p;
        int v;
        Status r;


        ch = -1;
        while(ch != 0){
            System.out.println("---------------");
            System.out.println("1 - show");
            System.out.println("2 - insert");
            System.out.println("3 - delete");
            System.out.println("4 - get");
            System.out.println("5 - find");
            System.out.println("0 - exit");
            System.out.println("---------------");
            System.out.print("select:");
            ch = scan.nextInt();

            switch(ch){
                case 2:
                    System.out.print("enter pos:");
                    p = scan.nextInt();
                    System.out.print("enter value:");
                    v = scan.nextInt();
                    r = l1.insert(p, v);
                    switch(r){
                        case OK:
                            System.out.println("OK");
                            break;
                        case ARRAY_FULL:
                            System.out.println("Error : ARRAY_FULL");
                            break;

                        case INVALID_POS:
                            System.out.println("Error : INVALID_POS");
                            break;
                    }
                    break;

                case 3:
                    System.out.print("enter pos:");
                    p = scan.nextInt();
                    r = l1.delete(p, ot);
                    switch(r){
                        case OK:
                            System.out.println("OK, old value is " + ot.value);
                            break;

                        case INVALID_POS:
                            System.out.println("Error : INVALID_POS");
                            break;
                    }
                    break;

                case 1:
                    l1.show();
                    break;

                case 4:
                    System.out.print("enter pos:");
                    p = scan.nextInt();
                    l1.get(p,ot);
                    if(ot.value != null){
                        System.out.println("OK, the value is " + ot.value);
                    }else{
                        System.out.println("Error : INVALID_POS");
                    }
                    break;

                case 5:
                    System.out.print("enter value:");
                    v = scan.nextInt();
                    p = l1.find(v);
                    if(p == 0)
                        System.out.print("not found");
                    else
                        System.out.println("found, position is " + p);
                    break;
            }

        }
        scan.close();

    }
}
