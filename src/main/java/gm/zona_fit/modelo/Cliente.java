package gm.zona_fit.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Cliente {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idCliente;
//    private String nombre;
//    private String apellido;
//    private Integer membresia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "membresia")
    private Integer membresia;

}