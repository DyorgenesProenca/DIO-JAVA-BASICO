import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // Permite instanciar como: new Cliente("Fulano de Tal")
public class Cliente {
    private String nome;
}