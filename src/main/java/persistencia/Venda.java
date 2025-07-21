package persistencia;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_nome", nullable = false, length = 100)
    private String clienteNome;

    @Column(name = "data_venda", nullable = false)
    private LocalDateTime dataVenda;

    @Column(name = "total", precision = 10, scale = 2, nullable = false)
    private BigDecimal total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> itens = new ArrayList<>();

    // Construtor
    public Venda() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    @Override
    public String toString() {
        return "Venda ID: " + id + ", Cliente: " + clienteNome + ", Total: R$" + total;
    }
}

