import java.time.LocalDateTime;

public class Bejegyzes{
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom){
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = likeok;
        this.letrejott = letrejott;
        this.szerkesztve = szerkesztve;
    }
    public String getSzerzo() {
        return this.szerzo;
    }

    public String getTartalom() {
        return this.tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
    }

    public int getLikeok(){ return this.likeok; }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void like(){
        likeok++;
    }

    @Override
    public String toString() {
        if (this.getSzerkesztve().isAfter(this.getLetrejott())){
            return String.format("%s - %d - %s\nSzerkesztve: %s\n%s",this.getSzerzo(),this.getLikeok(),this.getLetrejott(),this.getSzerkesztve(),this.getTartalom());
        }else {
            return String.format("%s - %d - %s\nSzerkesztve: Nem volt még szerkesztve\n%s",this.getSzerzo(),this.getLikeok(),this.getLetrejott(),this.getTartalom());
        }
    }

}
