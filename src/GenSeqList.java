//支持泛型的顺序表
//2021-9-24
//完成该类，并写一个测试方法，在main()调用

public class GenSeqList<E> {
    final int DEF_SIZE = 10;
    E[] A;
    int size;
    int n;

    //1.不能创建泛型数组，应创建Object[]并强转
    @SuppressWarnings("unchecked")
    public GenSeqList(){
        size = DEF_SIZE;
        A = (E[])new Object[size];
        n = 0;
    }

    @SuppressWarnings("unchecked")
    public GenSeqList(int s){
        if(s < 2 || s > 10000)
            size = DEF_SIZE;
        else
            size = s;
        A = (E[])new Object[size];
        n = 0;
    }

    Status insert(int pos, E value){
        int k;
        //若pos不合理,结束
        if(pos < 1 || pos > n + 1)
            return Status.INVALID_POS;

        if(n == size)
            return Status.ARRAY_FULL;

        k = n;
        while(k >= pos){
            A[k] = A[k-1];
            k--;
        }


        //将新元素存放在pos处
        A[pos - 1] = value;
        n++;

        return Status.OK;
    }

    //Status delete(int pos, Integer oldV){
    Status delete(int pos, getType<E> oldV){
        int k;
        //若pos不合理,结束
        if(pos < 1 || pos > n + 1)
            return Status.INVALID_POS;

        //oldV = A[pos-1];
        oldV.value = A[pos-1];

        k = pos;

        while(k < n){
            A[k-1] = A[k];
            k++;
        }

        n--;

        return Status.OK;
    }


    Status get(int pos, getType<E> oldV){
        if(pos < 1 || pos > n)
            return Status.INVALID_POS;

        oldV.value = A[pos - 1];

        return Status.OK;
    }


    int find(E v){
        int k = 0;
        while(k < n){
            if(A[k] == v)
                return k + 1;
            k++;
        }
        return 0;
    }

    void show(){
        int k = 0;
        while(k < n){
            System.out.print(A[k] + " ");
            k++;
        }
        System.out.println();
    }

}
