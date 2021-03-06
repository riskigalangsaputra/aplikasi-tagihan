package id.ac.tazkia.payment.virtualaccount.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
public class VirtualAccount {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_tagihan")
    private Tagihan tagihan;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_bank")
    private Bank bank;

    private String nomor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private VaStatus vaStatus = VaStatus.CREATE;

}
