
public class Main
{
    // 快速幂
    static long power(long p, long n, long m)
    {
        long sq = 1L;
        while (n > 0)
        {
            if (n % 2 == 1)
                sq = (sq * p) % m;
            p = (p * p) % m;
            n = n / 2;
        }
        return sq % m;
    }

    public static void main(String[] args)
    {
        // 已知条件：n=4294967297, e=7
        long n = 4294967297L, e = 7L;

        // 通过穷举，缩小穷举范围，寻找p的值
        long p = 0;
        for (long i = 3; i < Math.sqrt(n); i = i + 2)
        {
            if (n % i == 0)
            {
                p = i;
            }
        }

        // 通过公式n=p*q，计算q的值
        long q = n/p;

        // 通过公式fn=(p-1)*(q-1)，计算fn的值
        long fn = (p - 1) * (q - 1);

        // 根据公式(e*d)%fn=1，计算私有密钥d
        long d = 0;
        for (long i = 2; i < fn; i++)
        {
            if ((e * i) % fn == 1)
            {
                d = i;
            }
        }

        long m1, c1, m2, c2;
        m1 = 12L;
        c2 = 2L;

        
        c1 = power(m1, e, n);
        System.out.println("（1）\t已知：m1 = " + m1);
        System.out.println("\t\t求得：c1 = " + c1);

       
        m2 = power(c1, d, n);
        System.out.println("（2）\t已知：c2 = " + c2);
        System.out.println("\t\t求得：m2 = " + m2);
    }
}