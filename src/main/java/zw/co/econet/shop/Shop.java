package zw.co.econet.shop;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import zw.co.econet.assessment.area.Area;

import javax.persistence.*;


@Data
@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false, updatable = false)
    private Long id;

    private String name;

    @JsonBackReference
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Area area;
}
