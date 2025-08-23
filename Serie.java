import java.util.List;

public class Serie extends Midia {
    private List<Temporada> temporadas;
    
    public Serie(String titulo) {
        super(titulo);
        temporadas = new ArrayList<>();
    }

    public adicionarTemporada(Temporada temp) {
        temporadas.add(temp);
    }

    @Override
    public String info() {
        return "Série: " + super.info() + "; Quantidade de temporadas: " + temporadas.size();
    }
}