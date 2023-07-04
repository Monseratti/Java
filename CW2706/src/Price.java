public class Price extends Money{
    public Price(int whole, int fraction) {
        super(whole, fraction);
    }
    public void DecreasePrice(Money decrValue){
        Money res = this.Sub(decrValue);
        this.whole = res.getWhole();
        this.fraction = res.getFraction();
    }
    public void IncreasePrice(Money incrValue){
        Money res = this.Sum(incrValue);
        this.whole = res.getWhole();
        this.fraction = res.getFraction();
    }
}
