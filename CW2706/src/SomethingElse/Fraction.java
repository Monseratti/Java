package SomethingElse;

public class Fraction {
    int num;
    int denum;

    //region Constructors
    public Fraction() {
        this(1, 1);
    }

    public Fraction(int num, int denum) {
        if (denum == 0) {
            System.out.println("The denominator cannot be zero");
            return;
        }
        this.num = num;
        this.denum = denum;
    }
    //endregion

    @Override
    public String toString() {
        if (num < 0 && denum < 0) return "-(" + num * -1 + "/" + denum * -1 + ")";
        if (num < 0) return "-(" + num * -1 + "/" + denum + ")";
        if (denum < 0) return "-(" + num + "/" + denum * -1 + ")";
        return num + "/" + denum;
    }

    //region SetGet
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDenum() {
        return denum;
    }

    public void setDenum(int denum) {
        this.denum = denum;
    }
    //endregion

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public Fraction Sum(Fraction fr) {
        int LCM = lcm(this.getDenum(), fr.getDenum());
        int newDenum = LCM;
        int newNum = (LCM / this.getDenum()) * this.getNum() + (LCM / fr.getDenum()) * fr.getNum();
        int GCD = gcd(newNum, newDenum);
        return new Fraction((newNum / GCD), (newDenum / GCD));
    }

    public Fraction Sub(Fraction fr) {
        int LCM = lcm(this.getDenum(), fr.getDenum());
        int newDenum = LCM;
        int newNum = (LCM / this.getDenum()) * this.getNum() - (LCM / fr.getDenum()) * fr.getNum();
        int GCD = gcd(newNum, newDenum);
        return new Fraction((newNum / GCD), (newDenum / GCD));
    }

    public Fraction Mult(Fraction fr) {
        int newDenum = this.getDenum() * fr.getDenum();
        int newNum = this.getNum() * fr.getNum();
        int GCD = gcd(newNum, newDenum);
        return new Fraction((newNum / GCD), (newDenum / GCD));
    }

    public Fraction Div(Fraction fr) {
        int newDenum = this.getDenum() * fr.getNum();
        int newNum = this.getNum() * fr.getDenum();
        int GCD = gcd(newNum, newDenum);
        return new Fraction((newNum / GCD), (newDenum / GCD));
    }
}
