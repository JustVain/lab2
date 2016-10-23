
public class Main
{
    // ������
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
        // ��֪������n=4294967297, e=7
        long n = 4294967297L, e = 7L;

        // ͨ����٣���С��ٷ�Χ��Ѱ��p��ֵ
        long p = 0;
        for (long i = 3; i < Math.sqrt(n); i = i + 2)
        {
            if (n % i == 0)
            {
                p = i;
            }
        }

        // ͨ����ʽn=p*q������q��ֵ
        long q = n/p;

        // ͨ����ʽfn=(p-1)*(q-1)������fn��ֵ
        long fn = (p - 1) * (q - 1);

        // ���ݹ�ʽ(e*d)%fn=1������˽����Կd
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
        System.out.println("��1��\t��֪��m1 = " + m1);
        System.out.println("\t\t��ã�c1 = " + c1);

       
        m2 = power(c1, d, n);
        System.out.println("��2��\t��֪��c2 = " + c2);
        System.out.println("\t\t��ã�m2 = " + m2);
    }
}