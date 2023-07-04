public class Money {
    public int getWhole() {
        return whole;
    }

    public void setWhole(int whole) {
        this.whole = whole;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        if(fraction>=100){
            int wholePart = fraction/100;
            fraction -= wholePart*100;
            this.whole+=wholePart;
        }
        this.fraction = fraction;
    }
    int whole;
    int fraction;
    public Money(int whole, int fraction){
        this.whole = whole;
        setFraction(fraction);
    }
    @Override
    public String toString() {
        return whole + "." + fraction;
    }
    protected Money Sum(Money m1){
        int fract = this.whole*100+this.fraction;
        int fract1 = m1.getWhole()*100+m1.getFraction();
        return new Money(0,fract+fract1);
    }
    protected Money Sub(Money m1){
        int fract = this.whole*100+this.fraction;
        int fract1 = m1.getWhole()*100+m1.getFraction();
        return new Money(0,fract-fract1);
    }
}
